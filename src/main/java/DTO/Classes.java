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
public class Classes {
    int class_id;
    int course_id;
    String class_name;

    public Classes() {
    }

    public Classes(int class_id, int course_id, String class_name) {
        this.class_id = class_id;
        this.course_id = course_id;
        this.class_name = class_name;
    }
    public void setData(ResultSet resultSet) {
        try {
            this.class_id=resultSet.getInt("class_id");
            this.course_id=resultSet.getInt("course_id");
            this.class_name=resultSet.getString("class_name");
        } catch (SQLException ex) {
            Logger.getLogger(Classes.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }
    
    
}
