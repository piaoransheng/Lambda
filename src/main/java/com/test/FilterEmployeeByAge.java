package com.test;

public class FilterEmployeeByAge implements MyPredicate<Employee> {
    @Override
    public boolean test(Employee employee) {
        if (employee.getAge() >= 15){
            return true;
        }
        return false;
    }
}
