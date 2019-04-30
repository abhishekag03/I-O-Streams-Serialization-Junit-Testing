package App;

import java.io.Serializable;
import java.util.ArrayList;

public class Playlist implements Serializable{
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
	ArrayList<Song> songlist;
	String name;
	public Playlist(String s){
		songlist =  new ArrayList<Song>();
		name = s;
	}

	public String getName() {
		return this.name;
	}

	public int add(Song s) {
		this.songlist.add(s);
		return this.getSize();
	}

	public int getSize() {
		return this.songlist.size();
	}

	public String delete(String name) {
		int index=0;
		int flag = 0;
		for (int i=0; i<this.songlist.size(); i++) {
			if ((this.songlist.get(i).name).equals(name)) {
				index=i;
				flag=1;
			}
		}
		if (flag==1) {
			this.songlist.remove(index);
//			System.out.println(this.songlist.size());
			return (Integer.toString(this.songlist.size()));
		}
		else {
			return "Song does not exist";
		}
	}


	public String show() {
		if (this.songlist.size()==0) {
//			System.out.println("No Song Exists");
			return "No Song Exists";
		}
		String s = "";
		for (int i=0; i<this.songlist.size();i++) {
//			System out.println(this.songlist.get(i));
			s = s + this.songlist.get(i) + "\n";
//			return (this.songlist.get(i).toString());
		}
		
		return s;
	}

	public String search(String s) {
		for (int i=0; i<this.songlist.size(); i++) {
			if ((this.songlist.get(i).name).equals(s)) {
//				System.out.println(this.songlist.get(i));
				return this.songlist.get(i) + "\n";
			}
		} 
//		System.out.println("Song does not exist");
		return "Song does not exist";
	}

}
