import entities.from_xml.Member;
import entities.from_xml.Project;
import entities.from_xml.Projects;
import entities.to_xml.OutputMember;
import entities.to_xml.Role;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MainTest {

    private static Projects projects = new Projects();;
    private static Set<String> resultsNames = new TreeSet<>();
    private static Set<OutputMember> memberSet = new TreeSet<>();
    private static Set<OutputMember> outputMemberSet = new TreeSet<>();

    @BeforeClass
    public static void beforeTest(){
        List<Project> projectList = new ArrayList<>();
        List<Member> memberList = new ArrayList<>();

        resultsNames.add("Ivan");
        resultsNames.add("fedya");

        OutputMember outputMember = new OutputMember();
        Set<Role> roleSet = new TreeSet<>();

        Project project = new Project();
        project.setName("xml");
        Member member = new Member();
        member.setName("fedya");
        member.setRole("developer");
        memberList.add(member);

        member = new Member();
        member.setName("Ivan");
        member.setRole("manager");
        memberList.add(member);
        outputMember.setName("Ivan");
        Role role = new Role();
        role.setProject("xml");
        role.setName("manager");
        roleSet.add(role);
        outputMember.setRole(roleSet);
        outputMemberSet.add(outputMember);
        project.setMember(memberList);
        projectList.add(project);

        project = new Project();
        project.setName("rpc");
        member = new Member();
        outputMember = new OutputMember();
        roleSet = new TreeSet<>();
        member.setName("fedya");
        member.setRole("developer");
        memberList.add(member);
        outputMember.setName("fedya");
        role = new Role();
        role.setProject("rpc");
        role.setName("developer");
        roleSet.add(role);
        role = new Role();
        role.setProject("xml");
        role.setName("developer");
        roleSet.add(role);
        outputMember.setRole(roleSet);
        project.setMember(memberList);

        outputMemberSet.add(outputMember);
        projectList.add(project);
        projects.setProject(projectList);
    }


    @Test
    public void fillListOfNamesTest() {
        assertNotNull(Main.fillListOfNames(projects));
        assertEquals("Return list of names members in all projects",resultsNames, Main.fillListOfNames(projects));
    }

    @Test
    public void fillMembersTest() {
        assertNotNull(Main.fillMembers(memberSet, projects,resultsNames));
        assertEquals("Return new object \"Members\" for new xml-file", outputMemberSet, Main.fillMembers(memberSet, projects,resultsNames));
    }
}
