package de.jdsoft.plane;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;


public class DesktopStarter {
    public static void main(String[] args) {
        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
        cfg.title = "Title";
        cfg.useGL20 = false;
        cfg.width = 480;
        cfg.height = 800;
        new LwjglApplication(new PlaneGame(), cfg);
    }
}
