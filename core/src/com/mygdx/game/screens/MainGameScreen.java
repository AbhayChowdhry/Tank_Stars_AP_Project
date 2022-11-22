package com.mygdx.game.screens;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Game;
import com.mygdx.game.entities.Play;
import com.mygdx.game.entities.Player;
import com.mygdx.game.entities.Pumpkin;

public class MainGameScreen implements Screen{

    public static final float SPEED = 120;
    public static final int TANK_X = 150;
    public static final int TANK_Y = 200;
    Texture BACKGROUND = new Texture("PLAY_BACK.png");
    Texture TERRAIN = new Texture("TERRAIN.png");
    Texture TERR_BORDER = new Texture("TERR_BORDER.png");
    Texture PAUSE_INACTIVE = new Texture("PAUSE_INACTIVE.png");
    Texture PAUSE_ACTIVE = new Texture("PAUSE_ACTIVE.png");
    Texture RESUME_ACTIVE = new Texture("RESUME_ACTIVE.png");
    Texture RESUME_INACTIVE = new Texture("RESUME_INACTIVE.png");
    Texture SAVE_ACTIVE = new Texture("SAVE_ACTIVE.png");
    Texture SAVE_INACTIVE = new Texture("SAVE_INACTIVE.png");
    Texture EXIT_ACTIVE = new Texture("EXIT_ACTIVE.png");
    Texture EXIT_INACTIVE = new Texture("EXIT_INACTIVE.png");

    Texture HEALTH_LOGO_P1 = new Texture("HEALTH_LOGO_P1.png");
    Texture HEALTH_LOGO_P2 = new Texture("HEALTH_LOGO_P2.png");
    Texture HEALTH_CURR_P1 = new Texture("HEALTH_CURR_P1.png");
    Texture HEALTH_CURR_P2 = new Texture("HEALTH_CURR_P2.png");

    Texture VS = new Texture("VS.png");


    private static final double BUTTON_WIDTH = Game.getWIDTH() / 5.36;
    private static final double BUTTON_HEIGHT = Game.getHEIGHT() / 12.56;
    private static final double BUTTON_DIF = Game.getHEIGHT() / 9.0;
    private static final double BUTTON_X = Game.getWIDTH() / 1.257;
    private static final double BUTTON_Y = Game.getHEIGHT() / 1.291;
    private static final double PAUSE_Y = Game.getHEIGHT() / 1.129;
    private static final double PAUSE_X = Game.getWIDTH() / 1.067;
    private static final double PAUSE_WIDTH = Game.getWIDTH() / 22.32;
    private static final double PAUSE_HEIGHT = Game.getHEIGHT() / 12.558;

    private static final double HEALTH_LOGO_X1 = Game.getWIDTH() / 6.421;
    private static final double HEALTH_LOGO_X2 = Game.getWIDTH() / 1.705;
    private static final double HEALTH_LOGO_Y = Game.getHEIGHT() / 1.1757;


    private static final double HEALTH_LOGO_HEIGHT = Game.getHEIGHT() / 9.438;
    private static final double HEALTH_LOGO_WIDTH = Game.getWIDTH() / 3.83;

    private static final double VS_X = Game.getWIDTH() / 2.11;
    private static final double VS_Y = Game.getHEIGHT() / 1.168;

    private static final double VS_HEIGHT = Game.getHEIGHT() / 10.245;
    private static final double VS_WIDTH = Game.getWIDTH() / 18.113;
    private static final double HEALTH_CURR_X1 = Game.getWIDTH() / 4.717;
    private static final double HEALTH_CURR_X2 = Game.getWIDTH() / 1.693;
    private static final double HEALTH_CURR_Y = Game.getHEIGHT() / 1.116;


    private static final double HEALTH_CURR_HEIGHT = Game.getHEIGHT() / 19.836;
    private static final double HEALTH_CURR_WIDTH = Game.getWIDTH() / 4.987;


    boolean isPaused = false;

    Game game;
//    Sprite p1_body, p1_snout, p2_body, p2_snout;
//    Texture img;
//    private Pumpkin pumpkin;
//    Player player1 = new Player(1, pumpkin);
//    Player player2 = new Player(2, pumpkin);
    Play play=new Play();
    public MainGameScreen (Game game){
        this.game = game;
        //        this.stage = new Stage(viewport);

        // int[] height=Play.


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
        float[] height=play.getTerrain();
        for(int i=0;i<Game.getWIDTH();i++){
            game.batch.draw(TERRAIN, i, 0, 1, height[i]);
            game.batch.draw(TERR_BORDER, i, height[i], 1, Game.getHEIGHT()/120);
        }
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
        else {
            game.batch.draw(PAUSE_ACTIVE, (float) PAUSE_X, (float) PAUSE_Y, (float) PAUSE_WIDTH, (float) PAUSE_HEIGHT);
            game.batch.draw(RESUME_INACTIVE, (float) BUTTON_X, (float) (BUTTON_Y), (float) BUTTON_WIDTH, (float) BUTTON_HEIGHT);
            game.batch.draw(SAVE_INACTIVE, (float) BUTTON_X, (float) (BUTTON_Y - BUTTON_DIF), (float) BUTTON_WIDTH, (float) BUTTON_HEIGHT);
            game.batch.draw(EXIT_INACTIVE, (float) BUTTON_X, (float) (BUTTON_Y - 2 * BUTTON_DIF), (float) BUTTON_WIDTH, (float) BUTTON_HEIGHT);
            if (Gdx.input.getX() > PAUSE_X && Gdx.input.getX() < PAUSE_X + PAUSE_WIDTH && y > PAUSE_Y && y < PAUSE_Y + PAUSE_HEIGHT) {
                game.batch.draw(PAUSE_ACTIVE, (float) PAUSE_X, (float) PAUSE_Y, (float) PAUSE_WIDTH, (float) PAUSE_HEIGHT);
                if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
                    isPaused = false;
                }
            }
        }

        game.batch.draw(HEALTH_LOGO_P1, (float) HEALTH_LOGO_X1, (float) HEALTH_LOGO_Y, (float) HEALTH_LOGO_WIDTH, (float) HEALTH_LOGO_HEIGHT);
        game.batch.draw(HEALTH_LOGO_P2, (float) HEALTH_LOGO_X2, (float) HEALTH_LOGO_Y, (float) HEALTH_LOGO_WIDTH, (float) HEALTH_LOGO_HEIGHT);
        game.batch.draw(VS, (float) VS_X, (float) VS_Y, (float) VS_WIDTH, (float) VS_HEIGHT);
//        int health1 = play.getPlayer1().getHealth();
        game.batch.draw(HEALTH_CURR_P1, (float) HEALTH_CURR_X1, (float) HEALTH_CURR_Y, (float) (HEALTH_CURR_WIDTH*0.2), (float) HEALTH_CURR_HEIGHT);
//        int health2 = play.getPlayer2().getHealth();
        game.batch.draw(HEALTH_CURR_P2, (float) HEALTH_CURR_X2, (float) HEALTH_CURR_Y, (float) HEALTH_CURR_WIDTH, (float) HEALTH_CURR_HEIGHT);

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
