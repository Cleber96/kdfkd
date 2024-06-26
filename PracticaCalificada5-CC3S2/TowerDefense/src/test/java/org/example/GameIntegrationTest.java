package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.mockito.Mockito.*;

class GameIntegrationTest {
    @Mock private Map map;
    @Mock private Player player;
    @Mock private Wave wave;
    private Game game;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        System.setIn(new ByteArrayInputStream("1 1\n".getBytes()));
        game = new Game(map, player);
    }

    @Test
    void testGameProcess() {
        // Configure mocks
        when(player.getBaseHealth()).thenReturn(100, 50, 0);
        when(wave.getEnemies()).thenReturn(java.util.Collections.emptyList());
        doNothing().when(map).addEnemies(any());

        game.startGame();
        verify(map, times(1)).placeTower(0, 0);
        verify(map, times(1)).addEnemies(any());
        verify(player, atLeast(2)).getBaseHealth();
        verify(player, times(1)).getScore();
    }

    @Test
    void testWaveInteractions() {
        when(wave.getEnemies()).thenReturn(java.util.Collections.emptyList());
        when(player.getBaseHealth()).thenReturn(100, 0);
        when(map.placeTower(anyInt(), anyInt())).thenReturn(true);
        game.startGame();
        verify(map, times(1)).addEnemies(any());
    }
}
