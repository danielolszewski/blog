package com.dolszewski.blog;

import java.io.Serializable;

class Message implements Serializable {

    private long id;
    private String subject;
    private String content;

    Message(long id, String subject, String content) {
        this.id = id;
        this.subject = subject;
        this.content = content;
    }

    private Message() {
    }

    public long getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return id == message.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

}
