package com.sda.java3.ecommerce.domains;

import java.util.Objects;

public class Employee {
    private final String employeeId;
    private final String name;
    private final String department;

    public Employee(String employeeId, String name, String department) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Employee{employeeId='" + employeeId + "', name='" + name + "', department='" + department + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeId.equals(employee.employeeId) &&
               name.equals(employee.name) &&
               department.equals(employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, name, department);
    }
}
