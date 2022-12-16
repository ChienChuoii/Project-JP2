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
public class Subject {
    int subject_id;
    String subject_name;
    int semester_id;

    public Subject() {
    }

    public Subject(int subject_id, String subject_name, int semester_id) {
        this.subject_id = subject_id;
        this.subject_name = subject_name;
        this.semester_id = semester_id;
    }
 public void setData(ResultSet resultSet){
        try {
            this.subject_id = resultSet.getInt("subject_id");
            this.subject_name = resultSet.getString("subject_name");
            this.semester_id= resultSet.getInt("semester_id");
           
        } catch (SQLException ex) {
            Logger.getLogger(Subject.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public int getSemester_id() {
        return semester_id;
    }

    public void setSemester_id(int semester_id) {
        this.semester_id = semester_id;
    }
    
            
    
}
