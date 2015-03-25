package de.yellowapple.miniLD58.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.Array;

import de.yellowapple.miniLD58.core.GameMain;
import de.yellowapple.miniLD58.core.GameObject;
import de.yellowapple.miniLD58.core.ObjectID;
import de.yellowapple.miniLD58.core.RectObject;

public class PlayerBar extends RectObject {

    private boolean aiControlled;

    public PlayerBar(float x, float y, ObjectID oID, int width, int height, boolean aiControlled) {
	super(x, y, oID, width, height);
	this.aiControlled = aiControlled;
    }

    @Override
    public void update(Array<GameObject> objects) {
    }

    @Override
    public void update(Array<GameObject> objects, float velX, float velY) {
	this.velX = velX;
	this.velY = velY;
	checkCollision(objects);
    }

    @Override
    public void renderShapes(ShapeRenderer sr) {
	sr.set(ShapeType.Filled);
	sr.setColor(1, 1, 1, 0);
	sr.rect(x, x, width, height);
    }

    @Override
    public void renderSprites(SpriteBatch batch) {
    }

    @Override
    protected boolean checkCollision(Array<GameObject> objects) {
	if (y > GameMain.resolutionHeight - height || y < 0) {
	    System.out.println("PlayerBar - collision - top or bottom");
	    // not finished yet
	    return true;
	}
	return false;
    }

    public boolean isControlledByAI() {
	return aiControlled;
    }

    @Override
    public void dispose() {
	// dispose sprites here
    }
}
