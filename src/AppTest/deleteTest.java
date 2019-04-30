package AppTest;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import App.*;
public class deleteTest {

	@Test
	public void test() throws IOException, ClassNotFoundException{
		myApp obj = new myApp();
		Playlist p = myApp.deserialize("sample");
		p.delete("s2");
//		p.add(new Song("NewSong","NewSinger",15));
		
//		myApp.serialize(p);
		String output = p.show();
		String expected = "Name: s1 Singer: singer1 Duration 10.0" + "\n"+
//				"Name: s2 Singer: singer2 Duration 20.0"+ "\n" + 
				"Name: s3 Singer: singer3 Duration 15.0" + "\n" + 
				"Name: s4 Singer: singer4 Duration 5.0" + "\n" ;
//		System.out.println(output+".");
//		System.out.println(expected+".e");
//		System.out.println(".");
//		if(output.equals(expected))
//			System.out.println("yes");
		assertEquals(expected ,output);
//		serialize(p);
		
	}
//	Name: s1 Singer: singer1 Duration 10.0
//	Name: s2 Singer: singer2 Duration 20.0
//	Name: s3 Singer: singer3 Duration 15.0
//	Name: s4 Singer: singer4 Duration 5.0

}
