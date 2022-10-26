package org.depaul.logic.board;

import org.depaul.logic.data.Score;
import org.depaul.logic.data.ViewData;

public interface Board {

    boolean moveBrickRandom();

    boolean createNewBrick();

    int[][] getBoardMatrix();

    ViewData getViewData();

    void mergeBrickToBackground();

    Score getScore();

    void newGame();
}
