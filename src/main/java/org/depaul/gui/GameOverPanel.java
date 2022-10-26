package org.depaul.gui;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;


public class GameOverPanel extends BorderPane {

    public GameOverPanel() {
        this("Game Over!");
    }

    public GameOverPanel(String text) {
        final Label gameOverLabel = new Label(text);
        gameOverLabel.getStyleClass().add("gameOverStyle");
        setCenter(gameOverLabel);
    }
}
