package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Game;

public class TankSelectionScreen implements Screen {

    Game game;
    Texture TANK_SELECTION_BACK, SELECTION_NO_TANK;
    Texture TOXIC_ACTIVE, TOXIC_CLICK, TOXIC_INACTIVE, TOXIC_ROTATED;
    Texture PINKY_ACTIVE, PINKY_CLICK, PINKY_INACTIVE, PINKY_ROTATED;
    Texture ATOMIC_ACTIVE, ATOMIC_CLICK, ATOMIC_INACTIVE, ATOMIC_ROTATED;
    Texture PUMPKIN_ACTIVE, PUMPKIN_CLICK, PUMPKIN_INACTIVE, PUMPKIN_ROTATED;
    Texture FORWARD_ACTIVE, BACK_ACTIVE;

    private static final double BLOCK_WIDTH = Game.getWIDTH()/6.46;
    private static final double BLOCK_HEIGHT = Game.getHEIGHT()/3.6;
    private static final double DIF_HORIZ = Game.getWIDTH()/6;
    private static final double DIF_VERT = Game.getHEIGHT()/3.32;
    private static final double START_X = Game.getWIDTH()/11.36;
    private static final double START_Y = Game.getHEIGHT()/2.77;
    private static final double IMG_X = Game.getWIDTH()/1.62;
    private static final double IMG_Y = Game.getHEIGHT()/11.61;
    private static final double IMG_WIDTH = Game.getWIDTH()/3.27;
    private static final double IMG_HEIGHT = Game.getHEIGHT()/2.48;
    private static final double FORWARD_X = Game.getWIDTH()/1.087;
    private static final double FORWARD_Y = Game.getHEIGHT()/16.61;
    private static final double BACK_X = Game.getWIDTH()/38.4;
    private static final double BACK_Y = Game.getHEIGHT()/1.167;
    private static final double NAV_WIDTH = Game.getWIDTH()/20.42;
    private static final double NAV_HEIGHT = Game.getHEIGHT()/11.49;
    private boolean isSelected = false;
    private int selection_number = 0;
    public TankSelectionScreen(Game game){
        this.game = game;
        TANK_SELECTION_BACK = new Texture("TANK_SELECTION_BACK.png");
        SELECTION_NO_TANK = new Texture("SELECTION_NO_TANK.png");

        TOXIC_INACTIVE = new Texture("TOXIC_INACTIVE.png");
        TOXIC_ACTIVE = new Texture("TOXIC_ACTIVE.png");
        TOXIC_CLICK = new Texture("TOXIC_CLICK.png");
        TOXIC_ROTATED = new Texture("TOXIC_ROTATED.png");

        PINKY_INACTIVE = new Texture("PINKY_INACTIVE.png");
        PINKY_ACTIVE = new Texture("PINKY_ACTIVE.png");
        PINKY_CLICK = new Texture("PINKY_CLICK.png");
        PINKY_ROTATED = new Texture("PINKY_ROTATED.png");

        PUMPKIN_INACTIVE = new Texture("PUMPKIN_INACTIVE.png");
        PUMPKIN_ACTIVE = new Texture("PUMPKIN_ACTIVE.png");
        PUMPKIN_CLICK = new Texture("PUMPKIN_CLICK.png");
        PUMPKIN_ROTATED = new Texture("PUMPKIN_ROTATED.png");

        ATOMIC_INACTIVE = new Texture("ATOMIC_INACTIVE.png");
        ATOMIC_ACTIVE = new Texture("ATOMIC_ACTIVE.png");
        ATOMIC_CLICK = new Texture("ATOMIC_CLICK.png");
        ATOMIC_ROTATED = new Texture("ATOMIC_ROTATED.png");

        FORWARD_ACTIVE = new Texture("FORWARD_ACTIVE.png");
        BACK_ACTIVE = new Texture("BACK_ACTIVE.png");

    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 0);
        game.batch.begin();

        game.batch.draw(SELECTION_NO_TANK, 0, 0, game.getWIDTH(), game.getHEIGHT());
        game.batch.draw(ATOMIC_INACTIVE, (float) START_X, (float) (START_Y), (float) BLOCK_WIDTH, (float) BLOCK_HEIGHT);
        game.batch.draw(PUMPKIN_INACTIVE, (float) (START_X + DIF_HORIZ), (float) (START_Y), (float) BLOCK_WIDTH, (float) BLOCK_HEIGHT);
        game.batch.draw(PINKY_INACTIVE, (float) (START_X + DIF_HORIZ), (float) (START_Y - DIF_VERT), (float) BLOCK_WIDTH, (float) BLOCK_HEIGHT);
        game.batch.draw(TOXIC_INACTIVE, (float) (START_X), (float) (START_Y - DIF_VERT), (float) BLOCK_WIDTH, (float) BLOCK_HEIGHT);


