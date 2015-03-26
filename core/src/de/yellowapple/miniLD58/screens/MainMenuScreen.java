package de.yellowapple.miniLD58.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import de.yellowapple.miniLD58.core.GameMain;

public class MainMenuScreen implements Screen {

    private GameMain game;
    private OrthographicCamera camera;

    public MainMenuScreen(GameMain g) {
	game = g;
	camera = new OrthographicCamera();
	camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    @Override
    public void render(float delta) {
	Gdx.gl.glClearColor(0, 0, 0, 1);
	Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

	camera.update();

	game.batch.setProjectionMatrix(camera.combined);
	game.batch.begin();

	game.font.draw(game.batch, "Just Pong.", 300, 500);
	game.font.draw(game.batch, "Use your arrow-keys (left / right)", 350, 450);
	game.font.draw(game.batch, "Click to begin!", 350, 430);
	game.font.draw(game.batch, "v." + game.version, 5, 15);

	game.batch.end();

	if (Gdx.input.isTouched()) {
	    game.setScreen(new GameScreen(game));
	    dispose();
	}
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
	// dispose main menu graphics here
    }
}