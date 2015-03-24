package de.yellowapple.miniLD58.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import de.yellowapple.miniLD58.core.GameMain;
import de.yellowapple.miniLD58.handler.InputHandler;
import de.yellowapple.miniLD58.handler.ObjectHandler;
import de.yellowapple.miniLD58.handler.SoundHandler;

public class GameScreen implements Screen {

    private GameMain game;
    private OrthographicCamera camera;
    private ObjectHandler oHandler;
    private InputHandler input;
    private SoundHandler sound;

    public GameScreen(GameMain g) {
	game = g;
	camera = new OrthographicCamera();
	camera.setToOrtho(false, game.resolutionWidth, game.resolutionHeight);
	sound = new SoundHandler();
	oHandler = new ObjectHandler();
	input = new InputHandler(camera, oHandler);
	Gdx.input.setInputProcessor(input);
    }

    private void updateGame() {
	oHandler.updateObjects();
    }

    private void renderGame() {
	Gdx.gl.glClearColor(0, 0, 0, 1);
	Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

	camera.update();

	// sprite-rendering
	//
	game.batch.setProjectionMatrix(camera.combined);
	game.batch.begin();

	oHandler.renderObjectSprites(game.batch);

	game.font.draw(
		game.batch,
		"FPS:" + (1 / Gdx.graphics.getDeltaTime()),
		5,
		game.resolutionHeight - 5);

	game.batch.end();

	// shape-rendering
	//
	game.shapeRender.setProjectionMatrix(camera.combined);
	game.shapeRender.setAutoShapeType(true);
	game.shapeRender.begin();

	oHandler.renderObjectShapes(game.shapeRender);

	game.shapeRender.end();
    }

    @Override
    public void render(float delta) {
	updateGame();
	renderGame();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
	oHandler.dispose();
	sound.dispose();
    }
}