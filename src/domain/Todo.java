package domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Todo {
    private int id;
    private String title;
    private boolean completed = false;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    //constructor
    public Todo() {
    }

    public Todo(int id, String title, boolean completed, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.title = title;
        this.completed = completed;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    //getter/setter
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String format(LocalDateTime date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return date.format(formatter);
    }

    @Override
    public String toString() {
        return "\n== todo ==" + "\n" +
                "id = '" + id + '\'' +"\n" +
                "title = '" + title + '\'' +"\n" +
                "completed = " + completed +"\n" +
                "createdAt = " + format(createdAt) +"\n" +
                "updatedAt = " + format(updatedAt);
    }
}

