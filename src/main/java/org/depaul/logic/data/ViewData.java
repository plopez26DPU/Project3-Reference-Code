package org.depaul.logic.data;

import org.depaul.logic.util.Operations;

public record ViewData(int[][] brickData, int xPosition, int yPosition, int[][] nextBrickData) {

    public int[][] getBrickData() {
        return Operations.copyMatrix(brickData);
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public int[][] getNextBrickData() {
        return Operations.copyMatrix(nextBrickData);
    }
}
