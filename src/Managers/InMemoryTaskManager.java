package Managers;

import Tasks.EpicTask;
import Tasks.SubTask;
import Tasks.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class InMemoryTaskManager implements ITaskManager {

    //Поля
    public int id = 1;
    private final HashMap<Integer, Task> tasks = new HashMap<>();
    private final HashMap<Integer, SubTask> subs = new HashMap<>();
    private final HashMap<Integer, EpicTask> epics = new HashMap<>();

    private final IHistoryManager historyManager = Managers.getDefaultHistory();


    @Override
    public int addTask(Task task) {
        task.setId(this.id);
        this.tasks.put(this.id, task);
        return this.id++;
    }
    @Override
    public int addEpicTask(EpicTask epicTask) {
        epicTask.setId(this.id);
        this.epics.put(this.id, epicTask);
        return this.id++;
    }
    @Override
    public int addSubTask(SubTask subTask) {
        subTask.setId(this.id);
        this.subs.put(this.id, subTask);

        EpicTask epicTask = this.epics.get(subTask.getEpicID());
        if (epicTask != null) {
            epicTask.addSubTask(subTask);
            epicTask.updateStatus();
            return this.id++;
        } else {
            throw new NoSuchElementException(String.format("Не существует эпик-таска с ID %d", subTask.getEpicID()));
        }
    }
    @Override
    public Task getTask(int id) {
        Task copyTask = new Task(this.tasks.get(id).getName(), this.tasks.get(id).getDescription());
        this.historyManager.add(copyTask);
        return this.tasks.get(id);
    }
    @Override
    public EpicTask getEpicTask(int id) {
        this.historyManager.add(this.epics.get(id));
        return this.epics.get(id);
    }
    @Override
    public SubTask getSubTask(int id) {
        this.historyManager.add(this.subs.get(id));
        return this.subs.get(id);
    }
    @Override
    public void deleteTask(int id) {
        this.tasks.remove(id);
    }
    @Override
    public void deleteEpicTask(int id) {
        this.epics.remove(id);
    }
    @Override
    public void deleteSubTask(int id) {
        this.subs.remove(id);
    }
    @Override
    public void deleteAllTasks() {
        this.tasks.clear();
    }
    @Override
    public void deleteAllEpicTasks() {
        this.epics.clear();
    }
    @Override
    public void deleteAllSubTasks() {
        this.subs.clear();
    }
    @Override
    public void updateTask(Task oldTask, Task newTask) {
        this.tasks.put(oldTask.getId(), newTask);
        newTask.setId(oldTask.getId());
    }
    @Override
    public void updateSubTask(SubTask oldTask, SubTask newTask) {
        this.subs.put(oldTask.getId(), newTask);
        newTask.setId(oldTask.getId());
    }
    @Override
    public List<SubTask> getSubsForEpic(int id) {
        return this.epics.get(id).getSubTasks();
    }
    @Override
    public List<Task> getAllTasks() {
        var output = new ArrayList<Task>();
        output.addAll(this.tasks.values());
        output.addAll(this.epics.values());
        output.addAll(this.subs.values());
        return output;
    }

    @Override
    public IHistoryManager getHistoryManager() {
        return this.historyManager;
    }

    /*@Override
    public void updateHistory(Task latestTask) {
        if(this.history.size() > 10){
            this.history.removeFirst();
            this.history.addLast(latestTask);
        } else {
            this.history.addLast(latestTask);
        }
    }

    @Override
    public List<Task> getHistory() {
        return this.history;
    }*/
}
