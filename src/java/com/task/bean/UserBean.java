package com.task.bean;
 
/**
 * Bean class for "users" table.
 * users(user_id, name, email, password, phone, role, address, resume)
 */
public class UserBean {
 
    private int userId;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String role;      // e.g. "Candidate" / "Admin"
    private String address;
    private String resume;    // resume file name / path
 
    public UserBean() {
    }
 
    public UserBean(int userId, String name, String email, String password,
                     String phone, String role, String address, String resume) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.role = role;
        this.address = address;
        this.resume = resume;
    }
 
    public int getUserId() {
        return userId;
    }
 
    public void setUserId(int userId) {
        this.userId = userId;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public String getPhone() {
        return phone;
    }
 
    public void setPhone(String phone) {
        this.phone = phone;
    }
 
    public String getRole() {
        return role;
    }
 
    public void setRole(String role) {
        this.role = role;
    }
 
    public String getAddress() {
        return address;
    }
 
    public void setAddress(String address) {
        this.address = address;
    }
 
    public String getResume() {
        return resume;
    }
 
    public void setResume(String resume) {
        this.resume = resume;
    }
 
    @Override
    public String toString() {
        return "UserBean{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", role='" + role + '\'' +
                ", address='" + address + '\'' +
                ", resume='" + resume + '\'' +
                '}';
    }
}
 
