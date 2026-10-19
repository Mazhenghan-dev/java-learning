package practice;

interface IDepartment {
    void insert();
    void getDepartment();
}

class AccessDepartments implements IDepartment {
    @Override
    public void insert() {
        System.out.println("在Access数据库中插入Department记录");
    }
    @Override
    public void getDepartment() {
        System.out.println("从Access数据库获取Department记录");
    }
}

class SqlserverDepartment implements IDepartment {
    @Override
    public void insert() {
        System.out.println("在SQL Server数据库中插入Department记录");
    }
    @Override
    public void getDepartment() {
        System.out.println("从SQL Server数据库获取Department记录");
    }
}

interface IFactory {
    IDepartment createDepartment();
}

class AccessFactory implements IFactory {
    @Override
    public IDepartment createDepartment() {
        return new AccessDepartments();
    }
}

class SqlserverFactory implements IFactory {
    @Override
    public IDepartment createDepartment() {
        return new SqlserverDepartment();
    }
}

public class Task4_DatabaseFactory {
    public static void main(String[] args) {
        System.out.println("--- 任务4：数据库表Departments抽象工厂实现 ---");

        IFactory sqlServerFactory = new SqlserverFactory();
        IDepartment sqlServerDept = sqlServerFactory.createDepartment();
        sqlServerDept.insert();
        sqlServerDept.getDepartment();

        System.out.println();

        IFactory accessFactory = new AccessFactory();
        IDepartment accessDept = accessFactory.createDepartment();
        accessDept.insert();
        accessDept.getDepartment();
    }
}
