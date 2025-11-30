package ca.bcit.comp2522.project.numbergame;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Represents the main GUI for the Number Game.
 * Handles user interaction and updates the view based on NumberGameLogic.
 * Tracks session statistics as per project requirements.
 *
 * @author Minsu Kim
 * @version 1.0.0
 */
public class NumberGame implements GameConstants
{
    private static final int    WINDOW_WIDTH         = 600;
    private static final int    WINDOW_HEIGHT        = 600;
    private static final int    GAP_SIZE             = 10;
    private static final int    BUTTON_BOX_GAP       = 20;
    private static final int    ACTION_BTN_W         = 120;
    private static final int    INITIAL_INT_VALUE    = 0;
    private static final int    NON_PLAY_GAME        = 0;
    private static final double NO_AVERAGE           = 0.0;

    private static final String CSS_PATH = "/numbergame/styles.css";

    private final NumberGameLogic logic;
    private final Button[]        buttons;
    private final Random          random;

    private int   currentNumber;
    private Label statusLabel;
    private int   totalGamesPlayed;
    private int   totalGamesWon;
    private int   totalSuccessfulPlacements;
    private int   currentSuccessfulPlacements;

    private Stage primaryStage;

    /**
     * Constructor for NumberGame.
     */
    public NumberGame()
    {
        this.logic   = new NumberGameLogic();
        this.buttons = new Button[TOTAL_SLOTS];
        this.random  = new Random();

        this.totalGamesPlayed            = INITIAL_INT_VALUE;
        this.totalGamesWon               = INITIAL_INT_VALUE;
        this.totalSuccessfulPlacements   = INITIAL_INT_VALUE;
        this.currentSuccessfulPlacements = INITIAL_INT_VALUE;
    }

    /**
     * Opens a new game window and signals the latch when closed.
     * @param latch the latch to countdown when the window closes
     */
    public void openGameWindow(final CountDownLatch latch)
    {
        final Stage stage;
        stage = new Stage();
        this.primaryStage = stage;

        initStage(stage);
        stage.setOnHidden(e -> latch.countDown());
        stage.show();
        generateNextNumber();
    }

    /**
     * Initializes the stage with layout, buttons, and event handlers.
     * @param primaryStage the stage to initialize
     */
    private void initStage(final Stage primaryStage)
    {
        final VBox      root;
        final GridPane  grid;
        final Scene     scene;
        final Button    tryAgainBtn;
        final Button    quitBtn;
        final HBox      buttonBox;


        root = new VBox(GAP_SIZE);
        root.setAlignment(Pos.CENTER);
        root.getStyleClass().add("game-root");

        statusLabel = new Label("Welcome to Number Game!");
        statusLabel.getStyleClass().add("status-label");

        grid = createGrid();

        tryAgainBtn = new Button("Try Again");
        tryAgainBtn.setPrefWidth(ACTION_BTN_W);
        tryAgainBtn.getStyleClass().add("try-again-button");
        tryAgainBtn.setOnAction(e -> resetGame());

        quitBtn = new Button("Quit");
        quitBtn.setPrefWidth(ACTION_BTN_W);
        quitBtn.getStyleClass().add("quit-button");
        quitBtn.setOnAction(e -> showStatsAndQuit());

        buttonBox = new HBox(BUTTON_BOX_GAP);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(tryAgainBtn, quitBtn);

        root.getChildren().addAll(statusLabel, grid, buttonBox);

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

        primaryStage.setTitle("Number Game");
        primaryStage.setScene(scene);
    }

    /**
     * Creates the grid for the game.
     * @return the grid
     */
    private GridPane createGrid()
    {
        final GridPane grid;
        grid = new GridPane();

        grid.setHgap(GAP_SIZE);
        grid.setVgap(GAP_SIZE);
        grid.setAlignment(Pos.CENTER);

        int buttonIndex = FIRST_INDEX;
        for (int row = FIRST_INDEX; row < GRID_ROWS; row++)
        {
            for (int col = FIRST_INDEX; col < GRID_COLS; col++)
            {
                final Button btn;
                final int index;

                btn = new Button("[ ]");
                btn.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
                btn.getStyleClass().add("grid-button");

                index = buttonIndex;
                btn.setOnAction(e -> handleButtonClick(index));

                buttons[index] = btn;
                grid.add(btn, col, row);
                buttonIndex++;
            }
        }
        return grid;
    }

