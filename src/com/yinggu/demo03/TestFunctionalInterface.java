package com.yinggu.demo03;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import org.junit.Test;
import com.yinggu.data.EmployeeData;
import com.yinggu.domain.Employee;
/**
 * @author 黑猴子的家
 * http://www.121ugrow.com/
 * 
 * 此类用于演示函数式接口的使用 函数式接口：
 * 里面只有一个抽象方法的接口称为函数式接口 只有函数式接口，才可以使用Lambda表达式生成对象
 * 
 * Consumer<T> :消费性接口     有参数  无返回
 * Supplier<T> :供给型接口     无参数  有返回
 * Function<T,R>:函数型接口   有参数  有返回
 * Predicate<T> :断定型接口   有参数  有返回（true 或  false）
 *
 */
public class TestFunctionalInterface {
	
	/**
	 * Consumer<T> :消费性接口     有参数  无返回
	 */
	@Test
	public void testConsumer() {
		Consumer<Double> con = money -> {
			if (money > 1000)
				System.out.println("去k歌");
			else if (money > 500)
				System.out.println("去泡澡");
			else
				System.out.println("麻辣烫");
		};
		con.accept(580.0);
	}
	
	/**
	 * Supplier<T> :供给型接口     无参数  有返回
	 */
	@Test
	public void testSupplier() {
		Supplier<String> sup = () -> "苍老师".substring(0, 1);
		System.out.println(sup.get());
	}
	
	/**
	 * Function<T,R>:函数型接口   有参数  有返回
	 */
	@Test
	public void testFunction1() {
		Function<String, Integer> fun = str -> str.length();
		System.out.println(fun.apply("迪丽热巴"));

	}
	
	/**
	 * Function<T,R>:函数型接口   有参数  有返回
	 */
	@Test
	public void testFunction2() {
		// 根据编号返回员工对象
		/*
		 * 参数：int id——》Integer 返回：employee对象——》Employee
		 */
		Function<Integer, Employee> fun = id -> {
			
			// 查找员工对象的步骤
			List<Employee> list = EmployeeData.getData();
			for (Employee employee : list) {
				if (id == employee.getId()) {
					return employee;
				}
			}
			return null;
		};
		System.out.println(fun.apply(5));
	}
	
	/**
	 *  Predicate<T> :断定型接口   有参数  有返回（true 或  false）
	 *  判断字符串的长度是不是3
	 */
	@Test
	public void testPredicate() {
		Predicate<String> pre = str -> str.length() == 3;
		System.out.println(pre.test("段誉"));
	}
	/**
	 *  Predicate<T> :断定型接口   有参数  有返回（true 或  false）
	 *  求满足条件的员工信息
	 */
	@Test
	public void testPredicate2() {
		List<Employee> list = EmployeeData.getData();
		// 1.需求1：过滤年龄大于30岁
		List<Employee> data1 = getData(list, emp -> emp.getAge() > 30);
		for (Employee employee : data1) {
			System.out.println(employee);
		}
		System.out.println("-------------");
		// 2.需求2：过滤工资>20000
		List<Employee> data2 = getData(list, emp -> emp.getSalary() > 20000);
		for (Employee employee : data2) {
			System.out.println(employee);
		}
	}

	//定义一个方法
	public List<Employee> getData(List<Employee> list, Predicate<Employee> pre) {
		List<Employee> data = new ArrayList<>();
		for (Employee employee : list) {
			if (pre.test(employee)) {
				data.add(employee);
			}
		}
		return data;
	}
}