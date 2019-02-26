package com.yinggu.demo08;

import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.Test;

import com.yinggu.domain.Employee;

/**
 * @author 黑猴子的家 
 * http://www.121ugrow.com/
 * 此类用于演示构造器引用 特点：相当于代替了具备特殊要求的Lambda表达式作为函数式接口的实例 要求： 
 * 1.方法体中，仅仅就有一个语句而且是返回语句
 * 2.返回的是一个new 出来的对象 
 * 3.函数式接口的抽象方法的参数列表=对象构造器的参数列表+对象类型 语法： 类型：：new
 */
public class TestConstructorRef {
	
	// 无参
	@Test
	public void test1() {
		
		// Lambda表达式
		Supplier<Employee> sup = () -> new Employee();
		
		// 构造器引用
		Supplier<Employee> sup2 = Employee::new;
	}

	// 一个参数
	@Test
	public void test2() {
		
		// Lambda表达式
		Function<String, String> fun = (str) -> new String(str);
		
		// 构造器引用
		Function<String, String> fun2 = String::new;
	}

	// 多个参数
	@Test
	public void test3() {
		
		// Lambda表达式
		MyInterface<Integer, String, Integer, Double, Employee> m = (id, name, age, salary) -> new Employee(id, name,
				age, salary);

		// 构造器引用
		MyInterface<Integer, String, Integer, Double, Employee> m2 = Employee::new;
	}
}

interface MyInterface<T, R, U, E, K> {
	K operate(T t, R r, U u, E e);
}
