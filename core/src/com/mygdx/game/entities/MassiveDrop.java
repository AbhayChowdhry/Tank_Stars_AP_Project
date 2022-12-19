package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;

import java.io.Serializable;

public class MassiveDrop extends Weapon implements Serializable {
    private final transient Texture pumpkin = new Texture("1_4.png");
    private final transient Texture pinky = new Texture("2_4.png");
    private final transient Texture toxic = new Texture("3_4.png");
    private final transient Texture atomic = new Texture("4_4.png");
    public Texture picture(Tank tank) {
        if (tank instanceof Pumpkin) {
            return pumpkin;
        } else if (tank instanceof Pinky) {
            return pinky;
        } else if (tank instanceof Toxic) {
            return toxic;
        } else {
            return atomic;
        }
    }
}
