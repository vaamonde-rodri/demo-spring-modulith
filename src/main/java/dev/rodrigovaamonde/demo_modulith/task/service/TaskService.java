package dev.rodrigovaamonde.demo_modulith.task.service;

import dev.rodrigovaamonde.demo_modulith.task.TaskDTO;
import dev.rodrigovaamonde.demo_modulith.task.TaskExternalAPI;
import dev.rodrigovaamonde.demo_modulith.task.TaskInternalAPI;
import dev.rodrigovaamonde.demo_modulith.task.mapper.TaskMapper;
import dev.rodrigovaamonde.demo_modulith.task.model.Task;
import dev.rodrigovaamonde.demo_modulith.task.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService implements TaskInternalAPI, TaskExternalAPI {

    private static final Logger LOG = LoggerFactory.getLogger(TaskService.class);
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Override
    @Transactional
    public TaskDTO add(TaskDTO task) {
        Task taskEntity = taskMapper.taskDTOToTask(task);
        return taskMapper.taskToTaskDTO(taskRepository.save(taskEntity));
    }

    @Override
    public List<TaskDTO> getTaskByUserId(Long id) {
        return taskRepository.findByUserId(id);
    }

    @Override
    public List<TaskDTO> getTaskByListId(Long id) {
        return taskRepository.findByListId(id);
    }

    @EventListener
    void onRemovedListEvent(Long listId) {
        LOG.info("List with id {} was removed", listId);
        taskRepository.deleteByListId(listId);
    }
}
