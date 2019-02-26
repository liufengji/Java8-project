package com.yinggu.demo13;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.Test;

import com.yinggu.data.EmployeeData;
import com.yinggu.domain.Employee;


/**
 * 1. 给定一个数字列表，如何返回一个由每个数的平方构成的列表呢？ 例如，给定【1，2，3，4，5】， 应该返回【1，4，9，16，25】。
 * 
 * 
 * 2. 怎样用 map 和 reduce 方法数一数流中有多少个Employee呢？
 * 
 * @author 黑猴子的家 
 * http://www.121ugrow.com/
 *
 */
public class TestStream {

	@Test
	public void test2() {
		
		List<Employee> list = EmployeeData.getData();

		// 1.得到Stream
		Stream<Employee> stream = list.stream();

		// 方式一：

		long count = stream.count();
		System.out.println(count);
		System.out.println("---------------------------");

		// 方式二：
		Optional<Integer> count2 = list.stream().map((e) -> 1).reduce((t, u) -> t + u);

		System.out.println(count2);

	}

	@Test
	public void test1() {

		// 1.得到Stream
		Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);

		// 2.映射
		Stream<Integer> map = stream.map(i -> (int) Math.pow(i, 2));

		// 3.遍历
		map.forEach(System.out::println);
	}

}
