package entities.from_xml;

import javax.xml.bind.annotation.XmlAttribute;

public class Member{
    private String role;
    private String name;

    public String getRole() {
        return role;
    }

    @XmlAttribute
    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }
    @XmlAttribute
    public void setName(String name) {
        this.name = name;
    }
}