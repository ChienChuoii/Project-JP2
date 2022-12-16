/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Students;
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
public class StudentsDAO {

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
                Logger.getLogger(StudentsDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(StudentsDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        statement = null;
        con = null;
    }

    public static List<Students> list(String s) {
        List<Students> dataList = new ArrayList<>();

        openConnection();

        //B2. Thuc hien truy van
        try {
            String sql = "select * from students";
            if (s != null && !s.isEmpty()) {
                sql += " where name like ?";
            }

            statement = con.prepareStatement(sql);

            if (s != null && !s.isEmpty()) {
                statement.setString(1, "%" + s + "%");
            }

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Students std = new Students();
                std.setData(resultSet);

                dataList.add(std);
            }

        } catch (SQLException ex) {
            Logger.getLogger(StudentsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        closeConnection();

        return dataList;
    }

    public static void insert(Students std) {
        openConnection();

        String sql = "insert into students(name, birthday, gender, email, address,phoneNumber,create_at,update_at)"
                + " values (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            statement = con.prepareStatement(sql);
            statement.setString(1, std.getName());
            statement.setString(2, std.getBirthday());
            statement.setString(3, std.getGender());
            statement.setString(4, std.getEmail());
            statement.setString(5, std.getAddress());
            statement.setString(6, std.getPhoneNumber());
            statement.setString(7, std.getCreate_at());
            statement.setString(8, std.getUpdate_at());

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(StudentsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        closeConnection();
    }

    public static void update(Students std) {
        openConnection();

        String sql = "update students set name = ?, birthday = ?, gender = ?, email = ?, address = ?,phoneNumbwe= ?, create_at =?, update_at =? where student_rollNo = ?";

        try {
            statement = con.prepareStatement(sql);
            statement.setInt(1, std.getStudent_rollNo());
            statement.setString(2, std.getName());
            statement.setString(3, std.getBirthday());
            statement.setString(4, std.getGender());
            statement.setString(5, std.getEmail());
            statement.setString(6, std.getAddress());
            statement.setString(7, std.getPhoneNumber());
            statement.setString(8, std.getCreate_at());
            statement.setString(9, std.getUpdate_at());

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(StudentsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        closeConnection();
    }

    public static void delete(int student_rollNo) {
        openConnection();

        String sql = "delete from students where student_rollNo = ?";

        try {
            statement = con.prepareStatement(sql);
            statement.setInt(1, student_rollNo);

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(StudentsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        closeConnection();
    }
}
