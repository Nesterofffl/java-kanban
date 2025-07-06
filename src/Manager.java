import Tasks.EpicTask;
import Tasks.Status;
import Tasks.SubTask;
import Tasks.Task;

import java.util.List;
import java.util.HashMap;

public class Manager {

    //Поля
    public int id = 1;
    private final HashMap<Integer, Task> tasks = new HashMap<>();
    private final HashMap<Integer, SubTask> subs = new HashMap<>();
    private final HashMap<Integer, EpicTask> epics = new HashMap<>();

    public void addTask(Task task) {
        task.setId(id);
        tasks.put(id, task);
        id++;
    }
    public void addEpicTask(EpicTask epicTask) {
        epicTask.setId(id);
        epics.put(id, epicTask);
        id++;
    }
    public void addSubTask(SubTask subTask) {
        subTask.setId(id);
        subs.put(id, subTask);
        id++;
        epics.get(subTask.getEpicID()).addSubTask(subTask);
        epics.get(subTask.getEpicID()).setStatus();
    }
    public Task getTask(int id) {
        return tasks.get(id);
    }
    public EpicTask getEpicTask(int id) {
        return epics.get(id);
    }
    public SubTask getSubTask(int id) {
        return subs.get(id);
    }
    public void deleteTask(int id) {
        tasks.remove(id);
    }
    public void deleteEpicTask(int id) {
        epics.remove(id);
    }
    public void deleteSubTask(int id) {
        subs.remove(id);
    }
    public void deleteAllTasks() {
        tasks.clear();
    }
    public void deleteAllEpicTasks() {
        epics.clear();
    }
    public void deleteAllSubTasks() {
        subs.clear();
    }
    public void updateTask(Task oldTask, Task newTask) {
        tasks.put(oldTask.getId(), newTask);
        newTask.setId(oldTask.getId());
    }
    public void updateSubTask(SubTask oldTask, SubTask newTask) {
        subs.put(oldTask.getId(), newTask);
        newTask.setId(oldTask.getId());
    }
    public List<SubTask> getSubsForEpic(int id) {
        return epics.get(id).getSubTasks();
    }

    public String getAllTasks() {
        return tasks.values().toString() + epics.values().toString() + subs.values().toString();
    }
}
