package com.mygdx.game.screens;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Bezier;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Game;
import com.mygdx.game.entities.*;
import com.mygdx.game.exceptions.HealthZeroException;
import com.mygdx.game.exceptions.OutOfArenaException;

import java.awt.*;
import java.awt.geom.CubicCurve2D;
import java.util.ArrayList;
import java.util.Collection;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import static java.awt.Color.BLUE;


public class MainGameScreen implements Screen{

    public static final float SPEED = 2;
    public static final int TANK_X = 150;
    public static final int TANK_Y = 200;

    transient Texture BACKGROUND = new Texture("PLAY_BACK.png");
    transient Texture TERRAIN = new Texture("TERRAIN.png");

    transient Texture PAUSE_INACTIVE = new Texture("PAUSE_INACTIVE.png");
    transient Texture PAUSE_ACTIVE = new Texture("PAUSE_ACTIVE.png");
    transient Texture RESUME_ACTIVE = new Texture("RESUME_ACTIVE.png");
    transient Texture RESUME_INACTIVE = new Texture("RESUME_INACTIVE.png");
    transient Texture SAVE_ACTIVE = new Texture("SAVE_ACTIVE.png");
    transient Texture SAVE_INACTIVE = new Texture("SAVE_INACTIVE.png");
    transient Texture EXIT_ACTIVE = new Texture("EXIT_ACTIVE.png");
    transient Texture EXIT_INACTIVE = new Texture("EXIT_INACTIVE.png");

    transient Texture HEALTH_LOGO_P1 = new Texture("HEALTH_LOGO_P1.png");
    transient Texture HEALTH_LOGO_P2 = new Texture("HEALTH_LOGO_P2.png");
    transient Texture HEALTH_CURR_P1 = new Texture("HEALTH_CURR_P1.png");
    transient Texture HEALTH_CURR_P2 = new Texture("HEALTH_CURR_P2.png");
    transient Texture PLACEHOLDER_5 = new Texture("WPN_5.png");
    transient Texture PLACEHOLDER_4 = new Texture("WPN_4.png");
    transient Texture PLACEHOLDER_3 = new Texture("WPN_3.png");
    transient Texture PLACEHOLDER_2 = new Texture("WPN_2.png");
    transient Texture PLACEHOLDER_1 = new Texture("WPN_1.png");

    transient Texture VS = new Texture("VS.png");

    transient Texture FIRE_BUTTON = new Texture("FIRE_BUTTON.png");

    transient Texture FUEL = new Texture("FUEL.png");
    transient Texture FUEL_BACK = new Texture("FUEL_BACK.png");
    transient Texture FUEL_CURR = new Texture("FUEL_CURR.png");
    transient Texture WPN_SEL_BACK = new Texture("WPN_SEL_BACK.png");

    Texture POWER = new Texture("POWER.png");
    Texture POWER_BACK = new Texture("POWER_BACK.png");
    Texture POWER_CURR = new Texture("POWER_CURR.png");
    Texture dot = new Texture("dot.png");

    Sprite ground = new Sprite(TERRAIN);


    private static final double BUTTON_WIDTH = Game.getWIDTH() / 5.36;
    private static final double BUTTON_HEIGHT = Game.getHEIGHT() / 12.56;
    private static final double BUTTON_DIF = Game.getHEIGHT() / 9.0;
    private static final double BUTTON_X = Game.getWIDTH() / 1.257;
    private static final double BUTTON_Y = Game.getHEIGHT() / 1.35;
    // private static final double BUTTON_Y = Game.getHEIGHT() / 1.291;
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

    private static final double FUEL_BACK_X = Game.getWIDTH() / 9.458;
    private static final double FUEL_BACK_Y = Game.getHEIGHT() / 1.371;

    private static final double FUEL_BACK_HEIGHT = Game.getHEIGHT() / 15.428;
    private static final double FUEL_BACK_WIDTH = Game.getWIDTH() / 6.4;

    private static final double FUEL_CURR_X = Game.getWIDTH() / 9.014;
    private static final double FUEL_CURR_Y = Game.getHEIGHT() / 1.357;

    private static final double FUEL_CURR_HEIGHT = Game.getHEIGHT() / 19.838;
    private static final double FUEL_CURR_WIDTH = Game.getWIDTH() / 6.857;
    private static final double FUEL_X = Game.getWIDTH() / 6.2;
    private static final double FUEL_Y = Game.getHEIGHT() / 1.333;

    private static final double FUEL_HEIGHT = Game.getHEIGHT() / 39.0;
    private static final double FUEL_WIDTH = Game.getWIDTH() / 20.0;

    private static final double POWER_BACK_X = Game.getWIDTH() / 1.355;
    private static final double POWER_BACK_Y = Game.getHEIGHT() / 1.371;

    private static final double POWER_BACK_HEIGHT = Game.getHEIGHT() / 15.428;
    private static final double POWER_BACK_WIDTH = Game.getWIDTH() / 6.4;

    private static final double POWER_CURR_X = Game.getWIDTH() / 1.345;
    private static final double POWER_CURR_Y = Game.getHEIGHT() / 1.357;

    private static final double POWER_CURR_HEIGHT = Game.getHEIGHT() / 19.838;
    private static final double POWER_CURR_WIDTH = Game.getWIDTH() / 6.857;
    private static final double POWER_X = Game.getWIDTH() / 1.278;
    private static final double POWER_Y = Game.getHEIGHT() / 1.333;

    private static final double POWER_HEIGHT = Game.getHEIGHT() / 39.0;
    private static final double POWER_WIDTH = Game.getWIDTH() / 14.014;

    private static final double FIRE_X = Game.getWIDTH() / 1.207;
    private static final double FIRE_Y = Game.getHEIGHT() / 25.714;

    private static final double FIRE_HEIGHT = Game.getHEIGHT() / 9.231;
    private static final double FIRE_WIDTH = Game.getWIDTH() / 10.667;
    private static final double PLACEHOLDER_X = Game.getWIDTH() / 2.74 - Game.getWIDTH() / 3.86;
    private static final double PLACEHOLDER_Y = Game.getHEIGHT() / 36.0;
    private static final double PLACEHOLDER_HEIGHT = Game.getHEIGHT() /7.2;
    private static final double PLACEHOLDER_WIDTH_4 = Game.getWIDTH() / 3.25;
    private static final double PLACEHOLDER_WIDTH_3 = Game.getWIDTH() / 4.08;
    private static final double PLACEHOLDER_WIDTH_2 = Game.getWIDTH() / 5.48;
    private static final double PLACEHOLDER_WIDTH_1 = Game.getWIDTH() / 8.34;
    private static final double WEAPON_START_X = Game.getWIDTH() / 2.389 - Game.getWIDTH() / 3.86;
    private static final double WEAPON_START_Y = Game.getHEIGHT()/ 19.63;

    private static final double WEAPON_WIDTH = Game.getWIDTH()/ 19.009;
    private static final double WEAPON_HEIGHT = Game.getHEIGHT()/ 10.8;

    private static final double WEAPON_SEl_X_DIF = Game.getWIDTH() / 2.389 + Game.getWIDTH() / 640.0 ;
    private static final double WEAPON_SEL_Y_DIF = Game.getHEIGHT()/ 19.63 + Game.getHEIGHT()/ 270.0;

    private static final double WEAPON_WIDTH_SEL = Game.getWIDTH()/ 19.009 - Game.getWIDTH() / 320.0;
    private static final double WEAPON_HEIGHT_SEL = Game.getHEIGHT()/ 10.8 -  Game.getHEIGHT()/ 135.0;


    private static final double WEAPON_DIF = Game.getWIDTH() / 15.86;

    private static final float PPM = 32f;

    boolean isPaused = false;
    int x = 0;
    private World world;
    private Box2DDebugRenderer debugRenderer;
    private final OrthographicCamera camera;

    Game game;
    Play play;
    private Body boundary;
    private Body weapon_1, weapon_2;
    private Body[] weapon_1_multi = new Body[5];
    private Body[] weapon_2_multi = new Body[5];
    private int weapon_count;
    private boolean weaponSelected = false;
    private Weapon selected_weapon;
//    float weapon_starter = (float) WEAPON_START_X;
     private int player1_tank, player2_tank;
    private int angle_1, angle_2;
    private boolean flip_2, flip_3;

    public int getAngle_1() {
        return angle_1;
    }

