package com.wsjk.springpharmacy.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "USERS", schema = "", catalog = "")
public class UserEntity implements Serializable {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;
    private String userName;
    private String password;
    private String role;

    @Column(name = "NAME")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "PASS")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "ROLE")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
