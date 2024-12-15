package com.example.app.Parent;

import java.util.List;

import com.example.app.Student.putEditMarks;
import com.example.app.user.user;

public class parent extends user{
    int student_id;

    @Override
    public String toString() {
        return "parent [userName=" + userName + ", password=" + password + ", student_id=" + student_id + "]";
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public parent(String parent_username, String parent_password, int student_id) {
        this.student_id = student_id;
        this.password = parent_password;
        this.userName = parent_username;
    }

    public static void menu() {
       System.out.println("1 - show student's marks");
    }

    public static void executeActionAccordingToParentsChoise(int parentChoise, int child_id) {
        List<putEditMarks> allMarks = parentCRUDUtils.getMarks(child_id);
        for(int i = 0;i<allMarks.size();i++)
        {
            System.out.println(allMarks.get(i));
        }
    }
    
    
}
