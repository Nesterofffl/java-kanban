package Tasks;

import java.util.ArrayList;
import java.util.List;

public class EpicTask  extends  Task{
    private List<SubTask> subtasks = new ArrayList<>();

    public EpicTask(String name) {
        super(name);
    }

    public EpicTask(String name, String description) {
        super(name, description);
    }

    public EpicTask(String name, String description, Integer id) {
        super(name, description);
        this.id = id;
    }

    public void addSubTask(SubTask subTask){
        this.subtasks.add(subTask);
    }

    public void updateStatus() {
        boolean hasNew = false;
        boolean hasDone = false;

        for (SubTask sub : this.subtasks) {
            if (sub.status == Status.NEW) {
                hasNew = true;
            }
            if (sub.status == Status.DONE) {
                hasDone = true;
            }
        }

        if (hasNew && !hasDone) {
            this.status = Status.NEW;
        } else if (hasDone && !hasNew) {
            this.status = Status.DONE;
        } else {
            this.status = Status.IN_PROGRESS;
        }
    }

    public List<SubTask> getSubTasks() {
        return this.subtasks;
    }
}
