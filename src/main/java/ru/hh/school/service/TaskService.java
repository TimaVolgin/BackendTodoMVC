package ru.hh.school.service;

import ru.hh.school.dao.TaskDAOFactory;
import ru.hh.school.model.TaskEntity;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

public class TaskService {

    private TaskDAOFactory taskDaoFactory = new TaskDAOFactory();

    public List<TaskEntity> getAllTasks() {
        ArrayList<TaskEntity> listTaskEntity = taskDaoFactory.getTaskDAO().getAllTasks();
        return listTaskEntity;
    }

    public TaskEntity getTask(int id) {
        return taskDaoFactory.getTaskDAO().getTaskById(id);
    }

    public Response createTask(TaskEntity taskEntity) {
        taskDaoFactory.getTaskDAO().insertTask(taskEntity);
        return Response.ok().build();
    }

    public Response generateTasks(int numOfId) {
        for (int id = 0; id < numOfId; id++) {
            taskDaoFactory.generateTask(id + 1);
        }
        return Response.ok().build();
    }

    public void updateTask(int id, TaskEntity taskEntity) {
        taskDaoFactory.getTaskDAO().updateTask(id, taskEntity);
    }

    public void deleteTask(int id) {
        taskDaoFactory.getTaskDAO().deleteTask(id);
    }

    public void deleteAllTask() {
        taskDaoFactory.getTaskDAO().deleteAll();
    }
}
