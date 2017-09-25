package ru.javaops.masterjava;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.io.Resources;
import ru.javaops.masterjava.xml.schema.Group;
import ru.javaops.masterjava.xml.schema.ObjectFactory;
import ru.javaops.masterjava.xml.schema.Payload;
import ru.javaops.masterjava.xml.schema.User;
import ru.javaops.masterjava.xml.util.JaxbParser;
import ru.javaops.masterjava.xml.util.Schemas;
import ru.javaops.masterjava.xml.util.StaxStreamProcessor;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MainXml {
    private String projectName;

    private static final JaxbParser JAXB_PARSER = new JaxbParser(ObjectFactory.class);

    static {
        JAXB_PARSER.setSchema(Schemas.ofClasspath("payload.xsd"));
    }

    public MainXml(String projectName) {
        this.projectName = projectName;
    }

    public void printProjectUsersJAXB() throws IOException, JAXBException {
        Payload payload = JAXB_PARSER.unmarshal(Resources.getResource("payload.xml").openStream());
        List<Group> groups = payload.getProjects().getProject().stream()
                .filter( project -> project.getProjectName().equals(projectName))
                .findFirst().orElseThrow( () -> new RuntimeException("Not found project with name \"" + projectName + "\""))
                .getGroups().getGroup();
        List<User> usersInProject = payload.getUsers().getUser().stream()
                .filter( user -> !Collections.disjoint(user.getGroups(), groups))
                .sorted( (left, right) -> Ordering.natural().compare(left.getFullName(), right.getFullName()))
                .collect(Collectors.toList());
        usersInProject.forEach( user -> System.out.println(user.getFullName()));
    }

    public void printProjectUsersStAX() throws XMLStreamException, IOException {
        try (StaxStreamProcessor processor =
                     new StaxStreamProcessor(Resources.getResource("payload.xml").openStream())) {
            processor.doUntilAnyStartElementContainsValue("projectName", projectName);
            XMLStreamReader reader = processor.getReader();
            List<String> projectGroups = new ArrayList<>();
            while (reader.hasNext()) {
                int event = reader.next();
                if (event == XMLEvent.START_ELEMENT) {
                    if ("Group".equals(reader.getLocalName())) {
                        projectGroups.add(reader.getAttributeValue("", "name"));
                    }
                } else if (event == XMLEvent.END_ELEMENT) {
                    if ("Groups".equals(reader.getLocalName())) {
                        break;
                    }
                }
            }
            while (processor.doUntil(1, "User")) {
                List<String> userGroups = Lists.newArrayList(Splitter.on(" ").split(reader.getAttributeValue("", "groups")));
                if (!Collections.disjoint(projectGroups, userGroups)) {
                    String email = reader.getAttributeValue("", "email");
                    processor.doUntil(1, "fullName");
                    String name = reader.getElementText();
                    System.out.println(name + " " + email);
                }
            }
        }
    }
}
