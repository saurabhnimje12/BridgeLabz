import org.example.Student;
import org.example.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestStudentServices {
    List<Student> stuList = new ArrayList<>();
    StudentService stuService = new StudentService();

    @Test
    public void studentServiceTest() {
        Student stu1 = new Student(101, "John", "Mechanical", 9.34);
        assertEquals("success", stuService.insertStudent(stuList, stu1));
        Student stu2 = new Student(102, "Charle", "CSE", 8.42);
        Student stu3 = new Student(103, "Roy", "Electrical", 7.24);
        assertEquals("success", stuService.insertAllStudent(stuList, Arrays.asList(stu2, stu3)));
        assertEquals(2, stuService.removeStudent(stuList, 103));
        assertEquals(2, stuService.getAllStudentsCount(stuList));
        assertEquals("Charle", stuService.getStudentByStuID(stuList, 102));
        assertEquals(1, stuService.getStudentByCourse(stuList, "CSE"));

        List<Student> list = new ArrayList<>();
        list = stuService.getStudentByCgpa(stuList, 7.00);
        assertEquals(true, stuService.getAllStudentsCount(list) == 2);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Charle", "John"})
    public void studentServiceParaTest(String name) {
        Student stu1 = new Student(101, "John", "Mechanical", 9.34);
        Student stu2 = new Student(102, "Charle", "CSE", 8.42);
        Student stu3 = new Student(103, "Roy", "Electrical", 7.24);
        assertEquals("success", stuService.insertAllStudent(stuList, Arrays.asList(stu1, stu2, stu3)));

//        List<Student> listStu;
//        listStu = stuService.getStudentByName(stuList, name);
//        assertEquals(true, stuService.getAllStudentsCount(listStu) == 3);

        List<Student> listStu = stuService.getStudentByName(stuList, name);
        assertEquals(1, listStu.size(), "There should be 1 student with the name " + name);
//        System.out.println("Students found with name '" + name + "': " + listStu);

    }


}
