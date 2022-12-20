package com.mygdx.game.junit;
import com.mygdx.game.Game;
import com.mygdx.game.entities.Play;

import com.mygdx.game.entities.Player;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;


public class MyTest2 {

    @Test
    public void testTerrain() {

        Player player = new Player();
        assertEquals(player.getHealth(), 100);

    }
}
