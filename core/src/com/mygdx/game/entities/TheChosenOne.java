package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;

public class TheChosenOne extends Weapon{
    private final Texture pumpkin = new Texture("1_0.png");
    private final Texture pinky = new Texture("2_0.png");
    private final Texture toxic = new Texture("3_0.png");
    private final Texture atomic = new Texture("4_0.png");
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
