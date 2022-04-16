package com.ddd;

import com.uuu.Employee;

//@Mapper
public interface EmployeeMapper {

    Employee getEmployee();

    Employee getEmployAndDeptJoin();

    Employee getEmployAndDeptLazy();

    Employee getEmployAndDeptEager();

}
