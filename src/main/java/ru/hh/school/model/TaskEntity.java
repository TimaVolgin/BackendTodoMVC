package ru.hh.school.model;

public class TaskEntity {
    private int id;
    private String title;
    private boolean completed;

    public TaskEntity() {}

    public TaskEntity(int id, String title, boolean completed) {
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public TaskEntity(TaskDTO taskDTO) {
        this.id = taskDTO.getId();
        this.title = taskDTO.getTitle();
        this.completed = taskDTO.isCompleted();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TaskEntity taskEntity = (TaskEntity) o;
        return id == taskEntity.id;
    }

    @Override
    public int hashCode() {
        return (id ^ (id >>> 32));
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"title\":\"" + title + '\"' +
                ", \"completed\":\"" + completed + '\"' +
                '}';
    }
}
