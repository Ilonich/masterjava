package ru.javaops.masterjava.export;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import ru.javaops.masterjava.persist.DBIProvider;
import ru.javaops.masterjava.persist.dao.GroupDao;
import ru.javaops.masterjava.persist.dao.ProjectDao;
import ru.javaops.masterjava.persist.model.Group;
import ru.javaops.masterjava.persist.model.GroupType;
import ru.javaops.masterjava.persist.model.Project;
import ru.javaops.masterjava.xml.util.StaxStreamProcessor;

import javax.xml.stream.XMLStreamException;
import java.util.ArrayList;
import java.util.Map;

@Slf4j
public class ProjectGroupImporter {
    private final ProjectDao projectDao = DBIProvider.getDao(ProjectDao.class);
    private final GroupDao groupDao = DBIProvider.getDao(GroupDao.class);

    public Map<String, Group> process(StaxStreamProcessor processor) throws XMLStreamException {
        val projectMap = projectDao.getAsMap();
        val groupMap = groupDao.getAsMap();

        val newGroups = new ArrayList<Group>();

        while (processor.startElement("Project", "Projects")) {
            val pName = processor.getAttribute("name");
            val description = processor.getElementValue("description");
            Project project = projectMap.get(pName);
            if (project == null) {
                project = new Project(pName, description);
                log.info("Insert project " + project);
                projectDao.insert(project);
            }
            while (processor.startElement("Group", "Project")) {
                val gName = processor.getAttribute("name");
                if (!groupMap.containsKey(gName)) {
                    newGroups.add(new Group(gName, GroupType.valueOf(processor.getAttribute("type")), project.getId()));
                }
            }
        }
        log.info("Insert groups " + newGroups);
        groupDao.insertBatch(newGroups);
        return groupDao.getAsMap();
    }
}