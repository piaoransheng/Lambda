package com.test.prammar;

import com.test.Employee;
import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

public class TestDemo1 {

    //语法1：无参数无返回值
    @Test
    public void test1(){
        Runnable runnable2 = () -> System.out.println("Lambda打印内容1");
        runnable2.run();
    }

    //语法2：有一个参数，无返回值
    @Test
    public void test2(){
        Consumer<Employee> consumer1 = (x) ->  System.out.println(x);
        consumer1.accept(new Employee());
    }

    //语法3：多个参数，有返回值，并且方法体有多个语句
    @Test
    public void test3(){
        Comparator<Employee> comparator1 = (X,Y) -> {
            System.out.println("Lambda打印内容3");
            return 0;
        };
        comparator1.compare(new Employee(),new Employee());
    }


    //语法4：方法体只有一条语句时，方法体和return语句都可以不行
    @Test
    public void test4(){
        Comparator<Integer> comparator1 = (x,y) ->  Integer.compare(x,y);
        int compare = comparator1.compare(1, 2);
        System.out.println(compare);
    }

    //语法5：Lambda表达式的参数类型可以省略不写，因为jvm可以通过上下文推断出，即"类型推断"
}
