package com.yinggu.demo04;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

import com.yinggu.data.EmployeeData;
import com.yinggu.domain.Employee;


/**
 * @author 黑猴子的家
 * http://www.121ugrow.com/
 * 
 * 调用Collections.sort()方法，通过定制排序比较两个Employee(先按年龄比，年龄相同按姓名比),使用Lambda表达式作为参数传递。    
 **/
public class TestLambda1 {

   /**
    * 调用Collections.sort()方法，通过定制排序比较两个Employee(先按年龄比，年龄相同按姓名比),使用Lambda表达式作为参数传递。
    */
	@Test
	public void test1() {

		List<Employee> list = EmployeeData.getData();
		
		Collections.sort(list, new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				int com = o1.getAge() - o2.getAge();
				if (com > 0) {
					return 1;
				} else if (com < 0) {
					return -1;
				}
				return o1.getName().compareTo(o2.getName());
			}

		});
		System.out.println(list);
		System.out.println("---------------------");

		Collections.sort(list, (o1, o2) -> { 
				int com = o1.getAge() - o2.getAge();
				if (com > 0) {
					return 1;
				} else if (com < 0) {
					return -1;
				}
				return o1.getName().compareTo(o2.getName()); 
		});
		System.out.println(list);
	}
}