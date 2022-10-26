package org.depaul.gui;

import org.depaul.logic.data.ViewData;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.ToggleButton;
import javafx.scene.effect.Reflection;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;
import org.depaul.logic.events.EventSource;
import org.depaul.logic.events.EventType;
import org.depaul.logic.events.InputEventListener;
import org.depaul.logic.events.MoveEvent;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;

public class GuiController implements Initializable {

    private static final int BRICK_SIZE = 20;

    @FXML
    private GridPane gamePanel;

    @FXML
    private Text scoreValue;

    @FXML
    private Group groupNotification;

    @FXML
    private GridPane nextBrick;

    @FXML
    private GridPane brickPanel;

    @FXML
    private ToggleButton pauseButton;

    @FXML
    private Group gameOverNotification;

    private Rectangle[][] displayMatrix;

    private InputEventListener eventListener;

    private Rectangle[][] rectangles;

    private Timeline timeLine;

    private final BooleanProperty isPause = new SimpleBooleanProperty();

    private final BooleanProperty isGameOver = new SimpleBooleanProperty();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Font.loadFont(getClass().getClassLoader().getResource("3X5.TTF").toExternalForm(), 38);
        gamePanel.setFocusTraversable(true);
        gamePanel.requestFocus();

//        Key bindings for game panel
        gamePanel.setOnKeyPressed(keyEvent -> {
            if (isPause.getValue() == Boolean.FALSE && isGameOver.getValue() == Boolean.FALSE) {
                if (keyEvent.getCode() == KeyCode.SPACE || keyEvent.getCode() == KeyCode.R) {
                    randomAction();
                    keyEvent.consume();
                }
                if (keyEvent.getCode() == KeyCode.DOWN || keyEvent.getCode() == KeyCode.S) {
                    randomMove(new MoveEvent(EventType.DOWN, EventSource.USER));
                    keyEvent.consume();
                }
            }
        });

//        GAME OVER panel notification
        gameOverNotification.setVisible(false);

//        PAUSE button
        pauseButton.selectedProperty().bindBidirectional(isPause);
        pauseButton.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                timeLine.pause();
                pauseButton.setText("Resume");
            } else {
                timeLine.play();
                pauseButton.setText("Pause");
            }
        });

