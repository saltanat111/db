package com.example.app.Admin;

import java.util.List;
import java.util.Scanner;

import com.example.app.Parent.parent;
import com.example.app.Student.student;
import com.example.app.Teacher.teacher;
import com.example.app.user.user;


public class admin extends user {

    public static void menu() {
        System.out.println("1 - update student profile\n2 - update teacher profile\n3 - update parent profile\n4 - create student profile\n5 - create teacher profile\n6 - create parent profile\n7 - see all marks" );
    }
    public static void executeActionAccordingToAdminsChoise(int adminsChoise)
    {
        int student_id_for_new_student = 8;
        int teacher_id_for_new_teacher = 6;
        Scanner scan = new Scanner(System.in);

        if(adminsChoise == 7){
            List<com.example.app.Student.seeAllMarks> allMarks = adminCRUDUtils.getMarks("select marks.teacher_course, marks.mark, students.student_username from marks join students on students.student_id = marks.student_id");
            for (int i = 0;i<allMarks.size();i++)
            {
                System.out.println(allMarks.get(i));
            }
           
        }
        else if(adminsChoise == 6){
            System.out.println("Enter parent's username you want to create:");
            String parent_username = scan.next();
            System.out.println("Create password for this profile:");
            String parent_password = scan.next();
            System.out.println("Enter student's id:");
            int student_id = scan.nextInt();
            scan.nextLine();
            List<parent> createParent = adminCRUDUtils.createParentProfile(parent_username,parent_password,student_id);
            System.out.println("Parent's profile created");
            System.out.println(createParent.get(createParent.size()-1));
            
        }
        else if (adminsChoise == 5) {
            System.out.println("Enter teacher's username you want to create:");
            String teacher_username = scan.nextLine();
            System.out.println("Create password for this profile:");
            String teacher_password = scan.nextLine();
            System.out.println("Enter teacher's course:");
            String teacher_course = scan.nextLine();
            teacher_id_for_new_teacher++;
            List<teacher> createTeacher = adminCRUDUtils.createTeacherProfile(teacher_username,teacher_password,teacher_course,teacher_id_for_new_teacher);
            for (int i = 0;i<createTeacher.size();i++)
            {
                System.out.println(createTeacher.get(i));
            }
        }
        else if(adminsChoise == 4){

            System.out.println("Enter username for the student's profile:");
            String username = scan.nextLine();
            System.out.println("Enter password for this profile:");
            String password = scan.nextLine();
            List<student> createStudent = adminCRUDUtils.createStudentProfile(student_id_for_new_student,username,password);
            student_id_for_new_student++;
            for (int i = 0;i<createStudent.size();i++)
            {
                System.out.println(createStudent.get(i));
            }
        }
        else if(adminsChoise == 3){
            System.out.println("Enter parent username you want to update:");
            String username = scan.nextLine();
            System.out.println("Enter new password for the parent's profile:");
            String password = scan.nextLine();
            System.out.println("Enter student's id you want to set:");
            int id = scan.nextInt();
            scan.nextLine();
            List<parent> updateParent = adminCRUDUtils.updateParentProfile(username,password,id);
            for (int i = 0;i<updateParent.size();i++)
            {
                System.out.println(updateParent.get(i));
            }
        }
        else if(adminsChoise == 2){
            System.out.println("Enter teacher's username you want to update :");
            String username = scan.nextLine();
            System.out.println("Enter password you want to set:");
            String password = scan.nextLine();
            System.out.println("Enter teacher's course name you want to set:");
            String course_name = scan.nextLine();
            System.out.println("Enter teacher's course id you want to set:");
            int course_id = scan.nextInt();
            scan.nextLine();
            List<teacher> updateTeacher = adminCRUDUtils.updateTeacherProfile(username,password,course_name,course_id);
            for (int i = 0;i<updateTeacher.size();i++)
            {
                System.out.println(updateTeacher.get(i));
            }
        }
        else if(adminsChoise == 1){
            System.out.println("Enter student's id number you want to update :");
            int id = scan.nextInt();
            scan.nextLine();
            System.out.println("Enter username you want to set:");
            String username = scan.nextLine();
            System.out.println("Enter password you want to set:");
            String password = scan.nextLine();
            List<student> updateStudent = adminCRUDUtils.updateStudentProfile(id,username,password);
            for (int i = 0;i<updateStudent.size();i++)
            {
                System.out.println(updateStudent.get(i));
            }
        }
    }
    
}
