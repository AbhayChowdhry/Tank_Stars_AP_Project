package com.mygdx.game.entities;

import com.mygdx.game.Game;

public class Play {
    private Player player1;
    private Player player2;
    private static float[] terrain=new float[Game.getWIDTH()];

    float impact_rad;
    int impact_coord;

    public Play() {
        Player player1 = new Player();
        Player player2 = new Player();
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
            terrain[i]*=Game.getHEIGHT()/10;
        }
    }

    public static float[] getTerrain() {
        return terrain;
    }

//    public void updateTerrain(float impact_rad, float impact_coord) {
//        float height=terrain[impact_coord];
//        for(int i=0;i<=impact_rad;i++)
//        {
//
//        }
//    }

    //make a method to calculate radius of impact
    //sent that r and x to terrain
    //terrian will modify heights accordingly and draw it in the next second


}
