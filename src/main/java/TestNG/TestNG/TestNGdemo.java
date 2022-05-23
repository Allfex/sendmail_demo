package TestNG.TestNG;

import com.automation.scenario.netseasy.params.TestParams;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNGdemo {

	private static String value = "这是初始化值 = 1";
	TestParams params = new TestParams();

	@BeforeClass
	public void setup(){
		System.out.println("a start!");
		System.out.println(value);
		value = "这里是setup修改后的值";
		params.setMailContent("第一个值");
	}
	
	@AfterClass
	public void tearup(){
		
		System.out.println("a end!");
		System.out.println(value);

		System.out.println(params.getMailContent());
		params.setMailContent("第四个值");
	}
	
	@Test
	public void test1(){
		System.out.println("a1");
		System.out.println(value);
		value = "这里是test1修改之后的值";

		System.out.println(params.getMailContent());
		params.setMailContent("第二个值");

		
	}
	
	@Test
	public void test2(){
		System.out.println("a2");
		System.out.println(value);
		value = "这里是test2修改之后的值";

		System.out.println(params.getMailContent());
		params.setMailContent("第三个值");
		
	}
	
	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

}
