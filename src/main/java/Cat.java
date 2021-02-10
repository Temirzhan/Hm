

import java.io.Serializable;


public class Cat {
    private String name;
    private int health;
    private int damage;
    private boolean satiety;

    public Cat(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.satiety = false;
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.satiety = false;
    }

    public void takeHit(Cat another) {
        this.health -= another.getDamage();
        if (this.health > 0) System.out.println("Got a hit. Health is now " + health);
        if (this.health <= 0) {
            System.out.println(name + "dead");
            throw new RuntimeException("This cat is dead!!!");
        }
    }

    public void kick(Cat another) {
        System.out.println(this.name + " hits " + another.name);
        another.takeHit(this);
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public boolean isSatiety() {
        return satiety;
    }
}
