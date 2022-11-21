package com.mygdx.game.entities;

public class Play {
    private Player player1;
    private Player player2;
    private Terrain terrain;

    public Play() {
        Player player1 = new Player();
        Player player2 = new Player();
        Terrain terrain = new Terrain();
    }

//    public Terrain getTerrain() {
//        return terrain;
//    }

    //make a method to calculate radius of impact
    //sent that r and x to terrain
    //terrian will modify heights accordingly and draw it in the next second


}
