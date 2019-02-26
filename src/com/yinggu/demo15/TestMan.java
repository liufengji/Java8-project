package com.yinggu.demo15;

import java.util.Optional;

import org.junit.Test;
/*
 * @author 黑猴子的家 
 * http://www.121ugrow.com/
 */
public class TestMan {

	@Test
	public void test1() {

		System.out.println(getGirlName3(null));
		System.out.println(getGirlName3(new Man()));
		System.out.println(getGirlName3(new Man(new Girl())));

	}

	/**
	 * 优化二：使用Optional解决空指针 获取女孩的姓名
	 * 
	 * @param man
	 * @return
	 */
	public int getGirlName3(Man man) {
		Optional<Man> opt1 = Optional.ofNullable(man);
		Man newMan = opt1.orElse(new Man());
		Girl girl = newMan.getGirl();
		Optional<Girl> opt2 = Optional.ofNullable(girl);
		Girl orElse = opt2.orElse(new Girl("张柏芝"));

		String name = orElse.getName();
		Optional<String> opt3 = Optional.ofNullable(name);
		String newname = opt3.orElse("张柏芝");
		return newname.length();

	}

	/**
	 * 优化一：传统方式解决空指针 获取女孩的姓名
	 * 
	 * @param man
	 * @return
	 */
	public int getGirlName2(Man man) {
		if (man != null) {
			Girl girl = man.getGirl();
			if (girl != null) {
				String name = girl.getName();
				if (name != null) {
					return name.length();
				}
			}
		}
		return 0;
	}

	/**
	 * 获取女孩的姓名
	 * 
	 * @param man
	 * @return
	 */
	public int getGirlName(Man man) {
		return man.getGirl().getName().length();
	}

}
