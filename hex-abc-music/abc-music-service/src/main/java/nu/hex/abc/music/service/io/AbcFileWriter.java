package nu.hex.abc.music.service.io;

import abc.music.core.domain.Book;
import abc.music.core.domain.Collection;
import abc.music.core.domain.FormatTemplate;
import abc.music.core.domain.Person;
import abc.music.core.domain.Tune;
import abc.music.core.util.TextUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import nu.hex.abc.music.service.meta.MetaService;
import nu.hex.abc.music.service.properties.PropertyService;

/**
 * Created 2016-nov-28
 *
 * @author hl
 */
class AbcFileWriter implements Writer<File> {

    private static final String DEFAULT_CHARSET = "%%encoding utf-8";
    private static final String ABC_VERSION = "%%abc-version ";
    private static final String DEFAULT_ABC_VERSION = "2.1";
    private static final String ABC_CREATOR = "%%abc-creator hex-abc-music " + MetaService.getAppInfo().getVersion();
    private static final String NEW_LINE = "\n";
    private final PropertyService properties = new PropertyService();
    private final List<Tune> tunes;
    private final File file;
    private String abcDoc = "";
    private boolean isBook = false;
    private boolean isCollection = false;
    private FormatTemplate template;
    private Integer lineLength = 100;
    private String copyright = "";

    public AbcFileWriter(Tune tune, File file) {
        this(Arrays.asList(tune), file);
    }

    public AbcFileWriter(List<Tune> tunes, File file) {
        createFileHeader();
        this.tunes = tunes;
        this.file = file;
    }

    public AbcFileWriter(Collection collection, File file) {
        createFileHeader();
        tunes = collection.getTunes();
        copyright = collection.getCopyright();
        this.file = file;
        template = collection.getProject().getFormatTemplate(collection.getPreferredTemplate());
        if (template.hasLineLength()) {
            lineLength = template.getLineLength();
        }
        isBook = collection instanceof Book;
        isCollection = true;
        addHeaderAndIntroduction(collection);
        if (!collection.hasPreface()) {
            setHeadersAndFooters();
        }
        if (collection.getPrintPersons()) {
            List<Person> persons = collection.getPersons();
            Collections.sort(persons, (a, b) -> a.getFormalName().compareTo(b.getFormalName()));
            setPageBreak();
            setSkip(2.7);
            addPersonsInformation(collection.getPersonsHeader(), collection.getPersonsText(), persons);
        }
        if (collection.getPrintBooks()) {
            setPageBreak();
            setSkip(2.7);
            addBooksInformation(collection.getBooksHeader(), collection.getBooksText(), collection.getBooks());
        }
    }

    @Override
    public File write() {
        if (isCollection && !isBook) {
            Collections.sort(tunes, (a, b) -> a.getName().compareTo(b.getName()));
        }
        if (isCollection) {
            abcDoc += new AbcDocWriter(tunes, lineLength).write();
        } else {
            abcDoc += new AbcDocWriter(tunes).write();
        }
        return new SimpleFileWriter(file, abcDoc).write();
    }

    private void createFileHeader() {
        String abcVersion = properties.getProperty("abc-version");
        if (abcVersion == null) {
            abcVersion = DEFAULT_ABC_VERSION;
        }
        abcDoc += ABC_VERSION
                + abcVersion
                + NEW_LINE
                + DEFAULT_CHARSET
                + NEW_LINE
                + ABC_CREATOR
                + NEW_LINE;
    }

    private void addHeaderAndIntroduction(Collection collection) {
        listDeclaredFonts();
        appendLine("%%writefields Q false");
        setMargins();
        if (template.hasIndent()) {
            appendLine(template.getIndentAsAbcString());
        }
        setSkip(7.5);
        if (template.getFonts().containsKey(FormatTemplate.Font.COLLECTION_NAME)) {
            appendLine(template.getFontAsAbcString(FormatTemplate.Font.COLLECTION_NAME));
        }
        appendCenteredLine(collection.getName());
        if (collection.hasTitles()) {
            setPageBreak();
            appendCenteredLine(" ");
            setPageBreak();
            setSkip(7.5);
            for (int i = 0; i < collection.getTitles().size(); i++) {
                if (i > 0) {
                    appendLine(template.getFontAsAbcString(FormatTemplate.Font.COLLECTION_SUBTITLE));
                } else {
                    appendLine(template.getFontAsAbcString(FormatTemplate.Font.COLLECTION_TITLE));
                }
                appendCenteredLine(collection.getTitles().get(i));
            }
        }
        if (collection.hasPreface()) {
            setPageBreak();
            appendLine(template.getFontAsAbcString(FormatTemplate.Font.COLLECTION_PREFACE_HEADER));
            setHeadersAndFooters();
            setSkip(2.7);
            appendSingleTextLine(collection.getPrefaceHeader());
            appendLine(template.getFontAsAbcString(FormatTemplate.Font.COLLECTION_PREFACE_TEXT));
            appendMultipleTextLines(collection.getPreface(), 0.8);
        }
    }

