package com.touristmanagement.user_service.userdto;

import java.time.LocalDateTime;


public class UserResponse {

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

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setContact(Long contact) {
		this.contact = contact;
	}

	public void setExpirationDate(LocalDateTime expirationDate) {
		this.expirationDate = expirationDate;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
	}

	public void setDatetimeFormat(LocalDateTime datetimeFormat) {
		this.datetimeFormat = datetimeFormat;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public void setScopes(String scopes) {
		this.scopes = scopes;
	}

	public void setPrimaryGroupName(String primaryGroupName) {
		this.primaryGroupName = primaryGroupName;
	}

	public void setSecondaryGroupName(String secondaryGroupName) {
		this.secondaryGroupName = secondaryGroupName;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Long getUserId() {
		return userId;
	}

	public String getUsername() {
		return username;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public Long getContact() {
		return contact;
	}

	public LocalDateTime getExpirationDate() {
		return expirationDate;
	}

	public String getDescription() {
		return description;
	}

	public Integer getTimeout() {
		return timeout;
	}

	public LocalDateTime getDatetimeFormat() {
		return datetimeFormat;
	}

	public String getRoles() {
		return roles;
	}

	public String getScopes() {
		return scopes;
	}

	public String getPrimaryGroupName() {
		return primaryGroupName;
	}

	public String getSecondaryGroupName() {
		return secondaryGroupName;
	}

	public String getLanguage() {
		return language;
	}

	public String getOrganization() {
		return organization;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public String getMemo() {
		return memo;
	}

}
