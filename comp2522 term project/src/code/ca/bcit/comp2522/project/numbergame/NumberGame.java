package ca.bcit.comp2522.project.numbergame;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * GUI-based ascending-number placement game.
 *
 * This class is only the skeleton layout;
 * game logic will be added later.
 *
 * @author Minsu Kim
 * @version 1.0.0
 */
public class NumberGame extends Application
{
    private static final int ROW_COUNT        = 4;
    private static final int COLUMN_COUNT     = 5;
    private static final int WINDOW_WIDTH     = 600;
    private static final int WINDOW_HEIGHT    = 400;
    private static final int GAP_SIZE         = 10;
    private static final int PADDING_SIZE     = 15;

    private Label   currentNumberLabel;
    private Label   statusLabel;
    private Button  newGameButton;
    private Button  quitButton;
    private Button[][] cellButtons;

    @Override
    public void start(final Stage stage)
    {
        initializeFields();

        final BorderPane root;
        root = createRootLayout();

        final Scene scene;
        scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);

        stage.setTitle("Number Game");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Initializes fields that depend only on constants.
     */
    private void initializeFields()
    {
        cellButtons = new Button[ROW_COUNT][COLUMN_COUNT];

        currentNumberLabel = new Label("Next number: —");
        statusLabel        = new Label("Click \"New Game\" to begin.");

        newGameButton = new Button("New Game");
        quitButton    = new Button("Quit");

        // 이벤트 핸들러는 나중에 구현
        newGameButton.setOnAction(event -> handleNewGame());
        quitButton.setOnAction(event -> handleQuit());
    }

    /**
     * Creates the main BorderPane layout.
     *
     * @return configured root layout
     */
    private BorderPane createRootLayout()
    {
        final BorderPane borderPane;
        borderPane = new BorderPane();

        final HBox topBar;
        topBar = createTopBar();

        final VBox centerBox;
        centerBox = createCenterBox();

        final HBox bottomBar;
        bottomBar = createBottomBar();

        borderPane.setTop(topBar);
        borderPane.setCenter(centerBox);
        borderPane.setBottom(bottomBar);

        return borderPane;
    }

    /**
     * Top: 게임 제목 + 현재 숫자 표시.
     */
    private HBox createTopBar()
    {
        final Label titleLabel;
        titleLabel = new Label("Number Game – Place numbers in ascending order");

        final VBox textBox;
        textBox = new VBox();
        textBox.getChildren().addAll(titleLabel, currentNumberLabel);
        textBox.setSpacing(5);
        textBox.setAlignment(Pos.CENTER_LEFT);

        final HBox topBar;
        topBar = new HBox();
        topBar.getChildren().add(textBox);
        topBar.setPadding(new Insets(PADDING_SIZE));
        topBar.setAlignment(Pos.CENTER_LEFT);

        return topBar;
    }

    /**
     * Center: 4x5 버튼 그리드.
     */
    private VBox createCenterBox()
    {
        final GridPane grid;
        grid = new GridPane();
        grid.setHgap(GAP_SIZE);
        grid.setVgap(GAP_SIZE);
        grid.setPadding(new Insets(PADDING_SIZE));
        grid.setAlignment(Pos.CENTER);

        for (int row = 0; row < ROW_COUNT; row++)
        {
            for (int col = 0; col < COLUMN_COUNT; col++)
            {
                final Button cellButton;
                cellButton = new Button("—");

                cellButton.setPrefWidth(80);
                cellButton.setPrefHeight(50);

                final int finalRow;
                final int finalCol;
                finalRow = row;
                finalCol = col;

                // 나중에 숫자 배치 로직 넣을 자리
                cellButton.setOnAction(event -> handleCellClick(finalRow, finalCol));

                cellButtons[row][col] = cellButton;
                grid.add(cellButton, col, row);
            }
        }

        final VBox centerBox;
        centerBox = new VBox();
        centerBox.getChildren().add(grid);
        centerBox.setAlignment(Pos.CENTER);

        return centerBox;
    }

    /**
     * Bottom: 상태 메시지 + 버튼들.
     */
    private HBox createBottomBar()
    {
        final HBox buttonBox;
        buttonBox = new HBox();
        buttonBox.getChildren().addAll(newGameButton, quitButton);
        buttonBox.setAlignment(Pos.CENTER_LEFT);
        buttonBox.setSpacing(GAP_SIZE);

        final HBox bottomBar;
        bottomBar = new HBox();
        bottomBar.getChildren().addAll(buttonBox, statusLabel);
        bottomBar.setSpacing(GAP_SIZE);
        bottomBar.setPadding(new Insets(PADDING_SIZE));
        bottomBar.setAlignment(Pos.CENTER_LEFT);

        HBox.setMargin(statusLabel, new Insets(0, 0, 0, 40));

        return bottomBar;
    }

    // ====== 이벤트 핸들러 (지금은 뼈대만) ======

    private void handleNewGame()
    {
        // TODO: 배열 초기화, 점수 초기화, 첫 랜덤 숫자 생성 등
        statusLabel.setText("New game started (logic to be implemented).");
    }

    private void handleQuit()
    {
        // 여기서는 그냥 창만 닫기
        final Stage stage;
        stage = (Stage) statusLabel.getScene().getWindow();
        stage.close();
        // Main 메뉴 복귀는 Main 쪽에서 Application.launch 사용 패턴에 맞춰서 설계
    }

    private void handleCellClick(final int row,
                                 final int column)
    {
        // TODO: 현재 숫자를 해당 칸에 배치 가능한지 검사하고,
        //       가능하면 버튼 텍스트 변경 + 상태 업데이트
        System.out.println("Clicked cell (" + row + ", " + column + ")");
    }
}