package Managers;

import Tasks.Task;

import java.util.*;

public class InMemoryHistoryManager implements IHistoryManager {

    private final LinkedList<Task> history = new LinkedList<>();

    @Override
    public void add(Task task) {
        Task historyTask = task;
        this.history.add(historyTask);
        if (this.history.size() > 10) {
            this.history.removeFirst();
        }
    }

    @Override
    public List<Task> getHistory() {
        return this.history;
    }
}
