# Михайлов Кирилл ИТ-4 Лабораторная №3
# Задание 1
## Задача 1
### Текст задачи
**Дом над землей**.
Измените сущность Дом из задачи 1.4.3. Гарантируйте, что у дома всегда будет положительное
количество этажей. В случае попытки указать отрицательное количество этажей должна
выбрасываться соответствующая ошибка. Продемонстрируйте работоспособность решения на
примерах.

### Алгоритм реешния
```java
public class House {
    private int floors;

    public House(int floors) {
        if (floors < 0)
            throw new RuntimeException("Кол.-во этажей не может быть отрицательным");
        this.floors = floors;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        if (floors < 0)
            throw new RuntimeException("Кол.-во этажей не может быть отрицательным");
        this.floors = floors;
    }

    @Override
    public String toString() {
        int lastTwo = floors % 100;
        int lastOne = floors % 10;

        String endString;

        if (lastTwo >= 11 && lastTwo <= 14) {
            endString = "этажами";
        } else if (lastOne == 1) {
            endString = "этажом";
        } else {
            endString = "этажами";
        }

        return String.format("дом с %d %s", floors, endString);
    }
}
```

## Задача 5
### Текст решения
Перезарядка Пистолета.
Измените сущность Пистолет из задачи 1.5.1. Модификация предполагает внесение следующих
дополнительных требований:
* Имеет максимальное количество патронов. Максимальное количество устанавливается во
время создания пистолета и не может быть изменено позднее. У пистолета можно узнать,
какое максимальное количество он вмещает.
* Может быть перезаряжен. Для перезарядки необходимо передать пистолету число,
которое будет означать количество заряжаемых патронов. Если передано отрицательное
число, необходимо выбросить ошибку, объясняющую, что отрицательного числа
патронов быть не может. Если передано слишком большое число патронов – необходимо
лишние вернуть.
* Может быть разряжен. Это приводит к обнулению патронов в пистолете и возврате
нужного числа пользователю.
* Можно узнать сколько сейчас заряжено патронов.
* Можно узнать заряжен он или разряжен.
Создайте пистолет вместимостью 7, зарядите три патрона, выстрелите из него пять раз, затем
зарядите в него 8 патронов, выстрелите еще 2 раза, разрядите его, сделайте контрольный
выстрел.
Если все выполнено верно, то должно быть выведено: Бах! Бах! Бах! Клац! Клац! Бах! Бах! Клац!

### Алгоритм решения
```java
public class Pistol{
    private int ammo;
    private final int maxAmmo;

    public Pistol(int ammo, int maxAmmo) {
        this.ammo = ammo;
        this.maxAmmo = maxAmmo;
    }

    public Pistol() {
        this(5, 5);
    }

    public int reload(int newAmmo) {
        if (newAmmo < 0)
            throw new RuntimeException("Вы не можете перезарядить магазин на отрицательное кол.-во патронов");
        int resAmmo = newAmmo - maxAmmo;
        setAmmo(newAmmo);
        return resAmmo > 0 ? resAmmo : 0;
    }

    public int unload() {
        int currentAmmo = ammo;
        setAmmo(0);
        return currentAmmo;
    }

    public boolean isload() {
        return ammo != 0 ? true : false;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }

    public int getAmmo() {
        return ammo;
    }

    public int getMaxAmmo() {
        return maxAmmo;
    }

    @Override
    public String toString() {
        if (ammo > 0) {
            ammo--;
            return "Бах!";
        } else {
            return "Клац!";
        }
    }
}
```

