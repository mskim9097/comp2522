package ca.bcit.comp2522.project.mygame;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Objects;
import java.util.concurrent.CountDownLatch;

/**
 * JavaFX GUI for the virus outbreak simulation.
 * Delegates all game logic to {@link MyGameLogic}.
 *
 * @author Minsu Kim
 * @version 1.0.0
 */
public class MyGame
        implements MyGameConstants
{
    private static final int WINDOW_WIDTH     = 600;
    private static final int WINDOW_HEIGHT    = 650;
    private static final int GAP_SIZE         = 10;
    private static final int CONTROL_GAP_SIZE = 15;

    private static final String CSS_PATH = "/mygame/styles.css";

    private final MyGameLogic logic;

    private Grid<Cell>    grid;
    private Rectangle[][] rectangles;
    private Stage         primaryStage;
    private Label         roundLabel;
    private Label         statsLabel;

    /**
     * Constructs the GUI wrapper and initializes the game logic.
     * The JavaFX stage is created later in {@link #openGameWindow(CountDownLatch)}.
     */
    public MyGame()
    {
        logic = new MyGameLogic();
    }

    /**
     * Opens a new MyGame window and signals the latch when closed.
     *
     * @param latch latch to count down when the window is closed
     */
    public void openGameWindow(final CountDownLatch latch)
    {
        final Stage stage;

        stage        = new Stage();
        primaryStage = stage;

        initStage(stage);

        stage.setOnHidden(e -> latch.countDown());
        stage.show();
    }

    /**
     * Initializes the stage with the game grid, controls, and labels.
     *
     * @param stage the stage to initialize
     */
    private void initStage(final Stage stage)
    {
        final VBox     root;
        final Scene    scene;
        final GridPane gridPane;
        final HBox     controlBox;
        final Button   resetButton;
        final Button   quitButton;
        final Label    titleLabel;
        final Label    subtitleLabel;

        grid       = logic.getGrid();
        rectangles = new Rectangle[GRID_ROWS][GRID_COLS];

        gridPane = buildGridPane();

        titleLabel = new Label("MyGame - Virus Outbreak Simulator");
        titleLabel.getStyleClass().add("mygame-title");

        subtitleLabel = new Label(
                "Click a healthy (green) cell to vaccinate it and advance "
                        + "the round.\n"
                        + "Red cells spread to nearby green cells each round. "
                        + "Stop the outbreak before infection reaches 50%."
        );
        subtitleLabel.setWrapText(true);
        subtitleLabel.getStyleClass().add("subtitle-label");

        roundLabel = new Label("Round: " + logic.getRoundCount());
        roundLabel.getStyleClass().add("mygame-round-label");

        statsLabel = new Label(logic.buildStatsText());
        statsLabel.getStyleClass().add("mygame-stats-label");

        resetButton = new Button("Reset");
        resetButton.getStyleClass().add("mygame-button");
        resetButton.setOnAction(e -> resetGame());

        quitButton = new Button("Quit");
        quitButton.getStyleClass().add("mygame-button");
        quitButton.setOnAction(e -> primaryStage.close());

        controlBox = new HBox(CONTROL_GAP_SIZE);
        controlBox.setAlignment(Pos.CENTER);
        controlBox.getChildren().addAll(resetButton, quitButton);

        root = new VBox(GAP_SIZE);
        root.setAlignment(Pos.CENTER);
        root.getStyleClass().add("mygame-root");
        root.getChildren().addAll(
                titleLabel,
                subtitleLabel,
                roundLabel,
                statsLabel,
                gridPane,
                controlBox
        );

        scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);

        if (getClass().getResource(CSS_PATH) != null)
        {
            scene.getStylesheets().add(
                    Objects.requireNonNull(
                                    getClass().getResource(CSS_PATH))
                            .toExternalForm());
        }
        else
        {
            System.out.println("CSS file not found at " + CSS_PATH);
        }

        stage.setTitle("MyGame - Virus Outbreak Simulator");
        stage.setScene(scene);
    }

    /**
     * Builds the visual grid and wires up click handlers for vaccination.
     *
     * @return configured GridPane
     */
    private GridPane buildGridPane()
    {
        final GridPane gridPane;

        gridPane = new GridPane();
        gridPane.setHgap(GAP_SIZE);
        gridPane.setVgap(GAP_SIZE);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.getStyleClass().add("mygame-grid");

        int rowIndex;
        int colIndex;

        rowIndex = FIRST_INDEX;
        while (rowIndex < GRID_ROWS)
        {
            colIndex = FIRST_INDEX;
            while (colIndex < GRID_COLS)
            {
                final Rectangle rect;
                final Cell      cell;
                final int       r;
                final int       c;

                cell = grid.getCell(rowIndex, colIndex);

                rect = new Rectangle(CELL_SIZE, CELL_SIZE);
                rect.getStyleClass().add("mygame-cell-rect");
                rect.setFill(cell.getColor());

                rectangles[rowIndex][colIndex] = rect;

                r = rowIndex;
                c = colIndex;

                rect.setOnMouseClicked(e -> handleCellClick(r, c));

                gridPane.add(rect, colIndex, rowIndex);

                colIndex++;
            }
            rowIndex++;
        }

        return gridPane;
    }

    /**
     * Handles a click on a grid cell: try vaccination, refresh view,
     * and show the end-of-game popup if the game is over.
     *
     * @param row row index
     * @param col column index
     */
    private void handleCellClick(final int row,
                                 final int col)
    {
        final boolean vaccinated;

        vaccinated = logic.vaccinateCell(row, col);

        if (!vaccinated)
        {
            return;
        }

        refreshAllRectangleColors();
        updateLabels();

        if (logic.isGameOver())
        {
            showEndAlert();
        }
    }

    /**
     * Resets the simulation and refreshes the view.
     */
    private void resetGame()
    {
        logic.reset();
        refreshAllRectangleColors();
        updateLabels();
    }

    /**
     * Refreshes all rectangle colors from the current grid state.
     */
    private void refreshAllRectangleColors()
    {
        int rowIndex;
        int colIndex;

        rowIndex = FIRST_INDEX;
        while (rowIndex < GRID_ROWS)
        {
            colIndex = FIRST_INDEX;
            while (colIndex < GRID_COLS)
            {
                rectangles[rowIndex][colIndex].setFill(
                        grid.getCell(rowIndex, colIndex).getColor());
                colIndex++;
            }
            rowIndex++;
        }
    }

    /**
     * Updates the round and stats labels.
     */
    private void updateLabels()
    {
        roundLabel.setText("Round: " + logic.getRoundCount());
        statsLabel.setText(logic.buildStatsText());
    }

    /**
     * Shows an end-of-game summary popup.
     */
    private void showEndAlert()
    {
        final Alert alert;

        logic.saveResults();

        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(
                logic.didPlayerWin() ? "Outbreak Contained" : "Outbreak Lost");
        alert.setHeaderText(
                logic.didPlayerWin() ? "You Win!" : "You Lose!");
        alert.setContentText(logic.getEndSummary());
        alert.showAndWait();
    }
}