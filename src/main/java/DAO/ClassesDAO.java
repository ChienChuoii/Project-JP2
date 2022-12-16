/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Classes;
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
public class ClassesDAO {
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
                Logger.getLogger(ClassesDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClassesDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        statement = null;
        con = null;
    }
    public static List<Classes> list(String s) {
        List<Classes> dataList = new ArrayList<>();
        openConnection();
        try {
            String sql = "select * from classes";
             if (s != null && !s.isEmpty()) {
                sql += " where class_name like ?";
            }

            statement = con.prepareStatement(sql);
            if (s != null && !s.isEmpty()) {
                statement.setString(1, "%" + s + "%");
            }

            ResultSet resultSet= statement.executeQuery();
            
            while (resultSet.next()) {
                Classes classes = new Classes();
                classes.setData(resultSet);

                dataList.add(classes);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnection();
        return dataList;

    }
    public static void insert(Classes classes) {
        openConnection();

        String sql = "insert into classes(course_id,class_name)"
                + " values (?,?)";

        try {
            statement = con.prepareStatement(sql);
            statement.setInt(1, classes.getCourse_id());
            statement.setString(2, classes.getClass_name());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ClassesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        closeConnection();
    }

    public static void update(Classes classes) {
        openConnection();

        String sql = "update classes set course_id=?, class_name=? where class_id = ?";

        try {
            statement = con.prepareStatement(sql);
            
            statement.setInt(1, classes.getCourse_id());
            statement.setInt(2, classes.getClass_id());
            statement.setString(3,classes.getClass_name());
            

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ClassesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        closeConnection();
    }

    public static void delete(int class_id) {
        openConnection();

        String sql = "delete from classes where class_id = ?";

        try {
            statement = con.prepareStatement(sql);
            statement.setInt(1, class_id);

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ClassesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        closeConnection();
    }
    
}