        if(selection_number == 1) {
            game.batch.draw(ATOMIC_CLICK, (float) START_X, (float) (START_Y), (float) BLOCK_WIDTH, (float) BLOCK_HEIGHT);
            game.batch.draw(ATOMIC_ROTATED, (float) IMG_X, (float) IMG_Y, (float) IMG_WIDTH, (float) IMG_HEIGHT);
        }
        else if(selection_number == 2) {
            game.batch.draw(PUMPKIN_CLICK, (float) (START_X + DIF_HORIZ), (float) (START_Y), (float) BLOCK_WIDTH, (float) BLOCK_HEIGHT);
            game.batch.draw(PUMPKIN_ROTATED, (float) IMG_X, (float) IMG_Y, (float) IMG_WIDTH, (float) IMG_HEIGHT);
        }
        else if(selection_number == 3) {
            game.batch.draw(TOXIC_CLICK, (float) (START_X), (float) (START_Y - DIF_VERT), (float) BLOCK_WIDTH, (float) BLOCK_HEIGHT);
            game.batch.draw(TOXIC_ROTATED, (float) IMG_X, (float) IMG_Y, (float) IMG_WIDTH, (float) IMG_HEIGHT);
        }
        else if(selection_number == 4){
            game.batch.draw(PINKY_CLICK, (float) (START_X + DIF_HORIZ), (float) (START_Y - DIF_VERT), (float) BLOCK_WIDTH, (float) BLOCK_HEIGHT);
            game.batch.draw(PINKY_ROTATED, (float) IMG_X, (float) IMG_Y, (float) IMG_WIDTH, (float) IMG_HEIGHT);
        }

        int y = Game.getHEIGHT() - Gdx.input.getY();

        if (Gdx.input.getX() > FORWARD_X && Gdx.input.getX() < FORWARD_X + NAV_WIDTH && y > FORWARD_Y && y < FORWARD_Y + NAV_HEIGHT) {
            game.batch.draw(FORWARD_ACTIVE, (float) FORWARD_X, (float) (FORWARD_Y), (float) NAV_WIDTH, (float) NAV_HEIGHT);
            if (Gdx.input.isTouched()) {
                if(isSelected){
                    game.setScreen(new TankSelectionScreen(game));
                }
            }
        }else if (Gdx.input.getX() > BACK_X && Gdx.input.getX() < BACK_X + NAV_WIDTH && y > BACK_Y && y < BACK_Y + NAV_HEIGHT) {
            game.batch.draw(BACK_ACTIVE, (float) BACK_X, (float) (BACK_Y), (float) NAV_WIDTH, (float) NAV_HEIGHT);
            if (Gdx.input.isTouched()) {
                    game.setScreen(new MainMenuScreen(game));
            }
        }  else if (Gdx.input.getX() > START_X && Gdx.input.getX() < START_X + BLOCK_WIDTH && y > START_Y && y < START_Y + BLOCK_HEIGHT) {
            if(selection_number != 1){
                game.batch.draw(ATOMIC_ACTIVE, (float) START_X, (float) (START_Y), (float) BLOCK_WIDTH, (float) BLOCK_HEIGHT);
            }
            if (Gdx.input.isTouched()) {
                game.batch.draw(ATOMIC_CLICK, (float) START_X, (float) (START_Y), (float) BLOCK_WIDTH, (float) BLOCK_HEIGHT);
                selection_number = 1;
                isSelected = true;
            }
        } else if (Gdx.input.getX() > START_X + DIF_HORIZ && Gdx.input.getX() < START_X + BLOCK_WIDTH + DIF_HORIZ && y > START_Y && y < START_Y + BLOCK_HEIGHT) {
            if(selection_number != 2) {
                game.batch.draw(PUMPKIN_ACTIVE, (float) (START_X + DIF_HORIZ), (float) (START_Y), (float) BLOCK_WIDTH, (float) BLOCK_HEIGHT);
            }
            if (Gdx.input.isTouched()) {
                game.batch.draw(PUMPKIN_CLICK, (float) (START_X + DIF_HORIZ), (float) (START_Y), (float) BLOCK_WIDTH, (float) BLOCK_HEIGHT);
                selection_number = 2;
                isSelected = true;
            }
        } else if (Gdx.input.getX() > START_X + DIF_HORIZ && Gdx.input.getX() < START_X + BLOCK_WIDTH + DIF_HORIZ && y > START_Y - DIF_VERT && y < START_Y + BLOCK_HEIGHT - DIF_VERT) {
            if(selection_number != 4){
                game.batch.draw(PINKY_ACTIVE, (float) (START_X + DIF_HORIZ), (float) (START_Y - DIF_VERT), (float) BLOCK_WIDTH, (float) BLOCK_HEIGHT);
            }
            if (Gdx.input.isTouched()) {
                game.batch.draw(PINKY_CLICK, (float) (START_X + DIF_HORIZ), (float) (START_Y - DIF_VERT), (float) BLOCK_WIDTH, (float) BLOCK_HEIGHT);
                selection_number = 4;
                isSelected = true;
            }
        } else if (Gdx.input.getX() > START_X && Gdx.input.getX() < START_X + BLOCK_WIDTH && y > START_Y - DIF_VERT && y < START_Y + BLOCK_HEIGHT - DIF_VERT) {
            if(selection_number != 3) {
                game.batch.draw(TOXIC_ACTIVE, (float) (START_X), (float) (START_Y - DIF_VERT), (float) BLOCK_WIDTH, (float) BLOCK_HEIGHT);
            }
            if (Gdx.input.isTouched()) {
                game.batch.draw(TOXIC_CLICK, (float) (START_X), (float) (START_Y - DIF_VERT), (float) BLOCK_WIDTH, (float) BLOCK_HEIGHT);
                selection_number = 3;
                isSelected = true;
            }
        }

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
