package com.uuu;

public class Employee {
    private String id;
    private String employeeName;

    // 多对一：引入Dept。一对多：引入List<Dept>
    private Dept dept;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", dept=" + dept +
                '}';
    }
}