package v3.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Todo {
    private static long idCounter = 1;
    private long id;
    private String title;
    private boolean completed = false;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    //constructor
    public Todo() {
    }

    public Todo(String title, boolean completed, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = idCounter++;
        this.title = title;
        this.completed = completed;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    //getter/setter
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
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

    //toString
    public String format(LocalDateTime dateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dateTime.format(formatter);
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

    public void changeStatus(boolean completed){
        this.completed = !completed;
    }
}
