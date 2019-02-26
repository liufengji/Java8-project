package com.yinggu.demo07;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;

import org.junit.Test;

import com.yinggu.domain.Employee;

/**
 * 
 * @author 黑猴子的家 http://www.121ugrow.com/
 * 
 *         此类用于演示方法引用 特点： 方法引用相当于对某种具备特殊要求 的Lambda表达式的代替，目的是为了语法更加简洁！！！
 *         语法： 
 *         类名或对象::方法名 
 *         注意：没有参数列表
 * 
 *         要求： 
 *         情况1：类名调用静态方法 
 *         情况2：对象调用实例方法 满足： 函数式接口的抽象方法的参数列表和返回值类型 必须 与 方法体中的
 *         要调用方法的 参数列表和返回值类型相同
 *         情况3：类名调用实例方法 满足： 
 *         （1）函数式接口的抽象方法的返回类型和方法体中要调用方法的返回类型相同
 *         （2）函数式接口的第一个参数肯定是方法体中要调用方法的调用者
 * 
 *         经典案例 Consumer con = System.out::println;
 */
public class TestMethodRef1 {

	// 使用对象名调用实例方法
	/*
	 * 1、函数式接口的抽象方法的参数列表和返回值类型 必须和 方法实现中 要调用方法的 参数列表和返回类型相同
	 */
	@Test
	public void test1() {

		System.out.println("------------匿名内部类---------------");
		// 使用匿名内部类
		Consumer<Integer> con = new Consumer<Integer>() {
			@Override
			public void accept(Integer t) {
				System.out.println(t);
			}
		};
		con.accept(100);

		System.out.println("\n------------Lambda表达式---------------");
		// 使用Lambda表达式
		Consumer<Integer> con1 = t -> System.out.println(t);
		con1.accept(100);

		System.out.println("\n------------方法引用---------------");
		// 使用方法引用
		Consumer<Integer> con2 = System.out::println;
		con2.accept(100);

		BiPredicate<String, String> bp1 = (x, y) -> x.equals(y);
		bp1.test("hello", "ni");
		BiPredicate<String, String> bp2 = String::equals;
		bp2.test("hello", "ni");
	}

	// 使用类名调用静态方法
	/*
	 * 1、函数式接口的抽象方法的参数列表和返回值类型 必须和 方法实现中 要调用方法的 参数列表和返回类型相同
	 */
	@Test
	public void test2() {
		// 使用匿名内部类
		Comparator<Double> com = new Comparator<Double>() {

			@Override
			public int compare(Double o1, Double o2) {
				return Double.compare(o1, o2);
			}
		};
		System.out.println(com.compare(100.9, 23.5));
		System.out.println("---------------------------");

		// 使用Lambda表达式
		Comparator<Double> com1 = (o1, o2) -> Double.compare(o1, o2);
		System.out.println(com1.compare(100.9, 23.5));
		System.out.println("---------------------------");

		// 使用方法引用
		Comparator<Double> com2 = Double::compare;
		System.out.println(com2.compare(100.9, 23.5));
	}

	// 使用类名调用实例方法
	/*
	 * 要求： 1、函数式接口的抽象方法返回值类型 必须和 方法实现中 要调用方法的 返回类型相同 2、函数式接口的抽象方法的第一个参数必须和方法实现中
	 * 要调用方法的调用者一样
	 * 
	 */
	@Test
	public void test3() {
		Comparator<String> com = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		};
		System.out.println(com.compare("john", "jack"));
		System.out.println("---------------------------");
		// 使用Lambda表达式
		Comparator<String> com1 = (o1, o2) -> o1.compareTo(o2);
		System.out.println(com1.compare("john", "jack"));
		System.out.println("---------------------------");

		// 使用方法引用
		Comparator<String> com2 = String::compareTo;
		System.out.println(com2.compare("john", "jack"));
		System.out.println("---------------------------");

		// 测试二------------------------------------------
		Function<Employee, String> fun = new Function<Employee, String>() {

			@Override
			public String apply(Employee t) {
				return t.getName();
			}

		};

		Function<Employee, String> fun1 = e -> e.getName();

		Function<Employee, String> fun2 = Employee::getName;

	}

}
