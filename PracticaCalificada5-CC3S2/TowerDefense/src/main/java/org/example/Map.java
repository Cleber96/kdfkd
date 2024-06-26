package org.example;

import java.util.List;
import java.util.Random;

public class Map {
    private final int DIMENSION = 5;
    private final int EMPTY = 0;
    private final int PATH = 1;
    private final int BASE = 2;
    public int[][] grid;
    Random rand = new Random();
    public Map() {
        grid = new int[DIMENSION][DIMENSION];
        for(int i = 0; i < DIMENSION; i++) {
            for(int j = 0; j < DIMENSION; j++) {
                grid[i][j] = 0;
            }
        }
        grid[rand.nextInt(DIMENSION)][rand.nextInt(DIMENSION)] = 2; //se coloca base
        int nCaminos = 0;
        while(nCaminos < DIMENSION) {
            int fila = rand.nextInt(DIMENSION);
            int columna = rand.nextInt(DIMENSION);
            if(grid[fila][columna] == 0) {
                grid[fila][columna] = 1;
                nCaminos++;
            }
        }
    }
    public boolean isValidPosition(int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            return false;
        }
        return grid[x][y] == EMPTY;
    }
    public boolean placeTower(int x, int y) {
        if (isValidPosition(x, y)) {
            grid[x][y] = 3;
            return true;
        }
        return false;
    }
    public void addEnemies(List<Enemy> enemies) {
        System.out.println("añadidos");
    }
    public void printMap() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(getSymbol(grid[i][j]));
            }
            System.out.println();
        }
    }

    public String getSymbol(int cellType) {
        switch (cellType) {
            case EMPTY:
                return "[ ]";
            case PATH:
                return "[C]";
            case BASE:
                return "[B]";
            case 3:
                return "[T]";
            default:
                return "[ ]";
        }
    }
}
