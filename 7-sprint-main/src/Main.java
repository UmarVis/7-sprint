import com.google.gson.Gson;
import httptaskserver.HttpTaskServer;
import httptaskserver.KVServer;
import manager.Managers;
import manager.TaskManager;
import tasks.Epic;
import tasks.Subtask;
import tasks.Task;
import util.Status;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {


        HttpClient client = HttpClient.newHttpClient();
        new KVServer().start();
        HttpTaskServer server = new HttpTaskServer();
        server.start();


        Task task = new Task(1,"Задача 1", "Описание задачи 1", Status.NEW, 25,
                LocalDateTime.of(2022, 10, 1, 12, 0));
        Gson gson = new Gson();
        URI taskUri = URI.create("http://localhost:8080/tasks/task/");

        String taskJson = gson.toJson(task);

        final HttpRequest.BodyPublisher body = HttpRequest.BodyPublishers.ofString(taskJson);
        HttpRequest request = HttpRequest.newBuilder().uri(taskUri).POST(body).build();
        HttpResponse<String> responseTask = client.send(request, HttpResponse.BodyHandlers.ofString());

        //Проверка работы сервера

        URI uri2 = URI.create(taskUri + "?id=1");
        HttpRequest request4 = HttpRequest.newBuilder()
                .GET()
                .uri(uri2)
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        HttpResponse.BodyHandler<String> handler2 = HttpResponse.BodyHandlers.ofString();
    }
}
