package de.yellowapple.miniLD58.handler;

import de.yellowapple.miniLD58.core.GameMain;
import de.yellowapple.miniLD58.core.ObjectID;
import de.yellowapple.miniLD58.objects.Ball;
import de.yellowapple.miniLD58.objects.PlayerBar;

public class GameHandler {

    private ObjectHandler oHandler;

    public GameHandler(ObjectHandler oHandler) {
	this.oHandler = oHandler;
    }

    public void initGame() {
	oHandler.addObject(new Ball(GameMain.resolutionWidth / 2, GameMain.resolutionHeight / 2, ObjectID.Ball, 10)); // test
	oHandler.addObject(new PlayerBar(10, 50, ObjectID.PlayerBar, 10, 80, false));
    }
}
