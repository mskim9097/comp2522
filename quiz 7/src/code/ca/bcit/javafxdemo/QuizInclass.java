package ca.bcit.javafxdemo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public final class QuizInclass extends Application
{
    @Override
    public final void start(final Stage stage)
    {
        final BorderPane root;
        root = createRootLayout();

        final Scene scene;
        scene = new Scene(root, 450, 300);

        stage.setTitle("HBox • VBox • BorderPane Demo 🌟");
        stage.setScene(scene);
        stage.show();
    }

    private final BorderPane createRootLayout()
    {
        final BorderPane borderPane;
        final Label header;
        final VBox centerBox;
        final HBox bottomBar;

        borderPane = new BorderPane();
        header = createHeader();
        centerBox = createCenterBox();
        bottomBar = createBottomBar();

        borderPane.setTop(header);
        BorderPane.setAlignment(header, Pos.CENTER);

        borderPane.setCenter(centerBox);
        borderPane.setBottom(bottomBar);

        return borderPane;
    }

    private final Label createHeader()
    {
        final Label header;
        header = new Label("🎨 JavaFX Layout Pane Demo 🎨");

        return header;
    }

    private final VBox createCenterBox()
    {
        final Label title;
        final Label subtitle;
        final VBox centerBox;

        title = new Label("✨ Welcome to the Center VBox ✨");
        subtitle = new Label("📦 VBox stacks items vertically");
        centerBox = new VBox();

        centerBox.getChildren().add(title);
        centerBox.getChildren().add(subtitle);

        centerBox.setSpacing(10);
        centerBox.setAlignment(Pos.CENTER);
        centerBox.setPadding(new Insets(20));

        return centerBox;
    }

    private final HBox createBottomBar()
    {
        final Button okButton;
        final Button cancelButton;
        final HBox bottomBar;

        okButton = new Button("✔ OK");
        cancelButton = new Button("❌ Cancel");
        bottomBar = new HBox();

        bottomBar.getChildren().add(okButton);
        bottomBar.getChildren().add(cancelButton);

        bottomBar.setSpacing(15);
        bottomBar.setAlignment(Pos.CENTER);
        bottomBar.setPadding(new Insets(10));

        return bottomBar;
    }

    public static final void main(final String[] args)
    {
        launch(args);
    }
}