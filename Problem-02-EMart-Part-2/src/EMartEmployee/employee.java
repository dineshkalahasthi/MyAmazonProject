package EMartEmployee;

import java.util.*;

public class employee {
    private String Name;
    public int EmpId;
    public String city;

    employee() {
        this.city="Mysore";
    }
    employee(int empId) {
        this.EmpId=empId;
    }
    public String getname() {
        System.out.println("Name: " + this.Name);
        return Name;
    }
    public void setname(String name) {
        this.Name = name;
    }
}