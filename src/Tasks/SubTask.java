package Tasks;

public class SubTask extends Task{
    int epicID;

    public SubTask(String name, int epicID) {
        super(name );
        this.epicID = epicID;
    }

    public SubTask(String name, String description,int epicID) {
        super(name, description);
        this.epicID = epicID;
    }

    public int getEpicID() {
        return this.epicID;
    }
}
