package nu.hex.abc.music.service.xml.read;

import abc.music.core.domain.Project;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import nu.hex.abc.music.service.io.Reader;
import se.digitman.lightxml.XmlNode;

/**
 * Created 2016-dec-01
 *
 * @author hl
 */
class ProjectReader implements Reader<Project> {

    private final XmlNode node;
    private Project result;

    public ProjectReader(XmlNode node) {
        this.node = node;
    }

    @Override
    public Project read() {
        result = new Project(node.getAttribute("name"));
        if (node.hasAttribute("abc-version")) {
            result.setAbcVersion(node.getAttribute("abc-version"));
        }
        if (node.hasAttribute("summary")) {
            result.setSummary(node.getAttribute("summary"));
        }
        if (node.hasChildNamed("owner")) {
            if (result.getOwner() == null) {
                result.setOwner(new Project.Owner(result));
            }
            result.getOwner().setFirstName(node.getChild("owner").getAttribute("first-name"));
            result.getOwner().setLastName(node.getChild("owner").getAttribute("last-name"));
            result.getOwner().setEmail(node.getChild("owner").getAttribute("email"));
        }
        result.setLastUpdated(LocalDateTime.parse(node.getAttribute("last-updated"), DateTimeFormatter.ISO_DATE_TIME));
        if (node.hasChildNamed("persons") && node.getChild("persons").hasChildNamed("person")) {
            node.getChild("persons").getChildren("person").stream().forEach(this::addPerson);
        }
        if (node.hasChildNamed("tunes") && node.getChild("tunes").hasChildNamed("tune")) {
            node.getChild("tunes").getChildren("tune").stream().forEach(this::addTune);
        }
        return result;
    }

    private void addTune(XmlNode tuneNode) {
        result.addTune(new TuneReader(result, tuneNode).read());
    }

    private void addPerson(XmlNode personNode) {
        result.addPerson(new PersonReader(personNode).read());
    }
}