# Задание 2
## Задача 1
### Текст решения
Неизменяемый массив.
Необходимо разработать сущность НеизменяемыйСписокЗначений, представляющий собой
обертку над массивом целых чисел, который сохранит функциональные возможности массивов,
но добавит некоторые дополнительные возможности.
Состояние сущности описывают следующие сведения:
* Имеет массив целых чисел. Именно он используется для хранения значений.
Инициализация сущности может быть выполнена следующим образом:
* С указанием значений в виде массива целых чисел.
* С указанием перечня чисел как независимых значений (через запятую)
* С указанием другого Списка, в этом случае копируются все значения указанного списка.
Поведение сущности описывают следующие действия:
* Получение значения из позицииN. Позиция должна попадать в диапазон от 0 до N-1, где
N–текущее количество значений, иначе выкинуть ошибку.
* Замена значения в позиции N на новое значение. Позиция должна попадать в диапазон от
0 до N-1, где N–текущее количество значений, иначе выкинуть ошибку.
* Может быть приведен к строке. Строка должна представлять собой полный перечень всех
хранимых чисел, причем первый символ строки это ”[“, а последний “]”.
* Можно проверить пуст Список или нет. Список пуст если его размер 0.
* Можно узнать текущий размер.
* Все хранящиеся значения можно запросить в виде стандартного массива.
Продемонстрируйте работоспособность решения на примерах.

### Алгоритм решения
```java
import java.util.Arrays;

public class ImmutableArray {
    private final int[] values;

    public ImmutableArray(int... values) {
        this.values = values;
    }

    public ImmutableArray(ImmutableArray immutableArray) {
        this.values = immutableArray.getValues();
    }

    public int find(int position) {
        if (position < 0 || position >= values.length) {
            throw new IllegalArgumentException(
                    String.format("Позиция %d вне диапазона [0, %d]", position, values.length - 1));
        }
        return values[position];
    }

    public ImmutableArray replace(int position, int newValue) {
        if (position < 0 || position >= values.length) {
            throw new IllegalArgumentException(
                    String.format("Позиция %d вне диапазона [0, %d]", position, values.length - 1));
        }

        int[] newArray = Arrays.copyOf(values, values.length);
        values[position] = newValue;
        return new ImmutableArray(newArray);
    }

    public boolean isEmpty() {
        return values.length == 0;
    }

    public int getSize() {
        return values.length;
    }

    public int[] getValues() {
        return this.values;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < values.length; i++) {
            sb.append(values[i]);
            if (i < values.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
```

# Задание 3
## Задача 4
### Текст решения
Автомат. Создайте такой подвид сущности Пистолет из задачи 2.1.5, которая будет совпадать с
ней во всех отношениях, кроме следующего:
* Имеет скорострельность (целое число, неизменяемое) которое обозначает количество
выстрелов в секунду, поддерживаемое данным автоматом. Скорострельность всегда
положительное число.
*  При вызове Стрелять количество выстрелов соответствует скорострельности (например,
при скорострельности 3 выводится три строки с текстом выстрела).
* Умеет Стрелять N секунд, что приводит к количеству выстрелов равному N умноженное
на скорострельность.
* Инициализация может быть выполнены следующими способами:
a)
Без параметров. Скорострельность 30, вместимость 30.
b)
С указанием максимального числа патронов. Скорострельность будет равна
половине обоймы
c)
С указанием максимального количества патронов в обойме и скорострельности.

### Алгоритм решения
```java
public class AutomaticRifle extends Pistol {
    private final int speed;

    public AutomaticRifle() {
        super(30, 30);
        speed = 30;
    }

    public AutomaticRifle(int maxAmmo) {
        super(maxAmmo, maxAmmo);
        speed = maxAmmo / 2;
    }

    public AutomaticRifle(int maxAmmo, int speed) {
        super(maxAmmo, maxAmmo);
        if (speed <= 0)
            throw new IllegalArgumentException("Скорострельность должна быть положительным числом");
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public String shootForNSeconds(int seconds) {
        if (seconds <= 0) {
            throw new IllegalArgumentException("Количество секунд должно быть положительным");
        }

        StringBuilder result = new StringBuilder();
        int totalShots = seconds * speed;
        int actualShots = Math.min(totalShots, getAmmo());

        for (int i = 0; i < actualShots; i++) {
            setAmmo(getAmmo() - 1);
            result.append("Бах!");
            if (i < actualShots - 1) {
                result.append(" ");
            }
        }

        int emptyShots = totalShots - actualShots;
        if (emptyShots > 0) {
            if (actualShots > 0) {
                result.append(" ");
            }
            for (int i = 0; i < emptyShots; i++) {
                result.append("Клац!");
                if (i < emptyShots - 1) {
                    result.append(" ");
                }
            }
        }

        return result.toString();
    }

    @Override
    public String toString() {
        return shootForNSeconds(1);
    }
}
```

