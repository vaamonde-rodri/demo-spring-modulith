package dev.rodrigovaamonde.demo_modulith.task;

public record TaskDTO(
        String id,
        String title,
        String description,
        String userId,
        String listId,
        String createdAt,
        String updatedAt
) {
}
