package Tasks;

import java.util.ArrayList;

public class EpicTask  extends  Task{
    private ArrayList<Integer> subtasks = new ArrayList<>();

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

    public EpicTask(String name, String description, Integer id, ArrayList<Integer> subtasks) {
        super(name, description);
        this.id = id;
        this.subtasks = subtasks;
    }


    public ArrayList<Integer> getSubTasks() {
        return subtasks;
    }

    @Override
    public String toString() {
        return "task.Epic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }

}
