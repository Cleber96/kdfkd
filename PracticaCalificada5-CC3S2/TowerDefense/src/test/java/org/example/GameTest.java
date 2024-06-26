package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.mockito.Mockito.*;

public class GameTest {
    @Mock private Map map;
    @Mock private Player player;
    private Game game;
    private Scanner scanner;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        ByteArrayInputStream inContent = new ByteArrayInputStream("1 1\n".getBytes());
        scanner = new Scanner(inContent);
        game = new Game(map, player);
    }

    @Test
    public void testGameProcess() {
        when(player.getBaseHealth()).thenReturn(100, 50, 0);
        game.startGame();
        verify(map).placeTower(0, 0);
        verify(map, atLeastOnce()).addEnemies(any());
        verify(player, times(3)).getBaseHealth();
    }
}
