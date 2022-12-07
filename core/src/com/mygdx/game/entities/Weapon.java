package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;

public abstract class Weapon{
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
