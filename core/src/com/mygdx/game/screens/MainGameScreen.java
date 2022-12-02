package com.mygdx.game.screens;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Game;
import com.mygdx.game.entities.*;

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

    Texture FIRE_BUTTON = new Texture("FIRE_BUTTON.png");
    Texture FUEL = new Texture("FUEL.png");
    Texture FUEL_BACK = new Texture("FUEL_BACK.png");
    Texture FUEL_CURR = new Texture("FUEL_CURR.png");

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

    private static final double FIRE_X = Game.getWIDTH() / 1.207;
    private static final double FIRE_Y = Game.getHEIGHT() / 25.714;

    private static final double FIRE_HEIGHT = Game.getHEIGHT() / 9.231;
    private static final double FIRE_WIDTH = Game.getWIDTH() / 10.667;



    private static final float PPM = 32f;
    boolean isPaused = false;
    int x = 0;
    private World world;
    private Box2DDebugRenderer debugRenderer;
    private final OrthographicCamera camera;

    Game game;
//    Texture img;
//    private Pumpkin pumpkin;
//    Player player1 = new Player(1, pumpkin);
//    Player player2 = new Player(2, pumpkin);
    Play play=new Play();
    Body body;
    public MainGameScreen (Game game, int tank1, int tank2){
        this.game = game;
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

        world = new World(new Vector2(0,-9.18f), false);
        debugRenderer = new Box2DDebugRenderer();

        this.camera = new OrthographicCamera();
        this.camera.setToOrtho(false, Game.getWIDTH(), Game.getHEIGHT());

        game.batch.setProjectionMatrix(camera.combined);

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
        world = new World(new Vector2(0,-9.81f), false);
        debugRenderer = new Box2DDebugRenderer();
        camera.setToOrtho(false, Game.getWIDTH(), Game.getHEIGHT());
        debugRenderer.render(world, camera.combined.cpy().scl(PPM));

        BodyDef bodydef = new BodyDef();

        float[] height=play.getTerrain();
//        BodyDef bodydef = new BodyDef();
        for(int i=0;i<Game.getWIDTH();i++)
        {
            bodydef.type = BodyDef.BodyType.StaticBody;
            bodydef.position.set(i/PPM,0);
            PolygonShape shape = new PolygonShape();
            shape.setAsBox(1/PPM, height[i]/PPM);
            FixtureDef fixturedef = new FixtureDef();
            fixturedef.shape = shape;
            world.createBody(bodydef).createFixture(fixturedef);

        }

        bodydef.type = BodyDef.BodyType.DynamicBody;
        bodydef.position.set(Game.getWIDTH()/(2*PPM),Game.getHEIGHT()/(2*PPM));
//
        CircleShape shape = new CircleShape();
        shape.setRadius(0.5f);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 2.5f;
        fixtureDef.friction = 0.25f;
        fixtureDef.restitution = 0.75f;
        world.createBody(bodydef).createFixture(fixtureDef);
////
//        bodydef.type = BodyDef.BodyType.StaticBody;
//        bodydef.position.set(0,0);
//
//        ChainShape ground = new ChainShape();
//        ground.createChain(new Vector2[]{new Vector2(0,0), new Vector2(1080/PPM,607/PPM)});
//
//        fixtureDef.shape = ground;
//        fixtureDef.friction = 0.5f;
//        fixtureDef.restitution = 0;
//        world.createBody(bodydef).createFixture(fixtureDef);


//        shape.dispose();



        //game = new Game();
//        Image image1 = new Image(player1_body);
//        image1.setPosition(player1.getTank().getX_body(), 215);
//        stage.addActor(image1);
    }
    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        world.step(Gdx.graphics.getDeltaTime(), 8, 3);
        debugRenderer.render(world, camera.combined.cpy().scl(PPM));

        game.batch.begin();
        //Background
