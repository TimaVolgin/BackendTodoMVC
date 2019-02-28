package ru.hh.school;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import ru.hh.nab.starter.NabApplication;
import ru.hh.nab.testbase.NabTestBase;
import ru.hh.school.main.ApplicationResource;

import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(classes = ApplicationTestConfig.class)
public class ApplicationResourceTest extends NabTestBase {

  @Test
  public void hello() {
    final String name = "test";
    Response response = target("/hello")
        .queryParam("name", name)
        .request()
        .get();
    assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    assertEquals(String.format("Hello, %s!", name), response.readEntity(String.class));
  }

  @Test
  public void helloWithoutParams() {
    Response response = createRequest("/hello").get();
    assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    assertEquals("Hello, world!", response.readEntity(String.class));
  }

  @Override
  protected NabApplication getApplication() {
    return NabApplication.builder().configureJersey().registerResources(ApplicationResource.class).bindToRoot().build();
  }
}
