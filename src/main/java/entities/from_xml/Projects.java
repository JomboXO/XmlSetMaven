package entities.from_xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Projects {

    private List<Project> project = new ArrayList<>();

    public List<Project> getProject() {
        return project;
    }

    public void setProject(List<Project> project) {
        this.project = project;
    }
    @XmlElementWrapper(name = "projects")
    @XmlElement(name = "project")
    public List<Project> getProjects(){
        return project;
    }

    @Override
    public String toString() {
        return "Projects{" +
                "project=" + project +
                '}';
    }
}