//        game.batch.draw(BACKGROUND, 0, 0, Game.getWIDTH(), Game.getHEIGHT());
//
//        //Health
//        game.batch.draw(HEALTH_LOGO_P1, (float) HEALTH_LOGO_X1, (float) HEALTH_LOGO_Y, (float) HEALTH_LOGO_WIDTH, (float) HEALTH_LOGO_HEIGHT);
//        game.batch.draw(HEALTH_LOGO_P2, (float) HEALTH_LOGO_X2, (float) HEALTH_LOGO_Y, (float) HEALTH_LOGO_WIDTH, (float) HEALTH_LOGO_HEIGHT);
//        game.batch.draw(VS, (float) VS_X, (float) VS_Y, (float) VS_WIDTH, (float) VS_HEIGHT);
//        int health1 = play.getPlayer1().getHealth();
//        game.batch.draw(HEALTH_CURR_P1, (float) HEALTH_CURR_X1, (float) HEALTH_CURR_Y, (float) (HEALTH_CURR_WIDTH/100 * health1), (float) HEALTH_CURR_HEIGHT);
//        int health2 = play.getPlayer2().getHealth();
//        game.batch.draw(HEALTH_CURR_P2, (float) (HEALTH_CURR_X2 + HEALTH_CURR_WIDTH - HEALTH_CURR_WIDTH/100 * health2), (float) HEALTH_CURR_Y, (float) (HEALTH_CURR_WIDTH/100 *health2), (float) HEALTH_CURR_HEIGHT);
//
//        //Fire
//        game.batch.draw(FIRE_BUTTON, (float) FIRE_X, (float) FIRE_Y, (float) FIRE_WIDTH, (float) FIRE_HEIGHT);
//
//        //Pause Menu
//        int y = Game.getHEIGHT() - Gdx.input.getY();
//        if(isPaused == false) {
//            game.batch.draw(PAUSE_INACTIVE, (float) PAUSE_X, (float) PAUSE_Y, (float) PAUSE_WIDTH, (float) PAUSE_HEIGHT);
//            if(Gdx.input.getX() > PAUSE_X && Gdx.input.getX() < PAUSE_X + PAUSE_WIDTH && y > PAUSE_Y && y < PAUSE_Y + PAUSE_HEIGHT){
//                game.batch.draw(PAUSE_ACTIVE, (float) PAUSE_X, (float) PAUSE_Y, (float) PAUSE_WIDTH, (float) PAUSE_HEIGHT);
//                if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
//                    isPaused = true;
//                }
//            }
//        }
//        else {
//            game.batch.draw(PAUSE_ACTIVE, (float) PAUSE_X, (float) PAUSE_Y, (float) PAUSE_WIDTH, (float) PAUSE_HEIGHT);
//            game.batch.draw(RESUME_INACTIVE, (float) BUTTON_X, (float) (BUTTON_Y), (float) BUTTON_WIDTH, (float) BUTTON_HEIGHT);
//            game.batch.draw(SAVE_INACTIVE, (float) BUTTON_X, (float) (BUTTON_Y - BUTTON_DIF), (float) BUTTON_WIDTH, (float) BUTTON_HEIGHT);
//            game.batch.draw(EXIT_INACTIVE, (float) BUTTON_X, (float) (BUTTON_Y - 2 * BUTTON_DIF), (float) BUTTON_WIDTH, (float) BUTTON_HEIGHT);
//            if (Gdx.input.getX() > PAUSE_X && Gdx.input.getX() < PAUSE_X + PAUSE_WIDTH && y > PAUSE_Y && y < PAUSE_Y + PAUSE_HEIGHT) {
//                game.batch.draw(PAUSE_ACTIVE, (float) PAUSE_X, (float) PAUSE_Y, (float) PAUSE_WIDTH, (float) PAUSE_HEIGHT);
//                if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
//                    isPaused = false;
//                }
//            }
//            else if(Gdx.input.getX() > BUTTON_X && Gdx.input.getX() < BUTTON_X + BUTTON_WIDTH && y > BUTTON_Y && y < BUTTON_Y + BUTTON_HEIGHT){
//                game.batch.draw(RESUME_ACTIVE, (float) BUTTON_X, (float) (BUTTON_Y), (float) BUTTON_WIDTH, (float) BUTTON_HEIGHT);
//                if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
//                    isPaused = false;
//                }
//            }
//            else if(Gdx.input.getX() > BUTTON_X && Gdx.input.getX() < BUTTON_X + BUTTON_WIDTH && y > BUTTON_Y - BUTTON_DIF && y < BUTTON_Y + BUTTON_HEIGHT - BUTTON_DIF){
//                game.batch.draw(SAVE_ACTIVE, (float) BUTTON_X, (float) (BUTTON_Y - BUTTON_DIF), (float) BUTTON_WIDTH, (float) BUTTON_HEIGHT);
//                if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
//                    //
//                }
//            }
//            else if(Gdx.input.getX() > BUTTON_X && Gdx.input.getX() < BUTTON_X + BUTTON_WIDTH && y > BUTTON_Y - 2* BUTTON_DIF && y < BUTTON_Y + BUTTON_HEIGHT - 2* BUTTON_DIF){
//                game.batch.draw(EXIT_ACTIVE, (float) BUTTON_X, (float) (BUTTON_Y - 2 * BUTTON_DIF), (float) BUTTON_WIDTH, (float) BUTTON_HEIGHT);
//                if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
//                    game.setScreen(new MainMenuScreen(game));
//                }
//            }
//        }
//
//        //Fuel
//        game.batch.draw(FUEL_BACK, (float) FUEL_BACK_X, (float) FUEL_BACK_Y, (float) FUEL_BACK_WIDTH, (float) FUEL_BACK_HEIGHT);
//        int fuel;
//        if(play.getTurn())
//            fuel=play.getPlayer1().getFuel();
//        else
//            fuel=play.getPlayer2().getFuel();
//        game.batch.draw(FUEL_CURR, (float) FUEL_CURR_X, (float) FUEL_CURR_Y, (float) (FUEL_CURR_WIDTH/10*fuel), (float) FUEL_CURR_HEIGHT);
//        game.batch.draw(FUEL, (float) FUEL_X, (float) FUEL_Y, (float) FUEL_WIDTH, (float) FUEL_HEIGHT);

