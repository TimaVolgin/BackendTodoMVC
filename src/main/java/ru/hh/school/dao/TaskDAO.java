package ru.hh.school.dao;

import ru.hh.school.model.TaskEntity;

import java.util.ArrayList;

public interface TaskDAO {

    TaskEntity getTaskById(int id);

    ArrayList<TaskEntity> getAllTasks();

    void insertTask(TaskEntity taskEntity);

    void updateTask(int id, TaskEntity taskEntity);

    void deleteTask(int id);

    void deleteAll();
}
