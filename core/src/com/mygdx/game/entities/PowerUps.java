package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;

public class PowerUps {
    private Texture Powerup_icon;
    //protected Weapon weapon;
    protected int landing_spot;
    private Weapon weapon;

    PowerUps(Weapon weapon){
        this.weapon = weapon;
    }

    public void Randomize() {
        ;
    }
}
