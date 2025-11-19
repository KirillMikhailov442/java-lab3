package ru.mikhailov.weapons;

public class Shooter {
    private String name;
    private Pistol1_5 gun;

    public Shooter(String name) {
        this.name = name;
    }

    public Shooter(String name, Pistol1_5 gun) {
        this.name = name;
        this.gun = gun;
    }

    public void fire() {
        if (gun != null) {
            System.out.println(gun);
        } else {
            System.out.println("Не могу участвовать в перестрелке");
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGun(Pistol1_5 gun) {
        this.gun = gun;
    }

    public String getName() {
        return name;
    }

    public Pistol1_5 getGun() {
        return gun;
    }
}
