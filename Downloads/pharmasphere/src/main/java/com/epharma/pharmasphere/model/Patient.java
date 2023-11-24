package com.epharma.pharmasphere.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String email;

    private String username;
    private String phoneNumber;
    private String address;
  
    private String password;

    // Constructors

    public Patient() {
        // Default constructor
    }

    public Patient(String username, String phoneNumber, String address, String email, String password) {
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        this.password = password;
    }

    // Getters and Setters


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
}
