package AppTest;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import App.*;
public class addTest {

	@Test
	public void test() throws IOException, ClassNotFoundException{
		myApp obj = new myApp();
		Playlist p = myApp.deserialize("sample");
		
		p.add(new Song("NewSong","NewSinger",15));
		
		String output = p.show();
		String expected = "Name: s1 Singer: singer1 Duration 10.0" + "\n"+
				"Name: s2 Singer: singer2 Duration 20.0"+ "\n" + 
				"Name: s3 Singer: singer3 Duration 15.0" + "\n" + 
				"Name: s4 Singer: singer4 Duration 5.0" + "\n" +
				"Name: NewSong Singer: NewSinger Duration 15.0\n";

		assertEquals(expected ,output);
		
	}


}
