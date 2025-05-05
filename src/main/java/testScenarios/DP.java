package testScenarios;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DP {
	
	Object[][] data;
	@DataProvider(name="data")
	public Object[][] setData()
	{
		data = new Object[3][2];
		data[0][0]="jack";
		data[0][1]="jack123";
		
		data[1][0]="riya";
		data[1][1]="riya222";
		
		data[2][0]="tani";
		data[2][1]="tani222";
		return data;
	}
	@Test(dataProvider = "data")
	public void login(String un,String passwd)
	{
		System.out.println(un+"\t"+passwd);
		
		
	}

}
