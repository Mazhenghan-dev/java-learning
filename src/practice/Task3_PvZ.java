package practice;

interface Plant {
    void produceSun();
}

interface Zombie {
    void moveForward();
}

class DayLawnPlant implements Plant {
    @Override
    public void produceSun() {
        System.out.println("特征：向日葵/豌豆射手在自然阳光下产出阳光。");
    }
}

class DayLawnZombie implements Zombie {
    @Override
    public void moveForward() {
        System.out.println("特征：普通僵尸/路障僵尸在草地前院向前移动，位置改变。");
    }
}

class NightRoofPlant implements Plant {
    @Override
    public void produceSun() {
        System.out.println("特征：阳光菇/胆小菇在无自然光夜间产出阳光。");
    }
}

class NightRoofZombie implements Zombie {
    @Override
    public void moveForward() {
        System.out.println("特征：气球僵尸/扶梯僵尸在屋顶向前移动，位置改变。");
    }
}

interface SceneFactory {
    Plant createPlant();
    Zombie createZombie();
}

class DayLawnFactory implements SceneFactory {
    @Override
    public Plant createPlant() { return new DayLawnPlant(); }
    @Override
    public Zombie createZombie() { return new DayLawnZombie(); }
}

class NightRoofFactory implements SceneFactory {
    @Override
    public Plant createPlant() { return new NightRoofPlant(); }
    @Override
    public Zombie createZombie() { return new NightRoofZombie(); }
}

public class Task3_PvZ {
    private static int playCount = 0;

    public static void main(String[] args) {
        System.out.println("--- 任务3：植物大战僵尸场景模拟 ---");

        SceneFactory dayFactory = new DayLawnFactory();
        dayFactory.createPlant().produceSun();
        dayFactory.createZombie().moveForward();
        playCount++;
        System.out.println("场景加载，战斗开始。\n");

        SceneFactory nightFactory = new NightRoofFactory();
        nightFactory.createPlant().produceSun();
        nightFactory.createZombie().moveForward();
        playCount++;
        System.out.println("场景加载，战斗开始。\n");

        System.out.println("--- 关卡热度分析数据 ---");
        System.out.println("当前累计场景游玩次数: " + playCount);
    }
}
