package de.jdsoft.plane.draw;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;

public class TileGround extends Actor {

    private final ShapeRenderer renderer;

    public TileGround() {
        renderer = new ShapeRenderer();
    }

    public void draw (SpriteBatch batch, float parentAlpha) {
        batch.end();

        Gdx.gl.glEnable(GL10.GL_BLEND);
        Gdx.gl.glBlendFunc(GL10.GL_SRC_ALPHA,GL10.GL_ONE_MINUS_SRC_ALPHA);

        renderer.setProjectionMatrix(batch.getProjectionMatrix());
        renderer.setTransformMatrix(batch.getTransformMatrix());

        renderer.scale(1, 0.5f, 1);
        renderer.rotate(0, 0, 1, -45.0f);
        renderer.translate(getX(), getY(), 0);

        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(getColor());
        renderer.rect(0, 0, getWidth(), getHeight());
        renderer.end();

        Gdx.gl.glDisable(GL10.GL_BLEND);

        batch.begin();

    }

    public Actor hit (float x, float y, boolean touchable) {
        if (touchable && getTouchable() != Touchable.enabled) return null;

        Vector2 pos = new Vector2(x, y);

        Rectangle rect = new Rectangle(getX(), getY(), getWidth(), getHeight());

        //pos.scl(2, 0.5f);
        //pos.rotate(45);
        //System.out.println(pos.x + " -> " + getWidth() + " x " + pos.y + " -> " + getHeight());
        return pos.x >= 0 && pos.x < (getWidth()) && pos.y >= 0 && pos.y < (getHeight()) ? this : null;
    }
}
