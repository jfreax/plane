package de.jdsoft.plane.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.TimeUtils;
import de.jdsoft.plane.Input.GlobalInput;
import de.jdsoft.plane.Input.OrthoCamController;
import de.jdsoft.plane.MyActor;

public class Universe implements Screen {

    private final GlobalInput globalInput;
    private TiledMap map;

    private Stage stage;


    ShapeRenderer shapeRenderer = new ShapeRenderer();

;
    OrthographicCamera cam;
    OrthoCamController camController;
    long startTime = TimeUtils.nanoTime();

    public Universe() {
        cam = new OrthographicCamera(480, 320);
        cam.update();

        // Initialize input controller
        globalInput = new GlobalInput();


        stage = new Stage();
        stage.setCamera(cam);
        MyActor actor = new MyActor();
        actor.setHeight(50);
        actor.setWidth(30);
        stage.addActor(actor);
        globalInput.addProcessor(stage);



        // Add camera controller as last controller!
        globalInput.addProcessor(new OrthoCamController(cam));

    }

    @Override
    public void render(float v) {

        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();


    }
    @Override
    public void resize(int width, int height) {
        stage.setViewport(width, height, true);

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