/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.StudentClass;
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
public class StudentClassDAO {

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
                Logger.getLogger(StudentClassDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(StudentClassDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        statement = null;
        con = null;
    }

    public static List<StudentClass> list() {
        List<StudentClass> dataList = new ArrayList<>();
        openConnection();

        try {
            String sql = "select * from studentClass";
            statement = con.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                StudentClass studentclass = new StudentClass();
                studentclass.setData(resultSet);

                dataList.add(studentclass);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentClassDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        closeConnection();
        return dataList;

    }
    //insert
     public static void insert(StudentClass studentclass) {
        openConnection();

        String sql = "insert into studentClass(student_rollNo,class_id)"
                + " values (?,?)";

        try {
            statement = con.prepareStatement(sql);
            statement.setInt(1, studentclass.getStudent_rollNo());
            statement.setInt(2, studentclass.getClass_id());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(StudentClassDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        closeConnection();
    }

   
}
