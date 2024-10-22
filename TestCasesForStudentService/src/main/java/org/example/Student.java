package org.example;

public class Student {
    int studentId;
    String studentName;
    String courseName;
    double cgpa;

    public Student(int studentId, String studentName, String courseName, double cgpa) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.courseName = courseName;
        this.cgpa = cgpa;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }
}
