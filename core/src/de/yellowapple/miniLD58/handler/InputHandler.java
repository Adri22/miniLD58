package de.yellowapple.miniLD58.handler;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import de.yellowapple.miniLD58.core.ObjectID;

public class InputHandler implements InputProcessor {

    private OrthographicCamera camera;
    private ObjectHandler oHandler;
    private Vector3 clickPos;

    public InputHandler(OrthographicCamera camera, ObjectHandler oHandler) {
	this.camera = camera;
	this.oHandler = oHandler;
	clickPos = new Vector3();
    }

    @Override
    public boolean keyDown(int keycode) {
	switch (keycode) {
	    case Input.Keys.LEFT:
		oHandler.updateObjects(0, -300, ObjectID.PlayerBar);
		break; // down
	    case Input.Keys.RIGHT:
		oHandler.updateObjects(0, 300, ObjectID.PlayerBar);
		break; // up
	    default:
		break;
	}
	return false;
    }

    @Override
    public boolean keyUp(int keycode) {
	oHandler.updateObjects(0, 0, ObjectID.PlayerBar);
	return false;
    }

    @Override
    public boolean keyTyped(char character) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
	clickPos.set(screenX, screenY, 0);
	System.out.println("x: " + clickPos.x + " - y: " + clickPos.y);
	return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean scrolled(int amount) {
	// TODO Auto-generated method stub
	return false;
    }
}
