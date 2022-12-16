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
public class Score {

    int student_rollNo, subject_id;
    float theory1, theory2;
    float practical1, practical2;
    String create_at, update_at;

    public Score() {
    }

    public Score(int student_rollNo, int subject_id, float theory1, float theory2, float practical1, float practical2, String create_at, String update_at) {
        this.student_rollNo = student_rollNo;
        this.subject_id = subject_id;
        this.theory1 = theory1;
        this.theory2 = theory2;
        this.practical1 = practical1;
        this.practical2 = practical2;
        this.create_at = create_at;
        this.update_at = update_at;
    }
     public void setData(ResultSet resultSet){
        try {
            this.student_rollNo = resultSet.getInt("student_rollNo");
            this.subject_id = resultSet.getInt("subject_id ");
            this.theory1=resultSet.getFloat("theory1");
            this.theory2=resultSet.getFloat("theory2");
            this.practical1=resultSet.getFloat("practical1");
            this.practical2=resultSet.getFloat("practical2");
            this.create_at=resultSet.getString("create_at");
            this.update_at=resultSet.getString("update_at");
        } catch (SQLException ex) {
            Logger.getLogger(Score.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public int getStudent_rollNo() {
        return student_rollNo;
    }

    public void setStudent_rollNo(int student_rollNo) {
        this.student_rollNo = student_rollNo;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public float getTheory1() {
        return theory1;
    }

    public void setTheory1(float theory1) {
        this.theory1 = theory1;
    }

    public float getTheory2() {
        return theory2;
    }

    public void setTheory2(float theory2) {
        this.theory2 = theory2;
    }

    public float getPractical1() {
        return practical1;
    }

    public void setPractical1(float practical1) {
        this.practical1 = practical1;
    }

    public float getPractical2() {
        return practical2;
    }

    public void setPractical2(float practical2) {
        this.practical2 = practical2;
    }

    public String getCreate_at() {
        return create_at;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }

    public String getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(String update_at) {
        this.update_at = update_at;
    }

}
