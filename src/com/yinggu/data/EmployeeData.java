package com.yinggu.data;

import java.util.ArrayList;
import java.util.List;
import com.yinggu.domain.Employee;

/**
 * 封装多个员工对象的数据类 
 * @author 黑猴子的家
 * http://www.121ugrow.com/
 */

public class EmployeeData {
	
	public static List<Employee> getData() {

		List<Employee> list = new ArrayList<>();

		list.add(new Employee(1, "乔峰", 35, 29000));
		list.add(new Employee(2, "虚竹", 27, 39000));
		list.add(new Employee(3, "阿紫", 18, 8000));
		list.add(new Employee(4, "阿朱", 26, 18000));
		list.add(new Employee(5, "段誉", 23, 45000));
		list.add(new Employee(6, "王语嫣", 21, 1000));

		return list;
	}

}
