package designpatternpracticeshrayansh.proxydesignpatttern;

interface EmployeeDao {
    void getEmployeeInfo(int empID);

    void createEmployee(EmployeeDao obj);
}

class EmployeeDaoImpl implements EmployeeDao {
    public void getEmployeeInfo(int empID) {
        System.out.println("Fetching employee info for ID: " + empID);
    }

    public void createEmployee(EmployeeDao obj) {
        System.out.println("Creating employee: " + obj);
    }
}

class EmployeeDaoProxy implements EmployeeDao {

    private EmployeeDao empDaoObj;
    private String clientRole;

    public EmployeeDaoProxy(String clientRole) {
        empDaoObj = new EmployeeDaoImpl();
        this.clientRole = clientRole;
    }

    @Override
    public void getEmployeeInfo(int empID) {
        if (clientRole.equals("ADMIN") || clientRole.equals("USER")) {
            empDaoObj.getEmployeeInfo(empID);
        } else {
            throw new RuntimeException("Access Denied");
        }
    }

    @Override
    public void createEmployee(EmployeeDao obj) {
        if (clientRole.equals("ADMIN")) {
            empDaoObj.createEmployee(obj);
        } else {
            throw new RuntimeException("Access Denied");
        }
    }
}

 class EmployeeManagement {
    public static void main(String[] args) {
        System.out.println("===== Proxy Design Pattern =====");


        EmployeeDao userProxyObj = new EmployeeDaoProxy("USER");
        userProxyObj.getEmployeeInfo(11); //access granted
        userProxyObj.createEmployee(new EmployeeDaoImpl()); //access denied
    }
}