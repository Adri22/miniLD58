package de.yellowapple.miniLD58.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import de.yellowapple.miniLD58.GameMain;

public class HtmlLauncher extends GwtApplication {

    int width = GameMain.resolutionWidth;
    int height = GameMain.resolutionHeight;

    @Override
    public GwtApplicationConfiguration getConfig() {
	return new GwtApplicationConfiguration(width, height);
    }

    @Override
    public ApplicationListener getApplicationListener() {
	return new GameMain();
    }
}