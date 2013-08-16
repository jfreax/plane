package de.jdsoft.plane.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.TimeUtils;
import de.jdsoft.plane.Input.GlobalInput;
import de.jdsoft.plane.Input.OrthoCamController;
import de.jdsoft.plane.draw.TileGround;
import de.jdsoft.plane.sprite.Ground;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

public class Universe implements Screen {

    private final GlobalInput globalInput;
    private Stage stage;

    public Universe() {
        // Initialize input controller
        globalInput = new GlobalInput();


        stage = new Stage();

        Ground ground1 = new Ground(stage, 0, 0);
        Ground ground2 = new Ground(stage, 1, 1);
        Ground ground3 = new Ground(stage, 1, 0);
        Ground ground4 = new Ground(stage, 2, 0);
        Ground ground5 = new Ground(stage, 3, 0);

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
        //stage.setViewport(width, height, true);

        stage.setViewport(480, 320, true);
        stage.getCamera().translate(-stage.getGutterWidth(), -stage.getGutterHeight(), 0);

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