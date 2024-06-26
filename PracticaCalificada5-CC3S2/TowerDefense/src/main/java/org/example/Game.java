package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Map map;
    private Player player;
    private Scanner in = new Scanner(System.in);

    public Game(Map map, Player player) {
        this.map = map;
        this.player = player;
    }

    public void startGame() {
        int nOleada = 1;
        List<Wave> wave = new ArrayList<>();
        while (player.getBaseHealth() > 0) {
            System.out.println("______ENTRADA:______");
            System.out.print("PLACE_TOWER Cannon ");
            int raw = in.nextInt();
            int column = in.nextInt();
            map.placeTower(raw - 1, column - 1);
            System.out.print("START_WAVE...\n");
            System.out.println("______SALIDA:______");
            System.out.println("Torre Cannon colocada en (" + raw + ", " + column + ")");
            wave.add(new Wave(nOleada));
            System.out.println("Oleada " + nOleada + " iniciada");
            System.out.println("Enemigos en camino...");
            map.addEnemies(wave.get(nOleada - 1).getEnemies());
            System.out.println("Estado del juego:");
            map.printMap();
            System.out.println("Puntuación: " + player.getScore());
            System.out.println("Vida de la base: " + player.getBaseHealth());
            System.out.println();
            nOleada++;
        }
        System.out.println("GAME OVER");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game(new Map(), new Player());
        game.startGame();
    }
}