    /**
     * Handles the button click.
     * @param index the index of the button
     */
    private void handleButtonClick(final int index)
    {
        if (logic.isValidPlacement(currentNumber, index))
        {
            logic.setNumberAt(index, currentNumber);
            buttons[index].setText(String.valueOf(currentNumber));
            buttons[index].setDisable(true);

            currentSuccessfulPlacements++;

            if (logic.isBoardFull())
            {
                updateStats(true);

                statusLabel.setText("You Won! All slots filled.");
                disableAllButtons();
                showAlert("Victory",
                        "Congratulations! You completed the grid.\n\n" +
                        getStatusMessage());
                return;
            }

            generateNextNumber();
        }
        else
        {
            showAlert("Invalid Move",
                    "You cannot place " +
                    currentNumber +
                    " here.\n" +
                    "Remember: Ascending order!");
        }
    }

    /**
     * Updates game statistics.
     * @param isWin true if the game was won, false otherwise
     */
    private void updateStats(final boolean isWin)
    {
        totalGamesPlayed++;
        if (isWin)
        {
            totalGamesWon++;
        }
        totalSuccessfulPlacements += currentSuccessfulPlacements;
    }

    /**
     * Generates the status message string required by the assignment.
     * @return formatted status string
     */
    private String getStatusMessage()
    {
        final int           gamesLost;
        final double        average;
        final StringBuilder sb;

        gamesLost = totalGamesPlayed - totalGamesWon;
        sb        = new StringBuilder();

        if (totalGamesPlayed > NON_PLAY_GAME)
        {
            average = (double) totalSuccessfulPlacements / totalGamesPlayed;
        }
        else
        {
            average = NO_AVERAGE;
        }

        sb.append("You won ")
          .append(totalGamesWon)
          .append(" out of ")
          .append(totalGamesPlayed)
          .append(" games and you lost ")
          .append(gamesLost)
          .append(" out of ")
          .append(totalGamesPlayed)
          .append(" games,\nwith ")
          .append(totalSuccessfulPlacements)
          .append(" successful placements, an average of ")
          .append(String.format("%.1f", average))
          .append(" per game.");

        return sb.toString();
    }

    /**
     * Shows stats and closes the window.
     */
    private void showStatsAndQuit()
    {
        final Alert alert;
        final Optional<ButtonType> result;

        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Goodbye");
        alert.setHeaderText("Thanks for playing!");
        alert.setContentText(getStatusMessage());

        result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK)
        {
            primaryStage.close();
        }
    }

    /**
     * Resets the game to its initial state.
     */
    private void resetGame()
    {
        logic.resetBoard();

        for (final Button btn : buttons)
        {
            btn.setText("[ ]");
            btn.setDisable(false);
        }

        currentSuccessfulPlacements = INITIAL_INT_VALUE;

        statusLabel.setText("Game Restarted!");
        generateNextNumber();
    }

    /**
     * Generates the next unique number.
     */
    private void generateNextNumber()
    {
        do
        {
            currentNumber = random.nextInt(MAX_NUMBER_VALUE) +
                    MIN_NUMBER_VALUE;
        }
        while (logic.isNumberPresent(currentNumber));

        if (!logic.isMovePossible(currentNumber))
        {
            updateStats(false);

            statusLabel.setText("Game Over! " + getStatusMessage());
            disableAllButtons();
            showAlert("Game Over",
                    "No valid moves left for number: " +
                    currentNumber +
                    "\n\n" +
                    getStatusMessage());
            return;
        }
        statusLabel.setText("Next Number: " + currentNumber);
    }

    /**
     * Disables all buttons.
     */
    private void disableAllButtons()
    {
        for (final Button btn : buttons)
        {
            btn.setDisable(true);
        }
    }

    /**
     * Shows an alert dialog.
     */
    private void showAlert(final String title,
                           final String message)
    {
        final Alert alert;

        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}