package ru.hh.school.resource;

import ru.hh.school.model.TaskDTO;
import ru.hh.school.model.TaskEntity;
import ru.hh.school.service.TaskService;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/task")
@Produces(MediaType.APPLICATION_JSON)
public class TaskResource {

    private static final TaskService service = new TaskService();
    private static final Logger log = LoggerFactory.getLogger(TaskResource.class);

    @PUT
    @Path("/create/example/{numOfId}")
    public void generateExampleTask(@PathParam("numOfId") int numOfId) {
        if (log.isDebugEnabled()) {
            log.debug("On request PUT called method ExampleTasks");
        }
        service.generateTasks(numOfId);
    }

    @GET
    @Path("/all")
    public List<TaskDTO> getAllTasks() {
        if (log.isDebugEnabled()) {
            log.debug("On request GET called method getAllTasks");
        }
        return  service.getAllTasks().stream().map(TaskDTO::new).collect(Collectors.toList());
    }

    @GET
    @Path("/{id}")
    public TaskDTO getTaskById(@PathParam("id") int id) {
        if (log.isDebugEnabled()) {
            log.debug("On request GET called method getTaskById");
        }
        return new TaskDTO(service.getTask(id));
    }

    @PUT
    @Path("/{id}")
    public void updateTask(@PathParam("id") int id, TaskDTO taskDTO) {
        if (log.isDebugEnabled()) {
            log.debug("On request PUT called method updateTask by id " + id);
        }
        service.updateTask(id, new TaskEntity(taskDTO));
    }

    @DELETE
    @Path("/{id}")
    public void deleteTask(@PathParam("id") int id) {
        if (log.isDebugEnabled()) {
            log.debug("On request DELETE called method deleteTask by id " + id);
        }
        service.deleteTask(id);
    }

    @POST
    @Path("/create")
    public Response createTask(TaskDTO taskDTO) {
        if (log.isDebugEnabled()) {
            log.debug("On request POST called method createTask with params: id" + taskDTO.getId()
                    + ", title: " + taskDTO.getTitle() + ", completed: " + taskDTO.isCompleted());
        }
        return service.createTask(new TaskEntity(taskDTO));
    }

    @DELETE
    @Path("/clear")
    public void deleteAllTasks() {
        if (log.isDebugEnabled()) {
            log.debug("On request DELETE called method deleteAllTasks");
        }
        service.deleteAllTask();
    }

}
