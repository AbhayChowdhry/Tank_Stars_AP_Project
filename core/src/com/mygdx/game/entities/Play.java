package com.mygdx.game.entities;

import com.mygdx.game.Game;

public class Play {
    private Player player1;
    private Player player2;
    private float[] terrain=new float[Game.getWIDTH()];

    private int impact_rad, impact_coord;
    private boolean turn;

    public Play() {
        player1 = new Player(new Pinky());
        player2 = new Player(new Pumpkin());
        int[] arr=new int[4];
        for(int i=0;i<4;i++)
            arr[i]=(int)(Math.random()*(2));
        for(int i=0;i<Game.getWIDTH();i++)
        {
            double x=(double)i/100;
            terrain[i]=0;
            for(int j=0;j<4;j++)
            {
                if(arr[j]==1)
                    terrain[i]+=Math.pow(Math.sin(x/Math.pow(2,j)),2);
                else
                    terrain[i]+=Math.pow(Math.cos(x/Math.pow(2,j)),2);
            }
            terrain[i]*=Game.getHEIGHT()/10.0;
        }
        turn = true;
    }

    public float[] getTerrain() {
        return terrain;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public boolean getTurn() {
        return turn;
    }


    public void updateTerrain(int impact_rad, int impact_coord) {
        float[] terrain=getTerrain();
        float height=terrain[impact_coord]+(float)(impact_rad/(Game.getHEIGHT()/175));
        for(int i=0;i<=impact_rad;i++)
            if(impact_coord+i<Game.getWIDTH())
                terrain[impact_coord + i] = Math.min(terrain[impact_coord + i], height - (float) Math.pow(impact_rad * impact_rad - i * i, 0.5));
        for(int i=0;i<=impact_rad;i++)
            if(impact_coord-i>=0)
                terrain[impact_coord - i] = Math.min(terrain[impact_coord - i], height - (float) Math.pow(impact_rad * impact_rad - i * i, 0.5));
    }

    //make a method to calculate radius of impact
    //sent that r and x to terrain
    //terrian will modify heights accordingly and draw it in the next second


}
