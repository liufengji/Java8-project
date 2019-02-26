package com.yinggu.demo12;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;
import com.yinggu.data.EmployeeData;
import com.yinggu.domain.Employee;

/**
 * @author 黑猴子的家 
 * http://www.121ugrow.com/
 * 
 * 此类用于演示Stream的终止操作
 * 
 * allMatch anyMatch noneMatch findFirst findAny count max min reduce reduce()
 * collect foreach
 */
public class TestStreamEnd {

	List<Employee> list = EmployeeData.getData();

	// 匹配与查找
	@Test
	public void test1() {

		// 终止操作
		// 1-1 allMatch 是不是全部满足条件
		boolean allMatch = list.stream().allMatch(e -> e.getSalary() > 800);
		System.out.println(allMatch);

		// 1-2 anyMatch 只要有一个匹配就ok
		boolean anyMatch = list.stream().anyMatch(e -> e.getAge() > 30);
		System.out.println(anyMatch);

		// 1-3 noneMatch 是不是全部不满足条件
		boolean noneMatch = list.stream().noneMatch(e -> e.getAge() > 100);
		System.out.println(noneMatch);

		// 1-4 findFirst 找到第一个
		Optional<Employee> first = list.stream().findFirst();
		System.out.println(first);

		// 1-5 findAny 找到任意一个
		Optional<Employee> any = list.stream().findAny();
		System.out.println(any);
	}

	// 统计
	@Test
	public void test2() {

		// max:年龄最大值
		Optional<Integer> max = list.stream().map(Employee::getAge).max(Integer::compare);
		System.out.println(max);

		// min:工资最小值
		Optional<Double> min = list.stream().map(Employee::getSalary).min(Double::compare);
		System.out.println(min);

		// count:计算个数
		long count = list.stream().filter(e -> e.getAge() > 25).count();
		System.out.println(count);

		// foreach:遍历Stream
		list.stream().forEach(System.out::println);

	}

	// 归约
	@Test
	public void testreduce1() {

		// 案例1：求年龄和
		Optional<Integer> reduce = list.stream().map(Employee::getAge).reduce((t, u) -> t + u);
		System.out.println(reduce);

	}
	
	// 归约
	@Test
	public void testreduce2() {

		// 案例2：将所有的姓名拼接在一起 
		Optional<String> reduce = list.stream().map(Employee::getName).reduce((t,u)-> t.concat(u));
		System.out.println(reduce);

	}
	
	// 归约
	@Test
	public void testreduce3 () {

		// 案例1：求年龄和
		Integer reduce = list.stream().map(Employee::getAge).reduce(0,(t,u) -> t + u);
		System.out.println(reduce);

	}
	
	// 归约
	@Test
	public void testreduce4 () {

		// 案例4：拼接
		String reduce4 = list.stream().map(Employee::getName).reduce("哈哈哈", (t, u) -> t.concat(u));

		System.out.println(reduce4);

	}

	// 收集
	@Test
	public void test4() {

		List<Employee> collect = list.stream().collect(Collectors.toList());
		Set<Employee> set = list.stream().collect(Collectors.toSet());

		for (Employee e : collect) {
			System.out.println(e);
		}

		for (Employee e : set) {
			System.out.println(e);
		}

	}

}
