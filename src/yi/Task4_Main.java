package yi;

interface Human {
    void show();
}

class Man implements Human {
    @Override
    public void show() { System.out.println("造出了一个男人！"); }
}

class Woman implements Human {
    @Override
    public void show() { System.out.println("造出了一个女人！"); }
}

interface HumanFactory {
    Human createHuman();
}

class ManFactory implements HumanFactory {
    @Override
    public Human createHuman() { return new Man(); }
}

class WomanFactory implements HumanFactory {
    @Override
    public Human createHuman() { return new Woman(); }
}

public class Task4_Main {
    public static void main(String[] args) {
        HumanFactory yangFactory = new ManFactory();
        Human man = yangFactory.createHuman();
        man.show();

        HumanFactory yinFactory = new WomanFactory();
        Human woman = yinFactory.createHuman();
        woman.show();
    }
}

