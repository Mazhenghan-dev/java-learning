package practice;

interface Weapon{
    void fire();
}

interface Monster{
    void attack();
}

class Scythe implements Weapon{
    @Override
    public void fire() {
        System.out.println("随蝴蝶一起消散吧，旧日的幻影。");
    }
}
class Staff implements Weapon{
    @Override
    public void fire() {
        System.out.println("生存还是毁灭，你别无选择。");
    }
}
class SubmachineGun implements Weapon{
    @Override
    public void fire() {
        System.out.println("该说再见了...");
    }
}

class UndeadMonster implements Monster{
    @Override
    public void attack() {
        System.out.println("汪汪汪！");
    }
}
class ElementalMonster implements Monster{
    @Override
    public void attack() {
        System.out.println("记忆的涟漪...");
    }
}
class MechanicalMonster implements Monster{
    @Override
    public void attack() {
        System.out.println("解析，描摹，复原...重塑完美。");
    }
}

interface MonsterFactory{
    Monster createMonster();
    Weapon createWeapon();
}

class UndeadFactory implements MonsterFactory{
    @Override
    public Monster createMonster() {
        return new UndeadMonster();
    }
    public Weapon createWeapon(){
        return new Scythe();
    }
}

class ElementalFactory implements MonsterFactory{
    @Override
    public Monster createMonster() {
        return new ElementalMonster();
    }
    public Weapon createWeapon(){
        return new Staff();
    }
}

class MechanicalFactory implements MonsterFactory{
    @Override
    public Monster createMonster() {
        return new MechanicalMonster();
    }
    public Weapon createWeapon(){
        return new SubmachineGun();
    }
}
public class Task2 {
    static int killCount = 0;

    public static void main(String[] args) {
        MonsterFactory undeadFactory = new UndeadFactory();
        undeadFactory.createMonster().attack();
        undeadFactory.createWeapon().fire();
        killCount++;
        System.out.println("怪物登场，准备战斗。\n");

        MonsterFactory elementalFactory = new ElementalFactory();
        elementalFactory.createMonster().attack();
        elementalFactory.createWeapon().fire();
        killCount++;
        System.out.println("怪物登场，准备战斗。\n");

        MonsterFactory mechanicalFactory = new MechanicalFactory();
        mechanicalFactory.createMonster().attack();
        mechanicalFactory.createWeapon().fire();
        killCount++;
        System.out.println("怪物登场，准备战斗。\n");

        System.out.println("--- 游戏平衡性分析数据 ---");
        System.out.println("当前累计怪物击杀数量: " + killCount);
    }
}

