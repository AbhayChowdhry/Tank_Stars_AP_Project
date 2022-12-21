package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Game;
import com.mygdx.game.entities.Atomic;
import com.mygdx.game.entities.Play;
import com.mygdx.game.entities.Tank;
import com.mygdx.game.entities.Toxic;

import java.io.*;

public class LoadGameScreen implements Screen {

    Game game;

    private static final double BLOCK_WIDTH = Game.getWIDTH()/6.46;
    private static final double BLOCK_HEIGHT = Game.getHEIGHT()/3.6;
    private static final double DIF_HORIZ = Game.getWIDTH()/6.0;
    private static final double DIF_VERT = Game.getHEIGHT()/3.32;
    private static final double START_X = Game.getWIDTH()/11.36;
    private static final double START_Y = Game.getHEIGHT()/2.77;
    private static final double IMG_X = Game.getWIDTH()/1.62;
    private static final double IMG_Y = Game.getHEIGHT()/11.61;
    private static final double IMG_WIDTH = Game.getWIDTH()/3.27;
    private static final double IMG_HEIGHT = Game.getHEIGHT()/2.48;
    private static final double BACK_X = Game.getWIDTH()/38.4;
    private static final double BACK_Y = Game.getHEIGHT()/1.167;
    private static final double NAV_WIDTH = Game.getWIDTH()/20.42;
    private static final double NAV_HEIGHT = Game.getHEIGHT()/11.49;
    private static final double FORWARD_X = Game.getWIDTH()/1.087;
    private static final double FORWARD_Y = Game.getHEIGHT()/16.61;
    Texture LOAD_BACK;


    public LoadGameScreen(Game game){
        LOAD_BACK = new Texture("LOAD_BACK.png");
        this.game = game;

    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 0);
        game.batch.begin();

        game.batch.draw(LOAD_BACK, 0, 0, game.getWIDTH(), game.getHEIGHT());

        int y = Game.getHEIGHT() - Gdx.input.getY();

        if (Gdx.input.getX() > BACK_X && Gdx.input.getX() < BACK_X + NAV_WIDTH && y > BACK_Y && y < BACK_Y + NAV_HEIGHT) {
            game.setScreen(MainMenuScreen.getInstance(game));
        }
        else if (Gdx.input.getX() > START_X && Gdx.input.getX() < START_X + BLOCK_WIDTH && y > START_Y && y < START_Y + BLOCK_HEIGHT) {
            if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obj1.txt"))) {
                    Play deserializedObj = (Play) ois.readObject();
                    game.setScreen(new MainGameScreen(game, deserializedObj));
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        else if (Gdx.input.getX() > START_X + DIF_HORIZ && Gdx.input.getX() < START_X + BLOCK_WIDTH + DIF_HORIZ && y > START_Y && y < START_Y + BLOCK_HEIGHT) {
            if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obj2.txt"))) {
                    Play deserializedObj = (Play) ois.readObject();
                    game.setScreen(new MainGameScreen(game, deserializedObj));
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }
        }
        else if (Gdx.input.getX() > START_X + DIF_HORIZ && Gdx.input.getX() < START_X + BLOCK_WIDTH + DIF_HORIZ && y > START_Y - DIF_VERT && y < START_Y + BLOCK_HEIGHT - DIF_VERT) {
            if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obj4.txt"))) {
                    Play deserializedObj = (Play) ois.readObject();
                    game.setScreen(new MainGameScreen(game, deserializedObj));
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }
        }
        else if (Gdx.input.getX() > START_X && Gdx.input.getX() < START_X + BLOCK_WIDTH && y > START_Y - DIF_VERT && y < START_Y + BLOCK_HEIGHT - DIF_VERT) {
            if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obj3.txt"))) {
                    Play deserializedObj = (Play) ois.readObject();
                    game.setScreen(new MainGameScreen(game, deserializedObj));
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
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
