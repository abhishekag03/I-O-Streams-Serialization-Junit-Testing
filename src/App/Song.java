package App;

import java.io.Serializable;

public class Song implements Serializable{
	String name;
	String singer;
	float duration;

	public Song(String a, String b, float c){
		name = a;
		singer = b;
		duration = c;
	}
	@Override
	public String toString() {
		return ("Name: "+ this.name + " Singer: "+ this.singer + " Duration "+ this.duration);
	}
}
