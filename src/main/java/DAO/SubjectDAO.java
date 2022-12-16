/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManageStudents;

import DTO.Subject;
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
public class SubjectDAO {
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
                Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        statement = null;
        con = null;
    }
    public static List<Subject> list(String s) {
        List<Subject> dataList = new ArrayList<>();

        openConnection();

        
        try {
            String sql = "select * from subject";
            statement = con.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Subject sbj = new Subject();
                sbj.setData(resultSet);

                dataList.add(sbj);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        closeConnection();

        return dataList;
    }
 public static void insert(Subject sbj) {
        openConnection();

        String sql = "insert into subject(subject_name,semester_id)"
                + " values (?,?)";

        try {
            statement = con.prepareStatement(sql);
            statement.setString(1,sbj.getSubject_name());
            statement.setInt(2, sbj.getSemester_id());
 
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        closeConnection();
    }

    public static void update(Subject sbj) {
        openConnection();

        String sql = "update subject set subject_name=?, semester_id =? where subject_id = ?";

        try {
            statement = con.prepareStatement(sql);
            
            statement.setInt(1, sbj.getSubject_id());
            statement.setString(2,sbj.getSubject_name());
            statement.setInt(3, sbj.getSemester_id());

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        closeConnection();
    }

    public static void delete(int subject_id) {
        openConnection();

        String sql = "delete from subject where subject_id = ?";

        try {
            statement = con.prepareStatement(sql);
            statement.setInt(1, subject_id);

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        closeConnection();
    }
    
}
