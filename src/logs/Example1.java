package logs;

 class Example11 {
	int a;
	int b;
	int c;
	int d;
	
	public int sum()
	{
		return a+b;
		
	}

	public int sum2()
	{
		int temp=c+d;
		System.out.println("in class Example11----"+ temp);
		return c+d;
	}
}

class Ex2 extends Example11
{

	
	public int product()
	{
		return a * b;
		
	}
	
	public int product1()
	{
		return c * d;		
	}
	public int sum2()
	{
		System.out.println("in class Ex2-----"+ a);
		return a+b+c+d;
	}
}
public class Example1{
	public static void main(String[] args) {
		
		
		
		Example11 temp2 = new Example11();
		temp2.a=10;
		temp2.b=10;
		temp2.c=10;
		temp2.d=10;
		
		temp2.sum2();
		
		Ex2 temp1=new Ex2();
		System.out.println(temp1.a+"-"+temp1.b);
	}
}