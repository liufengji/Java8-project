package com.yinggu.demo15;
/*
 * @author 黑猴子的家 
 * http://www.121ugrow.com/
 */
public class Girl {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Girl(String name) {
		super();
		this.name = name;
	}

	public Girl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Girl [name=" + name + "]";
	}

}
