package de.yellowapple.miniLD58.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import de.yellowapple.miniLD58.GameMain;

public class DesktopLauncher {
    
    public static void main(String[] arg) {
	LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

	config.title = "miniLD";
	config.width = GameMain.resolutionWidth;
	config.height = GameMain.resolutionHeight;
	config.resizable = false;

	new LwjglApplication(new GameMain(), config);
    }
}
