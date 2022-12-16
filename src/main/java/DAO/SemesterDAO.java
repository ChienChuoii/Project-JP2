/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Semester;
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
public class SemesterDAO {

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
                Logger.getLogger(SemesterDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(SemesterDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        statement = null;
        con = null;
    }

    public static List<Semester> list() {
        List<Semester> dataList = new ArrayList<>();
        openConnection();
        try {
            String sql = "select * from semester";
            statement = con.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Semester semester = new Semester();
                semester.setData(resultSet);

                dataList.add(semester);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SemesterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnection();
        return dataList;

    }

    public static void insert(Semester semester) {
        openConnection();

        String sql = "insert into semester(semester_id,semester_name)"
                + " values (?,?)";

        try {
            statement = con.prepareStatement(sql);
            statement.setInt(1, semester.getSemester_id());
            statement.setString(2, semester.getSemester_name());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SemesterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        closeConnection();
    }

    public static void update(Semester semester) {
        openConnection();

        String sql = "update semester set semester_name=? where semester_id = ?";

        try {
            statement = con.prepareStatement(sql);

            statement.setInt(1, semester.getSemester_id());
            statement.setString(2, semester.getSemester_name());

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SemesterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        closeConnection();
    }

    public static void delete(int semester_id) {
        openConnection();

        String sql = "delete from semester where semester_id = ?";

        try {
            statement = con.prepareStatement(sql);
            statement.setInt(1, semester_id);

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SemesterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        closeConnection();
    }

}
