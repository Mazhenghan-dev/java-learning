package yi;

abstract class Plant {
    public abstract void display();

    public static Plant createPlant(String type) {
        return switch (type) {
            case "豌豆射手" -> new Peashooter();
            case "坚果墙" -> new WallNut();
            case "向日葵" -> new Sunflower();
            default -> null;
        };
    }
}

class Peashooter extends Plant {
    @Override
    public void display() { System.out.println("种植了豌豆射手，正在发射豌豆！"); }
}

class WallNut extends Plant {
    @Override
    public void display() { System.out.println("种植了坚果墙，正在抵挡僵尸！"); }
}

class Sunflower extends Plant {
    @Override
    public void display() { System.out.println("种植了向日葵，正在生产阳光！"); }
}

public class Task2_Main {
    public static void main(String[] args) {
        Plant p1 = Plant.createPlant("豌豆射手");
        if (p1 != null) {
            p1.display();
        }
        Plant p2 = Plant.createPlant("向日葵");
        if (p2 != null) {
            p2.display();
        }
    }
}

