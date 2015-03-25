package de.yellowapple.miniLD58.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import de.yellowapple.miniLD58.core.CircleObject;
import de.yellowapple.miniLD58.core.GameMain;
import de.yellowapple.miniLD58.core.GameObject;
import de.yellowapple.miniLD58.core.ObjectID;

public class Ball extends CircleObject {

    private enum direction {
	LEFT,
	RIGHT
    }

    private direction currentDirection;
    private boolean outside;
    private float speed;

    public Ball(float x, float y, ObjectID oID, int radius) {
	super(x, y, oID, radius);
	outside = false;
	speed = 0.1f;
	velX = 1;
	velY = 1;
	randomDirection();
    }

    @Override
    protected boolean checkCollision(Array<GameObject> objects) {
	for (int i = 0; i < objects.size; i++) {
	    GameObject tempObject = objects.get(i);

	    switch (tempObject.getID()) {
		case PlayerBar:
		    if (getBounds().overlaps(((CircleObject) tempObject).getBounds())) { // error
			System.out.println("Ball - intersection - PlayerBar");
			switch (currentDirection) {
			    case RIGHT:
				currentDirection = direction.LEFT;
				break;
			    case LEFT:
				currentDirection = direction.RIGHT;
				break;
			    default:
				break;
			}
			return true;
		    }
		    break;
		default:
		    break;
	    }
	}

	if (y > GameMain.resolutionHeight - (radius / 2) || y < 0 + (radius / 2)) {
	    System.out.println("Ball - collision - top or bottom");
	    return true;
	}
	return false;
    }

    private void handleVelocity() {
	velX += speed;
	velY += speed;
    }

    private void randomDirection() {
	boolean dirRnd = MathUtils.randomBoolean();
	if (dirRnd) { // i dont like this solution ...
	    currentDirection = direction.LEFT;
	} else {
	    currentDirection = direction.RIGHT;
	}
    }

    private void reset(float xPos, float yPos) {
	x = xPos;
	y = yPos;
	velX = 1;
	velY = 1;
	outside = false;
	randomDirection();
    }

    private boolean isOutside() {
	return outside;
    }

    @Override
    public void update(Array<GameObject> objects) {

	if (isOutside()) { // test
	    reset(GameMain.resolutionWidth / 2, GameMain.resolutionHeight / 2);
	}

	switch (currentDirection) { // not finished yet
	    case LEFT:
		x -= velX;
		// y += velY;
		break;
	    case RIGHT:
		x += velX;
		// y += velY;
		break;
	    default:
		break;
	}

	handleVelocity();
	checkCollision(objects);

	if (x > GameMain.resolutionWidth + (radius / 2) || x < 0 - (radius / 2)) {
	    outside = true;
	}
    }

    @Override
    public void update(Array<GameObject> objects, float velX, float velY) {
    }

    @Override
    public void renderShapes(ShapeRenderer sr) {
	sr.set(ShapeType.Filled);
	sr.setColor(1, 1, 1, 0);
	sr.circle(x, y, radius);
    }

    @Override
    public void renderSprites(SpriteBatch batch) {
    }

    @Override
    public void dispose() {
	// dispose sprites here
    }
}
