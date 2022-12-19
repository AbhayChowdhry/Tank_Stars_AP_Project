package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;

import java.io.Serializable;

public abstract class Weapon implements Serializable {
    private int damage;
    private int radius;
    private boolean isSelected;
    public void setIsSelected(boolean a) {
        this.isSelected = a;
    }
    public boolean getIsSelected() {
        return isSelected;
    }

    public abstract Texture picture(Tank tank);
}
