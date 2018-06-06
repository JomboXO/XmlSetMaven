package entities.to_xml;
import javax.xml.bind.annotation.XmlAttribute;

public class Role implements Comparable<Role> {
    private String name;
    private String project;

    public String getName() {
        return name;
    }

    @XmlAttribute
    public void setName(String name) {
        this.name = name;
    }

    public String getProject() {
        return project;
    }

    @XmlAttribute
    public void setProject(String project) {
        this.project = project;
    }


    @Override
    public int compareTo(Role o) {
        int res = this.project.compareTo(o.project);
        if (res == 0) {
            res = this.name.compareTo(o.name);
        }
        return res;
    }
}