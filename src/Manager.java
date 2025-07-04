import Tasks.EpicTask;
import Tasks.Status;
import Tasks.SubTask;
import Tasks.Task;

import java.util.ArrayList;
import java.util.HashMap;

public class Manager <T extends Task> {
    private int id;
    private final HashMap<Integer, Task> tasks = new HashMap<>();
    private final HashMap<Integer, SubTask> subtasks = new HashMap<>();
    private final HashMap<Integer, EpicTask> epics = new HashMap<>();

    public Manager() {
        id = 1;
    }

    public void addTask(Task task) {
        task.setId(id);
        tasks.put(id, task);
        idIncrease();
    }

    public void addEpic(EpicTask epic) {
        epic.setId(id);
        epics.put(id, epic);
        for (Integer idSubtask : this.getSubtasksFromEpic(epic.getId())) {
            this.addSubtask(this.getSubtask(idSubtask));
        }
        this.updateStatusEpic(epic.getId());
        idIncrease();
    }

    public void addSubtask(SubTask subtask) {
        subtask.setId(id);
        subtasks.put(id, subtask);
        EpicTask epic = this.getEpicTask(subtask.getIdEpicTask());
        epic.getSubTasks().add(subtask.getId());
        this.updateStatusEpic(epic.getId());
        idIncrease();
    }

    public boolean updateTask(Task task) {
        if (task.getId() != null) {
            if (tasks.containsKey(task.getId())) {
                tasks.put(task.getId(), task);
                return true;
            }
        }
        return false;
    }

    public boolean updateEpic(EpicTask epic) {
        if (epic.getId() != null) {
            if (epics.containsKey(epic.getId())) {
                epics.put(epic.getId(), epic);
                Integer[] temp = new Integer[0];
                Integer[] subtasksId = epic.getSubTasks().toArray(temp);
                for (Integer idSubtask : subtasksId) {
                    this.updateSubtask(this.getSubtask(idSubtask));
                }
                this.updateStatusEpic(epic.getId());
                return true;
            }
        }
        return false;

    }

    public void updateSubtask(SubTask subtask) {
        if (subtask.getId() != null) {
            if (subtasks.containsKey(subtask.getId())) {
                subtasks.put(subtask.getId(), subtask);
                EpicTask epic = this.getEpicTask(subtask.getIdEpicTask());
                epic.getSubTasks().add(subtask.getId());
                this.updateStatusEpic(epic.getId());
            }
        }
    }

    private void idIncrease() {
        id++;
    }

    public boolean deleteTask(int id) {
        if (tasks.containsKey(id)) {
            tasks.remove(id);
            return true;
        }
        return false;
    }

    private boolean deleteSubtaskWithoutUpdate(int id) {
        if (subtasks.containsKey(id)) {
            subtasks.remove(id);
            return true;
        }
        return false;
        /* Вспомогательный метод для полного удаления subtask из epic
        Удаление каждой subtask.getId() не требуется, updateStatusEpic() не требуется, поскольку
        epic по итогу удаляется, метод призван уменьшить трату ресурсов */
    }

    public boolean deleteSubtask(int id) {
        if (subtasks.containsKey(id)) {
            SubTask subtask = subtasks.get(id);
            EpicTask epic = this.getEpicTask(subtask.getIdEpicTask());
            epic.getSubTasks().remove(subtask.getId());
            subtasks.remove(id);
            this.updateStatusEpic(epic.getId());
            return true;
        }
        return false;
    }

    public boolean deleteEpic(int id) {
        if (epics.containsKey(id)) {
            EpicTask epic = epics.get(id);
            ArrayList<Integer> subtasks = epic.getSubTasks();
            for (Integer idSubtask : subtasks) {
                this.deleteSubtaskWithoutUpdate(idSubtask);
            }
            epics.remove(id);
            return true;
        }
        return false;
    }

    public Task getTask(int id) {
        if (tasks.containsKey(id)) {
            return tasks.get(id);
        }
        return null;
    }

    public EpicTask getEpicTask(int id) {
        if (epics.containsKey(id)) {
            return epics.get(id);
        }
        return null;
    }

    public SubTask getSubtask(int id) {
        if (subtasks.containsKey(id)) {
            return subtasks.get(id);
        }
        return null;
    }

    public ArrayList<Integer> getSubtasksFromEpic(int id) {
        EpicTask epic = this.getEpicTask(id);
        return epic.getSubTasks();
    }

    private void updateStatusEpic(int id) {
        EpicTask epic = this.getEpicTask(id);
        boolean isNew = true;
        boolean isDone = true;
        if (this.getSubtasksFromEpic(id).isEmpty()) {
            isNew = true;
        }
        for (Integer idSubtask : this.getSubtasksFromEpic(id)) {
            if (this.getSubtask(idSubtask).getStatus() == Status.IN_PROGRESS) {
                epic.setStatus(Status.IN_PROGRESS);
                return;
            }
            if (this.getSubtask(idSubtask).getStatus() == Status.DONE) {
                isNew = false;
            }
            if (this.getSubtask(idSubtask).getStatus() == Status.NEW) {
                isDone = false;
            }
        }
        if (isNew) {
            epic.setStatus(Status.NEW);
        } else if (isDone) {
            epic.setStatus(Status.DONE);
        } else {
            epic.setStatus(Status.IN_PROGRESS);
        }
    }

    public void deleteAllTasks() {
        Task[] temp = new Task[0];
        for (Task task : tasks.values().toArray(temp)) {
            this.deleteTask(((Task)(task)).getId());
        }
    }

    public void deleteAllSubtasks() {
        SubTask[] temp = new SubTask[0];
        for (SubTask subtask : subtasks.values().toArray(temp)) {
            this.deleteSubtask(((SubTask)(subtask)).getId());
        }
    }

    public void deleteAllEpics() {
        EpicTask[] temp = new EpicTask[0];
        for (EpicTask epic : epics.values().toArray(temp)) {
            this.deleteEpic(((EpicTask)(epic)).getId());
        }
    }

    public ArrayList<Task> getTasks() { return new ArrayList<>(tasks.values()); }

    public ArrayList<SubTask> getSubtasks() { return new ArrayList<>(subtasks.values()); }

    public ArrayList<EpicTask> getEpics() { return new ArrayList<>(epics.values());}
}
