package com.test;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainApplication {
    private static List<Employee> employeeList = Arrays.asList(
            new Employee("张三",13,3000),
            new Employee("李四",14,4000),
            new Employee("王五",15,5000),
            new Employee("赵六",16,6000),
            new Employee("田七",17,7000)
    );

    public static void main(String[] args) {
        //打印出所有
        employeeList.forEach(employee -> System.out.println("所有-----" + employee));


        //优化方式一：策略模式
        List<Employee> employees1 = filterEmployee(employeeList, new FilterEmployeeByAge());
        employees1.forEach(employee -> System.out.println("策略模式-----" +employee));

        //优化方式二：匿名内部类
        List<Employee> employees2 = filterEmployee(employeeList, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                if (employee.getSalary() <= 5000){
                    return true;
                }
                return false;
            }
        });
        employees1.forEach(employee -> System.out.println("匿名内部类-----" +employee));


        //优化方式三：Lambda
        List<Employee> employees3 = filterEmployee(employeeList, (e) -> e.getAge() == 15);
        employees3.forEach(employee -> System.out.println("Lambda方法-----" +employee));


        //优化方式四：只需要实体类和一个List
        employeeList.stream()
                .filter( (e) -> e.getAge() >=15 )
                .forEach(System.out::println);
    }



    //策略模式方法
    public static List<Employee> filterEmployee(List<Employee> list,MyPredicate<Employee> mp){
        List<Employee> resultList = new ArrayList<>();
        for (Employee employee:list){
            if (mp.test(employee)){
                resultList.add(employee);
            }
        }
        return resultList;
    }




}
