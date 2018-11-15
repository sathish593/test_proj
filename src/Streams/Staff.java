package Streams;

import java.math.BigDecimal;

public class Staff {
	public Staff(String string, int i, BigDecimal bigDecimal) {
		// TODO Auto-generated constructor stub
		this.name=string;
		this.age=i;
		this.salary=bigDecimal;
	}
	private String name;
    private int age;
    private BigDecimal salary;
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

}
