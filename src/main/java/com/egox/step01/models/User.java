package com.egox.step01.models;


import jakarta.persistence.*;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "USER_NAME", length = 50, nullable = false, unique = true)
    private String username;

    @Column(name = "FIRST_NAME", length = 50, nullable = false)
    private String firstname;

    @Column(name = "LAST_NAME", length = 50)
    private String lastname;

    @Column(name = "EMAIL", length = 50)
    private String email;

    @Column(name = "ROLE", length = 50)
    private String role;

    @Column(name = "CURP", length = 50, nullable = false, unique = true)
    private String curp;

    public User() {
    }

    public User(String username, String firstname, String curp) {
        this.username = username;
        this.firstname = firstname;
        this.curp = curp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", curp='" + curp + '\'' +
                '}';
    }
}
