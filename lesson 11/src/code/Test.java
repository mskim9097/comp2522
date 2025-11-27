import javafx.application.Application;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Test extends Application
{
    @Override
    public void start(final Stage s)
    {
        VBox root = new VBox();
        Button btn = new Button("Click me");
        Label label = new Label("Enter your name:");
        TextField textField = new TextField();
        Button tBtn = new Button("Task");
        Label tLabel = new Label("before Task");
        Button sBtn = new Button("Service");
        Label sLabel = new Label("before Service");

        Service<String> service = new Service<>() {
            @Override
            protected Task<String> createTask() {
                return new Task<>() {
                    @Override
                    protected String call() throws Exception {
                        if(Math.random() > 0.5) throw new RuntimeException("Random error");
                        Thread.sleep(1000);
                        return "Service completed";
                    }
                };
            }
        };

        service.setOnRunning(e -> {
            sLabel.setText("Running");
            sBtn.setText("Stop");
        });

        service.setOnSucceeded(e -> {
            sLabel.setText("Succeeded" + service.getValue());
            sBtn.setText("restart");
                });

        service.setOnFailed(e -> {
            sLabel.setText("Failed" + service.getException().getMessage());
            sBtn.setText("restart");
        });

        service.setOnCancelled(e -> {
            sLabel.setText("Cancelled");
            sBtn.setText("restart");
        });

        sBtn.setOnAction(e -> {
           if(service.isRunning()) service.cancel();
           else service.restart();
        });

        Task<String> task = new Task<>(){
            @Override
            protected String call() throws InterruptedException {
                Thread.sleep(1000);
                return "Task completed";
            }
        };

        task.setOnSucceeded(e -> tLabel.setText(task.getValue()));
        tBtn.setOnAction(e -> new Thread(task).start());

        btn.setOnAction(e -> label.setText("Hello, " + textField.getText()));
        btn.setOnAction(e -> System.out.println("Hello, " + textField.getText()));
        root.getChildren().addAll(btn, label, textField, tBtn, tLabel, sBtn, sLabel);
        Scene scene = new Scene(root, 300, 250);
        s.setScene(scene);
        s.setTitle("comp2522");
        s.show();
    }

    public static void main(final String[] args)
    {
        Application.launch(args);
    }


}
