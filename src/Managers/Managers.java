package Managers;

public class Managers {
    public static ITaskManager getDefault() {
        return new InMemoryTaskManager();
    }

    public static IHistoryManager getDefaultHistory() {
        return new InMemoryHistoryManager();
    }
}
