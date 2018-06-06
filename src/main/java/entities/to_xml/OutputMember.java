package entities.to_xml;

import javax.xml.bind.annotation.XmlAttribute;
import java.util.Set;
import java.util.TreeSet;

public class OutputMember implements Comparable<OutputMember>{

    private String name;
    private Set<Role> role = new TreeSet<>();

    public String getName() {
        return name;
    }

    @XmlAttribute
    public void setName(String name) {
        this.name = name;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }

    @Override
    public int compareTo(OutputMember o) {
        return this.name.compareTo(o.name);
    }
}