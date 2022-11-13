package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Game;
// import com.badlogic.gdx.physics.box2d.World;

public class MainGameScreen implements Screen {

    public static final float SPEED = 120;
    public static final int TANK_X = 150;
    public static final int TANK_Y = 200;
    private Game game;
    Texture img;
    float x, y;

    public MainGameScreen (Game game){
        this.game = game;
        //img = new Texture("badlogic.jpg");
        img = new Texture("TestTank.png");
    }


    @Override
    public void show() {
        game = new Game();
    }

    @Override
    public void render(float delta) {

        ScreenUtils.clear(1, 0, 0, 1);

        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            y += SPEED * (Gdx.graphics.getDeltaTime());
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            y -= SPEED * (Gdx.graphics.getDeltaTime());
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            x -= SPEED * (Gdx.graphics.getDeltaTime());
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            x += SPEED * (Gdx.graphics.getDeltaTime());
        }

        game.batch.begin();
        game.batch.draw(img, x, y, TANK_X, TANK_Y);
        game.batch.end();
    }


    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
