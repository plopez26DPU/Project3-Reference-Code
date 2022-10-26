package org.depaul.logic.bricks;

import org.junit.Assert;
import org.junit.Test;

public class IBrickTest {

    @Test
    public void testGetShapeMatrix() {
        Brick brick = new IBrick();
        brick.getBrickMatrixList().get(0)[0][0] = 2;
        brick.getBrickMatrixList().get(0)[1][0] = 3;
        Assert.assertEquals(0, brick.getBrickMatrixList().get(0)[0][0]);
        Assert.assertEquals(1, brick.getBrickMatrixList().get(0)[1][0]);
    }

    @Test
    public void testGetShapeMatrixList() {
        Brick brick = new IBrick();
        brick.getBrickMatrixList().remove(0);
        Assert.assertEquals(2, brick.getBrickMatrixList().size());
    }
}