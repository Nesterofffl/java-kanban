package Tests;

import Tasks.SubTask;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SubTaskTest {

    @Test
    public void testEquality() {
        SubTask task1 = new SubTask("Тест 1", 1, 1);
        SubTask task2 = new SubTask("Таск 2", 1, 1);
        Assertions.assertEquals(task1, task2);
    }
  
}