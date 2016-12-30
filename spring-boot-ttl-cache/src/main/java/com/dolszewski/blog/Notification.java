package com.dolszewski.blog;

import java.io.Serializable;
import java.time.LocalDateTime;

class Notification implements Serializable {

    private long id;
    private String text;
    private LocalDateTime created;

    Notification(long id, String text, LocalDateTime created) {
        this.id = id;
        this.text = text;
        this.created = created;
    }

    private Notification() {
    }

    public long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notification that = (Notification) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

}
