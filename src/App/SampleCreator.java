package App;

import java.io.IOException;

public class SampleCreator {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		myApp obj = new myApp();
		Playlist p = new Playlist("sample");
		p.add(new Song("s1","singer1",10));
		p.add(new Song("s2","singer2",20));
		p.add(new Song("s3","singer3",15));
		p.add(new Song("s4","singer4",5));
		
		myApp.serialize(p);

	}

}
