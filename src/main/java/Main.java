import entities.from_xml.Member;
import entities.from_xml.Project;
import entities.from_xml.Projects;
import entities.to_xml.Members;
import entities.to_xml.OutputMember;
import entities.to_xml.Role;

import javax.xml.bind.*;
import java.io.File;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        File file = new File("file.xml");

        Projects projects = doUnmarshaller(file);

        Set<OutputMember> memberSet = new TreeSet<>();

        Set<String> listOfNames = fillListOfNames(projects);
        memberSet = fillMembers(memberSet, projects, listOfNames);
        Members members = new Members();
        members.setMember(memberSet);
        doMarshaller(members);
    }

    private static Set<String> fillListOfNames(Projects pr) {
        Set<String> listOfNames = new TreeSet<>();
        for (Project project : pr.getProject())
            for (Member member : project.getMember())
                listOfNames.add(member.getName());

        return listOfNames;
    }

    private static Set<OutputMember> fillMembers(Set<OutputMember> memberSet, Projects projects, Set<String> listOfNames) {
        for (String name : listOfNames) {
            OutputMember outputMember = new OutputMember();
            Set<Role> roles = new TreeSet<>();
            for (Project project : projects.getProject()) {
                for (Member member : project.getMember()) {
                    if (Objects.equals(member.getName(), name)){
                        Role role = new Role();
                        role.setName(member.getRole());
                        role.setProject(project.getName());
                        roles.add(role);

                    }
                }
            }
            outputMember.setName(name);
            outputMember.setRole(roles);
            memberSet.add(outputMember);
        }

        return memberSet;
    }

    private static void doMarshaller(Members pr) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Members.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(pr, new File("out.xml"));
            jaxbMarshaller.marshal(pr, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private static Projects doUnmarshaller(File file) {
        Projects projects = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Projects.class);
            Unmarshaller jabxUnmarshaller = jaxbContext.createUnmarshaller();
            projects = (Projects) jabxUnmarshaller.unmarshal(file);
            System.out.println(projects);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return projects;
    }

}