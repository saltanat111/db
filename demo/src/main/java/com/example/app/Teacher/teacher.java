package com.example.app.Teacher;

import java.util.List;
import java.util.Scanner;
import com.example.app.Student.putEditMarks;
import com.example.app.user.user;

public class teacher extends user {

    

    public teacher(String teacher_username, String teacher_password,String teacher_course, int teacher_course_id) {
        this.teacher_course = teacher_course;
        this.teacher_course_id = teacher_course_id;
        this.userName = teacher_username;
        this.password = teacher_password;
    }

    @Override
    public String toString() {
        return "teacher [userName=" + userName + ", password=" + password + ", teacher_course=" + teacher_course
                + ", teacher_course_id=" + teacher_course_id + "]";
    }
    String teacher_course;
    int teacher_course_id;
    public String getTeacher_course() {
        return teacher_course;
    }
    public void setTeacher_course(String teacher_course) {
        this.teacher_course = teacher_course;
    }
    public int getTeacher_course_id() {
        return teacher_course_id;
    }
    public void setTeacher_course_id(int teacher_course_id) {
        this.teacher_course_id = teacher_course_id;
    }

    public static void executeActionAccordingToTeachersChoise(int teacherChoise,String courseName) {
        Scanner scan = new Scanner(System.in);
        if(teacherChoise == 1)
        {
            System.out.println("Enter student's id you want to put mark:");
            int id = scan.nextInt();
            scan.nextLine();
            System.out.println("Enter mark you want to put:");
            int mark = scan.nextInt();
            scan.nextLine();
            List<putEditMarks> putMark = teacherCRUDUtils.putMarks(id,courseName,mark);
            System.out.println(putMark.get(putMark.size()-1));
        }
        else if(teacherChoise == 2)
        {
            System.out.println("Enter student's id whose mark you want to edit: ");
            int id = scan.nextInt();
            scan.nextLine();
            System.out.println("Enter mark you want to put: ");
            int mark = scan.nextInt();
            scan.nextLine();
            List<putEditMarks> editedMark = teacherCRUDUtils.editMarks(id, courseName, mark);
            for (int i = 0;i<editedMark.size();i++)
            {
                System.out.println(editedMark.get(i));
            }
        }
        else if(teacherChoise == 3)
        {
            List<com.example.app.Student.seeAllMarks> myStudentsMarks = teacherCRUDUtils.getMarks("select marks.teacher_course, marks.mark, students.student_username from marks join students on students.student_id = marks.student_id",courseName);
            for (int i = 0;i<myStudentsMarks.size();i++)
            {
                System.out.println(myStudentsMarks.get(i));
            }
        }
    }

    public static void menu() {
       System.out.println("1 - put mark\n2 - edit mark\n3 - see my students marks");
    }


    
    
}
