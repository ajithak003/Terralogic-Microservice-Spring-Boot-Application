package com.touristmanagement.authenticationservice.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
	    name = "user_details_terralogic",
	    uniqueConstraints = {
	        @UniqueConstraint(columnNames = {"username"}), 
	        @UniqueConstraint(columnNames = {"email"})
	    }
	)
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    private String username;

    private String firstname;

    private String middlename;

    private String lastname;

    private String password;

    private String email;

    private Long contact;

    private LocalDateTime expirationDate;

    private String description;

    private Integer timeout; 

    private LocalDateTime datetimeFormat;

    private String roles;

    private String scopes;

    private String primaryGroupName;

    private String secondaryGroupName;

    private String language;

    private String organization;

    private String timeZone;

    private String memo;

    public Long getId() {
        return userId;
    }

    public void setId(Long userId) {
        this.userId = userId;
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

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getContact() {
        return contact;
    }

    public void setContact(Long contact) {
        this.contact = contact;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public LocalDateTime getDatetimeFormat() {
        return datetimeFormat;
    }

    public void setDatetimeFormat(LocalDateTime datetimeFormat) {
        this.datetimeFormat = datetimeFormat;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getScopes() {
        return scopes;
    }

    public void setScopes(String scopes) {
        this.scopes = scopes;
    }

    public String getPrimaryGroupName() {
        return primaryGroupName;
    }

    public void setPrimaryGroupName(String primaryGroupName) {
        this.primaryGroupName = primaryGroupName;
    }

    public String getSecondaryGroupName() {
        return secondaryGroupName;
    }

    public void setSecondaryGroupName(String secondaryGroupName) {
        this.secondaryGroupName = secondaryGroupName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
