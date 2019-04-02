package com.simplenote.springboot.web.model;

import java.util.Date;

import javax.validation.constraints.Size;

public class Note {
    private int id;
    private String user;
    
    @Size(min=5, message="Enter at least 5 Characters...")
    private String title;

    private Date targetDate;
    
    @Size(min=10, message="Enter at least 10 Characters...")
    private String detail;

    public Note() {
    		super();
    }
    
    public Note(int id, String user, String title, Date targetDate, String detail) {
        super();
        this.id = id;
        this.user = user;
        this.title = title;
        this.targetDate = targetDate;
        this.detail = detail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Note other = (Note) obj;
        if (id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format(
                "Todo [id=%s, user=%s, title=%s, targetDate=%s,  detail=%s]", id,
                user, title, targetDate, detail);
    }

}