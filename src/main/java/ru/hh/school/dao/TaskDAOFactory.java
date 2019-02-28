package ru.hh.school.dao;

import ru.hh.school.dao.impl.TaskDAOImpl;
import ru.hh.school.model.TaskEntity;

public class TaskDAOFactory {
    private static final TaskDAOImpl taskDAO = new TaskDAOImpl();

    public static TaskDAO getTaskDAO() {
        return taskDAO;
    }

    public void generateTask(int id) {
        taskDAO.insertTask(new TaskEntity(id, "Task" + id, false));
    }
}
