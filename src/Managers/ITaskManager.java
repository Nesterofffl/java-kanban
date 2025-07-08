package Managers;

import Tasks.EpicTask;
import Tasks.SubTask;
import Tasks.Task;

import java.util.List;

@SuppressWarnings("UnusedReturnValue")
public interface ITaskManager {
    int addTask(Task task);

    int addEpicTask(EpicTask epicTask);

    int addSubTask(SubTask subTask);

    Task getTask(int id);

    EpicTask getEpicTask(int id);

    SubTask getSubTask(int id);

    void deleteTask(int id);

    void deleteEpicTask(int id);

    void deleteSubTask(int id);

    void deleteAllTasks();

    void deleteAllEpicTasks();

    void deleteAllSubTasks();

    void updateTask(Task oldTask, Task newTask);

    void updateSubTask(SubTask oldTask, SubTask newTask);

    List<SubTask> getSubsForEpic(int id);

    List<Task> getAllTasks();

    IHistoryManager getHistoryManager();

    //void updateHistory(Task latestTask);

    //List<Task> getHistory();
}
