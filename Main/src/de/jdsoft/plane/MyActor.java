package de.jdsoft.plane;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class MyActor extends Actor {

    private final TextureRegion region;
    private ShapeRenderer renderer;

    public MyActor () {
        Pixmap pix = new Pixmap(16, 16, Pixmap.Format.RGB888);
        pix.setColor(Color.BLUE);
        pix.fill();
        Texture tex = new Texture(pix);

        region = new TextureRegion(tex);

        renderer = new ShapeRenderer();
    }

    public void draw (SpriteBatch batch, float parentAlpha) {
        Color color = getColor();
        batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
        batch.draw(region, getX(), getY(), getOriginX(), getOriginY(),
                getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());

    }
}
