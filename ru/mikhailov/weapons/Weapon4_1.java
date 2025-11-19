package ru.mikhailov.weapons;

abstract class Weapon4_1 {
    private int ammo;

    public Weapon4_1(int ammo) {
        if (ammo < 0)
            throw new RuntimeException();
        this.ammo = ammo;
    }

    abstract void shoot();

    public int ammo() {
        return ammo;
    }

    public boolean getAmmo() {
        if (ammo == 0)
            return false;
        ammo--;
        return false;
    }

    public int load(int ammo) {
        if (ammo < 0)
            throw new RuntimeException();
        int tmp = ammo;
        this.ammo = ammo;
        return tmp;
    }
}
