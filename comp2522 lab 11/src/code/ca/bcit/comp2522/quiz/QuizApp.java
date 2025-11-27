package ca.bcit.comp2522.quiz;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Simple JavaFX quiz application.
 * <p>
 * Loads questions from a text file and asks 10 random questions.
 * Shows the score and a list of missed questions at the end.
 *
 * @author Minsu Kim
 * @author Esin Sahutoglu
 * @author Hali Imanpanah
 *
 * @version 1.0
 */
public class QuizApp extends Application
{
    private static final int QUESTIONS_PER_QUIZ = 10;
    private static final int WINDOW_WIDTH       = 500;
    private static final int WINDOW_HEIGHT      = 600;
    private static final int INITIAL_SCORE      = 0;
    private static final int START_INDEX        = 0;
    private static final int SECOND_INDEX       = 1;
    private static final int TIME_LIMIT         = 100;
    private static final int INTERVAL_DURATION  = 1;
    private static final int END_TIME           = 0;

    private List<Question> allQuestions;
    private List<Question> quizQuestions;
    private List<Question> missedQuestions;

    private int currentIndex;
    private int score;
    private int timeLeft;

    private Label     questionLabel;
    private TextField answerField;
    private Button    submitButton;
    private Button    startButton;
    private Label     scoreLabel;
    private Label     missedLabel;
    private TextArea  missedArea;
    private Label     timerLabel;
    private Timeline  timer;

    /**
     * Represents a single quiz question with a prompt and an answer.
     */
    private static class Question
    {
        private final String prompt;
        private final String answer;

        /**
         * Creates a new {@code Question}.
         *
         * @param prompt the question text
         * @param answer the correct answer
         */
        Question(final String prompt,
                 final String answer)
        {
            this.prompt = prompt;
            this.answer = answer;
        }

        /**
         * Returns the question text.
         *
         * @return the prompt for this question
         */
        public String getPrompt()
        {
            return prompt;
        }

        /**
         * Returns the correct answer.
         *
         * @return the answer to this question
         */
        public String getAnswer()
        {
            return answer;
        }
    }

