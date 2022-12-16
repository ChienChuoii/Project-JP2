/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author welcome
 */
public class Semester {
    int semester_id;
    String semester_name;

    public Semester() {
    }

    public Semester(int semester_id, String semester_name) {
        this.semester_id = semester_id;
        this.semester_name = semester_name;
    }
    public void setData(ResultSet resultSet){
        try {
            this.semester_id= resultSet.getInt("semester_id");
            this.semester_name=resultSet.getString("semester_name");
        } catch (SQLException ex) {
            Logger.getLogger(Semester.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    public int getSemester_id() {
        return semester_id;
    }

    public void setSemester_id(int semester_id) {
        this.semester_id = semester_id;
    }

    public String getSemester_name() {
        return semester_name;
    }

    public void setSemester_name(String semester_name) {
        this.semester_name = semester_name;
    }

    
    
    
}
