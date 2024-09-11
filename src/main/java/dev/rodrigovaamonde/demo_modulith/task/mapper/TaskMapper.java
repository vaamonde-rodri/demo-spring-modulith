package dev.rodrigovaamonde.demo_modulith.task.mapper;

import dev.rodrigovaamonde.demo_modulith.task.TaskDTO;
import dev.rodrigovaamonde.demo_modulith.task.model.Task;
import org.mapstruct.Mapper;

@Mapper
public interface TaskMapper {
    TaskDTO taskToTaskDTO(Task task);
    Task taskDTOToTask(TaskDTO taskDTO);
}
