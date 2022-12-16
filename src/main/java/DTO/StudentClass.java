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
public class StudentClass {
    int student_rollNo;
    int class_id;

    public StudentClass() {
    }

    public StudentClass(int student_rollNo, int class_id) {
        this.student_rollNo = student_rollNo;
        this.class_id = class_id;
    }
    public void setData(ResultSet resultSet){
        try {
            this.student_rollNo=resultSet.getInt("student_rollNo");
            this.class_id=resultSet.getInt("class_id");
        } catch (SQLException ex) {
            Logger.getLogger(StudentClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public int getStudent_rollNo() {
        return student_rollNo;
    }

    public void setStudent_rollNo(int student_rollNo) {
        this.student_rollNo = student_rollNo;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }
    
}
