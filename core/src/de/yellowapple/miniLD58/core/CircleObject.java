package de.yellowapple.miniLD58.core;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;

public abstract class CircleObject extends GameObject {

    protected int radius;

    public CircleObject(float x, float y, ObjectID oID, int radius) {
	super(x, y, oID);
	this.radius = radius;
    }

    public Circle getBounds() {
	return new Circle(x, y, radius);
    }

    public Rectangle getHitboxBounds() {
	return new Rectangle(x - radius, y - radius, radius * 2, radius * 2);
    }
}