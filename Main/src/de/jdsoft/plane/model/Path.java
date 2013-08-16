package de.jdsoft.plane.model;


import com.badlogic.gdx.scenes.scene2d.Stage;
import de.jdsoft.plane.sprite.Ground;

public class Path extends Ground {

    public Path(Stage stage, int x, int y) {
        super(stage, x, y);

        actor.setColor(colorPath);


    }
}