    public void updateAngle_1(int a) {
        this.angle_1 += a;
    }
    public int getAngle_2() {
        return angle_2;
    }

    public void updateAngle_2(int a) {
        this.angle_2 += a;
    }


    TheChosenOne theChosenOne = new TheChosenOne();
    SharpShooter sharpShooter = new SharpShooter();
    MakeItRain[] makeItRain = new MakeItRain[5];
    MassiveDrop massiveDrop = new MassiveDrop();
    private boolean attack_1, attack_2;
    private int weapon_number;
    private boolean is_multi_1, is_multi_2;
    private int count_1, count_2;
    private ShapeRenderer shapeRenderer;

    public MainGameScreen (Game game, int tank1, int tank2){
        play = new Play();
        this.game = game;
        this.angle_1 = 0;
        this.angle_2 = 0;
        this.flip_2 = false;
        this.flip_3 = false;
        switch (tank1) {
            case 1:
                play.getPlayer1().setTank(new Atomic());
                break;
            case 2:
                play.getPlayer1().setTank(new Pumpkin());
                break;
            case 3:
                play.getPlayer1().setTank(new Toxic());
                break;
            case 4:
                play.getPlayer1().setTank(new Pinky());
                break;
        }

        switch (tank2) {
            case 1:
                play.getPlayer2().setTank(new Atomic());
                break;
            case 2:
                play.getPlayer2().setTank(new Pumpkin());
                break;
            case 3:
                play.getPlayer2().setTank(new Toxic());
                break;
            case 4:
                play.getPlayer2().setTank(new Pinky());
                break;
        }
        player1_tank = tank1;
        player2_tank = tank2;
        play.setPlayer1_tank_number();
        play.setPlayer2_tank_number();
        world = new World(new Vector2(0,-9.81f), false);
        debugRenderer = new Box2DDebugRenderer();

        this.camera = new OrthographicCamera();
        this.camera.setToOrtho(false, Game.getWIDTH(), Game.getHEIGHT());

        game.batch.setProjectionMatrix(camera.combined);
        this.attack_1 = false;
        this.attack_2 = false;

        this.is_multi_1 = false;
        this.is_multi_2 = false;

        this.count_1 = 0;
        this.count_2 = 0;

        this.weapon_number = -1;
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.setAutoShapeType(true);
    }
    public MainGameScreen(Game game, Play newplay){
        play = new Play();
        play = newplay;
        this.game = game;
        this.angle_1 = 0;
        this.angle_2 = 0;
        this.flip_2 = false;
        this.flip_3 = false;

        int tank1 = newplay.getPlayer1_tank_number();
        int tank2 = newplay.getPlayer2_tank_number();

        switch (tank1) {
            case 1:
                play.getPlayer1().setTank(new Atomic());
                break;
            case 2:
                play.getPlayer1().setTank(new Pumpkin());
                break;
            case 3:
                play.getPlayer1().setTank(new Toxic());
                break;
            case 4:
                play.getPlayer1().setTank(new Pinky());
                break;
        }

        switch (tank2) {
            case 1:
                play.getPlayer2().setTank(new Atomic());
                break;
            case 2:
                play.getPlayer2().setTank(new Pumpkin());
                break;
            case 3:
                play.getPlayer2().setTank(new Toxic());
                break;
            case 4:
                play.getPlayer2().setTank(new Pinky());
                break;
        }

        this.attack_1 = false;
        this.attack_2 = false;

        this.is_multi_1 = false;
        this.is_multi_2 = false;

        this.count_1 = 0;
        this.count_2 = 0;

        this.weapon_number = -1;

        player1_tank = tank1;
        player2_tank = tank2;

        world = new World(new Vector2(0,-9.81f), false);
        debugRenderer = new Box2DDebugRenderer();

        this.camera = new OrthographicCamera();
        this.camera.setToOrtho(false, Game.getWIDTH(), Game.getHEIGHT());

        game.batch.setProjectionMatrix(camera.combined);

        play.setTank_1_position(newplay.getTank_1_position());
        play.setTank_2_position(newplay.getTank_2_position());

        play.getPlayer1().setHealth(newplay.getPlayer1().getHealth());
        play.getPlayer2().setHealth(newplay.getPlayer2().getHealth());
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(camera.combined);
    }
    @Override
    public void show() {
        world = new World(new Vector2(0,-9.81f), false);
        debugRenderer = new Box2DDebugRenderer();
        camera.setToOrtho(false, Game.getWIDTH(), Game.getHEIGHT());
        debugRenderer.render(world, camera.combined.cpy().scl(PPM));
    }
    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        world.step(Gdx.graphics.getDeltaTime(), 8, 3);
        debugRenderer.render(world, camera.combined.cpy().scl(PPM));

        BodyDef bodydef = new BodyDef();
        FixtureDef fixturedef;
        PolygonShape shape;

        game.batch.begin();

        //Background
        game.batch.draw(BACKGROUND, 0, 0, Game.getWIDTH(), Game.getHEIGHT());


        //Health
        game.batch.draw(HEALTH_LOGO_P1, (float) HEALTH_LOGO_X1, (float) HEALTH_LOGO_Y, (float) HEALTH_LOGO_WIDTH, (float) HEALTH_LOGO_HEIGHT);
        game.batch.draw(HEALTH_LOGO_P2, (float) HEALTH_LOGO_X2, (float) HEALTH_LOGO_Y, (float) HEALTH_LOGO_WIDTH, (float) HEALTH_LOGO_HEIGHT);
        game.batch.draw(VS, (float) VS_X, (float) VS_Y, (float) VS_WIDTH, (float) VS_HEIGHT);
        int health1 = play.getPlayer1().getHealth();
        game.batch.draw(HEALTH_CURR_P1, (float) HEALTH_CURR_X1, (float) HEALTH_CURR_Y, (float) (HEALTH_CURR_WIDTH/100 * health1), (float) HEALTH_CURR_HEIGHT);
        int health2 = play.getPlayer2().getHealth();
        game.batch.draw(HEALTH_CURR_P2, (float) (HEALTH_CURR_X2 + HEALTH_CURR_WIDTH - HEALTH_CURR_WIDTH/100 * health2), (float) HEALTH_CURR_Y, (float) (HEALTH_CURR_WIDTH/100 *health2), (float) HEALTH_CURR_HEIGHT);

        //Power
        game.batch.draw(POWER_BACK, (float) POWER_BACK_X, (float) POWER_BACK_Y, (float) POWER_BACK_WIDTH, (float) POWER_BACK_HEIGHT);
        float power;
        if(play.getTurn())
            power=play.getPlayer1().getPower();
        else
            power=play.getPlayer2().getPower();
        game.batch.draw(POWER_CURR, (float) POWER_CURR_X, (float) POWER_CURR_Y, (float) (POWER_CURR_WIDTH/10 * power), (float) POWER_CURR_HEIGHT);
        game.batch.draw(POWER, (float) POWER_X, (float) POWER_Y, (float) POWER_WIDTH, (float) POWER_HEIGHT);

