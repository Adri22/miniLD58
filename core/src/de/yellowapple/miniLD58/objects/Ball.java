package de.yellowapple.miniLD58.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
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
    private float bounceAngle;

    public Ball(float x, float y, ObjectID oID, int radius) {
	super(x, y, oID, radius);
	outside = false;
	speed = 0.5f;
	velX = 1;
	velY = 1;
	bounceAngle = 0;
	randomDirection();
    }

    @Override
    protected boolean checkCollision(Array<GameObject> objects) {
	for (int i = 0; i < objects.size; i++) {
	    GameObject tempObject = objects.get(i);
	    switch (tempObject.getID()) {
		case PlayerBar:
		case AIBar:
		    PlayerBar pb = (PlayerBar) objects.get(i);
		    if (getHitboxBounds().overlaps(pb.getBounds())) {
			bounceAngle = calculateBarCollisionAngle(pb.getBounds());
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

	/*
	 * needs border top / down collision if (y + radius >
	 * GameMain.resolutionHeight || y - radius < 0) { bounceAngle =
	 * calculateBorderCollisionAngle(); return true; }
	 */
	return false;
    }

    private float calculateBarCollisionAngle(Rectangle barBounds) {
	return (((barBounds.y + (barBounds.height / 2)) - y) / (barBounds.height / 2)) * 75;
    }

    private float calculateBorderCollisionAngle() {
	return (GameMain.resolutionWidth / 2) * 75; // not finished
    }

    private void handleVelocity() {
	velX += speed * MathUtils.cosDeg(bounceAngle);
	velY += speed * -MathUtils.sinDeg(bounceAngle);
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
	bounceAngle = 0;
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

	switch (currentDirection) {
	    case LEFT:
		x -= velX * Gdx.graphics.getDeltaTime();
		y += velY * Gdx.graphics.getDeltaTime();
		break;
	    case RIGHT:
		x += velX * Gdx.graphics.getDeltaTime();
		y += velY * Gdx.graphics.getDeltaTime();
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
	/*
	 * hitbox rendering sr.set(ShapeType.Line); sr.setColor(1, 0, 0, 0);
	 * sr.rect(x - radius, y - radius, radius * 2, radius * 2);
	 */
    }

    @Override
    public void renderSprites(SpriteBatch batch) {
    }

    @Override
    public void dispose() {
	// dispose sprites here
    }
}
