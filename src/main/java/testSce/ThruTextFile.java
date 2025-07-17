package testSce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.Test;

public class ThruTextFile {

	
	FileWriter fw;
	BufferedWriter bw;
	FileReader fr;
	BufferedReader br;
	File fc;
	String src ="C:\\selenium_new\\Sel@9.30PM(IST)_June9th\\data.txt";
	
	@Test
	public void readFrmTextFile() throws IOException
	{
		fc=new File(src);
		fc.createNewFile();
		fw=new FileWriter(src);
		bw=new BufferedWriter(fw);
		bw.write("This is my first line");
		bw.newLine();
		bw.write("This is my Second line");
		bw.close();
		fr=new FileReader(src);
		br=new BufferedReader(fr);
		String cont=null;
		while((cont=br.readLine())!=null)
		{
			System.out.println(cont);
		}
		br.close();
		
		
	}
}
