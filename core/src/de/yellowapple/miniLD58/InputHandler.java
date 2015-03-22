package de.yellowapple.miniLD58;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;

public class InputHandler implements InputProcessor {

    private OrthographicCamera camera;
    private ObjectsHandler oHandler;
    private Vector3 clickPos;

    public InputHandler(OrthographicCamera camera, ObjectsHandler oHandler) {
	this.camera = camera;
	this.oHandler = oHandler;
	clickPos = new Vector3();
    }

    @Override
    public boolean keyDown(int keycode) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean keyUp(int keycode) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean keyTyped(char character) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
	// TODO Auto-generated method stub
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
