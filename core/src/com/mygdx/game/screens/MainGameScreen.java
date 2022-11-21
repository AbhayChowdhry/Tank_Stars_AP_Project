package com.mygdx.game.screens;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Game;
import com.mygdx.game.entities.Player;
import com.mygdx.game.entities.Pumpkin;

import java.util.concurrent.TimeUnit;

public class MainGameScreen implements Screen{

    public static final float SPEED = 120;
    public static final int TANK_X = 150;
    public static final int TANK_Y = 200;
    Texture BACKGROUND = new Texture("PLAY_BACK.png");
    Texture PAUSE_INACTIVE = new Texture("PAUSE_INACTIVE.png");
    Texture PAUSE_ACTIVE = new Texture("PAUSE_ACTIVE.png");
    Texture RESUME_ACTIVE = new Texture("RESUME_ACTIVE.png");
    Texture RESUME_INACTIVE = new Texture("RESUME_INACTIVE.png");
    Texture SAVE_ACTIVE = new Texture("SAVE_ACTIVE.png");
    Texture SAVE_INACTIVE = new Texture("SAVE_INACTIVE.png");
    Texture EXIT_ACTIVE = new Texture("EXIT_ACTIVE.png");
    Texture EXIT_INACTIVE = new Texture("EXIT_INACTIVE.png");

    private static final double BUTTON_WIDTH = Game.getWIDTH() / 5.36;
    private static final double BUTTON_HEIGHT = Game.getHEIGHT() / 12.56;
    private static final double BUTTON_DIF = Game.getHEIGHT() / 9.0;
    private static final double BUTTON_X = Game.getWIDTH() / 1.37;
    private static final double BUTTON_Y = Game.getHEIGHT() / 1.129;
    private static final double PAUSE_Y = BUTTON_Y;
    private static final double PAUSE_X = Game.getWIDTH() / 1.067;
    private static final double PAUSE_WIDTH = Game.getWIDTH() / 22.32;
    private static final double PAUSE_HEIGHT = Game.getHEIGHT() / 12.558;

    boolean isPaused = false;
    Game game;
    Sprite p1_body, p1_snout, p2_body, p2_snout;
    Texture img;
//    private Pumpkin pumpkin;
//    Player player1 = new Player(1, pumpkin);
//    Player player2 = new Player(2, pumpkin);


    public MainGameScreen (Game game){
        this.game = game;

//        ScreenViewport viewport = new ScreenViewport();
//        this.stage = new Stage(viewport);
//        Gdx.input.setInputProcessor(stage);

//        Actor actor = new Actor();
//        stage.addActor(actor);
//        stage.setKeyboardFocus(actor);
//        img = new Texture("TestTank.png");
//        Texture p1_snout_texture = player1.getTank().getSnout();
//        Texture p1_body_texture = player1.getTank().getBody();
//
//        p1_body=new Sprite(p1_body_texture);
//        p1_snout=new Sprite(p1_snout_texture);
//        //p1_body.setSize(652,366);
//        p1_body.setSize(326,183);
//        p1_body.setOrigin(0,0);
//
//        //p1_snout.setSize(652,146);
//        p1_snout.setSize(326,73);
//        p1_snout.setOrigin(164,36);
//
//        Texture p2_snout_texture = player2.getTank().getSnout();
//        Texture p2_body_texture = player2.getTank().getBody();
//
//        p2_body=new Sprite(p2_body_texture);
//        p2_snout=new Sprite(p2_snout_texture);
//        //p1_body.setSize(652,366);
//        p2_body.setSize(326,183);
//        p2_body.setOrigin(0,0);
//        p2_body.flip(true, false);
//
//        //p1_snout.setSize(652,146);
//        p2_snout.setSize(326,73);
//        p2_snout.setOrigin(163,36);
//        p2_snout.flip(true, false);

    }
    @Override
    public void show() {
        //game = new Game();
//        Image image1 = new Image(player1_body);
//        image1.setPosition(player1.getTank().getX_body(), 215);
//        stage.addActor(image1);
    }

    @Override
    public void render(float delta) {

        ScreenUtils.clear(1, 0, 0, 1);

        game.batch.begin();
        game.batch.draw(BACKGROUND, 0, 0, Game.getWIDTH(), Game.getHEIGHT());

        int y = Game.getHEIGHT() - Gdx.input.getY();
        if(isPaused == false) {
            game.batch.draw(PAUSE_INACTIVE, (float) PAUSE_X, (float) PAUSE_Y, (float) PAUSE_WIDTH, (float) PAUSE_HEIGHT);
            if(Gdx.input.getX() > PAUSE_X && Gdx.input.getX() < PAUSE_X + PAUSE_WIDTH && y > PAUSE_Y && y < PAUSE_Y + PAUSE_HEIGHT){
                game.batch.draw(PAUSE_ACTIVE, (float) PAUSE_X, (float) PAUSE_Y, (float) PAUSE_WIDTH, (float) PAUSE_HEIGHT);
                if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
                        isPaused = true;
                    }
            }
        }
        else{
            game.batch.draw(PAUSE_ACTIVE, (float) PAUSE_X, (float) PAUSE_Y, (float) PAUSE_WIDTH, (float) PAUSE_HEIGHT);
            game.batch.draw(RESUME_INACTIVE, (float) BUTTON_X, (float) (BUTTON_Y), (float) BUTTON_WIDTH, (float) BUTTON_HEIGHT);
            game.batch.draw(SAVE_INACTIVE, (float) BUTTON_X, (float) (BUTTON_Y - BUTTON_DIF), (float) BUTTON_WIDTH, (float) BUTTON_HEIGHT);
            game.batch.draw(EXIT_INACTIVE, (float) BUTTON_X, (float) (BUTTON_Y - 2*BUTTON_DIF), (float) BUTTON_WIDTH, (float) BUTTON_HEIGHT);
            if(Gdx.input.getX() > PAUSE_X && Gdx.input.getX() < PAUSE_X + PAUSE_WIDTH && y > PAUSE_Y && y < PAUSE_Y + PAUSE_HEIGHT){
                game.batch.draw(PAUSE_ACTIVE, (float) PAUSE_X, (float) PAUSE_Y, (float) PAUSE_WIDTH, (float) PAUSE_HEIGHT);
                if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
                    isPaused = false;
                }
            }
        }

//        p1_body.setPosition(player1.getTank().getX_body(),player1.getTank().getY_body());
//        p1_snout.setPosition(player1.getTank().getX_snout(),player1.getTank().getY_snout() + 102);
//
//        p2_body.setPosition(player2.getTank().getX_body() + Game.getWIDTH()*3/4,player1.getTank().getY_body());
//        p2_snout.setPosition(player2.getTank().getX_snout() + Game.getWIDTH()*3/4,player1.getTank().getY_snout() + 102);
//
//        p1_snout.draw(game.batch);
//        p1_body.draw(game.batch);
//
//        p2_snout.draw(game.batch);
//        p2_body.draw(game.batch);

//        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
//            p1_snout.setRotation(p1_snout.getRotation() + 1);
//        }
//        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
//            p1_snout.setRotation(p1_snout.getRotation() - 1);
//        }
//        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
//            player1.getTank().backward();
//        }
//        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
//            player1.getTank().forward();
//        }

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
