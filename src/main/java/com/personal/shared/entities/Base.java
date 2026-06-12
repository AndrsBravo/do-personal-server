package com.personal.shared.entities;

import java.time.LocalDateTime;

import com.personal.backoffice.user.entities.User;

public abstract class Base {

    private String Id;
    private User createdBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Base(String id) {
        this.Id = id;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public int hashCode() {
        return this.Id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this.Id.equals(((Base) obj).Id);
    }

}
