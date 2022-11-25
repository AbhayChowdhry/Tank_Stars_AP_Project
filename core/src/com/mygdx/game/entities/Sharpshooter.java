package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;

public class Sharpshooter extends Weapon {
    Sharpshooter(Texture projectile_img, int x, int y, int d, int r) {
        super(projectile_img, x, y, 50, 10);
    }
}
