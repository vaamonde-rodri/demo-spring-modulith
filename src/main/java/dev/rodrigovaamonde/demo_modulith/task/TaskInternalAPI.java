package dev.rodrigovaamonde.demo_modulith.task;

import java.util.List;

public interface TaskInternalAPI {

    List<TaskDTO> getTaskByUserId(Long id);
    List<TaskDTO> getTaskByListId(Long id);
}
