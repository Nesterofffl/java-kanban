package Tests;

import Tasks.EpicTask;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EpicTaskTest {

    @Test
    public void testEquality() {
        EpicTask task1 = new EpicTask("Тест 1", "Des", 12);
        EpicTask task2 = new EpicTask("Таск 2", "des", 12);
        Assertions.assertEquals(task1, task2);
    }
  
}