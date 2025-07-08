package Tests;

import Managers.ITaskManager;
import Managers.Managers;
import Tasks.EpicTask;
import Tasks.Status;
import Tasks.SubTask;
import Tasks.Task;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagersTest {

    @Test
    public void managersReturnReadyToUseTaskManager() {
        ITaskManager manager = Managers.getDefault();
        Task task1 = new Task("Отработать смену на заводе", "8:00 - 17:00", Status.DONE);
        assertNotEquals(0, manager.addTask(task1));

        EpicTask epic = new EpicTask("Планы на выходные");
        assertNotEquals(0, manager.addEpicTask(epic));

        SubTask subtask1 = new SubTask("Встать пораньше, понаблюдать за птицами", epic.getId());
        assertNotEquals(0, manager.addSubTask(subtask1));
    }

}