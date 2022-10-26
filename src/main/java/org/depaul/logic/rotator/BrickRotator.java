package org.depaul.logic.rotator;

import org.depaul.logic.bricks.Brick;

public class BrickRotator {

    private Brick brick;
    private int currentShapeIndex = 0;
    private int nextShapeIndex;

    public int[][] getNextShapeMatrix() {
        nextShapeIndex = currentShapeIndex;
        nextShapeIndex = (++nextShapeIndex) % brick.getBrickMatrixList().size();
        return brick.getBrickMatrixList().get(nextShapeIndex);
    }

    public int[][] getCurrentShapeMatrix() {
        return brick.getBrickMatrixList().get(currentShapeIndex);
    }

    public int getCurrentShapeIndex() {
        return currentShapeIndex;
    }

    public int getNextShapeIndex() {
        return nextShapeIndex;
    }

    public void setCurrentShapeIndex(int currentShapeIndex) {
        this.currentShapeIndex = currentShapeIndex;
    }

    public void setBrick(Brick brick) {
        this.brick = brick;
        currentShapeIndex = 0;
    }


}
