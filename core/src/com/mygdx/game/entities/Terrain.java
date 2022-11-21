package com.mygdx.game.entities;

import java.util.*;
import com.mygdx.game.Game;

public class Terrain {
    private static int[] height=new int[Game.getWIDTH()];

    public void generateTerrain () {
        height[0] = 85;
        for(int i=1;i<Game.getWIDTH();i++) {
            height[i]=height[i-1]+(int)(Math.random()*(11)-5);
            if(height[i]<0)
                height[i]=0;
            else if(height[i]>140)
                height[i]=140;
        }
    }

//    public void updateTerrian(int r, int x) {
//
//    }

    public static int[] getHeight() {
        return height;
    }
}
