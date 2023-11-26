package com.epharma.pharmasphere.model;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;


@Entity
public class Pharmainfo {
    @Id
    private String email;

    private String pharmacy_name;
    private String phoneNumber;
    private String password;
    private String address;
    
    
    // Constructors
    public Pharmainfo() {
        // Default constructor
    }

    public Pharmainfo(String pharmacy_name, String email, String phoneNumber, String address, String password) {
        this.pharmacy_name = pharmacy_name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password =password;
        this.address = address;
        
    }


    public String getPharmacy_name() {
        return pharmacy_name;
    }

    public void setPharmacy_name(String pharmacy_name) {
        this.pharmacy_name = pharmacy_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber2) {
        this.phoneNumber = phoneNumber2;
    }
    
    public String getPassword() {
        return password;
    }

    // Hash the password using BCrypt before setting it
    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    

}


