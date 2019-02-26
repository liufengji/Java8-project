package com.yinggu.demo10;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

import com.yinggu.data.EmployeeData;
import com.yinggu.domain.Employee;

/**
 * @author 黑猴子的家 
 * http://www.121ugrow.com/
 * 
 * 此类用于演示创建Stream
 */
public class TestStreamCreate {

	// 通过集合获取Stream对象
	@Test
	public void test1() {
		List<Employee> list = EmployeeData.getData();
		// 根据list集合获取Stream对象
		Stream<Employee> stream = list.stream();
		stream.forEach(System.out::println);
		System.out.println("---------------------------");
	}

	// 通过数组获取Stream对象
	@Test
	public void test2() {
		Integer[] arr = { 10, 20, 30 };
		// 根据数组获取Stream对象
		//IntStream stream1 = (IntStream) Arrays.stream(arr);
		Stream<Integer> stream2 = Arrays.stream(arr);
		stream2.forEach(System.out::println);
		System.out.println("---------------------------");
	}

	// 通过制定的列表值获取Stream对象
	@Test
	public void test3() {
		Stream<String> stream = Stream.of("john", "lucy", "lily");
		stream.forEach(System.out::println);
		System.out.println("---------------------------");
	}

	// 无限流
	@Test
	public void test4() {

		//匿名内部类
//		Stream.generate(new Supplier<Double>() {
//			@Override
//			public Double get() {
//				// TODO Auto-generated method stub
//				return Math.random();
//			}
//		});
		//Lambda 表达式
		//Stream.generate( ()-> Math.random());
		
		Stream<Double> stream = Stream.generate(Math::random);
		stream.limit(5).forEach(System.out::println);
		//stream.forEach(System.out::println);
		System.out.println("---------------------------");
	}
}
