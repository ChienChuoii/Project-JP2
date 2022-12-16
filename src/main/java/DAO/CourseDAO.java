/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import DTO.Course;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author welcome
 */
public class CourseDAO {

    static Connection con = null;
    static PreparedStatement statement = null;

    private static void openConnection() {
        // TODO add your handling code here:
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
        } catch (SQLException e) {
        }
    }

    private static void closeConnection() {
        //B3. Dong ket noi
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        statement = null;
        con = null;
    }

    public static List<Course> list(String s) {
        List<Course> dataList = new ArrayList<>();
        openConnection();
        try {
            String sql = "select * from courses";
             statement = con.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                Course course = new Course();
                course.setData(resultSet);

                dataList.add(course);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnection();
        return dataList;

    }
    public static void insert(Course course) {
        openConnection();

        String sql = "insert into courses(course_id,course_name)"
                + " values (?,?)";

        try {
            statement = con.prepareStatement(sql);
            statement.setInt(1, course.getCourse_id());
            statement.setString(2, course.getCourse_name());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        closeConnection();
    }

    public static void update(Course course) {
        openConnection();

        String sql = "update courses set course_name=? where course_id = ?";

        try {
            statement = con.prepareStatement(sql);
            
            statement.setInt(1, course.getCourse_id());
            statement.setString(2,course.getCourse_name());

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        closeConnection();
    }

    public static void delete(int course_id) {
        openConnection();

        String sql = "delete from courses where course_id = ?";

        try {
            statement = con.prepareStatement(sql);
            statement.setInt(1, course_id);

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        closeConnection();
    }

   
}
