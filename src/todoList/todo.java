package todoList;

public class todo {
    private String id;
    private String title;
    private boolean completed;
    private String createdAt;
    private String updatedAt;

    //constructor
    public todo() {
    }

    public todo(String id, String title, boolean completed, String createdAt, String updatedAt) {
        this.id = id;
        this.title = title;
        this.completed = completed;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    //getter/setter
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "todo{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
