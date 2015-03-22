package de.yellowapple.miniLD58;

import com.badlogic.gdx.math.Circle;

public abstract class CircleObject extends GameObject {

    protected int radius;

    public CircleObject(float x, float y, ObjectID oID, int radius) {
	super(x, y, oID);
	this.radius = radius;
    }

    public Circle getBounds() {
	return new Circle(x, y, radius);
    }
}