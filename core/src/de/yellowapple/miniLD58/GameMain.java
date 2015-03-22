package de.yellowapple.miniLD58;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class GameMain extends Game {

    public static float version = 1.0f;
    public static int resolutionWidth = 1024;
    public static int resolutionHeight = 768;
    public SpriteBatch batch;
    public ShapeRenderer shapeRender;
    public BitmapFont font;

    @Override
    public void create() {
	batch = new SpriteBatch();
	shapeRender = new ShapeRenderer();
	font = new BitmapFont();
	this.setScreen(new MainMenuScreen(this));
    }

    @Override
    public void render() {
	super.render();
    }

    @Override
    public void dispose() {
	batch.dispose();
	shapeRender.dispose();
	font.dispose();
    }
}
