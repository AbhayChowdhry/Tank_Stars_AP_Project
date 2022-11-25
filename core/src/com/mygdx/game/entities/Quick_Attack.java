package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;

public class Quick_Attack extends Weapon{
    Quick_Attack(Texture projectile_img, int x, int y, int d, int r) {
        super(projectile_img, x, y, 30, 20);
    }
}
