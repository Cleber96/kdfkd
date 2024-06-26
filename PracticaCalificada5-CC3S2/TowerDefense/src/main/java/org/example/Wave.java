package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Wave {
    private List<Enemy> enemies;
    private int waveNumber;
    Random rand = new Random();
    public Wave(int waveNumber) {
        this.waveNumber = waveNumber;
        this.enemies = generateEnemies(waveNumber);
    }
    private List<Enemy> generateEnemies(int waveNumber) {
        List<Enemy> enemies = new ArrayList<>();
        for (int i = 0; i < waveNumber * 5; i++) {
            if(rand.nextBoolean()) {
                enemies.add(new BasicEnemy());
            } else {
                enemies.add(new FastEnemy());
            }
        }
        if (waveNumber % 5 == 0) {
            enemies.add(new BossEnemy());
        }
        return enemies;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public int getWaveNumber() {
        return waveNumber;
    }
}
