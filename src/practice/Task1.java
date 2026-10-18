package practice;

interface GameCtrlFacTory{
    OperateController createOperateController ();
    InterFaceController createInterFaceController ();
}

interface OperateController{
    void touchEvent ();
}
interface InterFaceController{
    void showMsg ();
}

class iOSOperateController implements OperateController {
    public void touchEvent() {
        System.out.println("特征：iOS 触摸事件，支持3D Touch，位置精确到像素");
    }
}
class iOSInterFaceController implements InterFaceController {
    public void showMsg() {
        System.out.println("特征：iOS 界面提示，采用UIAlertController，圆角居中显示");
    }
}

class AndroidOperateController implements OperateController {
    public void touchEvent() {
        System.out.println("特征：Android 触摸事件，支持3D Touch，位置精确到像素");
    }
}
class AndroidInterFaceController implements InterFaceController {
    public void showMsg() {
        System.out.println("特征：Android 界面提示，采用UIAlertController，圆角居中显示");
    }
}

class WinPhoneOperateController implements OperateController {
    public void touchEvent() {
        System.out.println("特征：WinPhone 触摸事件，支持3D Touch，位置精确到像素");
    }
}
class WinPhoneInterFaceController implements InterFaceController {
    public void showMsg() {
        System.out.println("特征：WinPhone 界面提示，采用UIAlertController，圆角居中显示");
    }
}

class iSOFactory implements GameCtrlFacTory{
    static int userCount = 0;
    public iSOFactory(){userCount++;}
    public OperateController createOperateController() {
        return new iOSOperateController();
    }
    public InterFaceController createInterFaceController() {
        return new iOSInterFaceController();
    }
}

class AndroidFactory implements GameCtrlFacTory{
    static int userCount = 0;
    public AndroidFactory(){userCount++;}
    public OperateController createOperateController() {
        return new AndroidOperateController();
    }
    public InterFaceController createInterFaceController() {
        return new AndroidInterFaceController();
    }
}

class WinPhoneFactory implements GameCtrlFacTory{
    static int userCount = 0;
    public WinPhoneFactory(){userCount++;}
    public OperateController createOperateController() {
        return new WinPhoneOperateController();
    }
    public InterFaceController createInterFaceController() {
        return new WinPhoneInterFaceController();
    }
}

public class Task1 {
    public static void main(String[] args) {
        GameCtrlFacTory ISOFactory = new iSOFactory();
        ISOFactory.createOperateController().touchEvent();
        ISOFactory.createInterFaceController().showMsg();

        GameCtrlFacTory androidFactory = new AndroidFactory();
        androidFactory.createOperateController().touchEvent();
        androidFactory.createInterFaceController().showMsg();

        System.out.println(" ");
        System.out.println("游戏控制器创建完成，加载对应操作系统适配模块");
        new iSOFactory();
        new AndroidFactory();
        System.out.println(" ");

        System.out.println("iSO:"+iSOFactory.userCount);
        System.out.println("Android:"+AndroidFactory.userCount);
        System.out.println("WinPhone:"+WinPhoneFactory.userCount);
    }
}

