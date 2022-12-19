package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.io.Serializable;

public abstract class Weapon implements Serializable {
    private int damage;
    private int radius;
    private double width, height;
    private boolean isSelected;
    public void setIsSelected(boolean a) {
        this.isSelected = a;
    }
    public boolean getIsSelected() {
        return isSelected;
    }

    public abstract Texture picture(Tank tank);
    public abstract Sprite weapons(Tank tank);

    public abstract double getHeight(Tank tank);

    public abstract double getWidth(Tank tank);

    public abstract int getName();
}
