package com.mygdx.game.entities;

import com.mygdx.game.Game;

import java.io.Serializable;

public class Play implements Serializable {
    private Player player1;
    private Player player2;
    private int player1_tank_number;
    private int player2_tank_number;
    private float[] terrain=new float[Game.getWIDTH()];

    private int impact_rad, impact_coord;
    private boolean turn; // TRUE for player1 and FALSE for player2
    private int tank_1_position;
    private int tank_2_position;

    public Play() {
        player1 = new Player();
        player2 = new Player();
        int[] arr=new int[4];
        for(int i=0;i<4;i++)
            arr[i]=(int)(Math.random()*(2));
        for(int i=0;i<Game.getWIDTH();i++)
        {
//            terrain[i]=100;
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
//        updateTerrain(100, 300);
        turn = true;

        tank_1_position =200;
        tank_2_position =800;
    }

    public int getTank_1_position() {
        return tank_1_position;
    }

    public int getTank_2_position() {
        return tank_2_position;
    }

    public void setTank_1_position(int tank_1_position) {
        this.tank_1_position = tank_1_position;
    }

    public void setTank_2_position(int tank_2_position) {
        this.tank_2_position = tank_2_position;
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

    public void setTurn(boolean turn) {
        this.turn = turn;
    }


    public void updateTerrain(int impact_rad, int impact_coord) {
        float[] terrain=getTerrain();
        float height=terrain[impact_coord]+(float)(impact_rad/(Game.getHEIGHT()/175));
        for(int i=0;i<=impact_rad;i++)
            if(impact_coord+i<Game.getWIDTH())
            {
                terrain[impact_coord + i] = Math.min(terrain[impact_coord + i], height - (float) Math.pow(impact_rad * impact_rad - i * i, 0.5));
                terrain[impact_coord + i] = Math.max(0, terrain[impact_coord + i]); }
        for(int i=0;i<=impact_rad;i++)
            if(impact_coord-i>=0)
            {
                terrain[impact_coord - i] = Math.min(terrain[impact_coord - i], height - (float) Math.pow(impact_rad * impact_rad - i * i, 0.5));
                terrain[impact_coord - i] = Math.max(0, terrain[impact_coord - i]); }
    }

    public int getPlayer1_tank_number() {
        return player1_tank_number;
    }

    public int getPlayer2_tank_number() {
        return player2_tank_number;
    }

    public void setPlayer1_tank_number() {
        Tank tank = player1.getTank();
        if(tank instanceof Pumpkin){
            this.player1_tank_number = 2;

        }
        else if(tank instanceof Atomic){
            this.player1_tank_number = 1;

        }
        else if(tank instanceof Toxic){
            this.player1_tank_number = 3;
        }
        else if(tank instanceof Pinky){
            this.player1_tank_number = 4;
        }
    }
    public void setPlayer2_tank_number() {
        Tank tank = player2.getTank();
        if(tank instanceof Pumpkin){
            this.player2_tank_number = 2;

        }
        else if(tank instanceof Atomic){
            this.player2_tank_number = 1;

        }
        else if(tank instanceof Toxic){
            this.player2_tank_number = 3;
        }
        else if(tank instanceof Pinky){
            this.player2_tank_number = 4;
        }
    }


}
