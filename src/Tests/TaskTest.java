package Tests;

import Tasks.Status;
import Tasks.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskTest {

    @Test
    public void testEquality() {
        Task task1 = new Task("Тест 1", "Des", Status.NEW, 1);
        Task task2 = new Task("Таск 2", "des", Status.NEW, 1);
        Assertions.assertEquals(task1, task2);
    }
}