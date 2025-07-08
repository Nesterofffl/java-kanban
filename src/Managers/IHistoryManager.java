package Managers;

import Tasks.Task;

import java.util.List;

public interface IHistoryManager {

    void add(Task task);

    List<Task> getHistory();
}
