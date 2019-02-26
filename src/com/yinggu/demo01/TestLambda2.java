package com.yinggu.demo01;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.yinggu.data.EmployeeData;
import com.yinggu.domain.Employee;
import com.yinggu.util.Filter;



/**
 * 此类用于演示Lambda表达式使用二
 * 
 * @author 黑猴子的家
 * http://www.121ugrow.com/
 * 
 * 问题：针对员工的集合数据，有如下的一些需求，我们考虑如何完成？
 * 
 *         需求1：获取当前公司中员工年龄大于30的员工信息 
 *         需求2：获取公司中工资大于 5000 的员工信息 
 */
public class TestLambda2 {

	// 进阶3
	@Test
	public void test3() {
		List<Employee> list = EmployeeData.getData();
		// 需求1：获取当前公司中员工年龄大于30的员工信息
		List<Employee> ageList = getData(list, e -> e.getAge() > 30);
		printList(ageList);
		System.out.println("--------------------");
		// 需求3：获取当前公司中员工工资>20000的员工信息
		List<Employee> salaryList = getData(list, e -> e.getSalary() > 20000);
		printList(salaryList);
	}

	// 进阶2
	@Test
	public void test2() {
		List<Employee> list = EmployeeData.getData();
		// 需求1：获取当前公司中员工年龄大于30的员工信息
		Filter<Employee> ageFilter = new Filter<Employee>() {
			@Override
			public boolean filter(Employee e) {
				return e.getAge() > 30;
			}

		};
		List<Employee> ageList = getData(list, ageFilter);
		printList(ageList);

		System.out.println("--------------------------------");

		// 需求2：获取当前公司中员工工资>20000的员工信息

		Filter<Employee> salaryFilter = new Filter<Employee>() {
			@Override
			public boolean filter(Employee e) {
				return e.getSalary() > 20000;
			}

		};
		List<Employee> salaryList = getData(list, salaryFilter);
		printList(salaryList);

	}

	// 进阶1
	@Test
	public void test1() {
		List<Employee> list = EmployeeData.getData();
		// 需求1：获取当前公司中员工年龄大于30的员工信息
		List<Employee> ageList = filterByAge(list);
		printList(ageList);
		System.out.println("--------------------------------");
		// 需求2：获取当前公司中员工工资>20000的员工信息
		List<Employee> salaryList = filterBySalary(list);
		printList(salaryList);

	}

	// 根据过滤器进行筛选员工信息
	public List<Employee> getData(List<Employee> list, Filter<Employee> filter) {

		List<Employee> data = new ArrayList<>();
		for (Employee employee : list) {

			if (filter.filter(employee)) {
				data.add(employee);
			}
		}
		return data;

	}

	// 打印集合对象的各个元素
	public void printList(List<Employee> list) {
		for (Employee employee : list) {
			System.out.println(employee);
		}
	}

	/*
	 * 按年龄过滤，返回符和要求的数据
	 */
	public List<Employee> filterByAge(List<Employee> list) {
		List<Employee> data = new ArrayList<>();
		for (Employee employee : list) {

			if (employee.getAge() > 30) {
				data.add(employee);
			}
		}
		return data;

	}

	/*
	 * 按工资过滤，返回符和要求的数据
	 */
	public List<Employee> filterBySalary(List<Employee> list) {
		List<Employee> data = new ArrayList<>();
		
		for (Employee employee : list) {
			if (employee.getSalary() > 20000) {
				data.add(employee);
			}
		}
		return data;

	}

}

