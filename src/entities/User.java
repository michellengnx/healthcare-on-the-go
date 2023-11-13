package entities;

import java.util.Date;

public abstract class User {
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private String gender;
    private String insurance;
    private Date birthday;

    public User(String username, String password, String email, String phoneNumber, String gender, String insurance, Date birthday) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.insurance = insurance;
        this.birthday = birthday;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public String getInsurance() {
        return insurance;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
