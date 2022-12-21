package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Game;

public class FinalWinScreen implements Screen {
    private int won;
    Game game;
    transient Texture EXIT_ACTIVE,NEW_GAME_ACTIVE;
    transient Texture P1_wins, P2_wins;
    transient Texture back;

    private static final double BUTTON_WIDTH = Game.getWIDTH() / 5.36;
    private static final double BUTTON_HEIGHT = Game.getHEIGHT() / 12.56;
    private static final double BUTTON_X = Game.getWIDTH()/2.45;
    private static final double BUTTON_Y = Game.getHEIGHT()/2.17;
    private static final double BUTTON_DIF = Game.getHEIGHT()/7.88;

    public FinalWinScreen(Game game, int i){

        this.game = game;
        this.won = i;
        NEW_GAME_ACTIVE = new Texture("NEW_GAME_ACTIVE.png");
        EXIT_ACTIVE = new Texture("EXIT_ACTIVE.png");
        P1_wins = new Texture("P1_wins.png");
        P2_wins = new Texture("P2_wins.png");
        back = new Texture("Win_screen.png");

    }

    public int getWon() {
        return won;
    }

    public void setWon(int won) {
        this.won = won;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        ScreenUtils.clear(0, 0, 0, 0);
        game.batch.begin();
        game.batch.draw(back, 0, 0, game.getWIDTH(), game.getHEIGHT());

        int y = Game.getHEIGHT() - Gdx.input.getY();
        if(Gdx.input.getX() > BUTTON_X && Gdx.input.getX() < BUTTON_X + BUTTON_WIDTH && y > BUTTON_Y && y < BUTTON_Y + BUTTON_HEIGHT) {
            game.batch.draw(NEW_GAME_ACTIVE, (float) BUTTON_X, (float) BUTTON_Y, (float)  BUTTON_WIDTH, (float) BUTTON_HEIGHT);
            if(Gdx.input.isTouched()){
                game.setScreen(new TankSelectionScreen(game, false, 0));
            }
        }
        else if(Gdx.input.getX() > BUTTON_X && Gdx.input.getX() < BUTTON_X + BUTTON_WIDTH && y > BUTTON_Y - BUTTON_DIF && y < BUTTON_Y + BUTTON_HEIGHT - BUTTON_HEIGHT){
            game.batch.draw(EXIT_ACTIVE, (float) BUTTON_X, (float) (BUTTON_Y - BUTTON_DIF), (float)  BUTTON_WIDTH, (float) BUTTON_HEIGHT);
            if(Gdx.input.isTouched()){
                Gdx.app.exit();
            }

        }


        if(this.getWon() == 1){
            // player 1 won
            game.batch.draw(P1_wins, (float) (Game.getHEIGHT()/3.588), (float) (Game.getHEIGHT()/1.641), (float) (Game.getWIDTH()/2.344), (float) (Game.getHEIGHT()/4.86));
        }
        else{
            // player 2 won
            game.batch.draw(P2_wins, (float) (Game.getHEIGHT()/3.588), (float) (Game.getHEIGHT()/1.641), (float) (Game.getWIDTH()/2.344), (float) (Game.getHEIGHT()/4.86));
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