    private void setHeadersAndFooters() {
        appendLine(template.getFontAsAbcString(FormatTemplate.Font.PAGE_HEADER));
        appendLine(template.getFontAsAbcString(FormatTemplate.Font.PAGE_FOOTER));
        String header = "%%header \"";
        if (template.hasHeaderLeft()) {
            header = addField(header, template.getHeaderLeft());
        }
        header += "\t";
        if (template.hasHeaderCenter()) {
            header = addField(header, template.getHeaderCenter());
        }
        header += "\t";
        if (template.hasHeaderRight()) {
            header = addField(header, template.getHeaderRight());
        }
        header += "\"";
        if (!header.equals("%%header \"\t\t\"")) {
            appendLine(header);
        }
        String footer = "%%footer \"";
        if (template.hasFooterLeft()) {
            footer = addField(footer, template.getFooterLeft());
        }
        footer += "\t";
        if (template.hasFooterCenter()) {
            footer = addField(footer, template.getFooterCenter());
        }
        footer += "\t";
        if (template.hasFooterRight()) {
            footer = addField(footer, template.getFooterRight());
        }
        footer += "\"";
        if (!footer.equals("%%footer \"\t\t\"")) {
            appendLine(footer);
        }
    }

    private String addField(String text, String input) {
        if (input == null || input.isEmpty()) {
            return text;
        }
        if (input.equals("©")) {
            if (copyright != null) {
                text += copyright;
            }
        } else {
            text += input;
        }
        return text;
    }

    private void setMargins() {
        if (template.getMargin(FormatTemplate.Margin.TOP) != null) {
            appendLine("%%topmargin " + template.getMargin(FormatTemplate.Margin.TOP) + "cm");
        }
        if (template.getMargin(FormatTemplate.Margin.RIGHT) != null) {
            appendLine("%%rightmargin " + template.getMargin(FormatTemplate.Margin.RIGHT) + "cm");
        }
        if (template.getMargin(FormatTemplate.Margin.BOTTOM) != null) {
            appendLine("%%botmargin " + template.getMargin(FormatTemplate.Margin.BOTTOM) + "cm");
        }
        if (template.getMargin(FormatTemplate.Margin.LEFT) != null) {
            appendLine("%%leftmargin " + template.getMargin(FormatTemplate.Margin.LEFT) + "cm");
        }
    }

    private void listDeclaredFonts() {
        for (String f : template.getDeclaredFonts()) {
            appendLine("%%textfont " + f);
        }
    }

    private void addPersonsInformation(String header, String text, List<Person> persons) {
        appendLine(template.getFontAsAbcString(FormatTemplate.Font.COLLECTION_PREFACE_HEADER));
        appendSingleTextLine(header);
        appendLine(template.getFontAsAbcString(FormatTemplate.Font.COLLECTION_PREFACE_TEXT));
        appendMultipleTextLines(text, 0.8);
        for (Person p : persons) {
            appendLine(template.getFontAsAbcString(FormatTemplate.Font.COLLECTION_PERSON_HEADER));
            appendSingleTextLine(p.getFirstName() + " " + p.getLastName());
            appendLine(template.getFontAsAbcString(FormatTemplate.Font.COLLECTION_PERSON_TEXT));
            appendMultipleTextLines(p.getHistory(), 0.8);
        }
    }

    private void addBooksInformation(String header, String text, List<Book> books) {
        appendLine(template.getFontAsAbcString(FormatTemplate.Font.COLLECTION_PREFACE_HEADER));
        appendSingleTextLine(header);
        appendLine(template.getFontAsAbcString(FormatTemplate.Font.COLLECTION_PREFACE_TEXT));
        appendMultipleTextLines(text, 0.8);
        for (Book b : books) {
            appendLine(template.getFontAsAbcString(FormatTemplate.Font.COLLECTION_BOOK_HEADER));
            appendSingleTextLine(b.getName());
            appendLine(template.getFontAsAbcString(FormatTemplate.Font.COLLECTION_BOOK_TEXT));
            if (!isBook) {
                List<String> titles = new ArrayList<>();
                for (Tune t : b.getTunes()) {
                    titles.add(t.getName());
                }
                appendMultipleTextLines(b.getShortDescription(), titles, 0.8);
            } else {
                appendMultipleTextLines(b.getShortDescription(), 0.8);
            }
        }
    }

    private void appendSingleTextLine(String text) {
        if (hasContent(text)) {
            appendLine("%%begintext");
            appendLine("%%" + text);
            appendLine("%%endtext");
        }
    }

    private void appendMultipleTextLines(String text, double verticalSkip) {
        if (hasContent(text)) {
            for (String paragraph : text.split("\n\n")) {
                appendLine("%%begintext");
                String[] para = new TextUtil(paragraph).createLines(lineLength).split("\n");
                for (String line : para) {
                    appendLine("%%" + line);
                }
                appendLine("%%endtext");
                setSkip(verticalSkip);
            }
        }
    }

    private void appendMultipleTextLines(String text, List<String> list, double verticalSkip) {
        boolean isFirst = true;
        if (hasContent(text)) {
            for (String paragraph : text.split("\n\n")) {
                if (!isFirst) {
                    setSkip(verticalSkip);
                }
                isFirst = false;
                appendLine("%%begintext");
                String[] para = new TextUtil(paragraph).createLines(lineLength).split("\n");
                for (String line : para) {
                    appendLine("%%" + line);
                }
                appendLine("%%endtext");
            }
        }
        appendLine("%%begintext");
        list.stream().forEach((l) -> {
            appendLine("%% - " + l);
        });
        appendLine("%%endtext");
        setSkip(verticalSkip);
    }

    private void appendCenteredLine(String text) {
        if (hasContent(text)) {
            appendLine("%%center " + text);
        }
    }

    private static boolean hasContent(String text) {
        return text != null && !text.isEmpty();
    }

    private void appendLine(String string) {
        abcDoc += string + NEW_LINE;
    }

    private void setSkip(Double value) {
        appendLine("%%vskip " + value + "cm");
    }

    private void setPageBreak() {
        appendLine("%%newpage");
    }
}
