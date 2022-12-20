package com.mygdx.game.junit;
import com.mygdx.game.Game;
import com.mygdx.game.entities.Play;

import org.junit.Test;
import static org.junit.Assert.assertNotSame;


public class MyTest {

    @Test
    public void testTerrain() {
        Play play = new Play();
        float terrain[] = play.getTerrain();

        for(int i=0; i< Game.getWIDTH(); i++){
            for(int j=Game.getHEIGHT()/2; j< Game.getHEIGHT(); j++) {
                assertNotSame(terrain[i], j);
            }
        }

    }
}
