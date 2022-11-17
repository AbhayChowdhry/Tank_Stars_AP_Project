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

public class MainGameScreen implements Screen{

    public static final float SPEED = 120;
    public static final int TANK_X = 150;
    public static final int TANK_Y = 200;
    Game game;
    Sprite p1_body, p1_snout, p2_body, p2_snout;
    Texture img;
    private Pumpkin pumpkin;
    Player player1 = new Player(1, pumpkin);


    public MainGameScreen (Game game){
        this.game = game;

//        ScreenViewport viewport = new ScreenViewport();
//        this.stage = new Stage(viewport);
//        Gdx.input.setInputProcessor(stage);

//        Actor actor = new Actor();
//        stage.addActor(actor);
//        stage.setKeyboardFocus(actor);
        img = new Texture("TestTank.png");
        Texture p1_snout_texture = player1.getTank().getSnout();
        Texture p1_body_texture = player1.getTank().getBody();

        p1_body=new Sprite(p1_body_texture);
        p1_snout=new Sprite(p1_snout_texture);
        p1_body.setSize(652,366);
        p1_body.setOrigin(0,0);

        p1_snout.setSize(652,146);
        p1_snout.setOrigin(325,73);

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

        p1_body.setPosition(player1.getTank().getX_body(),player1.getTank().getY_body());
        p1_snout.setPosition(player1.getTank().getX_snout(),player1.getTank().getY_snout() + 215);

        p1_snout.draw(game.batch);
        p1_body.draw(game.batch);

        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            p1_snout.setRotation(p1_snout.getRotation() + 1);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            p1_snout.setRotation(p1_snout.getRotation() - 1);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            player1.getTank().backward();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            player1.getTank().forward();
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
