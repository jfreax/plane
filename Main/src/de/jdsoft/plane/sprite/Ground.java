package de.jdsoft.plane.sprite;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import de.jdsoft.plane.Constants;
import de.jdsoft.plane.draw.TileGround;

import java.util.Random;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

public class Ground implements Constants {
    static final Random rand = new Random(System.currentTimeMillis());
    final protected TileGround actor;

    public Ground(Stage stage, int x, int y) {


        actor = new TileGround();

        actor.setX(x * (tileSizeWidth + tileGap));
        actor.setY(y * (tileSizeHeight + tileGap));

        //actor.setX((x * (tileSizeWidth + tileGap + 50)) + (y%2==0 ? (tileSizeWidth + tileGap)/2 : 0));
        //actor.setY(y * (tileSizeHeight + tileGap) /2);

        actor.setHeight(tileSizeHeight);
        actor.setWidth(tileSizeWidth);

        //actor.setRotation(45);

        actor.setColor(colorPath);
        actor.addAction(sequence(
                delay(rand.nextFloat() * 0.5f),
                parallel(moveBy(0, 0, 2.0f, Interpolation.elasticOut), fadeIn(1))
            )
        );

        // Put on stage
        stage.addActor(actor);
    }
}
