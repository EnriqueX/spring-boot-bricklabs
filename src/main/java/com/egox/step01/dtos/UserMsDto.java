package com.egox.step01.dtos;

public class UserMsDto {

    private Long id;
    private String username;
    private String emailAdr;

    public UserMsDto() {
    }

    public UserMsDto(Long id, String username, String emailAdr) {
        this.id = id;
        this.username = username;
        this.emailAdr = emailAdr;
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

    public String getEmailAdr() {
        return emailAdr;
    }

    public void setEmailAdr(String email) {
        this.emailAdr = email;
    }
}
