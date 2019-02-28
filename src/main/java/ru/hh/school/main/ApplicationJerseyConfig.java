package ru.hh.school.main;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.hh.school.resource.TaskResource;

@Configuration
@Import({ApplicationResource.class, TaskResource.class})
public class ApplicationJerseyConfig {
}
