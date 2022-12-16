/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Score;
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
public class ScoreDAO {

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
                Logger.getLogger(ScoreDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ScoreDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        statement = null;
        con = null;
    }

    public static List<Score> list() {
        List<Score> dataList = new ArrayList<>();

        openConnection();

        //B2. Thuc hien truy van
        try {
            String sql = "select * from score";

            statement = con.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Score score = new Score();
                score.setData(resultSet);

                dataList.add(score);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ScoreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        closeConnection();

        return dataList;
    }

    public static void insert(Score score) {
        openConnection();

        String sql = "insert into score(student_rollNo,subject_id,theory1,theory2,practical1,practical2,create_at,update_at)"
                + " values (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            statement = con.prepareStatement(sql);
            statement.setInt(1, score.getStudent_rollNo());
            statement.setInt(2, score.getSubject_id());
            statement.setFloat(3, score.getTheory1());
            statement.setFloat(4, score.getTheory2());
            statement.setFloat(5, score.getPractical1());
            statement.setFloat(6, score.getPractical2());
            statement.setString(7, score.getCreate_at());
            statement.setString(8, score.getUpdate_at());

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(StudentsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        closeConnection();
    }

    public static void update(Score score) {
        openConnection();

        String sql = "update score set  subject_id=?,theory1=?,theory2=?,practical1=?,practica2=?, create_at =?, update_at =? where student_rollNo = ?";

        try {
            statement = con.prepareStatement(sql);

            statement.setInt(1, score.getStudent_rollNo());
            statement.setInt(2, score.getSubject_id());
            statement.setFloat(3, score.getTheory1());
            statement.setFloat(4, score.getTheory2());
            statement.setFloat(5, score.getPractical1());
            statement.setFloat(6, score.getPractical2());
            statement.setString(7, score.getCreate_at());
            statement.setString(8, score.getUpdate_at());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ScoreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        closeConnection();
    }

    public static void delete(int student_rollNo) {
        openConnection();

        String sql = "delete from score where student_rollNo = ?";

        try {
            statement = con.prepareStatement(sql);
            statement.setInt(1, student_rollNo);

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ScoreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        closeConnection();
    }
}
