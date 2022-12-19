package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Game;
import com.mygdx.game.entities.Play;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.concurrent.TimeUnit;

public class MainMenuScreen implements Screen {
    Game game;
    transient Texture VS_FRIEND_ACTIVE, VS_FRIEND_INACTIVE, VS_FRIEND_CLICK;
    transient Texture VS_COMP_ACTIVE, VS_COMP_INACTIVE, VS_COMP_CLICK;
    transient Texture LOAD_INACTIVE, LOAD_ACTIVE,LOAD_CLICK;
    transient Texture EXIT_INACTIVE, EXIT_ACTIVE, EXIT_CLICK;
    transient Texture MAIN_BACK;
    private static final double BUTTON_WIDTH = Game.getWIDTH() / 5.36;
    // private static final double BUTTON_HEIGHT = Game.HEIGHT / 13.4;
    private static final double BUTTON_HEIGHT = Game.getHEIGHT() / 12.56;
    private static final double BUTTON_X = Game.getWIDTH()/9.89;
    private static final double BUTTON_Y = Game.getHEIGHT()/2.28;
    private static final double BUTTON_DIF = Game.getHEIGHT()/10.09;

    private static MainMenuScreen gen = null;
    public static MainMenuScreen getInstance(Game game1)
    {
        if (gen == null) {
            gen = new MainMenuScreen(game1);
        }
        return gen;
    }
    private MainMenuScreen(Game game){
        this.game = game;
        VS_FRIEND_ACTIVE = new Texture("VS_FRIEND_ACTIVE.png");
        VS_FRIEND_INACTIVE = new Texture("VS_FRIEND_INACTIVE.png");
        VS_FRIEND_CLICK = new Texture("VS_FRIEND_CLICK.png");
        VS_COMP_ACTIVE = new Texture("VS_COMP_ACTIVE.png");
        VS_COMP_INACTIVE = new Texture("VS_COMP_INACTIVE.png");
        VS_COMP_CLICK = new Texture("VS_COMP_CLICK.png");
        LOAD_INACTIVE = new Texture("LOAD_INACTIVE.png");
        LOAD_ACTIVE = new Texture("LOAD_ACTIVE.png");
        LOAD_CLICK = new Texture("LOAD_CLICK.png");
        EXIT_INACTIVE = new Texture("EXIT_INACTIVE.png");
        EXIT_ACTIVE = new Texture("EXIT_ACTIVE.png");
        EXIT_CLICK = new Texture("EXIT_CLICK.png");
        MAIN_BACK = new Texture("MAIN_BACK.png");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 0);
        game.batch.begin();

        game.batch.draw(MAIN_BACK, 0, 0, game.getWIDTH(), game.getHEIGHT());
        game.batch.draw(VS_FRIEND_INACTIVE, (float) BUTTON_X, (float) BUTTON_Y, (float) BUTTON_WIDTH, (float) BUTTON_HEIGHT);
        game.batch.draw(VS_COMP_INACTIVE, (float) BUTTON_X, (float) BUTTON_Y - (float) BUTTON_DIF, (float) BUTTON_WIDTH, (float) BUTTON_HEIGHT);
        game.batch.draw(LOAD_INACTIVE, (float) BUTTON_X, (float) BUTTON_Y - 2*(float) BUTTON_DIF, (float) BUTTON_WIDTH, (float) BUTTON_HEIGHT);
        game.batch.draw(EXIT_INACTIVE,(float) BUTTON_X, (float) BUTTON_Y - 3*(float) BUTTON_DIF, (float) BUTTON_WIDTH, (float) BUTTON_HEIGHT);


        // Introduction of new variable y because Gdx.input.getY() return the distance from top, while the drawings of the buttons are made from the bottom
        int y = Game.getHEIGHT() - Gdx.input.getY();

        if(Gdx.input.getX() > BUTTON_X && Gdx.input.getX() < BUTTON_X + BUTTON_WIDTH && y > BUTTON_Y && y < BUTTON_Y + BUTTON_HEIGHT) {
            game.batch.draw(VS_FRIEND_ACTIVE, (float) BUTTON_X, (float) BUTTON_Y, (float) BUTTON_WIDTH, (float) BUTTON_HEIGHT);
            if(Gdx.input.isTouched()){
                game.batch.draw(VS_FRIEND_CLICK, (float) BUTTON_X, (float) BUTTON_Y, (float) BUTTON_WIDTH, (float) BUTTON_HEIGHT);
                // this.dispose();
                game.setScreen(new TankSelectionScreen(game, false, 0));
            }

        }else if(Gdx.input.getX() > BUTTON_X && Gdx.input.getX() < BUTTON_X + BUTTON_WIDTH && y > BUTTON_Y - (float) BUTTON_DIF && y < BUTTON_Y + BUTTON_HEIGHT- (float) BUTTON_DIF){
            game.batch.draw(VS_COMP_ACTIVE, (float) BUTTON_X, (float) BUTTON_Y - (float) BUTTON_DIF, (float) BUTTON_WIDTH, (float) BUTTON_HEIGHT);
            if(Gdx.input.isTouched()){
                game.batch.draw(VS_COMP_CLICK, (float) BUTTON_X, (float) BUTTON_Y - (float) BUTTON_DIF, (float) BUTTON_WIDTH, (float) BUTTON_HEIGHT);
                //send tanks fo human and comp
//                game.setScreen(new MainGameScreen(game, ));
            }
        }
        else if(Gdx.input.getX() > BUTTON_X && Gdx.input.getX() < BUTTON_X + BUTTON_WIDTH && y > BUTTON_Y -  2*(float) BUTTON_DIF && y < BUTTON_Y + BUTTON_HEIGHT - 2*(float) BUTTON_DIF){
            game.batch.draw(LOAD_ACTIVE, (float) BUTTON_X, (float) BUTTON_Y - 2*(float) BUTTON_DIF, (float) BUTTON_WIDTH, (float) BUTTON_HEIGHT);
            if(Gdx.input.isTouched()){
                game.batch.draw(LOAD_CLICK, (float) BUTTON_X, (float) BUTTON_Y - 2*(float) BUTTON_DIF, (float) BUTTON_WIDTH, (float) BUTTON_HEIGHT);
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obj.txt"))) {
                    Play deserializedObj = (Play) ois.readObject();
                    // System.out.println(deserializedObj);  // Output: 10
                    // MainGameScreen mainscreen = new MainGameScreen(game, deserializedObj);
                    // mainscreen.play = deserializedObj;
                    game.setScreen(new MainGameScreen(game, deserializedObj));
                    // game.setScreen();

                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        else if(Gdx.input.getX() > BUTTON_X && Gdx.input.getX() < BUTTON_X + BUTTON_WIDTH && y > BUTTON_Y - 3 * (float) BUTTON_DIF && y < BUTTON_Y + BUTTON_HEIGHT - 3*(float) BUTTON_DIF){
            game.batch.draw(EXIT_ACTIVE, (float) BUTTON_X, (float) BUTTON_Y - 3*(float) BUTTON_DIF, (float) BUTTON_WIDTH, (float) BUTTON_HEIGHT);
            if(Gdx.input.isTouched()){
                game.batch.draw(EXIT_CLICK, (float) BUTTON_X, (float) BUTTON_Y - 3*(float) BUTTON_DIF, (float) BUTTON_WIDTH, (float) BUTTON_HEIGHT);
                Gdx.app.exit();
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
