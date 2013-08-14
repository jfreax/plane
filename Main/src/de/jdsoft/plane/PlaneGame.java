package de.jdsoft.plane;

import com.badlogic.gdx.Game;
import de.jdsoft.plane.screens.Universe;

public class PlaneGame extends Game {

    @Override
    public void create() {
        this.setScreen(new Universe());
    }

    @Override
    public void render() {
        super.render();

    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }
}
