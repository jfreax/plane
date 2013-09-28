package de.jdsoft.plane.model;


import com.badlogic.gdx.scenes.scene2d.*;
import de.jdsoft.plane.sprite.Ground;

public class Path extends Ground {

    public Path(Stage stage, int x, int y) {
        super(stage, x, y);

        actor.setColor(colorPath);
        actor.getColor().a = 0;


        actor.addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("down");
                return true;
            }

            public void enter (InputEvent event, float x, float y, int pointer, Actor fromActor) {
                System.out.println("enter!");
                actor.setColor(colorHome);
            }

            public void exit (InputEvent event, float x, float y, int pointer, Actor toActor) {
                System.out.println("exit!");
                actor.setColor(colorPath);
            }

        });
    }
}
