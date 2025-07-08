package Tests;

import Managers.ITaskManager;
import Managers.Managers;
import Tasks.Task;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryHistoryManagerTest {

    @Test
    public void previousVersionbBeingSavedInHistory() {
        ITaskManager manager = Managers.getDefault();

        Task task = new Task("Тест 1");
        manager.addTask(task);
        manager.getTask(task.getId());
        task.setDescription("Тестовая смена описания");
        Task oldTask = manager.getHistoryManager().getHistory().getFirst();
        assertNotEquals(task, oldTask);
    }

}