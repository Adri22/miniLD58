package de.yellowapple.miniLD58.handler;

import de.yellowapple.miniLD58.core.AI;
import de.yellowapple.miniLD58.core.GameMain;
import de.yellowapple.miniLD58.core.ObjectID;
import de.yellowapple.miniLD58.objects.Ball;
import de.yellowapple.miniLD58.objects.PlayerBar;

public class GameHandler {

    private ObjectHandler oHandler;
    private AI ai;

    public GameHandler(ObjectHandler oHandler) {
	this.oHandler = oHandler;
	this.ai = new AI(oHandler);
    }

    public void initGame() {
	oHandler.addObject(new Ball(GameMain.resolutionWidth / 2, GameMain.resolutionHeight / 2 + 300, ObjectID.Ball, 10));
	oHandler.addObject(new PlayerBar(10.0f, (GameMain.resolutionHeight / 2) - (80 / 2), ObjectID.PlayerBar, 20, 80));
	oHandler.addObject(new PlayerBar(GameMain.resolutionWidth - 10 - 20, (GameMain.resolutionHeight / 2) - (80 / 2), ObjectID.AIBar, 20, 80));
    }

    public void updateAI() {
	ai.update();
    }
}
