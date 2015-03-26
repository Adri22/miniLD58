package de.yellowapple.miniLD58.core;

import com.badlogic.gdx.math.Rectangle;

public abstract class RectObject extends GameObject {

    protected int width;
    protected int height;

    public RectObject(float x, float y, ObjectID oID, int width, int height) {
	super(x, y, oID);
	this.width = width;
	this.height = height;
    }

    public RectObject(ObjectID oID, int width, int height) {
	super(oID);
	this.width = width;
	this.height = height;
    }

    public Rectangle getBounds() {
	return new Rectangle(x, y, width, height);
    }
}