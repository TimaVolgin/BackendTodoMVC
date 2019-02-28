package ru.hh.school.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TaskDTO {

    @JsonProperty(required = true)
    private int id;
    @JsonProperty(required = true)
    private String title;
    @JsonProperty(required = true)
    private boolean completed;

    public TaskDTO() {

    }

    public TaskDTO(int id, String title, boolean completed) {
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public TaskDTO(TaskEntity taskEntity) {
        this.id = taskEntity.getId();
        this.title = taskEntity.getTitle();
        this.completed = taskEntity.isCompleted();
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
        TaskDTO item = (TaskDTO) o;
        return id == item.id;
    }

    @Override
    public int hashCode() {
        return (id ^ (id >>> 32));
    }

    @Override
    public String toString() {
        return "TaskDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}
