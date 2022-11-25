package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;

public class Weapon {

    private Texture projectile_img;
    private int x;
    private int y;
    private int damage;
    private int radius;

    Weapon(Texture projectile_img, int x, int y, int d, int r) {
        this.projectile_img = projectile_img;
        this.x = x;
        this.y = y;
        this.damage = d;
        this.radius = r;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
