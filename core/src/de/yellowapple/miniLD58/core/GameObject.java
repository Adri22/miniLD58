package de.yellowapple.miniLD58.core;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public abstract class GameObject {

    protected float x, y;
    protected float velX, velY;
    protected ObjectID id;

    public GameObject(float x, float y, ObjectID id) {
	this.x = x;
	this.y = y;
	this.id = id;
	this.velX = 0;
	this.velY = 0;
    }

    public GameObject(ObjectID id) {
	this.x = 0;
	this.y = 0;
	this.id = id;
	this.velX = 0;
	this.velY = 0;
    }

    public abstract void update(Array<GameObject> objects);

    public abstract void update(Array<GameObject> objects, float velX, float velY);

    public abstract void renderShapes(ShapeRenderer sr);

    public abstract void renderSprites(SpriteBatch batch);

    protected abstract boolean checkCollision(Array<GameObject> objects);

    // ----------------------
    // get position
    //

    public float getX() {
	return x;
    }

    public float getY() {
	return y;
    }

    public Vector2 getPos() {
	return new Vector2(this.x, this.y);
    }

    // ----------------------
    // set position
    //

    public void setX(float x) {
	this.x = x;
    }

    public void setY(float y) {
	this.y = y;
    }

    public void setPos(Vector2 v) {
	this.x = v.x;
	this.y = v.y;
    }

    public void setPos(float x, float y) {
	this.x = x;
	this.y = y;
    }

    // ----------------------
    // get velocity
    //

    public float getVelX() {
	return velX;
    }

    public float getVelY() {
	return velY;
    }

    public Vector2 getVel() {
	return new Vector2(this.velX, this.velY);
    }

    // ----------------------
    // set velocity
    //

    public void setVelX(float velX) {
	this.velX = velX;
    }

    public void setVelY(float velY) {
	this.velY = velY;
    }

    public void setVel(Vector2 v) {
	this.velX = v.x;
	this.velY = v.y;
    }

    public void setVel(float vx, float vy) {
	this.velX = vx;
	this.velY = vy;
    }

    // ----------------------

    // public abstract <T> T getBounds();

    public ObjectID getID() {
	return id;
    }

    public abstract void dispose();
}
