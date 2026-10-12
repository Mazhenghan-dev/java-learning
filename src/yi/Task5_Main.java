package yi;

interface Television {
    void play();
}

class HaierTelevision implements Television {
    @Override
    public void play() { System.out.println("海尔电视机正在播放..."); }
}

class TCLTelevision implements Television {
    @Override
    public void play() { System.out.println("TCL电视机正在播放..."); }
}

interface AirConditioner {
    void cool();
}

class HaierAirConditioner implements AirConditioner {
    @Override
    public void cool() { System.out.println("海尔空调正在制冷..."); }
}

class TCLAirConditioner implements AirConditioner {
    @Override
    public void cool() { System.out.println("TCL空调正在制冷..."); }
}

interface ApplianceFactory {
    Television createTelevision();
    AirConditioner createAirConditioner();
}


class HaierFactory implements ApplianceFactory {
    @Override
    public Television createTelevision() { return new HaierTelevision(); }

    @Override
    public AirConditioner createAirConditioner() { return new HaierAirConditioner(); }
}


class TCLFactory implements ApplianceFactory {
    @Override
    public Television createTelevision() { return new TCLTelevision(); }

    @Override
    public AirConditioner createAirConditioner() { return new TCLAirConditioner(); }
}

public class Task5_Main {
    public static void main(String[] args) {
        System.out.println("====== 海尔生产线 ======");
        ApplianceFactory haierFactory = new HaierFactory();
        haierFactory.createTelevision().play();
        haierFactory.createAirConditioner().cool();

        System.out.println("\n====== TCL生产线 ======");
        ApplianceFactory tclFactory = new TCLFactory();
        tclFactory.createTelevision().play();
        tclFactory.createAirConditioner().cool();
    }
}

