package com.uuu;

import java.util.List;

public class Dept {
    private String id;
    private String deptName;

    // 多对一：引入Dept。一对多：引入List<Dept>
//    private List<Employee> employees;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }


    @Override
    public String toString() {
        return "Dept{" +
                "id='" + id + '\'' +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}