package org.example;

public abstract class Enemy implements EnemyFactory {
    private int speed;
    private int health;
    private int reward;

    public Enemy( int speed, int health, int reward){
        this.speed = speed;
        this.health = health;
        this.reward = reward;
    }
    @Override
    public void move() {
        //movePosicion speed veces
    }
    @Override
    public void damageHealth() {
        //actualiza salud
    }
    @Override
    public boolean defeated() {
        //verifica si fue derrotado
        return false;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }
}