# Задание 4
## Задача 1
### Текст решения
**Оружие**.
Измените сущность Пистолет, полученную в задаче 2.1.5 таким образом, чтобы она наследовалась
от класса Weapon описанного на рисунке:
```java
abstract class Weapon {
    private int ammo;

    public Weapon(int ammo) {
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
```

### Алгоритм решения
```java
public class Pistol extends Weapon{
    private int ammo;
    private final int maxAmmo;

    public Pistol(int ammo, int maxAmmo) {
        super(ammo);
        this.ammo = ammo;
        this.maxAmmo = maxAmmo;
    }

    public Pistol() {
        this(5, 5);
    }

    public int reload(int newAmmo) {
        if (newAmmo < 0)
            throw new RuntimeException("Вы не можете перезарядить магазин на отрицательное кол.-во патронов");
        int resAmmo = newAmmo - maxAmmo;
        setAmmo(newAmmo);
        return resAmmo > 0 ? resAmmo : 0;
    }

    public int unload() {
        int currentAmmo = ammo;
        setAmmo(0);
        return currentAmmo;
    }

    public boolean isload() {
        return ammo != 0 ? true : false;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }

    public int getMaxAmmo() {
        return maxAmmo;
    }

    @Override
    public String toString() {
        if (ammo > 0) {
            ammo--;
            return "Бах!";
        } else {
            return "Клац!";
        }
    }

    @Override
    void shoot() {
        throw new UnsupportedOperationException("Unimplemented method 'shoot'");
    }
}
```

# Задание 5
## Задача 8
### Текст решения
Лучший стрелок.
Создайте сущность Стрелок, которая описывается:
* Имя, строка
* Оружие, из задачи 2.4.1.
* При создании объекта необходимо указать ему имя
* Имя и оружие можно поменять и получить в любой момент без ограничения.
Основная способность Стрелка - умение стрелять. Если оружие есть, то выстрел происходит по
правилам оружия, если его нет – то выводится текст “не могу участвовать в перестрелке”.
Создайте трех стрелков: одного без оружия, одного с пистолетом и одного с автоматом, и пусть
каждый из них выстрелит.

### Алгоритм решения
```java
public class Shooter {
    private String name;
    private AutomaticRifle gun;

    public Shooter(String name) {
        this.name = name;
    }

    public void fire() {
        if (gun != null){
            gun.shootForNSeconds(1);
        }
        else{
            System.out.println("Не могу участвовать в перестрелке");
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGun(AutomaticRifle gun) {
        this.gun = gun;
    }

    public String getName() {
        return name;
    }

    public Pistol getGun() {
        return gun;
    }
}
```

# Задание 6
## Задача 2
### Текст решения
**Сравнение точек**.
Измените сущность Точка из задачи 1.4.1. Переопределите метод сравнения объектов по
состоянию таким образом, чтобы две точки считались одинаковыми тогда, когда они
расположены в одинаковых координатах.

### Алгоритм решения
```java
public class Dot {
    private final int x;
    private final int y;

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Dot dot = (Dot) obj;
        return x == dot.x && y == dot.y;
    }

    @Override
    public String toString() {
        return String.format("{%d:%d}", x, y);
    }
}
```
# Задание 7
## Задача 2
### Текст решения
**Патроны наследникам**.
Измените класс Weapon из задачи 2.4.1 таким образом, что бы любой класс наследник мог
непосредственно работать сполем хранящим количество патронов заряженном в оружии.
Обратите внимание, что метод разрядки Пистолет, усложнившийся при решении задачи
2.4.1снова можно упростить.

### Алгоритм решения
```java
abstract class Weapon {
    protected int ammo;

    public Weapon(int ammo) {
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
```