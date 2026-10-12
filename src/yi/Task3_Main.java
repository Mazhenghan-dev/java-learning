package yi;

interface LateReason {
    void explain();
}

class ToiletReason implements LateReason {
    @Override
    public void explain() { System.out.println("老师，我去上厕所了。"); }
}

class OnRoadReason implements LateReason {
    @Override
    public void explain() { System.out.println("老师，路上堵车了。"); }
}

class GoHomeReason implements LateReason {
    @Override
    public void explain() { System.out.println("老师，我回家拿东西了。"); }
}

class BlindDateReason implements LateReason {
    @Override
    public void explain() { System.out.println("老师，家里安排相亲，实在走不开。"); }
}

interface ReasonFactory {
    LateReason createReason();
}


class ToiletFactory implements ReasonFactory {
    @Override
    public LateReason createReason() { return new ToiletReason(); }
}

class OnRoadFactory implements ReasonFactory {
    @Override
    public LateReason createReason() { return new OnRoadReason(); }
}

class GoHomeFactory implements ReasonFactory {
    @Override
    public LateReason createReason() { return new GoHomeReason(); }
}

class BlindDateFactory implements ReasonFactory {
    @Override
    public LateReason createReason() { return new BlindDateReason(); }
}

public class Task3_Main {
    public static void main(String[] args) {
        ReasonFactory factory = new ToiletFactory();
        LateReason reason1 = factory.createReason();
        reason1.explain();

        ReasonFactory blindDateFactory = new BlindDateFactory();
        LateReason reason2 = blindDateFactory.createReason();
        reason2.explain();
    }
}

