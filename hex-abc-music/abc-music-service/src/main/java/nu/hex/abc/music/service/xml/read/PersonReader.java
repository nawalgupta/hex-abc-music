package nu.hex.abc.music.service.xml.read;

import abc.music.core.domain.Person;
import se.digitman.lightxml.XmlNode;

/**
 * Created 2016-dec-02
 *
 * @author hl
 */
public class PersonReader extends NodeReader<Person> {

    public PersonReader(XmlNode node) {
        super(node);
    }

    @Override
    public Person read() {
        Person result = new Person();
        if (node.hasAttribute("first-name")) {
            result.setFirstName(node.getAttribute("first-name"));
        }
        if (node.hasAttribute("last-name")) {
            result.setLastName(node.getAttribute("last-name"));
        }
        if (node.hasAttribute("email")) {
            result.setEmail(node.getAttribute("email"));
        }
        return result;
    }
}
