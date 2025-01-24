package com.touristmanagement.user_service.userdto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserRequest {

	    @NotNull(message = "Username is required")
	    @NotBlank(message = "Username is required")
	    @Column(nullable = false, unique = true)
	    private String username;

	    @NotBlank(message = "Firstname is required")
	    private String firstname;

	    private String middlename;

	    @NotBlank(message = "Lastname is required")
	    private String lastname;

	    @NotBlank(message = "Password is required")
	    @Size(min = 8, message = "Password must be at least 8 characters long")
	    private String password;

	    @NotBlank(message = "Email is required")
	    @Email(message = "Email should be valid")
	    @Column(nullable = false, unique = true)
	    private String email;

	    @NotNull(message = "contact is required")
	    @Digits(integer = 10, fraction = 0, message = "Contact should be a valid number")
	    private Long contact;

	    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	    private LocalDateTime expirationDate;

	    private String description;

	    @NotNull(message = "Timeout is required")
	    private Integer timeout; 

	    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	    private LocalDateTime datetimeFormat;

	    private String roles;

	    private String scopes;

	    @NotBlank(message = "PrimaryGroupName is required")
	    private String primaryGroupName;

	    private String secondaryGroupName;

	    private String language;

	    private String organization;

	    @NotBlank(message = "TimeZone is required")
	    private String timeZone;

	    @Size(max = 2048, message = "Memo should not exceed 2048 characters")
	    private String memo;

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