        //Pause Menu
        int y = Game.getHEIGHT() - Gdx.input.getY();
        if(!isPaused) {
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
            else if(Gdx.input.getX() > BUTTON_X && Gdx.input.getX() < BUTTON_X + BUTTON_WIDTH && y > BUTTON_Y && y < BUTTON_Y + BUTTON_HEIGHT){
                game.batch.draw(RESUME_ACTIVE, (float) BUTTON_X, (float) (BUTTON_Y), (float) BUTTON_WIDTH, (float) BUTTON_HEIGHT);
                if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
                    isPaused = false;
                }
            }
            else if(Gdx.input.getX() > BUTTON_X && Gdx.input.getX() < BUTTON_X + BUTTON_WIDTH && y > BUTTON_Y - BUTTON_DIF && y < BUTTON_Y + BUTTON_HEIGHT - BUTTON_DIF){
                game.batch.draw(SAVE_ACTIVE, (float) BUTTON_X, (float) (BUTTON_Y - BUTTON_DIF), (float) BUTTON_WIDTH, (float) BUTTON_HEIGHT);
                if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
                    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("obj.txt"))) {
                        oos.writeObject(play);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            else if(Gdx.input.getX() > BUTTON_X && Gdx.input.getX() < BUTTON_X + BUTTON_WIDTH && y > BUTTON_Y - 2* BUTTON_DIF && y < BUTTON_Y + BUTTON_HEIGHT - 2* BUTTON_DIF){
                game.batch.draw(EXIT_ACTIVE, (float) BUTTON_X, (float) (BUTTON_Y - 2 * BUTTON_DIF), (float) BUTTON_WIDTH, (float) BUTTON_HEIGHT);
                if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
//                    game.setScreen(new MainMenuScreen(game));
                    game.setScreen(MainMenuScreen.getInstance(game));
                }
            }
        }

        //Fuel
        game.batch.draw(FUEL_BACK, (float) FUEL_BACK_X, (float) FUEL_BACK_Y, (float) FUEL_BACK_WIDTH, (float) FUEL_BACK_HEIGHT);
        float fuel;
        if(play.getTurn())
            fuel=play.getPlayer1().getFuel();
        else
            fuel=play.getPlayer2().getFuel();
        game.batch.draw(FUEL_CURR, (float) FUEL_CURR_X, (float) FUEL_CURR_Y, (float) (FUEL_CURR_WIDTH/10*fuel), (float) FUEL_CURR_HEIGHT);
        game.batch.draw(FUEL, (float) FUEL_X, (float) FUEL_Y, (float) FUEL_WIDTH, (float) FUEL_HEIGHT);

        //Terrain
        float[] height=play.getTerrain();
        for(int i=0;i<Game.getWIDTH();i++) {
            ground.setPosition(i,0);
            ground.setSize(1,height[i]);
            ground.draw(game.batch);
        }


        //Player 1 Slope
        int x1_1 = play.getTank_1_position();
        int x2_1 = (int)(play.getTank_1_position()+play.getPlayer1().getTank().getTank_width()/1.5f);
        float slope1 =(float)Math.atan((height[x2_1]-height[x1_1])/(float)(x2_1-x1_1));
        float phi1 = (float)Math.atan(play.getPlayer1().getTank().getSnout_y()/play.getPlayer1().getTank().getSnout_x());
        float length1 = (float)Math.sqrt(Math.pow(play.getPlayer1().getTank().getSnout_x()/1.5f,2)+Math.pow(play.getPlayer1().getTank().getSnout_y()/1.5f,2));


        //Player 1 Snout
        play.getPlayer1().getTank().getSnout().setPosition(play.getTank_1_position()+length1*(float)Math.cos(slope1+phi1),height[play.getTank_1_position()]+length1*(float)Math.sin(slope1+phi1));
        play.getPlayer1().getTank().getSnout().setSize((float) play.getPlayer1().getTank().getSnout_width()/1.5f, (float) play.getPlayer1().getTank().getSnout_height()/1.5f);
        play.getPlayer1().getTank().getSnout().setRotation(slope1*MathUtils.radiansToDegrees+getAngle_1());
        if(player1_tank==1)
            play.getPlayer1().getTank().getSnout().setOrigin(5,5);
        else
            play.getPlayer1().getTank().getSnout().setOrigin(0,0);
        play.getPlayer1().getTank().getSnout().draw(game.batch);

        //Player 1 Tank
        play.getPlayer1().getTank().getBody().setPosition(play.getTank_1_position(), height[play.getTank_1_position()]);
        play.getPlayer1().getTank().getBody().setSize((float) play.getPlayer1().getTank().getTank_width()/1.5f, (float) play.getPlayer1().getTank().getTank_height()/1.5f);
        play.getPlayer1().getTank().getBody().setRotation(slope1*MathUtils.radiansToDegrees);
        play.getPlayer1().getTank().getBody().setOrigin(0,0);
        play.getPlayer1().getTank().getBody().draw(game.batch);



        //Player 2 Slope
        int x1_2 = play.getTank_2_position();
        int x2_2 = (int)(play.getTank_2_position()+play.getPlayer2().getTank().getTank_width()/1.5f);

        float phi2 = (float)Math.atan(play.getPlayer2().getTank().getSnout_y()/play.getPlayer2().getTank().getSnout_x());
        float length2 = (float)Math.sqrt(Math.pow(play.getPlayer2().getTank().getSnout_x()/1.5f,2)+Math.pow(play.getPlayer2().getTank().getSnout_y()/1.5f,2));
        float slope2 = (float)Math.atan((height[x2_2]-height[x1_2])/(float)(x2_2-x1_2));

        //Player 2 Snout

        play.getPlayer2().getTank().getSnout().setPosition(play.getTank_2_position()+length2*(float)Math.cos(slope2+phi2),height[play.getTank_2_position()]+length2*(float)Math.sin(slope2+phi2));
        play.getPlayer2().getTank().getSnout().setSize((float) play.getPlayer2().getTank().getSnout_width()/1.5f, (float) play.getPlayer2().getTank().getSnout_height()/1.5f);
        play.getPlayer2().getTank().getSnout().setRotation((float) (180 + ((slope2)*MathUtils.radiansToDegrees + getAngle_2())));
        if(player2_tank == 1)
            play.getPlayer2().getTank().getSnout().setOrigin(5, 5);
        else
            play.getPlayer2().getTank().getSnout().setOrigin(0, 0);