//        SCORE: Setting the reflection style
        final Reflection reflection = new Reflection();
        reflection.setFraction(0.8);
        reflection.setTopOpacity(0.9);
        reflection.setTopOffset(-12);
        scoreValue.setEffect(reflection);
    }

    public void initGameView(int[][] boardMatrix, ViewData brick) {
//        displayMatrix is the GUI representation of the current state of the board currentGameMatrix
        displayMatrix = new Rectangle[boardMatrix.length][boardMatrix[0].length];
        for (int i = 2; i < boardMatrix.length; i++) {
            for (int j = 0; j < boardMatrix[i].length; j++) {
                Rectangle rectangle = new Rectangle(BRICK_SIZE, BRICK_SIZE);
                rectangle.setFill(Color.TRANSPARENT);
                displayMatrix[i][j] = rectangle;
                gamePanel.add(rectangle, j, i - 2);
            }
        }

//        rectangles is the GUI representation of the current state of brick.
        rectangles = new Rectangle[brick.getBrickData().length][brick.getBrickData()[0].length];
        for (int i = 0; i < brick.getBrickData().length; i++) {
            for (int j = 0; j < brick.getBrickData()[i].length; j++) {
                Rectangle rectangle = new Rectangle(BRICK_SIZE, BRICK_SIZE);
                rectangle.setFill(getFillColor(brick.getBrickData()[i][j]));
                rectangles[i][j] = rectangle;
                brickPanel.add(rectangle, j, i);
            }
        }
        brickPanel.setLayoutX(160+gamePanel.getLayoutX() + brick.getxPosition() * brickPanel.getVgap() + brick.getxPosition() * BRICK_SIZE);
        brickPanel.setLayoutY(-42 + gamePanel.getLayoutY() + brick.getyPosition() * brickPanel.getHgap() + brick.getyPosition() * BRICK_SIZE);

        generateNextBrickPanel(brick.getNextBrickData());


        timeLine = new Timeline(new KeyFrame(
                Duration.millis(500),
                ae -> randomMove(new MoveEvent(EventType.DOWN, EventSource.THREAD))
        ));
        timeLine.setCycleCount(Timeline.INDEFINITE);
        timeLine.play();
    }

    private Paint getFillColor(int i) {
        Paint returnPaint = switch (i) {
            case 0 -> Color.TRANSPARENT;
            case 1 -> Color.web("f94144", 1);
            case 2 -> Color.web("f3722c", 1);
            case 3 -> Color.web("f8961e", 1);
            case 4 -> Color.web("f9844a", 1);
            case 5 -> Color.web("f9c74f", 1);
            case 6 -> Color.web("90be6d", 1);
            case 7 -> Color.web("43aa8b", 1);
            case 8 -> Color.web("4d908e", 1);
            case 9 -> Color.web("577590", 1);
            case 10 -> Color.web("277da1", 1);
            default -> Color.web("", 1);
        };
        return returnPaint;
    }

    private void generateNextBrickPanel(int[][] nextBrickData) {
        nextBrick.getChildren().clear();
        for (int i = 0; i < nextBrickData.length; i++) {
            for (int j = 0; j < nextBrickData[i].length; j++) {
                Rectangle rectangle = new Rectangle(BRICK_SIZE, BRICK_SIZE);
                setRectangleData(nextBrickData[i][j] == 0 ? 0 : ThreadLocalRandom.current().nextInt(10)+1, rectangle);
                if (nextBrickData[i][j] != 0) {
                    nextBrick.add(rectangle, j, i);
                }
            }
        }
    }

    private void refreshBrick(ViewData brick) {
        if (isPause.getValue() == Boolean.FALSE) {
            brickPanel.setLayoutX(160+gamePanel.getLayoutX() + brick.getxPosition() * brickPanel.getVgap() + brick.getxPosition() * BRICK_SIZE);
            brickPanel.setLayoutY(-42 + gamePanel.getLayoutY() + brick.getyPosition() * brickPanel.getHgap() + brick.getyPosition() * BRICK_SIZE);
            for (int i = 0; i < brick.getBrickData().length; i++) {
                for (int j = 0; j < brick.getBrickData()[i].length; j++) {
                    setRectangleData(brick.getBrickData()[i][j] == 0 ? 0 : ThreadLocalRandom.current().nextInt(10)+1, rectangles[i][j]);
                }
            }
            generateNextBrickPanel(brick.getNextBrickData());
        }
    }

    public void refreshGameBackground(int[][] board) {
        for (int i = 2; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                setRectangleData(board[i][j] == 0 ? 0 : ThreadLocalRandom.current().nextInt(10)+1, displayMatrix[i][j]);
            }
        }
    }

    private void setRectangleData(int color, Rectangle rectangle) {
        rectangle.setFill(getFillColor(color));
        rectangle.setArcHeight(9);
        rectangle.setArcWidth(9);
    }

    private void randomAction(){

        int action = ThreadLocalRandom.current().nextInt(5); // 0 for game over - anything else for bonus

        if (action!=0) {
            //        Bonus notification
            NotificationPanel notificationPanel = new NotificationPanel("+" + ThreadLocalRandom.current().nextInt(100));
            groupNotification.getChildren().add(notificationPanel);
            notificationPanel.showScore(groupNotification.getChildren());

        } else {
            //        Game Over
           gameOver();
        }
    }

    private void randomMove(MoveEvent event) {
        if (isPause.getValue() == Boolean.FALSE) {
            ViewData viewData = eventListener.onRandomMoveEvent(event);
            refreshBrick(viewData);
        }
        gamePanel.requestFocus();
    }

    public void setEventListener(InputEventListener eventListener) {
        this.eventListener = eventListener;
    }

    public void bindScore(IntegerProperty integerProperty) {
        scoreValue.textProperty().bind(integerProperty.asString());
    }

    public void gameOver() {
        timeLine.stop();
        GameOverPanel gameOverPanel = new GameOverPanel("Game Over!");
        gameOverNotification.getChildren().add(gameOverPanel);
        gameOverNotification.setVisible(true);
        isGameOver.setValue(Boolean.TRUE);

    }

    public void newGame(ActionEvent actionEvent) {
        timeLine.stop();
        gameOverNotification.setVisible(false);
        eventListener.createNewGame();
        gamePanel.requestFocus();
        timeLine.play();
        isPause.setValue(Boolean.FALSE);
        isGameOver.setValue(Boolean.FALSE);
    }

    public void pauseGame(ActionEvent actionEvent) {
        gamePanel.requestFocus();
    }
}
