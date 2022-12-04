package com.mygdx.game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.screens.MainGameScreen;
import com.mygdx.game.screens.MainMenuScreen;
import com.mygdx.game.screens.TankSelectionScreen;

public class Game extends com.badlogic.gdx.Game {


	// public static final int WIDTH = 720;
	// public static final int HEIGHT = 405;
	private static final int WIDTH = 1080;
	private static final int HEIGHT = 607;
	public SpriteBatch batch;

	public static int getWIDTH() {
		return WIDTH;
	}
	public static int getHEIGHT() {
		return HEIGHT;
	}

	@Override
	public void create () {
		batch = new SpriteBatch();
//		 this.setScreen(new MainMenuScreen(this));
		this.setScreen(new MainGameScreen(this, 2, 2));
	}

	@Override
	public void render () {
		super.render();
	}
	
//	@Override
//	public void dispose () {
//		batch.dispose();
//		img.dispose();
//	}
}
