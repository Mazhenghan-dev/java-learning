package yi;

abstract class Fruit {
    public abstract void getInfo();

    public static Fruit createFruit(String name) {
        if (name.equals("苹果")) {
            return new Apple();
        } else if (name.equals("草莓")) {
            return new Strawberry();
        } else if (name.equals("桃子")) {
            return new Peach();
        }
        return null;
    }
}

class Apple extends Fruit {
    @Override
    public void getInfo() { System.out.println("我是苹果！"); }
}

class Strawberry extends Fruit {
    @Override
    public void getInfo() { System.out.println("我是草莓！"); }
}

class Peach extends Fruit {
    @Override
    public void getInfo() { System.out.println("我是桃子！"); }
}

public class Task1_Main {
    public static void main(String[] args) {
        Fruit f1 = Fruit.createFruit("苹果");
        if (f1 != null) f1.getInfo();

        Fruit f2 = Fruit.createFruit("草莓");
        if (f2 != null) f2.getInfo();
    }
}