    /**
     * Starts the JavaFX application and builds the main window.
     *
     * @param stage the main application window
     */
    @Override
    public void start(final Stage stage)
    {
        final VBox  root;
        final Scene scene;

        allQuestions    = loadQuestions();
        missedQuestions = new ArrayList<>();
        timerLabel      = new Label("Time: " + TIME_LIMIT);
        questionLabel   = new Label("Press 'Start Quiz' to begin!");
        answerField     = new TextField();
        submitButton    = new Button("Submit");
        startButton     = new Button("Start Quiz");
        scoreLabel      = new Label("Score: " + INITIAL_SCORE);
        missedLabel     = new Label("Missed Questions:");
        missedArea      = new TextArea();

        missedArea.setEditable(false);
        missedArea.setWrapText(true);
        submitButton.setDisable(true);
        answerField.setDisable(true);

        root = new VBox();
        root.getStyleClass().add("vbox");

        answerField.setOnAction(e -> submitAnswer());
        submitButton.setOnAction(e -> submitAnswer());
        startButton.setOnAction(e -> startQuiz());

        root.getChildren().addAll(
                timerLabel,
                questionLabel,
                answerField,
                submitButton,
                startButton,
                scoreLabel,
                missedLabel,
                missedArea
        );

        scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
        scene.getStylesheets().add(
                QuizApp.class.getResource("styles.css").toExternalForm()
        );

        stage.setTitle("Simple Quiz App");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Starts a new quiz round.
     * <p>
     * Resets the score, picks 10 random questions,
     * and shows the first question.
     */
    private void startQuiz()
    {
        if (allQuestions == null ||
            allQuestions.isEmpty())
        {
            questionLabel.setText("No questions available. Check quiz.txt.");
            return;
        }

        timeLeft = TIME_LIMIT;
        timerLabel.setText("Time: " + timeLeft);
        startTimer();

        final List<Question> shuffled;
        final int            quizSize;

        score        = INITIAL_SCORE;
        currentIndex = START_INDEX;

        missedQuestions.clear();
        missedArea.clear();
        scoreLabel.setText("Score: " + INITIAL_SCORE);

        shuffled = new ArrayList<>(allQuestions);
        Collections.shuffle(shuffled);

        quizSize = QUESTIONS_PER_QUIZ;

        quizQuestions = new ArrayList<>(shuffled.subList(START_INDEX, quizSize));

        startButton.setDisable(true);
        submitButton.setDisable(false);
        showCurrentQuestion();
    }

    /**
     * Shows the current question in the label.
     * <p>
     * If there are no more questions, ends the quiz.
     */
    private void showCurrentQuestion()
    {
        if (currentIndex >= quizQuestions.size())
        {
            endQuiz();
            return;
        }

        final Question current;
        current = quizQuestions.get(currentIndex);

        questionLabel.setText(current.getPrompt());
        answerField.clear();
        answerField.setDisable(false);
        answerField.requestFocus();
    }

    /**
     * Handles the user's answer.
     * <p>
     * Called when the user clicks the Submit button
     * or presses ENTER in the text field.
     */
    private void submitAnswer()
    {
        if (quizQuestions == null ||
            quizQuestions.isEmpty() ||
            currentIndex >= quizQuestions.size())
        {
            return;
        }

        final String   correctAnswer;
        final Question current;

        String userAnswer;
        userAnswer = answerField.getText();

        if (userAnswer == null)
        {
            userAnswer = "";
        }

        userAnswer = userAnswer.trim();

        current       = quizQuestions.get(currentIndex);
        correctAnswer = current.getAnswer();

        if (userAnswer.equalsIgnoreCase(correctAnswer))
        {
            score++;
            scoreLabel.setText("Score: " + score);
        }
        else
        {
            missedQuestions.add(current);
        }

        currentIndex++;

        if (currentIndex >= quizQuestions.size())
        {
            endQuiz();
        }
        else
        {
            showCurrentQuestion();
        }
    }

    /**
     * Ends the quiz and shows the final result.
     * <p>
     * Disables input, shows the final score,
     * and lists the missed questions and their correct answers.
     */
    private void endQuiz()
    {
        if (timer != null)
        {
            timer.stop();
        }

        final String message;
        final StringBuilder sb;

        message = "Quiz Complete! Final Score: " +
                score +
                " / " +
                quizQuestions.size();
        questionLabel.setText(message);

        submitButton.setDisable(true);
        answerField.clear();
        answerField.setDisable(true);
        startButton.setDisable(false);

        sb = new StringBuilder();

        if (missedQuestions.isEmpty())
        {
            sb.append("None! Great job.");
        }
        else
        {
            for (final Question missed : missedQuestions)
            {
                sb.append("Q: ")
                        .append(missed.getPrompt())
                        .append("\n");
                sb.append("A: ")
                        .append(missed.getAnswer())
                        .append("\n\n");
            }
        }

        missedArea.setText(sb.toString());
    }

    /**
     * A method to start the timer.
     */
    private void startTimer()
    {
        if (timer != null)
        {
            timer.stop();
        }

        timer = new Timeline(
                new KeyFrame(Duration.seconds(INTERVAL_DURATION), e -> {
                    timeLeft--;
                    timerLabel.setText("Time: " + timeLeft);

                    if (timeLeft <= END_TIME)
                    {
                        timer.stop();
                        endQuiz();
                    }
                })
        );

        timer.setCycleCount(TIME_LIMIT);
        timer.play();
    }

    /**
     * Loads all questions from the {@code quiz.txt} file.
     * <p>
     * Each line in the file must have the form:
     * {@code question|answer}.
     *
     * @return a list of {@code Question} objects;
     *         an empty list if the file cannot be read
     */
    private List<Question> loadQuestions()
    {
        final Path path;
        final List<Question> list;

        path = Paths.get("src",
                "resources",
                "ca",
                "bcit",
                "comp2522",
                "quiz",
                "quiz.txt");
        list = new ArrayList<>();

        try
        {
            final List<String> lines;
            lines = Files.readAllLines(path);

            for (final String line : lines)
            {
                if (line.isBlank() || !line.contains("|"))
                {
                    continue;
                }

                final String[] parts;
                final String   q;
                final String   a;

                parts = line.split("\\|");
                q     = parts[START_INDEX].trim();
                a     = parts[SECOND_INDEX].trim();

                list.add(new Question(q, a));
            }

        }
        catch (final IOException e)
        {
            System.out.println("Could not load quiz file: " + e.getMessage());
        }

        return list;
    }

    /**
     * Launches the JavaFX application.
     *
     * @param args command line arguments (not used)
     */
    public static void main(final String[] args)
    {
        launch(args);
    }
}