package de.yellowapple.miniLD58.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.Array;
import de.yellowapple.miniLD58.core.GameMain;
import de.yellowapple.miniLD58.core.GameObject;
import de.yellowapple.miniLD58.core.ObjectID;
import de.yellowapple.miniLD58.core.RectObject;

public class PlayerBar extends RectObject {

    /*
     * public PlayerBar(float x, float y, ObjectID oID, int width, int height,
     * boolean aiControlled) { super(x, y, oID, width, height);
     * this.aiControlled = aiControlled; }
     */
    public PlayerBar(float x, float y, ObjectID oID, int width, int height) {
	super(oID, width, height);
	this.x = x;
	this.y = y;
    }

    @Override
    public void update(Array<GameObject> objects) {
	if (!checkCollision(objects)) {
	    this.y += this.velY * Gdx.graphics.getDeltaTime();
	}
    }

    @Override
    public void update(Array<GameObject> objects, float velX, float velY) {
	this.velX = velX;
	this.velY = velY;
    }

    @Override
    public void renderShapes(ShapeRenderer sr) {
	sr.set(ShapeType.Filled);
	sr.setColor(1, 1, 1, 0);
	sr.rect(x, y, width, height);
    }

    @Override
    public void renderSprites(SpriteBatch batch) {
    }

    @Override
    protected boolean checkCollision(Array<GameObject> objects) {
	if (y > GameMain.resolutionHeight - height) {
	    this.y = GameMain.resolutionHeight - height;
	    return true;
	} else if (y < 0) {
	    this.y = 0;
	    return true;
	}
	return false;
    }

    @Override
    public void dispose() {
	// dispose sprites here
    }
}
