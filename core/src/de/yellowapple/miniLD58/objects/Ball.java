package de.yellowapple.miniLD58.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;
import de.yellowapple.miniLD58.core.CircleObject;
import de.yellowapple.miniLD58.core.GameMain;
import de.yellowapple.miniLD58.core.GameObject;
import de.yellowapple.miniLD58.core.ObjectID;

public class Ball extends CircleObject {

    private boolean outside;

    public Ball(float x, float y, ObjectID oID, int radius) {
	super(x, y, oID, radius);
	outside = false;
	velX = 1;
	velY = 1;
    }

    private void checkCollisions(Array<GameObject> objects) {
	for (int i = 0; i < objects.size; i++) {
	    GameObject tempObject = objects.get(i);

	    switch (tempObject.getID()) {
		case PlayerBar:
		    if (getBounds().overlaps(((CircleObject) tempObject).getBounds())) {
			System.out.println("Ball - intersection - PlayerBar");
		    }
		    break;
		default:
		    break;
	    }
	}
    }

    private void handleVelocity() {
	if (!outside) {
	    velX += 0.5;
	    velY += 0.5;
	} else {
	    velX = 1;
	    velY = 1;
	}
    }

    public void reset(float xPos, float yPos) {
	x = xPos;
	y = yPos;
	outside = false;
    }

    public boolean isOutside() {
	return outside;
    }

    @Override
    public void update(Array<GameObject> objects) {
	x += velX;
	y += velY;

	handleVelocity();
	checkCollisions(objects);

	if (x > GameMain.resolutionWidth + (radius / 2)
		|| x < 0 - (radius / 2)
		|| y > GameMain.resolutionHeight + (radius / 2)
		|| y < 0 - (radius / 2)) {
	    System.out.println("Ball outside");
	    outside = true;
	}
    }

    @Override
    public void renderShapes(ShapeRenderer sr) {
	sr.setColor(0, 0, 0, 0);
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
