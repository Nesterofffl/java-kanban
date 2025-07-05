package Tasks;

import java.util.ArrayList;

public class EpicTask  extends  Task{
    private ArrayList<SubTask> subtasks = new ArrayList<>();

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
        subtasks.add(subTask);
    }

    public void setStatus() {
        boolean isAllNew = true;
        boolean isAllDone = false;
        for (SubTask sub : subtasks) {
            if(sub.status == Status.NEW) {
                isAllNew = true;
            } else {
                isAllNew = false;
            }
            if(isAllNew){
                this.status = Status.NEW;
            }
            if(sub.status == Status.DONE)
            {
               isAllDone = true;
            } else {
                isAllDone = false;
            }
            if(isAllDone) {
                this.status = Status.DONE;
            } else {
                this.status = Status.IN_PROGRESS;
            }
        }
    }

    public ArrayList<SubTask> getSubTasks() {
        return subtasks;
    }
}
