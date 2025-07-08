import Managers.Managers;
import Managers.ITaskManager;
import Tasks.EpicTask;
import Tasks.Status;
import Tasks.SubTask;
import Tasks.Task;

public class Main {

    public static void main(String[] args) {
        ITaskManager inMemoryTaskManager = Managers.getDefault();

        //Пример работы программы
        /*
        Task task1 = new Task("Помыть посуду");
        Task task2 = new Task("Помыть раковину");
        Task task3 = new Task("Помыть каструлю");
        EpicTask task4 = new EpicTask("Сходить в кино");
        SubTask task5 = new SubTask("Купить билет", 4);
        task5.setStatus(Status.DONE);
        SubTask task6 = new SubTask("Приготовить наряд", 4);
        EpicTask task7 = new EpicTask("Сделать курсы");
        SubTask task8 = new SubTask("Пройти теорию", 7);

        inMemoryTaskManager.addTask(task1);
        inMemoryTaskManager.addTask(task2);
        inMemoryTaskManager.addTask(task3);
        inMemoryTaskManager.addEpicTask(task4);
        inMemoryTaskManager.addSubTask(task5);
        inMemoryTaskManager.addSubTask(task6);
        inMemoryTaskManager.addEpicTask(task7);
        inMemoryTaskManager.addSubTask(task8);
        inMemoryTaskManager.getTask(1);
        inMemoryTaskManager.getTask(2);
        inMemoryTaskManager.getTask(3);
        inMemoryTaskManager.getEpicTask(4);
        inMemoryTaskManager.getSubTask(5);
        inMemoryTaskManager.getSubTask(6);

        System.out.println(inMemoryTaskManager.getHistoryManager().getHistory());
        System.out.println(inMemoryTaskManager.getSubsForEpic(4));
        */

        //Cоздание задачи - Task taskName = new Task("Обязательное имя", описание, статус через Status.NEW/IN_PROGRESS/DONE);
        //Создание Эпика - EpicTask taskName = new EpicTask("Обязательное имя", описание);
        //Создание Саба - SubTask taskName = new SubTask("Обязательное имя", описание, Обязательный ID эпика)
        //Добавление задачи в менеджер - manager.addTask(Название задачи), передаем сразу объект task
        //Добавление Эпика в менеджер - manager.addEpicTask(Название задачи), передаем сразу объект EpicTask
        //Добавление задачи в менеджер - manager.addSubTask(Название задачи), передаем сразу объект SubTask
        //Получить задачу по её ID - manager.getTask(id)
        //Получить Эпик по её ID - manager.getEpicTask(id)
        //Получить Саб по её ID - manager.getSubTask(id)
        //Удалить задачу по её ID - manager.removeTask(id)
        //Удалить эпик по её ID - manager.removEpicTask(id)
        //Удалить Саб по её ID - manager.removeSubTask(id)
        //Удалить все задачи - manager.removeAllTasks();
        //Удалить все Эпики - manager.removeAllEpicTasks();
        //Удалить все Сабы - manager.removeAllSubTasks();
        //Обновить задачу - manager.updateTask(задача которую обновить, задача которой обновить)
        //Обновить Эпик - manager.updateEpicTask(задача которую обновить, задача которой обновить)
        //Обновить Саб - manager.updateSubTask(задача которую обновить, задача которой обновить)
        //Получить список всех задач - manager.getAllTasks()
        //Получить список все сабов в эпике по ID - manager.getSubsForEpic(ID Эпика);
    }
}
