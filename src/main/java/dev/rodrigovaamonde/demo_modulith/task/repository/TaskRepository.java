package dev.rodrigovaamonde.demo_modulith.task.repository;

import dev.rodrigovaamonde.demo_modulith.task.TaskDTO;
import dev.rodrigovaamonde.demo_modulith.task.model.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {
    List<TaskDTO> findByUserId(Long userId);
    List<TaskDTO> findByListId(Long listId);

    void deleteByListId(Long listId);
}
