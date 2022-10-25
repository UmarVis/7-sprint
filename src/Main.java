import manager.Managers;
import manager.TaskManager;
import tasks.Epic;
import tasks.Subtask;
import tasks.Task;
import util.Status;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        TaskManager manager = Managers.getDefault();
        Task newTask = new Task("Задача 1", "Описание задачи 1", Status.NEW, 25,
                LocalDateTime.of(2022, 10, 1, 12, 0));
        Task newTask2 = new Task("Задача 2", "Описание задачи 2", Status.NEW, 30,
                LocalDateTime.of(2022, 10, 1, 12, 30));
        Task newTask3 = new Task("Задача 3", "Описание задачи 3", Status.NEW, 25,
                LocalDateTime.of(2022, 10, 1, 13, 0));
        manager.createTask(newTask);
        manager.createTask(newTask2);

        Epic epic1 = new Epic("Эпик 1", "Описание эпика 1", Status.NEW, 0,
                LocalDateTime.of(2000, 1, 1, 0, 0));
        Epic epic2 = new Epic("Эпик 2", "Описание эпика 2", Status.NEW, 0,
                LocalDateTime.of(2000, 1, 1, 0, 0));
        manager.createEpic(epic1);
        manager.createEpic(epic2);

        Subtask subtaskEpic1 = new Subtask("Подзадача 1 эпика 1", "Описание подзадачи 1",
                Status.NEW, 35, LocalDateTime.of(2022, 10, 2, 9, 0), 3);
        Subtask subtaskEpic2A = new Subtask("Подзадача 2 эпика 2", "Описание подзадачи 2", Status.NEW,
                20, LocalDateTime.of(2022, 10, 2, 10, 0), 4);
        Subtask subtaskEpic2B = new Subtask("Подзадача 3 эпика 2", "Описание подзадачи 3", Status.DONE,
                20, LocalDateTime.of(2022, 10, 2, 10, 30), 4);
        Subtask subtaskEpic3B = new Subtask("Подзадача 3 эпика 2", "Описание подзадачи 3", Status.DONE,
                25, LocalDateTime.of(2022, 10, 3, 11, 0), 4);
        manager.createSubtask(subtaskEpic1);
        manager.createSubtask(subtaskEpic2A);
        manager.createSubtask(subtaskEpic2B);
        manager.createSubtask(subtaskEpic3B);
        System.out.println("============================");
        System.out.println(manager.getAllTasks());
        System.out.println(manager.getAllEpics());
        System.out.println(manager.getAllSubtasks());
        manager.getTask(1);
        manager.getSubtask(6);
        System.out.println(manager.getHistory());

        System.out.println("============================");
        System.out.println(manager.getPrioritizedTasks());
        System.out.println("============================");


    }
}
