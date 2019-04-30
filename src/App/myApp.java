package App;
import java.util.*;
//import java.lang.*;
import java.io.*;



public class myApp {

	public static void serialize(Playlist p) throws IOException{

		ObjectOutputStream out = null;
		try {
//			System.out.println(p.getName());x`
			out = new ObjectOutputStream(new FileOutputStream("./src/" + p.getName() + ".txt"));
//			System.out.println("created");
			out.writeObject(p);
		}
		finally {
			out.close();
		}
	}
	public static Playlist deserialize(String filename) throws IOException, ClassNotFoundException{
		
		ObjectInputStream in = null;
		try {
			
			in = new ObjectInputStream(new FileInputStream("./src/" + filename + ".txt"));
			Playlist s1 = (Playlist)in.readObject();
			//			in.readObject();
			return s1;
		}
		finally {
			in.close();
		}
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		
//		System.out.println(path);
//		Playlist p = new Playlist("sample");
//		p.add(new Song("s1","singer1",10));
//		p.add(new Song("s2","singer2",20));
//		p.add(new Song("s3","singer3",15));
//		p.add(new Song("s4","singer4",5));
//		
//		serialize(p);
		
		while (true) {
			final String path = (new File("").getAbsolutePath())+ "/src";
			File allfiles = new File(path);
			File array[] = allfiles.listFiles();
			System.out.println("List of current playlists:");
			for (File file : array) {
//				System.out.println(file.getName());
				if (file.getName().endsWith(".txt")) {
//					Sysou
					System.out.println(file.getName());
				}
			}
			int loop = 0;
			
			System.out.println("Enter the name of the playlist: ");
			String s = Reader.next();
			Playlist playlist = deserialize(s);
			//			printmenu()
			while (true) {
				
//				Playlist playlist = deserialize(s);
				System.out.println("1. Add a new song");
				System.out.println("2. Delete a song");
				System.out.println("3. Search for a song");
				System.out.println("4. Show all songs");
				System.out.println("5. Back to menu");
				System.out.println("6. Exit");

				int input = Reader.nextInt();

				if (input==1) {
//					Playlist playlist = deserialize(s);
					System.out.println("Enter Song name");
					String name = Reader.next();
					System.out.println("Enter Singers name");
					String singer = Reader.next();
					System.out.println("Enter duration");
					float dur = Reader.nextFloat();

					Song song = new Song(name, singer, dur);

					int num = playlist.add(song);
					System.out.println(num);
					serialize(playlist);
				}

				else if (input==2) {
//					Playlist playlist = deserialize(s);
					System.out.println("Enter the name of song you want to delete");
					String name = Reader.next();
					String s2 = playlist.delete(name);
					System.out.println(s2);
					serialize(playlist);
				}

				else if (input==3) {
//					Playlist playlist = deserialize(s); 
					System.out.println("Enter the name of song you want to search");
					String name = Reader.next();
//					playlist.delete(name);
					playlist.search(name); 
				}

				else if (input==4) {
//					Playlist playlist = deserialize(s);
					String out = playlist.show();
					System.out.println(out);
				}
				
				else if (input==5) {
					loop = 1;

					break;
				}
				
				else if (input==6) {
					loop = 2;
					break;
				}
			}
			if (loop==1) {
				continue;
			}
			if (loop==2) {
				break;
			}
		}
	}

}
class Reader {
	static BufferedReader reader;
	static StringTokenizer tokenizer;
	/** call this method to initialize reader for InputStream */
	static void init(InputStream input) {
		reader = new BufferedReader(
				new InputStreamReader(input) );
		tokenizer = new StringTokenizer("");
	}

	/** get next word */
	static String next() throws IOException {
		while ( ! tokenizer.hasMoreTokens() ) {
			//TODO add check for if necessary
			tokenizer = new StringTokenizer(
					reader.readLine() );
		}
		return tokenizer.nextToken();
	}

	static int nextInt() throws IOException {
		return Integer.parseInt( next() );
	}
	static float nextFloat() throws IOException {
		return Float.parseFloat( next() );
	}
	static double nextDouble() throws IOException {
		return Double.parseDouble( next() );
	}
}