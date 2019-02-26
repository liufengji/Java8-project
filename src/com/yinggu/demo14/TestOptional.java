package com.yinggu.demo14;
import java.util.Optional;
import org.junit.Test;

import com.yinggu.domain.Employee;
/**
 * 此类用于演示Optional的特点和使用 作用： 为了解决空指针异常的问题
 * 
 * 使用： 1、创建Optional对象 2、调用相关API
 * 
 * @author 黑猴子的家 
 * http://www.121ugrow.com/
 *
 */
public class TestOptional {

	// 创建Optional对象
	@Test
	public void test1() {

		// 方式一：将null对象进行了包装
		Optional opt1 = Optional.empty();
		System.out.println(opt1);

		// 方式二：将一个非空的对象进行了包装
		Optional<Employee> opt2 = Optional.of(new Employee(1, "john", 12, 1000));
		System.out.println(opt2);

		//Optional<Employee> opt3 = Optional.of(null);
		//System.out.println(opt3);

		// 方式三：将一个可能为空，也可能不为空的对象进行包装
		Optional<Employee> opt4 = Optional.ofNullable(new Employee(1, "john", 12, 1000));
		Optional<Employee> opt5 = Optional.ofNullable(null);
		System.out.println(opt4);
		System.out.println(opt5);
	}

	// 调用API
	@Test
	public void test2() {
		Optional<Employee> opt = Optional.ofNullable(new Employee(1, "john", 12, 1000));
		Optional<Employee> opt2 = Optional.ofNullable(null);

		// orElse
		// Employee orElse = opt2.orElse(new Employee());
		// System.out.println(orElse);

		// ifPresent
		// opt2.ifPresent(System.out::println);

		// get
		if (opt.isPresent()) {
			System.out.println(opt.get());
		} else {
			System.out.println("为空");
		}
	}
}