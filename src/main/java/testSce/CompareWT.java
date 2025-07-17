package testSce;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class CompareWT {

	ArrayList<String> exp_data = new ArrayList<String>();
	ArrayList<String> act_data = new ArrayList<String>();
	FileReader fr;
	BufferedReader br;
	String src ="C:\\selenium_new\\Sel@9.30PM(IST)_June9th\\data.txt";
	@Test(priority=1)
	public void readFrmTxtFile() throws IOException
	{
		fr=new FileReader(src);
		br=new BufferedReader(fr);
		String cont=null;
		while((cont=br.readLine())!=null)
		{
			//System.out.println(cont);
			exp_data.add(cont);
		}
		System.out.println("Expected Array List count="+exp_data.size());
	}
	@Test(priority=2)
	public void readFrmWT()
	{
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		WebElement myTable=driver.findElement(By.id("customers"));
		List<WebElement> allRows=myTable.findElements(By.tagName("tr"));
		System.out.println("total rows="+allRows.size());
		for(int i=1;i<allRows.size();i++) //focus Rows
		{
			List<WebElement> allCols=allRows.get(i).findElements(By.tagName("td"));
			for(int j=0;j<allCols.size();j++)
			{
				//System.out.println(allCols.get(j).getText());
				act_data.add(allCols.get(j).getText());
				}
		}
		System.out.println("Actual Array List count="+act_data.size());
		driver.quit();
	}
	@Test(priority=3)
	public void compareData()
	{
		for(int i=0;i<exp_data.size();i++)
		{
			if(exp_data.get(i).equals(act_data.get(i))) {
				System.out.println("Item exists...");
			}
			else
			{
				System.out.println("Item not exists...");
			}
		}
	}
}
