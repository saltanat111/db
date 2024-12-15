package com.example.app.Student;

public class seeAllMarks {
    private String student_username;
    private String teacher_course;
    private int mark;

    

    public seeAllMarks(String student_username, String teacher_course, int mark) {
        this.student_username = student_username;
        this.teacher_course = teacher_course;
        this.mark = mark;
    }

    public seeAllMarks(int student_id2, String teacher_coursers, int mark2) {
        //TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "student_username: " + student_username + 
                ",course: " + teacher_course +
                ", mark: " + mark + "";
    }
    
    public String getTeacher_course() {
        return teacher_course;
    }
    public void setTeacher_course(String teacher_course) {
        this.teacher_course = teacher_course;
    }
    public int getMark() {
        return mark;
    }
    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getStudent_username() {
        return student_username;
    }

    public void setStudent_username(String student_username) {
        this.student_username = student_username;
    }
    

}
