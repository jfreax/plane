package de.jdsoft.plane;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
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

        Gdx.gl.glEnable(GL10.GL_BLEND);
        Gdx.gl.glBlendFunc(GL10.GL_SRC_ALPHA,GL10.GL_ONE_MINUS_SRC_ALPHA);

        renderer.setProjectionMatrix(batch.getProjectionMatrix());
        renderer.setTransformMatrix(batch.getTransformMatrix());
        renderer.translate(getX(), getY(), 0);
        renderer.scale(1, 0.5f, 1);
        renderer.rotate(0, 0, 1, 45.0f);

        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(getColor());
        renderer.rect(0, 0, getWidth(), getHeight() / 2.f);
        renderer.end();

        Gdx.gl.glDisable(GL10.GL_BLEND);

        batch.begin();

    }
}
