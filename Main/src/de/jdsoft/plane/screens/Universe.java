package de.jdsoft.plane.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Scaling;
import de.jdsoft.plane.input.GlobalInput;
import de.jdsoft.plane.input.OrthoCamController;
import de.jdsoft.plane.model.Path;
import de.jdsoft.plane.sprite.Ground;

public class Universe implements Screen {

    private final GlobalInput globalInput;
    private Stage stage;

    public Universe() {
        // Initialize input controller
        globalInput = new GlobalInput();


        stage = new Stage();

        new Path(stage, 0, 0);
        new Path(stage, 1, 0);
        new Path(stage, 2, 0);
        new Path(stage, 0, 1);

        //stage.getCamera().position.add(1000);
        //stage.getCamera().update();

        // Stage input processor
        globalInput.addProcessor(stage);

        // Add camera controller as last controller!
        globalInput.addProcessor(new OrthoCamController(stage.getCamera()));

    }

    @Override
    public void render(float v) {
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();


    }
    @Override
    public void resize(int width, int height) {
        Vector3 oldPosition = stage.getCamera().position.cpy();

        Vector2 size = Scaling.fit.apply(480, 800, width, height);
        int viewportX = (int)(width - size.x) / 2;
        int viewportY = (int)(height - size.y) / 2;
        int viewportWidth = (int)size.x;
        int viewportHeight = (int)size.y;
        Gdx.gl.glViewport(viewportX, viewportY, viewportWidth, viewportHeight);
        stage.setViewport(800, 480, true, viewportX, viewportY, viewportWidth, viewportHeight);

        // Reset camera to old position
        stage.getCamera().position.set(oldPosition);
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
    public void dispose () {

    }
}