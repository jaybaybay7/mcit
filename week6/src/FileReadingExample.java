import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileReadingExample {

	public static void main(String[] args) {
		File myFile = new File("/Users/jaymaglione/git/mcit/week6/src/newfile");
		try {
			Scanner s = new Scanner(myFile);
			try {
				FileWriter fw = new FileWriter(myFile, true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			s.nextLine();
			String countLine = s.nextLine();
			
			Scanner q = new Scanner(countLine);
			int count = 0;
			
			while(q.hasNext()) {
				q.next();
				count++;
			}
			
			System.out.println(count);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
