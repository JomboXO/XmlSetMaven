package entities.to_xml;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;
import java.util.TreeSet;

@XmlRootElement
public class Members {
    private Set<OutputMember> outputMembers = new TreeSet<>();

    public Set<OutputMember> getMember() {
        return outputMembers;
    }

    public void setMember(Set<OutputMember> outputMembers) {
        this.outputMembers = outputMembers;
    }

}