//        play.getPlayer2().getTank().getSnout().setPosition(play.getTank_2_position()+length2*(float)Math.cos(slope2+phi2),height[play.getTank_2_position()]+length2*(float)Math.sin(slope2+phi2));
//        play.getPlayer2().getTank().getSnout().setSize((float) play.getPlayer2().getTank().getSnout_width()/1.5f, (float) play.getPlayer2().getTank().getSnout_height()/1.5f);
//        play.getPlayer2().getTank().getSnout().setRotation((float) (180 + ((slope2)*MathUtils.radiansToDegrees + getAngle_2())));
//        if(player2_tank==1)
//            play.getPlayer1().getTank().getSnout().setOrigin(5,5);
//        else
//            play.getPlayer1().getTank().getSnout().setOrigin(0,0);
        play.getPlayer2().getTank().getSnout().draw(game.batch);

        //Player 2 Tank
        play.getPlayer2().getTank().getBody().setPosition(play.getTank_2_position(), height[play.getTank_2_position()]);
        play.getPlayer2().getTank().getBody().setSize((float) play.getPlayer2().getTank().getTank_width()/1.5f, (float) play.getPlayer2().getTank().getTank_height()/1.5f);
        play.getPlayer2().getTank().getBody().setRotation(slope2*MathUtils.radiansToDegrees);
        play.getPlayer2().getTank().getBody().setOrigin(0, 0);
        if(!this.flip_3) {
            play.getPlayer2().getTank().getBody().flip(true, false);
            this.flip_3 = true;
        }
        play.getPlayer2().getTank().getBody().draw(game.batch);

        //Weapon Tank 1
        if(attack_1) {
            switch(weapon_number) {
                case 0:
                    theChosenOne.weapons(play.getPlayer1().getTank()).setPosition((float) (weapon_1.getPosition().x * PPM - theChosenOne.getWidth(play.getPlayer1().getTank()) / 3), (float) (weapon_1.getPosition().y * PPM - theChosenOne.getHeight(play.getPlayer1().getTank()) / 3));
                    theChosenOne.weapons(play.getPlayer1().getTank()).setSize((float) theChosenOne.getWidth(play.getPlayer1().getTank()) / 1.5f, (float) theChosenOne.getHeight(play.getPlayer1().getTank()) / 1.5f);
                    theChosenOne.weapons(play.getPlayer1().getTank()).setRotation(weapon_1.getAngle() * MathUtils.radiansToDegrees);
                    theChosenOne.weapons(play.getPlayer1().getTank()).setOrigin((float) theChosenOne.getWidth(play.getPlayer1().getTank()) / 3f, (float) theChosenOne.getHeight(play.getPlayer1().getTank()) / 3f);
                    theChosenOne.weapons(play.getPlayer1().getTank()).draw(game.batch);
                    break;
                case 1:
                    sharpShooter.weapons(play.getPlayer1().getTank()).setPosition((float) (weapon_1.getPosition().x * PPM - sharpShooter.getWidth(play.getPlayer1().getTank()) / 3), (float) (weapon_1.getPosition().y * PPM - sharpShooter.getHeight(play.getPlayer1().getTank()) / 3));
                    sharpShooter.weapons(play.getPlayer1().getTank()).setSize((float) sharpShooter.getWidth(play.getPlayer1().getTank()) / 1.5f, (float) sharpShooter.getHeight(play.getPlayer1().getTank()) / 1.5f);
                    sharpShooter.weapons(play.getPlayer1().getTank()).setRotation(weapon_1.getAngle() * MathUtils.radiansToDegrees);
                    sharpShooter.weapons(play.getPlayer1().getTank()).setOrigin((float) sharpShooter.getWidth(play.getPlayer1().getTank()) / 3f, (float) sharpShooter.getHeight(play.getPlayer1().getTank()) / 3f);
                    sharpShooter.weapons(play.getPlayer1().getTank()).draw(game.batch);
                    break;
                case 3:
                    for (int i = 0; i < 5; i++) {
                        makeItRain[i].weapons(play.getPlayer1().getTank()).setPosition((float) (weapon_1_multi[i].getPosition().x * PPM - makeItRain[i].getHeight(play.getPlayer1().getTank()) / 3), (float) (weapon_1_multi[i].getPosition().y * PPM - makeItRain[i].getWidth(play.getPlayer1().getTank()) / 3));
                        makeItRain[i].weapons(play.getPlayer1().getTank()).setSize((float) makeItRain[i].getHeight(play.getPlayer1().getTank()) / 1.5f, (float) makeItRain[i].getWidth(play.getPlayer1().getTank()) / 1.5f);
                        makeItRain[i].weapons(play.getPlayer1().getTank()).setRotation(weapon_1_multi[i].getAngle() * MathUtils.radiansToDegrees);
                        makeItRain[i].weapons(play.getPlayer1().getTank()).setOrigin((float) makeItRain[i].getHeight(play.getPlayer1().getTank()) / 3f, (float) makeItRain[i].getWidth(play.getPlayer1().getTank()) / 3f);
                        makeItRain[i].weapons(play.getPlayer1().getTank()).draw(game.batch);
                    }
                    break;
                case 4:
                    massiveDrop.weapons(play.getPlayer1().getTank()).setPosition((float) (weapon_1.getPosition().x * PPM - massiveDrop.getHeight(play.getPlayer1().getTank()) / 3), (float) (weapon_1.getPosition().y * PPM - massiveDrop.getWidth(play.getPlayer1().getTank()) / 3));
                    massiveDrop.weapons(play.getPlayer1().getTank()).setSize((float) massiveDrop.getHeight(play.getPlayer1().getTank()) / 1.5f, (float) massiveDrop.getWidth(play.getPlayer1().getTank()) / 1.5f);
                    massiveDrop.weapons(play.getPlayer1().getTank()).setRotation(weapon_1.getAngle() * MathUtils.radiansToDegrees);
                    massiveDrop.weapons(play.getPlayer1().getTank()).setOrigin((float) massiveDrop.getHeight(play.getPlayer1().getTank()) / 3f, (float) massiveDrop.getWidth(play.getPlayer1().getTank()) / 3f);
                    massiveDrop.weapons(play.getPlayer1().getTank()).draw(game.batch);
                    break;
            }
        }

        //Weapon Tank 2
        if(attack_2) {
            switch(weapon_number) {
                case 0:
                    theChosenOne.weapons(play.getPlayer2().getTank()).setPosition((float)(weapon_2.getPosition().x*PPM-theChosenOne.getWidth(play.getPlayer2().getTank())/3), (float)(weapon_2.getPosition().y*PPM-theChosenOne.getHeight(play.getPlayer2().getTank())/3));
                    theChosenOne.weapons(play.getPlayer2().getTank()).setSize((float)theChosenOne.getWidth(play.getPlayer2().getTank())/1.5f, (float)theChosenOne.getHeight(play.getPlayer2().getTank())/1.5f);
                    theChosenOne.weapons(play.getPlayer2().getTank()).setRotation(weapon_2.getAngle()*MathUtils.radiansToDegrees);
                    theChosenOne.weapons(play.getPlayer2().getTank()).setOrigin((float)theChosenOne.getWidth(play.getPlayer2().getTank())/3f, (float)theChosenOne.getHeight(play.getPlayer2().getTank())/3f);
                    theChosenOne.weapons(play.getPlayer2().getTank()).draw(game.batch);
                    break;
                case 1:
                    sharpShooter.weapons(play.getPlayer2().getTank()).setPosition((float)(weapon_2.getPosition().x*PPM-sharpShooter.getWidth(play.getPlayer2().getTank())/3), (float)(weapon_2.getPosition().y*PPM-sharpShooter.getHeight(play.getPlayer2().getTank())/3));
                    sharpShooter.weapons(play.getPlayer2().getTank()).setSize((float)sharpShooter.getWidth(play.getPlayer2().getTank())/1.5f, (float)sharpShooter.getHeight(play.getPlayer2().getTank())/1.5f);
                    sharpShooter.weapons(play.getPlayer2().getTank()).setRotation(weapon_2.getAngle()*MathUtils.radiansToDegrees);
                    sharpShooter.weapons(play.getPlayer2().getTank()).setOrigin((float)sharpShooter.getWidth(play.getPlayer2().getTank())/3f, (float)sharpShooter.getHeight(play.getPlayer2().getTank())/3f);
                    sharpShooter.weapons(play.getPlayer2().getTank()).draw(game.batch);
                    break;
                case 3:
                    for(int i=0;i<5;i++) {
                        makeItRain[i].weapons(play.getPlayer2().getTank()).setPosition((float)(weapon_2_multi[i].getPosition().x*PPM-makeItRain[i].getHeight(play.getPlayer2().getTank())/3), (float)(weapon_2_multi[i].getPosition().y*PPM-makeItRain[i].getWidth(play.getPlayer2().getTank())/3));
                        makeItRain[i].weapons(play.getPlayer2().getTank()).setSize((float)makeItRain[i].getHeight(play.getPlayer2().getTank())/1.5f, (float)makeItRain[i].getWidth(play.getPlayer2().getTank())/1.5f);
                        makeItRain[i].weapons(play.getPlayer2().getTank()).setRotation(weapon_2_multi[i].getAngle()*MathUtils.radiansToDegrees);
                        makeItRain[i].weapons(play.getPlayer2().getTank()).setOrigin((float)makeItRain[i].getHeight(play.getPlayer2().getTank())/3f, (float)makeItRain[i].getWidth(play.getPlayer2().getTank())/3f);
                        makeItRain[i].weapons(play.getPlayer2().getTank()).draw(game.batch);
                    }
                    break;
                case 4:
                    massiveDrop.weapons(play.getPlayer2().getTank()).setPosition((float)(weapon_2.getPosition().x*PPM-massiveDrop.getHeight(play.getPlayer2().getTank())/3), (float)(weapon_2.getPosition().y*PPM-massiveDrop.getWidth(play.getPlayer2().getTank())/3));
                    massiveDrop.weapons(play.getPlayer2().getTank()).setSize((float)massiveDrop.getHeight(play.getPlayer2().getTank())/1.5f, (float)massiveDrop.getWidth(play.getPlayer2().getTank())/1.5f);
                    massiveDrop.weapons(play.getPlayer2().getTank()).setRotation(weapon_2.getAngle()*MathUtils.radiansToDegrees);
                    massiveDrop.weapons(play.getPlayer2().getTank()).setOrigin((float)massiveDrop.getHeight(play.getPlayer2().getTank())/3f, (float)massiveDrop.getWidth(play.getPlayer2().getTank())/3f);
                    massiveDrop.weapons(play.getPlayer2().getTank()).draw(game.batch);
                    break;
            }
        }

        //Attack Tank 1
        try{
            if(attack_1 && !is_multi_1 && (weapon_1.getPosition().x*PPM>1050 || weapon_1.getPosition().x*PPM<30)) {
                throw new OutOfArenaException("Going out of frame");
            }
        }
        catch (OutOfArenaException e) {
            world.destroyBody(weapon_1);
            attack_1 = false;
        }
        if(attack_1 && !is_multi_1 && weapon_1.getPosition().y*PPM<=height[(int)(weapon_1.getPosition().x*PPM)]+(float)massiveDrop.getHeight(play.getPlayer1().getTank())/3f) {
            float diff_1 = (float) Math.abs(weapon_1.getPosition().x*PPM-play.getTank_2_position()-play.getPlayer2().getTank().getTank_width()/3f);
            float diff_2 = (float) Math.abs(weapon_1.getPosition().x*PPM-play.getTank_1_position()-play.getPlayer1().getTank().getTank_width()/3f);
            if(diff_1<=100) {
                play.getPlayer2().setHealth(Math.max(0, (int) (play.getPlayer2().getHealth() + 0.2 * diff_1 - 23)));
                if (weapon_1.getPosition().x * PPM > play.getTank_2_position() + play.getPlayer2().getTank().getTank_width() / 3f)
                    play.setTank_2_position(Math.max(80,play.getTank_2_position() - (int)(diff_1 + 100)));
                else
                    play.setTank_2_position(Math.min(1000, play.getTank_2_position() + (int)(diff_1 + 100)));
            }
            if(diff_2<=100) {
                play.getPlayer1().setHealth(Math.max(0, (int) (play.getPlayer1().getHealth() + 0.2 * diff_2 - 23)));
                if (weapon_1.getPosition().x * PPM > play.getTank_1_position() + play.getPlayer1().getTank().getTank_width() / 3f)
                    play.setTank_1_position(Math.max(80, play.getTank_1_position() - (int)(diff_2 + 100)));
                else
                    play.setTank_1_position(Math.min(1000, play.getTank_1_position() + (int)(diff_2 + 100)));
            }
            play.updateTerrain(play.getPlayer1().getPower() * Game.getWIDTH() / 320, (int) (weapon_1.getPosition().x * PPM));
            world.destroyBody(weapon_1);
            attack_1 = false;
        }
        else if(attack_1 && is_multi_1) {
            for(int i=0;i<5;i++)
                if(weapon_1_multi[i].getPosition().y*PPM<=height[(int)(weapon_1_multi[i].getPosition().x*PPM)]+(float)makeItRain[i].getHeight(play.getPlayer1().getTank())/3f){
                    float diff_1 = (float) Math.abs(weapon_1_multi[i].getPosition().x*PPM-play.getTank_2_position()-play.getPlayer2().getTank().getTank_width()/3f);
                    float diff_2 = (float) Math.abs(weapon_1_multi[i].getPosition().x*PPM-play.getTank_1_position()-play.getPlayer1().getTank().getTank_width()/3f);
                    if(diff_1<=100) {
                        play.getPlayer2().setHealth(Math.max(0, (int) (play.getPlayer2().getHealth() + 0.005 * diff_1 - 5)));
                        if (weapon_1_multi[i].getPosition().x * PPM > play.getTank_2_position() + play.getPlayer2().getTank().getTank_width() / 3f)
                            play.setTank_2_position(Math.max(80, play.getTank_2_position() - (int)(diff_1 + 20)));
                        else
                            play.setTank_2_position(Math.min(1000, play.getTank_2_position() + (int)(diff_1 + 20)));
                    }
                    if(diff_2<=100) {
                        play.getPlayer1().setHealth(Math.max(0, (int) (play.getPlayer1().getHealth() + 0.005 * diff_2 - 5)));
                        if (weapon_1_multi[i].getPosition().x * PPM > play.getTank_1_position() + play.getPlayer1().getTank().getTank_width() / 3f)
                            play.setTank_1_position(Math.max(80, play.getTank_1_position() - (int)(diff_2 + 20)));
                        else
                            play.setTank_1_position(Math.min(1000, play.getTank_1_position() + (int)(diff_2 + 20)));
                    }
                    play.updateTerrain(play.getPlayer1().getPower()*Game.getWIDTH()/320, (int)(weapon_1_multi[i].getPosition().x*PPM));
                    world.destroyBody(weapon_1_multi[i]);
                    count_1++;
                }
            if(count_1 == 5) {
                is_multi_1 = false;
                attack_1 = false;
                count_1 = 0;
            }
        }

        //Attack Tank 2
        try{
            if(attack_2 && !is_multi_2 && (weapon_2.getPosition().x*PPM>1050 || weapon_2.getPosition().x*PPM<30)) {
                throw new OutOfArenaException("Going out of frame");
            }
        }
        catch (OutOfArenaException e) {
            world.destroyBody(weapon_2);
            attack_2 = false;
        }
        if(attack_2 && !is_multi_2 && weapon_2.getPosition().y*PPM<=height[(int)(weapon_2.getPosition().x*PPM)]+(float)massiveDrop.getHeight(play.getPlayer2().getTank())/3f) {
            float diff_1 = (float) Math.abs(weapon_2.getPosition().x*PPM-play.getTank_2_position()-play.getPlayer2().getTank().getTank_width()/3f);
            float diff_2 = (float) Math.abs(weapon_2.getPosition().x*PPM-play.getTank_1_position()-play.getPlayer1().getTank().getTank_width()/3f);
            if(diff_1<=100) {
                play.getPlayer2().setHealth(Math.max(0, (int) (play.getPlayer2().getHealth() + 0.2 * diff_1 - 23)));
                if (weapon_2.getPosition().x * PPM > play.getTank_2_position() + play.getPlayer2().getTank().getTank_width() / 3f)
                    play.setTank_2_position(Math.max(80, play.getTank_2_position() - (int)(diff_1 + 100)));
                else
                    play.setTank_2_position(Math.min(1000, play.getTank_2_position() + (int)(diff_1 + 100)));
            }
            if(diff_2<=100) {
                play.getPlayer1().setHealth(Math.max(0, (int) (play.getPlayer1().getHealth() + 0.2 * diff_2 - 23)));
                if (weapon_2.getPosition().x * PPM > play.getTank_1_position() + play.getPlayer1().getTank().getTank_width() / 3f)
                    play.setTank_1_position(Math.max(80, play.getTank_1_position() - (int)(diff_2 + 100)));
                else
                    play.setTank_1_position(Math.min(1000, play.getTank_1_position() + (int)(diff_2 + 100)));
            }
            play.updateTerrain(play.getPlayer2().getPower() * Game.getWIDTH() / 320, (int) (weapon_2.getPosition().x * PPM));
            world.destroyBody(weapon_2);
            attack_2 = false;
        }
        else if(attack_2 && is_multi_2) {
            for(int i=0;i<5;i++)
                if(weapon_2_multi[i].getPosition().y*PPM<=height[(int)(weapon_2_multi[i].getPosition().x*PPM)]+(float)makeItRain[i].getHeight(play.getPlayer2().getTank())/3f){
                    float diff_1 = (float) Math.abs(weapon_2_multi[i].getPosition().x*PPM-play.getTank_2_position()-play.getPlayer2().getTank().getTank_width()/3f);
                    float diff_2 = (float) Math.abs(weapon_2_multi[i].getPosition().x*PPM-play.getTank_1_position()-play.getPlayer1().getTank().getTank_width()/3f);
                    if(diff_1<=100) {
                        play.getPlayer2().setHealth(Math.max(0, (int) (play.getPlayer2().getHealth() + 0.005 * diff_1 - 5)));
                        if (weapon_2_multi[i].getPosition().x * PPM > play.getTank_2_position() + play.getPlayer2().getTank().getTank_width() / 3f)
                            play.setTank_2_position(Math.max(80, play.getTank_2_position() - (int)(diff_1 + 20)));
                        else
                            play.setTank_2_position(Math.min(1000, play.getTank_2_position() + (int)(diff_1 + 20)));
                    }
                    if(diff_2<=100) {
                        play.getPlayer1().setHealth(Math.max(0, (int) (play.getPlayer1().getHealth() + 0.005 * diff_2 - 5)));
                        if (weapon_2_multi[i].getPosition().x * PPM > play.getTank_1_position() + play.getPlayer1().getTank().getTank_width() / 3f)
                            play.setTank_1_position(Math.max(80, play.getTank_1_position() - (int)(diff_2 + 20)));
                        else
                            play.setTank_1_position(Math.min(1000, play.getTank_1_position() + (int)(diff_2 + 20)));
                    }
                    play.updateTerrain(play.getPlayer2().getPower()*Game.getWIDTH()/320, (int)(weapon_2_multi[i].getPosition().x*PPM));
                    world.destroyBody(weapon_2_multi[i]);
                    count_2++;
                }
            if(count_2 == 5) {
                is_multi_2 = false;
                attack_2 = false;
                count_2 = 0;
            }
        }

        if(play.getTurn()) {

            weapon_count =  play.getPlayer1().getTank().getWeapons().size();
            Tank temp = play.getPlayer1().getTank();
            switch(weapon_count){
                case 4:
                    game.batch.draw(PLACEHOLDER_4, (float) PLACEHOLDER_X, (float) PLACEHOLDER_Y, (float) PLACEHOLDER_WIDTH_4, (float) PLACEHOLDER_HEIGHT);
                case 3:
                    game.batch.draw(PLACEHOLDER_3, (float) PLACEHOLDER_X, (float) PLACEHOLDER_Y, (float) PLACEHOLDER_WIDTH_3, (float) PLACEHOLDER_HEIGHT);
                case 2:
                    game.batch.draw(PLACEHOLDER_2, (float) PLACEHOLDER_X, (float) PLACEHOLDER_Y, (float) PLACEHOLDER_WIDTH_2, (float) PLACEHOLDER_HEIGHT);
                case 1:
                    game.batch.draw(PLACEHOLDER_1, (float) PLACEHOLDER_X, (float) PLACEHOLDER_Y, (float) PLACEHOLDER_WIDTH_1, (float) PLACEHOLDER_HEIGHT);
            }
            for(Weapon weapon : temp.getWeapons()){
                int index = temp.getWeapons().indexOf(weapon);
                if(!weapon.getIsSelected()) {
                    game.batch.draw(weapon.picture(temp), (float) (WEAPON_START_X + index * WEAPON_DIF), (float) WEAPON_START_Y, (float) WEAPON_WIDTH, (float) WEAPON_HEIGHT);
                }
                else{
                    game.batch.draw(WPN_SEL_BACK, (float) (WEAPON_START_X + index * WEAPON_DIF), (float) WEAPON_START_Y, (float) WEAPON_WIDTH, (float) WEAPON_HEIGHT);
                    game.batch.draw(selected_weapon.picture(temp), (float) (WEAPON_SEl_X_DIF + index * WEAPON_DIF  - Game.getWIDTH() / 3.86), (float) (WEAPON_SEL_Y_DIF), (float) WEAPON_WIDTH_SEL, (float) WEAPON_HEIGHT_SEL);
                }
            }

            if (Gdx.input.isKeyJustPressed(Input.Keys.D))
                play.getPlayer1().setPower(Math.min(10,play.getPlayer1().getPower()+1));
            if (Gdx.input.isKeyJustPressed(Input.Keys.A))
                play.getPlayer1().setPower(Math.max(1,play.getPlayer1().getPower()-1));
            if (Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(Input.Keys.W)) {
                updateAngle_1(1);
            }
            if (Gdx.input.isKeyPressed(Input.Keys.DOWN) || Gdx.input.isKeyPressed(Input.Keys.S)) {
                updateAngle_1(-1);
            }

            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && play.getPlayer1().getFuel() > 0) {
                play.setTank_1_position(play.getTank_1_position()+1);
                play.getPlayer1().setFuel(play.getPlayer1().getFuel() - 0.05f);
            }
            if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && play.getPlayer1().getFuel() > 0) {
                play.setTank_1_position(play.getTank_1_position()-1);
                play.getPlayer1().setFuel(play.getPlayer1().getFuel() - 0.05f);
            }
            if (Gdx.input.getX() > WEAPON_START_X && Gdx.input.getX() < WEAPON_START_X + WEAPON_WIDTH && y > WEAPON_START_Y && y < WEAPON_HEIGHT + WEAPON_START_Y){
                if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
                    for(Weapon weapon : play.getPlayer1().getTank().getWeapons()){
                        weapon.setIsSelected(false);
                    }
                    if(!temp.getWeapons().get(0).getIsSelected()) {
                        selected_weapon = temp.getWeapons().get(0);
                        play.getPlayer1().getTank().getWeapons().get(0).setIsSelected(true);
                        weaponSelected = true;
                        weapon_number = play.getPlayer1().getTank().getWeapons().get(0).getName();
                    }
                    else{
                        play.getPlayer1().getTank().getWeapons().get(0).setIsSelected(false);
                        weaponSelected = false;
                    }
                }
            }
            else if (Gdx.input.getX() > WEAPON_START_X + WEAPON_DIF&& Gdx.input.getX() < WEAPON_START_X + WEAPON_WIDTH + WEAPON_DIF && y > WEAPON_START_Y && y < WEAPON_HEIGHT + WEAPON_START_Y && temp.getWeapons().size() >= 2){
                if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
                    for(Weapon weapon : play.getPlayer1().getTank().getWeapons()){
                        weapon.setIsSelected(false);
                    }
                    if(!temp.getWeapons().get(1).getIsSelected()) {
                        selected_weapon = temp.getWeapons().get(1);
                        play.getPlayer1().getTank().getWeapons().get(1).setIsSelected(true);
                        weaponSelected = true;
                        weapon_number = play.getPlayer1().getTank().getWeapons().get(1).getName();
                    }
                    else{
                        play.getPlayer1().getTank().getWeapons().get(1).setIsSelected(false);
                        weaponSelected = false;
                    }
                }
            }
            else if (Gdx.input.getX() > WEAPON_START_X + 2*WEAPON_DIF&& Gdx.input.getX() < WEAPON_START_X + WEAPON_WIDTH + 2*WEAPON_DIF && y > WEAPON_START_Y && y < WEAPON_HEIGHT + WEAPON_START_Y && temp.getWeapons().size() >= 3){
                if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
                    for(Weapon weapon : play.getPlayer1().getTank().getWeapons()){
                        weapon.setIsSelected(false);
                    }
                    if(!temp.getWeapons().get(2).getIsSelected()) {
                        selected_weapon = temp.getWeapons().get(2);
                        play.getPlayer1().getTank().getWeapons().get(2).setIsSelected(true);
                        weaponSelected = true;
                        weapon_number = play.getPlayer1().getTank().getWeapons().get(2).getName();
                    }
                    else{
                        play.getPlayer1().getTank().getWeapons().get(2).setIsSelected(false);
                        weaponSelected = false;
                    }
                }
            }
            else if (Gdx.input.getX() > WEAPON_START_X + 3*WEAPON_DIF&& Gdx.input.getX() < WEAPON_START_X + WEAPON_WIDTH + 3*WEAPON_DIF && y > WEAPON_START_Y && y < WEAPON_HEIGHT + WEAPON_START_Y && temp.getWeapons().size() >= 4){
                if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
                    for(Weapon weapon : play.getPlayer1().getTank().getWeapons()){
                        weapon.setIsSelected(false);
                    }
                    if(!temp.getWeapons().get(3).getIsSelected()) {
                        selected_weapon = temp.getWeapons().get(3);
                        play.getPlayer1().getTank().getWeapons().get(3).setIsSelected(true);
                        weaponSelected = true;
                        weapon_number = play.getPlayer1().getTank().getWeapons().get(3).getName();
                    }
                    else{
                        play.getPlayer1().getTank().getWeapons().get(3).setIsSelected(false);
                        weaponSelected = false;
                    }
                }
            }
            if (Gdx.input.getX() > FIRE_X && Gdx.input.getX() < FIRE_X + FIRE_WIDTH && y > FIRE_Y && y < FIRE_Y + FIRE_HEIGHT){

                if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT) && weaponSelected){

                    switch(weapon_number)
                    {
                        case 0:
                            bodydef.type = BodyDef.BodyType.DynamicBody;
                            bodydef.position.set((play.getTank_1_position())/PPM,(height[play.getTank_1_position()]+30)/PPM);
                            fixturedef = new FixtureDef();
                            shape = new PolygonShape();
                            shape.setAsBox((float)theChosenOne.getWidth(play.getPlayer1().getTank())/(3*PPM),(float)theChosenOne.getHeight(play.getPlayer1().getTank())/(3*PPM));
                            fixturedef.shape = shape;
                            fixturedef.density = 500f;
                            fixturedef.friction = 0.2f;
                            fixturedef.restitution = 0;
                            weapon_1 = world.createBody(bodydef);
                            weapon_1.createFixture(fixturedef);
                            weapon_1.setLinearVelocity(new Vector2((float)(play.getPlayer1().getPower()*1.8*Math.cos(slope1+Math.toRadians(getAngle_1()))),(float)(play.getPlayer1().getPower()*1.8*Math.sin(slope1+Math.toRadians(getAngle_1())))));
                            attack_1 = true;
                            break;
                        case 1:
                            bodydef.type = BodyDef.BodyType.DynamicBody;
                            bodydef.position.set(play.getTank_1_position()/PPM,(height[play.getTank_1_position()]+30)/PPM);
                            fixturedef = new FixtureDef();
                            shape = new PolygonShape();
                            shape.setAsBox((float)sharpShooter.getWidth(play.getPlayer1().getTank())/(3*PPM),(float)sharpShooter.getHeight(play.getPlayer1().getTank())/(3*PPM));
                            fixturedef.shape = shape;
                            fixturedef.density = 500f;
                            fixturedef.friction = 0.2f;
                            fixturedef.restitution = 0;
                            weapon_1 = world.createBody(bodydef);
                            weapon_1.createFixture(fixturedef);
                            weapon_1.setLinearVelocity(new Vector2((float)(play.getPlayer1().getPower()*1.8*Math.cos(slope1+Math.toRadians(getAngle_1()))),(float)(play.getPlayer1().getPower()*1.8*Math.sin(slope1+Math.toRadians(getAngle_1())))));
                            attack_1 = true;
                            break;
                        case 3:
                            int[] position ={950, 935, 960, 940, 920};
                            for(int i=0;i<5;i++) {
                                makeItRain[i] = new MakeItRain();
                                bodydef.type = BodyDef.BodyType.DynamicBody;
                                bodydef.position.set(Math.min(950/PPM,(play.getTank_1_position()+play.getPlayer1().getPower()*Game.getWIDTH()/19.2f)/PPM)+(10*i)/PPM, position[i]/PPM);
                                fixturedef = new FixtureDef();
                                shape = new PolygonShape();
                                shape.setAsBox((float)makeItRain[i].getHeight(play.getPlayer1().getTank())/(3*PPM),(float)makeItRain[i].getWidth(play.getPlayer1().getTank())/(3*PPM));
                                fixturedef.shape = shape;
                                fixturedef.density = 500f;
                                fixturedef.friction = 0.2f;
                                fixturedef.restitution = 0;
                                weapon_1_multi[i] = world.createBody(bodydef);
                                weapon_1_multi[i].createFixture(fixturedef);
                            }
                            attack_1 = true;
                            is_multi_1 = true;
                            break;
                        case 4:
                            bodydef.type = BodyDef.BodyType.DynamicBody;
                            bodydef.position.set(Math.min(980/PPM,(play.getTank_1_position()+play.getPlayer1().getPower()*Game.getWIDTH()/19.2f)/PPM), 1000/PPM);
                            fixturedef = new FixtureDef();
                            shape = new PolygonShape();
                            shape.setAsBox((float)massiveDrop.getHeight(play.getPlayer1().getTank())/(3*PPM),(float)massiveDrop.getWidth(play.getPlayer1().getTank())/(3*PPM));
                            fixturedef.shape = shape;
                            fixturedef.density = 500f;
                            fixturedef.friction = 0.2f;
                            fixturedef.restitution = 0;
                            weapon_1 = world.createBody(bodydef);
                            weapon_1.createFixture(fixturedef);
                            attack_1 = true;
                            break;
                    }

                    for(Weapon weapon : play.getPlayer1().getTank().getWeapons()){
                        weapon.setIsSelected(false);
                    }
                    play.getPlayer1().getTank().getWeapons().remove(selected_weapon);

                    if(play.getPlayer1().getTank().getWeapons().isEmpty()){
                        play.getPlayer1().getTank().getWeapons().add(new TheChosenOne());
                        play.getPlayer1().getTank().getWeapons().add(new SharpShooter());
                        play.getPlayer1().getTank().getWeapons().add(new MakeItRain());
                        play.getPlayer1().getTank().getWeapons().add(new MassiveDrop());
                    }
                    play.setTurn(false);
                    play.getPlayer1().setFuel(10);
                    play.getPlayer1().setPower(10);
                    weaponSelected = false;
                }
            }
        }

        else{
            weapon_count =  play.getPlayer2().getTank().getWeapons().size();
            Tank temp2 = play.getPlayer2().getTank();
            switch(weapon_count){
                case 4:
                    game.batch.draw(PLACEHOLDER_4, (float) PLACEHOLDER_X, (float) PLACEHOLDER_Y, (float) PLACEHOLDER_WIDTH_4, (float) PLACEHOLDER_HEIGHT);
                case 3:
                    game.batch.draw(PLACEHOLDER_3, (float) PLACEHOLDER_X, (float) PLACEHOLDER_Y, (float) PLACEHOLDER_WIDTH_3, (float) PLACEHOLDER_HEIGHT);
                case 2:
                    game.batch.draw(PLACEHOLDER_2, (float) PLACEHOLDER_X, (float) PLACEHOLDER_Y, (float) PLACEHOLDER_WIDTH_2, (float) PLACEHOLDER_HEIGHT);
                case 1:
                    game.batch.draw(PLACEHOLDER_1, (float) PLACEHOLDER_X, (float) PLACEHOLDER_Y, (float) PLACEHOLDER_WIDTH_1, (float) PLACEHOLDER_HEIGHT);
            }
            for(Weapon weapon : temp2.getWeapons()){
                int index = temp2.getWeapons().indexOf(weapon);
                if(!weapon.getIsSelected()) {
                    game.batch.draw(weapon.picture(temp2), (float) (WEAPON_START_X + index * WEAPON_DIF), (float) WEAPON_START_Y, (float) WEAPON_WIDTH, (float) WEAPON_HEIGHT);
                }
                else{
                    game.batch.draw(WPN_SEL_BACK, (float) (WEAPON_START_X + index * WEAPON_DIF), (float) WEAPON_START_Y, (float) WEAPON_WIDTH, (float) WEAPON_HEIGHT);
                    game.batch.draw(selected_weapon.picture(temp2), (float) (WEAPON_SEl_X_DIF + index * WEAPON_DIF - Game.getWIDTH() / 3.86), (float) (WEAPON_SEL_Y_DIF), (float) WEAPON_WIDTH_SEL, (float) WEAPON_HEIGHT_SEL);
                }
            }
            if (Gdx.input.isKeyJustPressed(Input.Keys.D))
                play.getPlayer2().setPower(Math.min(10,play.getPlayer2().getPower()+1));
            if (Gdx.input.isKeyJustPressed(Input.Keys.A))
                play.getPlayer2().setPower(Math.max(1,play.getPlayer2().getPower()-1));
            if (Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(Input.Keys.W)) {
                updateAngle_2(-1);
            }
            if (Gdx.input.isKeyPressed(Input.Keys.DOWN) || Gdx.input.isKeyPressed(Input.Keys.S)) {
                updateAngle_2(1);
            }
            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && play.getPlayer2().getFuel() > 0) {
                play.setTank_2_position(play.getTank_2_position()+1);
                 play.getPlayer2().setFuel(play.getPlayer2().getFuel() - 0.05f);
            }
            if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && play.getPlayer2().getFuel() > 0) {
                play.setTank_2_position(play.getTank_2_position()-1);
                 play.getPlayer2().setFuel(play.getPlayer2().getFuel() - 0.05f);
            }
            if (Gdx.input.getX() > WEAPON_START_X && Gdx.input.getX() < WEAPON_START_X + WEAPON_WIDTH && y > WEAPON_START_Y && y < WEAPON_HEIGHT + WEAPON_START_Y){
                if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
                    for(Weapon weapon : play.getPlayer2().getTank().getWeapons()){
                        weapon.setIsSelected(false);
                    }
                    if(!temp2.getWeapons().get(0).getIsSelected()) {
                        selected_weapon = temp2.getWeapons().get(0);
                        play.getPlayer2().getTank().getWeapons().get(0).setIsSelected(true);
                        weaponSelected = true;
                        weapon_number = play.getPlayer2().getTank().getWeapons().get(0).getName();
                    }
                    else{
                        play.getPlayer2().getTank().getWeapons().get(0).setIsSelected(false);
                        weaponSelected = false;
                    }
                }
            }
            else if (Gdx.input.getX() > WEAPON_START_X + WEAPON_DIF&& Gdx.input.getX() < WEAPON_START_X + WEAPON_WIDTH + WEAPON_DIF && y > WEAPON_START_Y && y < WEAPON_HEIGHT + WEAPON_START_Y && temp2.getWeapons().size() >= 2){
                if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
                    for(Weapon weapon : play.getPlayer2().getTank().getWeapons()){
                        weapon.setIsSelected(false);
                    }
                    if(!temp2.getWeapons().get(1).getIsSelected()) {
                        selected_weapon = temp2.getWeapons().get(1);
                        play.getPlayer2().getTank().getWeapons().get(1).setIsSelected(true);
                        weaponSelected = true;
                        weapon_number = play.getPlayer2().getTank().getWeapons().get(1).getName();
                    }
                    else{
                        play.getPlayer2().getTank().getWeapons().get(1).setIsSelected(false);
                        weaponSelected = false;
                    }
                }
            }
            else if (Gdx.input.getX() > WEAPON_START_X + 2*WEAPON_DIF&& Gdx.input.getX() < WEAPON_START_X + WEAPON_WIDTH + 2*WEAPON_DIF && y > WEAPON_START_Y && y < WEAPON_HEIGHT + WEAPON_START_Y && temp2.getWeapons().size() >= 3){
                if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
                    for(Weapon weapon : play.getPlayer2().getTank().getWeapons()){
                        weapon.setIsSelected(false);
                    }
                    if(!temp2.getWeapons().get(2).getIsSelected()) {
                        selected_weapon = temp2.getWeapons().get(2);
                        play.getPlayer2().getTank().getWeapons().get(2).setIsSelected(true);
                        weaponSelected = true;
                        weapon_number = play.getPlayer2().getTank().getWeapons().get(2).getName();
                    }
                    else{
                        play.getPlayer2().getTank().getWeapons().get(2).setIsSelected(false);
                        weaponSelected = false;
                    }
                }
            }
            else if (Gdx.input.getX() > WEAPON_START_X + 3*WEAPON_DIF&& Gdx.input.getX() < WEAPON_START_X + WEAPON_WIDTH + 3*WEAPON_DIF && y > WEAPON_START_Y && y < WEAPON_HEIGHT + WEAPON_START_Y && temp2.getWeapons().size() >= 4){
                if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
                    for(Weapon weapon : play.getPlayer2().getTank().getWeapons()){
                        weapon.setIsSelected(false);
                    }
                    if(!temp2.getWeapons().get(3).getIsSelected()) {
                        selected_weapon = temp2.getWeapons().get(3);
                        play.getPlayer2().getTank().getWeapons().get(3).setIsSelected(true);
                        weaponSelected = true;
                        weapon_number = play.getPlayer2().getTank().getWeapons().get(3).getName();
                    }
                    else{
                        play.getPlayer2().getTank().getWeapons().get(3).setIsSelected(false);
                        weaponSelected = false;
                    }
                }
            }
            if (Gdx.input.getX() > FIRE_X && Gdx.input.getX() < FIRE_X + FIRE_WIDTH && y > FIRE_Y && y < FIRE_Y + FIRE_HEIGHT){
                if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT) && weaponSelected){

                    switch(weapon_number)
                    {
                        case 0:
                            bodydef.type = BodyDef.BodyType.DynamicBody;
                            bodydef.position.set((play.getTank_2_position())/PPM,(height[play.getTank_2_position()]+30)/PPM);
                            fixturedef = new FixtureDef();
                            shape = new PolygonShape();
                            shape.setAsBox((float)theChosenOne.getWidth(play.getPlayer2().getTank())/(3*PPM),(float)theChosenOne.getHeight(play.getPlayer2().getTank())/(3*PPM));
                            fixturedef.shape = shape;
                            fixturedef.density = 500f;
                            fixturedef.friction = 0.2f;
                            fixturedef.restitution = 0;
                            weapon_2 = world.createBody(bodydef);
                            weapon_2.createFixture(fixturedef);
                            weapon_2.setLinearVelocity(new Vector2((float)(play.getPlayer2().getPower()*(-1.8)*Math.cos(-slope2-Math.toRadians(getAngle_2()))),(float)(play.getPlayer2().getPower()*1.8*Math.sin(slope2+Math.toRadians(getAngle_2())))));
                            attack_2 = true;
                            break;
                        case 1:
                            bodydef.type = BodyDef.BodyType.DynamicBody;
                            bodydef.position.set(play.getTank_2_position()/PPM,(height[play.getTank_2_position()]+30)/PPM);
                            fixturedef = new FixtureDef();
                            shape = new PolygonShape();
                            shape.setAsBox((float)sharpShooter.getWidth(play.getPlayer2().getTank())/(3*PPM),(float)sharpShooter.getHeight(play.getPlayer2().getTank())/(3*PPM));
                            fixturedef.shape = shape;
                            fixturedef.density = 500f;
                            fixturedef.friction = 0.2f;
                            fixturedef.restitution = 0;
                            weapon_2 = world.createBody(bodydef);
                            weapon_2.createFixture(fixturedef);
                            weapon_2.setLinearVelocity(new Vector2((float)(play.getPlayer2().getPower()*(-1.8)*Math.cos(-slope2-Math.toRadians(getAngle_2()))),(float)(play.getPlayer2().getPower()*1.8*Math.sin(slope2+Math.toRadians(getAngle_2())))));
                            attack_2 = true;
                            break;
                        case 3:
                            int[] position ={950, 935, 960, 940, 920};
                            for(int i=0;i<5;i++) {
                                makeItRain[i] = new MakeItRain();
                                bodydef.type = BodyDef.BodyType.DynamicBody;
                                bodydef.position.set(Math.max(100/PPM,(play.getTank_2_position()-play.getPlayer2().getPower()*Game.getWIDTH()/19.2f)/PPM)+(10*i)/PPM, position[i]/PPM);
                                fixturedef = new FixtureDef();
                                shape = new PolygonShape();
                                shape.setAsBox((float)makeItRain[i].getHeight(play.getPlayer2().getTank())/(3*PPM),(float)makeItRain[i].getWidth(play.getPlayer2().getTank())/(3*PPM));
                                fixturedef.shape = shape;
                                fixturedef.density = 500f;
                                fixturedef.friction = 0.2f;
                                fixturedef.restitution = 0;
                                weapon_2_multi[i] = world.createBody(bodydef);
                                weapon_2_multi[i].createFixture(fixturedef);
                            }
                            attack_2 = true;
                            is_multi_2 = true;
                            break;
                        case 4:
                            bodydef.type = BodyDef.BodyType.DynamicBody;
                            bodydef.position.set(Math.max(100/PPM,(play.getTank_2_position()-play.getPlayer2().getPower()*Game.getWIDTH()/19.2f)/PPM), 1000/PPM);
                            fixturedef = new FixtureDef();
                            shape = new PolygonShape();
                            shape.setAsBox((float)massiveDrop.getHeight(play.getPlayer2().getTank())/(3*PPM),(float)massiveDrop.getWidth(play.getPlayer2().getTank())/(3*PPM));
                            fixturedef.shape = shape;
                            fixturedef.density = 500f;
                            fixturedef.friction = 0.2f;
                            fixturedef.restitution = 0;
                            weapon_2 = world.createBody(bodydef);
                            weapon_2.createFixture(fixturedef);
                            attack_2 = true;
                            break;
                    }

                    for(Weapon weapon : play.getPlayer2().getTank().getWeapons()){
                        weapon.setIsSelected(false);
                    }
                    play.getPlayer2().getTank().getWeapons().remove(selected_weapon);

                    if(play.getPlayer2().getTank().getWeapons().isEmpty()){
                        play.getPlayer2().getTank().getWeapons().add(new TheChosenOne());
                        play.getPlayer2().getTank().getWeapons().add(new SharpShooter());
                        play.getPlayer2().getTank().getWeapons().add(new MakeItRain());
                        play.getPlayer2().getTank().getWeapons().add(new MassiveDrop());
                    }
                    play.setTurn(true);
                    play.getPlayer2().setFuel(10);
                    play.getPlayer2().setPower(10);
                    weaponSelected = false;
                }
            }
        }


        //Fire
        game.batch.draw(FIRE_BUTTON, (float) FIRE_X, (float) FIRE_Y, (float) FIRE_WIDTH, (float) FIRE_HEIGHT);

        game.batch.draw(dot, play.getTank_1_position(), height[play.getTank_2_position()], 10, 10);

        try{
            if(play.getPlayer1().getHealth() <= 0) {
                throw new HealthZeroException("Player 2 Wins!");
            }
        }
        catch(HealthZeroException e){
            game.setScreen(new FinalWinScreen(game, 2));
        }

        try{
            if(play.getPlayer2().getHealth() <= 0) {
                throw new HealthZeroException("Player 1 Wins!");
            }
        }
        catch(HealthZeroException e){
            game.setScreen(new FinalWinScreen(game, 1));
        }
        game.batch.end();
    }

    public void update(float delta)
    {
        world.step(Gdx.graphics.getDeltaTime(), 8, 3);
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
        dispose();
    }
    @Override
    public void dispose() {
        world.dispose();
        debugRenderer.dispose();
        ground.getTexture().dispose();
    }
}
