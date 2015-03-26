package de.yellowapple.miniLD58.core;

import de.yellowapple.miniLD58.handler.ObjectHandler;
import de.yellowapple.miniLD58.objects.Ball;
import de.yellowapple.miniLD58.objects.PlayerBar;

public class AI {

    private enum direction {
	UP,
	DOWN
    }

    private ObjectHandler oHandler;
    private PlayerBar AIPlayerBar;
    private Ball ball;

    public AI(ObjectHandler oHandler) {
	this.oHandler = oHandler;
    }

    public void update() {
	for (int i = 0; i < oHandler.objects.size; i++) {
	    switch (oHandler.objects.get(i).getID()) {
		case AIBar:
		    AIPlayerBar = (PlayerBar) oHandler.objects.get(i);
		    break;
		case Ball:
		    ball = (Ball) oHandler.objects.get(i);
		    break;
		default:
		    break;
	    }
	}

	if (ball.getY() > AIPlayerBar.getY()) {
	    triggerDown(direction.UP);
	}
	if (ball.getY() < AIPlayerBar.getY() + AIPlayerBar.getBounds().height) {
	    triggerDown(direction.DOWN);
	}
	if (ball.getY() < AIPlayerBar.getY() && ball.getY() > AIPlayerBar.getY() + AIPlayerBar.getBounds().height) {
	    triggerUp();
	}
    }

    private void triggerDown(direction dir) {
	switch (dir) {
	    case DOWN:
		oHandler.updateObjects(0, -300, ObjectID.AIBar);
		break; // down
	    case UP:
		oHandler.updateObjects(0, 300, ObjectID.AIBar);
		break; // up
	    default:
		break;
	}
    }

    private void triggerUp() {
	oHandler.updateObjects(0, 0, ObjectID.AIBar);
    }
}
