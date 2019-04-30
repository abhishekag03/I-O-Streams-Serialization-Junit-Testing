package AppTest;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import App.Playlist;
import App.myApp;

public class searchTest {
	
	@Test
	public void test() throws IOException, ClassNotFoundException{
		myApp obj = new myApp();
//		System.out.println("hello?");
		
		Playlist p = myApp.deserialize("sample");
//		System.out.println("hi");
		String output = p.search("sn");
		String expected = "Song does not exist";
//		System.out.println(output);
//		System.out.println(expected);
		assertEquals(output, expected );
	}

}
