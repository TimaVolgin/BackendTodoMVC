package ru.hh.school.dao.impl;

import ru.hh.school.model.TaskEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import ru.hh.school.dao.TaskDAO;

public class TaskDAOImpl implements TaskDAO {

    private Map<Integer, TaskEntity> taskIdMap = new HashMap<>();

    public TaskEntity getTaskById(int id) {
        return taskIdMap.get(id);
    }

    public ArrayList<TaskEntity> getAllTasks() {
        return new ArrayList<>(taskIdMap.values());
    }

    public void insertTask(TaskEntity taskEntity) {
        taskIdMap.put(taskEntity.getId(), taskEntity);
    }

    public void updateTask(int id, TaskEntity taskEntity) {
        taskIdMap.put(id, taskEntity);
    }

    public void deleteTask(int id) {
        taskIdMap.remove(id);
    }

    public void deleteAll() {
        taskIdMap.clear();
    }
}
