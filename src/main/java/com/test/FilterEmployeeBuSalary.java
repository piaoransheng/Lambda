package com.test;

public class FilterEmployeeBuSalary implements MyPredicate<Employee> {
    @Override
    public boolean test(Employee employee) {
        if (employee.getSalary() >= 5000){
            return true;
        }
        return false;
    }
}
