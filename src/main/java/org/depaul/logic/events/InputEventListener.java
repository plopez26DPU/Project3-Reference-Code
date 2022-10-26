package org.depaul.logic.events;

import org.depaul.logic.data.ViewData;

public interface InputEventListener {

    ViewData onRandomMoveEvent(MoveEvent event);

    void createNewGame();
}
