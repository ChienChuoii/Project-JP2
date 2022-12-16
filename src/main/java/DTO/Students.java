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
public class Students {
    int student_rollNo;
    String name;
    String birthday;
    String gender;
    String email;
    String address;
    String phoneNumber;
    String create_at,update_at;

    public Students() {
    }

    public Students(int student_rollNo, String name, String birthday, String gender, String email, String address, String phoneNumber, String create_at, String update_at) {
        this.student_rollNo = student_rollNo;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.create_at = create_at;
        this.update_at = update_at;
    }

    
    public void setData(ResultSet resultSet){
        try {
            this.student_rollNo = resultSet.getInt("student_rollNo");
            this.name = resultSet.getString("name");
            this.birthday= resultSet.getString("birthday");
            this.gender = resultSet.getString("gender");
            this.email=resultSet.getString("email");
            this.address= resultSet.getString("address");
            this.phoneNumber= resultSet.getString("phoneNumber");
            this.create_at=resultSet.getString("create_at");
            this.update_at=resultSet.getString("update_at");
        } catch (SQLException ex) {
            Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public int getStudent_rollNo() {
        return student_rollNo;
    }

    public void setStudent_rollNo(int student_rollNo) {
        this.student_rollNo = student_rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
