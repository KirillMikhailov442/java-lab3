package ru.mikhailov.main;

import java.util.Scanner;

import ru.mikhailov.buildings.House;
import ru.mikhailov.geometry.Dot;
import ru.mikhailov.structures.ImmutableArray;
import ru.mikhailov.weapons.AutomaticRifle;
import ru.mikhailov.weapons.Pistol1_5;
import ru.mikhailov.weapons.Pistol4_1;
import ru.mikhailov.weapons.Shooter;
import ru.mikhailov.weapons.WeaponExample;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int task = 0;
        int subtask = 0;

        while (true) {
            System.out.print("Введите номер задания: ");
            if (scanner.hasNextInt()) {
                task = scanner.nextInt();
                break;
            } else {
                System.out.println("Некорректное число");
                scanner.next();
            }
        }

        while (true) {
            System.out.print("Введите номер задачи: ");
            if (scanner.hasNextInt()) {
                subtask = scanner.nextInt();
                break;
            } else {
                System.out.println("Некорректное число");
                scanner.next();
            }
        }

        if (task == 1 && subtask == 1) {
            House house = new House(1);
            house.setFloors(-1);
            System.out.println(house);

            House house2 = new House(-1);
            System.out.println(house2);
        }

        else if (task == 1 && subtask == 5) {
            Pistol1_5 pistol = new Pistol1_5(3, 7);
            pistol.fire();
            pistol.fire();
            pistol.fire();
            pistol.fire();
            pistol.fire();
            pistol.reload(8);
            pistol.fire();
            pistol.fire();
            pistol.unload();
            pistol.fire();
        }

        else if (task == 2 && subtask == 1) {
            int[] values = { 1, 2, 3 };
            ImmutableArray immutableArray1 = new ImmutableArray(values);
            ImmutableArray immutableArray2 = new ImmutableArray(1, 2, 3);
            ImmutableArray immutableArray3 = new ImmutableArray(immutableArray2);

            System.out.printf("Позиция 1 в списке: %d \n", immutableArray1.find(1));
            immutableArray2.replace(1, 100);
            System.out.println(immutableArray2);
            System.out.printf("Пуст ли список: %b \n", immutableArray3.isEmpty());
            System.out.printf("Размер списка: %d \n", immutableArray3.getSize());
            System.out.print(immutableArray3.getValues());
        }

        else if (task == 3 && subtask == 4) {
            AutomaticRifle automaticRifle1 = new AutomaticRifle();
            AutomaticRifle automaticRifle2 = new AutomaticRifle(10);
            AutomaticRifle automaticRifle3 = new AutomaticRifle(10, 2);

            System.out.println(automaticRifle3.shootForNSeconds(2));
        }

        else if (task == 4 && subtask == 1) {
            Pistol4_1 pistol = new Pistol4_1(1, 10);
            System.out.println(pistol);
        }

        else if (task == 5 && subtask == 8) {
            Pistol1_5 pistol = new Pistol1_5(3, 7);
            AutomaticRifle automaticRifle = new AutomaticRifle(10, 2);

            Shooter alex = new Shooter("Alex");
            Shooter steve = new Shooter("Steve", pistol);
            Shooter bob = new Shooter("Bob", automaticRifle);

            System.out.println("ALEX");
            alex.fire();
            System.out.println("STEVE");
            steve.fire();
            System.out.println("BOB");
            bob.fire();
        }

        else if (task == 6 && subtask == 2) {
            Dot dot1 = new Dot(1, 1);
            Dot dot2 = new Dot(1, 1);
            Dot dot3 = new Dot(2, 2);

            System.out.println(dot1.equals(dot2));
            System.out.println(dot1.equals(dot3));
        }

        else if (task == 8 && subtask == 2) {
            WeaponExample weaponExample = new WeaponExample(2);
            weaponExample.setAmmo(12);
            weaponExample.showAmmo();
        }

        else {
            System.out.println("Такого задания или задачи не существует");
            System.exit(1);
        }
    }
}
