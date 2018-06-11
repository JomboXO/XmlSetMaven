import entities.from_xml.Member;
import entities.from_xml.Project;
import entities.from_xml.Projects;
import entities.to_xml.OutputMember;
import entities.to_xml.Role;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MainTest {

    private  Projects projects;
    private  Project project;
    private Member member;
    private Role role;
    private OutputMember outputMember;
    private List<Project> projectList = new ArrayList<>();
    private List<Member> memberList = new ArrayList<>();
    private Set<String> resultsNames = new TreeSet<>();
    private Set<Role> roleSet;
    private Set<OutputMember> outputMemberSet = new TreeSet<>();
    private Set<OutputMember> memberSet = new TreeSet<>();

    @Before
    public void beforeTest(){
        resultsNames.add("Ivan");
        resultsNames.add("fedya");

        projects = new Projects();

        outputMember = new OutputMember();
        roleSet = new TreeSet<>();

        project = new Project();
        project.setName("xml");
        member = new Member();
        member.setName("fedya");
        member.setRole("developer");
        memberList.add(member);

        member = new Member();
        member.setName("Ivan");
        member.setRole("manager");
        memberList.add(member);
        outputMember.setName("Ivan");
        role = new Role();
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
        assertEquals("results",resultsNames, Main.fillListOfNames(projects));
    }

    @Test
    public void fillMembersTest() {
        assertEquals("result", outputMemberSet, Main.fillMembers(memberSet, projects,resultsNames));
    }
}
