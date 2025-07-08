package Tasks;

public class SubTask extends Task{
    int epicID;

    public SubTask(String name, int epicID) {
        super(name );
        this.epicID = epicID;
    }

    public SubTask(String name, int epicID, int id) {
        super(name);
        this.epicID = epicID;
    }

    public SubTask(String name, int epicID, String description, Status status, int id) {
        super(name, description, status, id);
        this.epicID = epicID;
    }

    public int getEpicID() {
        return this.epicID;
    }
}
