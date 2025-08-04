package dev.madeyskij.taskmanager

import java.time.LocalDateTime

class TaskManager {
    private val tasks = mutableListOf<Task>()

    fun addTask(title: String, description: String = "", priority: Priority = Priority.MEDIUM) {
        val task = Task(title=title, description=description, priority=priority)
        tasks.add(task)
    }

    fun getAllTasks(): List<Task> {
        return tasks
    }

    fun getCompletedTasks(): List<Task> {
        return tasks.filter { it.completed }
    }

    fun getUncompletedTasks(): List<Task> {
        return tasks.filter { !it.completed } .sortedByDescending { it.priority }
    }

    fun getTaskById(id: String): Task? {
        return tasks.find { it.id == id }
    }

    fun markTaskAsCompleted(id: String) {
        val task = getTaskById(id)
        if (task != null) {
            task.completed = true
            task.updatedAt = LocalDateTime.now()
        }
    }

    fun deleteTask(id: String) {
        tasks.removeIf { it.id == id }
    }
}