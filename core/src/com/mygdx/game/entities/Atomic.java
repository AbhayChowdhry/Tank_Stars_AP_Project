package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Game;

import java.util.ArrayList;

public class Atomic extends Tank{

    private Texture body_texture = new Texture("atomic_body.png");
    private Texture snout_texture = new Texture("atomic_snout.png");

//    private float x_body = 0;
//    private float y_body = 0;
//    private float x_snout = x_body;
    // private float y_snout = (float) (y_body + Game.getHEIGHT()/5.0232);
    //private float y_snout = (float) (y_body + 215);
    Weapon SelectedWeapon = new Weapon(body_texture, 0, 0);
    protected ArrayList<Weapon> WeaponList;

    private double tank_width = Game.getWIDTH()/7.0;
    private double tank_height = Game.getHEIGHT()/8.0;

    Sprite body = new Sprite(body_texture);
    Sprite snout = new Sprite(snout_texture);

    public void move_forward(){
        x_body += 4;
    }
    public void move_backward(){
        x_body -= 4;
    }

    @Override
    public void fire() {
        SelectedWeapon.setX(10);
    }

    @Override
    public void selectWeapon() {
        setSelectedWeapon(WeaponList.get(2));
    }

    @Override
    public Sprite getBody() {
        return body;
    }

    @Override
    public Sprite getSnout() {
        return snout;
    }

    public void setSelectedWeapon(Weapon selectedWeapon) {
        SelectedWeapon = selectedWeapon;
    }
}
