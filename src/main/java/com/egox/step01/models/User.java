package com.egox.step01.models;


import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Entity
@Table(name = "USERS")
//@JsonIgnoreProperties({"firstname", "lastname"}) -- Static filtering
//@JsonFilter(value = "userFilter") -- MappingJacksonValue filtering
public class User extends RepresentationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(Views.External.class)
    private Long id;

    @NotEmpty(message = "Username is mandatory field, please provide a valid username")
    @Column(name = "USER_NAME", length = 50, nullable = false, unique = true)
    @JsonView(Views.External.class)
    private String username;

    @Size(min = 2, message = "Firstname should have at least 2 characters")
    @Column(name = "FIRST_NAME", length = 50, nullable = false)
    @JsonView(Views.External.class)
    private String firstname;

    @Column(name = "LAST_NAME", length = 50)
    @JsonView(Views.External.class)
    private String lastname;

    @Column(name = "EMAIL", length = 50)
    @JsonView(Views.External.class)
    private String email;

    @Column(name = "ROLE", length = 50)
    @JsonView(Views.Internal.class)
    private String role;

    @Column(name = "ADDRESS", length = 100)
    @JsonView(Views.Internal.class)
    private String address;

    @Column(name = "CURP", length = 50, nullable = false, unique = true)
    //@JsonIgnore
    @JsonView(Views.Internal.class)
    private String curp;

    @OneToMany(mappedBy = "user")
    @JsonView(Views.Internal.class)
    private List<Order> orders;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
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
