package de.jdsoft.plane;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class MyActor extends Actor {

    private final ShapeRenderer renderer;

    public MyActor () {
        renderer = new ShapeRenderer();
    }

    public void draw (SpriteBatch batch, float parentAlpha) {
        batch.end();

        renderer.setProjectionMatrix(batch.getProjectionMatrix());
        renderer.setTransformMatrix(batch.getTransformMatrix());
        renderer.translate(getX(), getY(), 0);
        renderer.scale(1, 0.5f, 1);
        renderer.rotate(0, 0, 1, 45.0f);

        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(Color.BLUE);
        renderer.rect(0, 0, 100, 100);
        renderer.end();

        batch.begin();

    }
}
