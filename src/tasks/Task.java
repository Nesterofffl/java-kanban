package tasks;

import java.util.Objects;

public class Task {

    Integer id;
    String name;
    String description;
    Status status;

    //Конструкторы
    public Task() {
        this.status = Status.NEW;

    }
    public Task(String name) {
        this();
        this.name = name;
    }
    public Task(String name, String description) {
        this(name);
        this.description = description;
    }
    public Task(String name, String description, Status status, int id) {
        this(name, description);
        this.status = status;
        this.id = id;
    }
    public Task(String name, String description, Status status) {
        this(name, description);
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "task.Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Task task)) return false;
        return Objects.equals(this.id, task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.id);
    }
}