//        float[] height=play.getTerrain();
//        BodyDef bodydef = new BodyDef();
//        for(int i=0;i<Game.getWIDTH();i++)
//        {
//            bodydef.type = BodyDef.BodyType.StaticBody;
//            bodydef.position.set(i/PPM,0);
//            PolygonShape shape = new PolygonShape();
//            shape.setAsBox(1/PPM, height[i]/PPM);
//            FixtureDef fixturedef = new FixtureDef();
//            fixturedef.shape = shape;
//            world.createBody(bodydef).createFixture(fixturedef);
//
//        }

//        bodydef.position.set(Game.getWIDTH()/(2*PPM),Game.getHEIGHT()/(2*PPM));
//
//        CircleShape shape = new CircleShape();
//        shape.setRadius(0.5f);
//
//        FixtureDef fixtureDef = new FixtureDef();
//        fixtureDef.shape = shape;
//        fixtureDef.density = 2.5f;
//        fixtureDef.friction = 0.25f;
//        fixtureDef.restitution = 0.75f;
//        world.createBody(bodydef).createFixture(fixtureDef);

//        float[] height=play.getTerrain();
//        for(int i=0;i<Game.getWIDTH();i++){
//            game.batch.draw(TERRAIN, i, 0, 1, height[i]);
//            game.batch.draw(TERR_BORDER, i, height[i], 1, Game.getHEIGHT()/120);
//        }

//        ground.setPosition(10,0);
//        ground.setSize(1,100);
//        ground.draw(game.batch);
//        float[] height=play.getTerrain();
//        for(int i=0;i<Game.getWIDTH();i++) {
//            ground.setPosition(i,0);
//            ground.setSize(1,height[i]);
//            ground.draw(game.batch);
//            System.out.println(i+" "+height[i]);
//        }

//
//

//        game.batch.draw(FUEL_CURR, (float) FUEL_CURR_X, (float) FUEL_CURR_Y, (float) (FUEL_CURR_WIDTH), (float) FUEL_CURR_HEIGHT);

//        // player1_tank.getBody().setOrigin((float) player1_tank.getTank_width()/2, 0);
//        player1_tank.getBody().setPosition(x, height[x]);
//        player1_tank.getBody().setSize((float) player1_tank.getTank_width()/2, (float) player1_tank.getTank_height()/2);
//        //game.batch.draw(player1_tank.getBody());
//        player1_tank.getBody().draw(game.batch);
//                p1_body.setPosition(player1.getTank().getX_body(),player1.getTank().getY_body());
//                p1_snout.setPosition(player1.getTank().getX_snout(),player1.getTank().getY_snout() + 102);

////        p2_body.setPosition(player2.getTank().getX_body() + Game.getWIDTH()*3/4,player1.getTank().getY_body());
////        p2_snout.setPosition(player2.getTank().getX_snout() + Game.getWIDTH()*3/4,player1.getTank().getY_snout() + 102);
////
////        p1_snout.draw(game.batch);
////        p1_body.draw(game.batch);
////
////        p2_snout.draw(game.batch);
////        p2_body.draw(game.batch);
////        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
////            p1_snout.setRotation(p1_snout.getRotation() + 1);
////        }
////        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
////            p1_snout.setRotation(p1_snout.getRotation() - 1);
////        }
//        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
//            x -= 3;
//        }
//        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
//            x += 3;
//        }
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
    }
}
