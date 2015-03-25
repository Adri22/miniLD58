package de.yellowapple.miniLD58.handler;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;
import de.yellowapple.miniLD58.core.GameObject;
import de.yellowapple.miniLD58.core.ObjectID;

public class ObjectHandler {

    public Array<GameObject> objects = new Array<GameObject>();

    public ObjectHandler() {
    }

    public void updateObjects() {
	for (int i = 0; i < objects.size; i++) {
	    this.objects.get(i).update(objects);
	}
    }

    public void updateObjects(float velX, float velY, ObjectID oID) {
	for (int i = 0; i < objects.size; i++) {
	    if (oID == this.objects.get(i).getID()) {
		this.objects.get(i).update(objects, velX, velY);
	    }
	}
    }

    public void renderObjectShapes(ShapeRenderer sr) {
	for (int i = 0; i < objects.size; i++) {
	    this.objects.get(i).renderShapes(sr);
	}
    }

    public void renderObjectSprites(SpriteBatch batch) {
	for (int i = 0; i < objects.size; i++) {
	    this.objects.get(i).renderSprites(batch);
	}
    }

    public void addObject(GameObject object) {
	this.objects.add(object);
    }

    public void removeObject(GameObject object) {
	int index = this.objects.indexOf(object, false);
	this.objects.removeIndex(index);
    }

    public void dispose() {
	for (int i = 0; i < objects.size; i++) {
	    this.objects.get(i).dispose();
	}
    }
}
