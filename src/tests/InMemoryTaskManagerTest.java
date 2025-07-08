package tests;

import managers.ITaskManager;
import managers.Managers;
import tasks.Status;
import tasks.SubTask;
import tasks.Task;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryTaskManagerTest {

    private final ITaskManager taskManager = Managers.getDefault();

    @Test
    void addNewTask() {
        Task task = new Task("Test addNewTask", "Test addNewTask description",Status.NEW);
        final int taskId = this.taskManager.addTask(task);

        final Task savedTask = this.taskManager.getTask(taskId);

        assertNotNull(savedTask, "Задача не найдена.");
        assertEquals(task, savedTask, "Задачи не совпадают.");

    final List<Task> tasks = this.taskManager.getAllTasks();

        assertNotNull(tasks, "Задачи не возвращаются.");
        assertEquals(1, tasks.size(), "Неверное количество задач.");
        assertEquals(task, tasks.get(0), "Задачи не совпадают.");
    }

    @Test
    void checkGeneratedIdAndCreatedId(){
        Task task = new Task("Test task", "test task", Status.NEW, 1);
        Task task2 = new Task("Test task2");

        assertNotEquals(task.getId(), task2.getId());
    }

    @Test
    void checkSubTaskNotBeingOwnEpic() {
        assertThrows(NoSuchElementException.class, () -> {
            SubTask subTask = new SubTask("Саб таск", 1);
            this.taskManager.addSubTask(subTask);
        });
    }

    @Test
    void checkEpicNotBeingOwnSub() {
        /*Этот тест не обязателен, так как метод addSubtask() принимает объекты только SubTask и не может принять в себя
          объект EpicTask
        */
    }

    @Test
    void taskDoesntChangeAfterAdding() {
        Task task = new Task("Таск 1", "Описание 1", Status.NEW);
        String name = task.getName();
        String description = task.getDescription();
        String status = String.valueOf(task.getStatus());

        this.taskManager.addTask(task);

        assertEquals(name, task.getName());
        assertEquals(description, task.getDescription());
        assertEquals(status, String.valueOf(task.getStatus()));
    }
}