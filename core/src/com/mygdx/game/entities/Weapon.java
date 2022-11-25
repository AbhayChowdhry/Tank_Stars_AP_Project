package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;

public class Weapon {
    private Texture projectile_img;
    private int x;
    private int y;

    Weapon(Texture projectile_img, int x, int y) {
        this.projectile_img = projectile_img;
        this.x = x;
        this.y = y;
    }
}
