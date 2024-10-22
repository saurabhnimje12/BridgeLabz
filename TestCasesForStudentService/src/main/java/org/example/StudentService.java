package org.example;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

    // Inserting single students
    public String insertStudent(List<Student> stuList, Student student) {
        if (student != null) {
            stuList.add(student);
            return "success";
        } else {
            return "failure";
        }
    }

    // Inserting multiple students
    public String insertAllStudent(List<Student> studentList, List<Student> list) {
        if (!list.isEmpty()) {
            studentList.addAll(list);
            return "success";
        } else {
            return "failure";
        }
    }

    // Removing students from the list and returning the studentlist size
    public int removeStudent(List<Student> stuList, Integer stuId) {
        for (Student student : stuList) {
            if (student.getStudentId() == stuId) {
                stuList.remove(student);
                return stuList.size();
            }
        }
        return -1;
    }

    // Returning the all studentlist size
    public int getAllStudentsCount(List<Student> stuList) {
        return stuList.size();
    }

    // Retrieving the student name at the specified student id
    public String getStudentByStuID(List<Student> stuList, Integer stuId) {
        for (Student student : stuList) {
            if (student.getStudentId() == stuId) {
                return student.getStudentName();
            }
        }
        return "failure";
    }

    // Returning the student list who matches for a specific course
    public int getStudentByCourse(List<Student> stuList, String course) {
        int count = 0;
        for (Student student : stuList) {
           if ( student.getCourseName().equals(course)) {
               count++;
           }
        }
        return count;
    }

    // Returning the student list who matches for a specific gpa and more
    public List<Student> getStudentByCgpa(List<Student> stuList, double cgpa) {
        List<Student> list = new ArrayList<>();
        for (Student student : stuList) {
            if (student.getCgpa() >= cgpa) {
                list.add(student);
            }
        }
        return list;
    }

    // Returning the student list who matches for a specific name
    public List<Student> getStudentByName(List<Student> stuList, String name) {
        List<Student> list = new ArrayList<>();
        for (Student student : stuList) {
            if (student.getStudentName().equals(name)) {
                list.add(student);
            }
        }
        return list;
    }

}
