package com.yinggu.demo11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

import com.yinggu.data.EmployeeData;
import com.yinggu.domain.Employee;

/**
 * @author 黑猴子的家 
 * http://www.121ugrow.com/
 * 
 * 此类用于演示中间操作
 * 
 * 1.中间操作相当于流水线，调用完一个中间操作APi，可以继续调用下一个中间操作API
 * 
 * 2.中间操作需要搭配着终止操作一起执行，否则将不做任何处理，将这种现象称为“惰性操作”
 * 
 * 特点： stream一旦做完终止操作，将 关闭，不能再继续进行中间操作
 * 
 * 相关API：
 * filter 过滤
 * distinct 去重，注意必须重写hashcode和equals
 * limit 限制最大个数
 * skip 跳过
 * 
 * map 映射
 * flatMap 映射
 * sorted 自然排序
 * sorted(Comparator)定制排序
 */
public class TestStreamMiddle {

	List<Employee> list = EmployeeData.getData();

	// 筛选
	@Test
	public void test1() {
		// 1.获取Stream对象
		Stream<Employee> streamlist = list.stream();

		// 2.中间操作
		// 2-1.中间操作——filter
		Stream<Employee> filterstream = streamlist.filter(e -> e.getAge() > 30);

		// 3.终止操作
		filterstream.forEach(System.out::println);
	}

	// 筛选
	/**
	 * 先打印全部，再打印过滤的
	 */
	@Test
	public void test2() {

		Stream<Employee> streamlist = list.stream();

		streamlist.forEach(System.out::println);

		System.out.println("--------------------------------------");

		list.stream().filter(e -> e.getAge() > 30).forEach(System.out::println);

	}

	// distinct
	/**
	 * 重写 Employee 类的hashCode和equals 方法
	 */
	@Test
	public void test3() {

		list.add(new Employee(100, "鸠摩智", 20, 10000));
		list.add(new Employee(100, "鸠摩智", 20, 10000));
		list.add(new Employee(100, "鸠摩智", 20, 10000));
		list.add(new Employee(100, "鸠摩智", 20, 10000));
		list.add(new Employee(100, "鸠摩智", 20, 10000));

		Stream<Employee> streamlist = list.stream();
		Stream<Employee> distinctstream = streamlist.distinct();

		distinctstream.forEach(System.out::println);
	}

	// limit
	@Test
	public void test4() {

		// 1.获取Stream对象
		Stream<Employee> streamlist = list.stream();

		// 2.中间操作
		// 2-1 .中间操作——limit
		Stream<Employee> limitStream1 = streamlist.limit(3);
		// Stream<Employee> limitStream2 = streamlist.limit(20);

		// 3.终止操作
		limitStream1.forEach(System.out::println);
	}

	// skip
	@Test
	public void test5() {

		// 1.获取Stream对象
		Stream<Employee> streamlist = list.stream();

		// 2.中间操作
		// 2-1.中间操作——skip
		Stream<Employee> skipStream = streamlist.skip(2);

		// 3.终止操作
		skipStream.forEach(System.out::println);
	}

	// 连写
	@Test
	public void test6() {
		list.stream().filter(e -> e.getSalary() > 1000).limit(3).distinct().skip(1).forEach(System.out::println);
	}

	// 映射map
	@Test
	public void testmap1() {
		// 1.获取Stream对象
		Stream<Employee> streamlist = list.stream();
		// 2.中间操作
		// 2-1.map:将每一个元素 映射成一个普通类型的元素
		Stream<String> mapStream = streamlist.map(Employee::getName);
		// Stream<Integer> map = streamlist.map(Employee::getAge);
		// 3.终止操作
		mapStream.forEach(System.out::println);
	}

	// 映射 flatMap
	@Test
	public void testmap2() {
		// 1.获取Stream对象
		Stream<Employee> streamlist = list.stream();
		// 2.中间操作
		Stream<Object> mapstream = streamlist.flatMap(TestStreamMiddle::fromEmployeeToStream);
		// 3.终止操作
		mapstream.forEach(System.out::println);
	}

	public static Stream<Object> fromEmployeeToStream(Employee e) {
		return Stream.of(e.getId(), e.getName(), e.getAge(), e.getSalary());
	}

	// 映射flatMap
	@Test
	public void testmap3() {
		// 定义一个集合
		List<String> list = new ArrayList<>();
		list.add("john");
		list.add("lucy");
		list.add("lily");
		// 获取Stream对象
		Stream<String> streamlist = list.stream();
		// 映射:将每一个元素 映射成char类型的Stream
		Stream<Character> flatmapStream = streamlist.flatMap(TestStreamMiddle::fromStreamToChar);
		// 终止操作
		flatmapStream.forEach(System.out::println);
	}

	public static Stream<Character> fromStreamToChar(String str) {
		char[] charArray = str.toCharArray();
		List<Character> list = new ArrayList<>();
		for (int i = 0; i < charArray.length; i++) {
			list.add(charArray[i]);
		}
		return list.stream();
	}

	// 排序
	@Test
	public void testsort1() {
		List<String> list2 = Arrays.asList("john", "lucy", "tom");
		// 1.获取Stream对象
		// Stream<String> stream = list2.stream();
		Stream<Employee> stream = list.stream();
		// 2.中间操作
		// 2-1 .排序
		// Stream<Employee> sorted = stream.sorted();
		Stream<Employee> sorted = stream.sorted((o1, o2) -> Integer.compare(o2.getAge(), o1.getAge()));
		// 3.终止操作
		sorted.forEach(System.out::println);
	}
	
}
