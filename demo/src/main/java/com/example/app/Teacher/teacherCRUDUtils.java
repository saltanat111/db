package com.example.app.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.app.Admin.DBUtils;
import com.example.app.Student.seeAllMarks;
import com.example.app.Student.putEditMarks;


public class teacherCRUDUtils {
    private static final String INSERT_INTO = "INSERT INTO marks (student_id,teacher_course,mark) VALUES (?, ?, ? );";
    private static final String UPDATE_MARK = "UPDATE marks SET mark = ? WHERE teacher_course = ? and student_id = ? ;";

    public static List<seeAllMarks> getMarks(String query,String teacher_coursee){
        List <seeAllMarks> marks = new ArrayList<>();

        try (Connection connection = DBUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)){
        ResultSet rs = preparedStatement.executeQuery();

        while(rs.next()){

            String student_username = rs.getString("student_username");
            String teacher_course = rs.getString("teacher_course");
            int mark = rs.getInt("mark");
            if(teacher_course.equals(teacher_coursee))
            {
                marks.add(new seeAllMarks(student_username,teacher_course,mark));
            }
        }

        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return marks;
    }

    public static List<putEditMarks> putMarks(int student_id, String teacher_course,int mark){
        List <putEditMarks> putMarks = new ArrayList<>();
        //    String INSERT_INTO = "INSERT_INTO marks (student_id,teacher_course,mark) VALUES (?,?,?);";
        try (Connection connection = DBUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO)){

        preparedStatement.setInt(1,student_id);
        preparedStatement.setString(2,teacher_course);
        preparedStatement.setInt(3, mark);
        preparedStatement.executeUpdate();

            PreparedStatement allMarks = connection.prepareStatement("SELECT * FROM marks");
            ResultSet rs = allMarks.executeQuery();


        while(rs.next()){
            int student_idn = rs.getInt("student_id");
            String teacher_coursen = rs.getString("teacher_course");
            int markn = rs.getInt("mark");
            if(teacher_coursen.equals(teacher_course))
            {
                putMarks.add(new putEditMarks(student_idn, teacher_coursen, markn));
            }
        }

        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return putMarks;
    }
    
    public static List<putEditMarks> editMarks(int student_id, String teacher_course,int mark){
        List <putEditMarks> editMarks = new ArrayList<>();
        //   UPDATE marks SET mark = ? WHERE teacher_course = ? and student_id = ? ;
        try (Connection connection = DBUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_MARK)){

        preparedStatement.setInt(1,mark);
        preparedStatement.setString(2,teacher_course);
        preparedStatement.setInt(3, student_id);
        preparedStatement.executeUpdate();

            PreparedStatement allMarks = connection.prepareStatement("SELECT * FROM marks");
            ResultSet rs = allMarks.executeQuery();


        while(rs.next()){
            int student_idn = rs.getInt("student_id");
            String teacher_coursen = rs.getString("teacher_course");
            int markn = rs.getInt("mark");
            if (teacher_course.equals(teacher_coursen))
            {
                editMarks.add(new putEditMarks(student_idn, teacher_coursen, markn));
            }
        }

        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return editMarks;
    }


}
