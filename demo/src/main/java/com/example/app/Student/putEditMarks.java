package com.example.app.Student;

public class putEditMarks {
    private int student_id;
    String teacher_cource;
    int mark;


    
    public putEditMarks(int student_id, String teacher_cource, int mark) {
        this.student_id = student_id;
        this.teacher_cource = teacher_cource;
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "student_id: " + student_id + ",teacher_cource: " + teacher_cource + ", mark: " + mark + "";
    }

    public int getStudent_id() {
        return student_id;
    }
    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }
    public String getTeacher_cource() {
        return teacher_cource;
    }
    public void setTeacher_cource(String teacher_cource) {
        this.teacher_cource = teacher_cource;
    }
    public int getMark() {
        return mark;
    }
    public void setMark(int mark) {
        this.mark = mark;
    }

   
    
    
}
