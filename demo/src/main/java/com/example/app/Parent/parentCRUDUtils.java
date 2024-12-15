package com.example.app.Parent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.app.Admin.DBUtils;
import com.example.app.Student.putEditMarks;


public class parentCRUDUtils {
    private static String queryAccordingToStudent_id = "SELECT * FROM marks WHERE student_id = ?;";

     public static List<putEditMarks> getMarks(int student_id){
        List <putEditMarks> marks = new ArrayList<>();

        try (Connection connection = DBUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(queryAccordingToStudent_id)){
        
        preparedStatement.setInt(1, student_id);
        preparedStatement.executeQuery();

        //PreparedStatement allMarks = connection.prepareStatement("SELECT * FROM marks");
        ResultSet rs = preparedStatement.executeQuery();

        while(rs.next()){

            int student_idd = rs.getInt("student_id");
            String teacher_course = rs.getString("teacher_course");
            int mark = rs.getInt("mark");
            marks.add(new putEditMarks(student_idd,teacher_course,mark));
        }

        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return marks;
    }
}
