import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class WordRunner {
	
	public WordRunner() {
		
	}
	
	public boolean spellChecker(String word) {
		File dic = new File("./engDictionary.txt");
		try {
			Scanner s = new Scanner(dic);
			
			while (s.hasNext()) {
				if (s.next().equals(word)) {
					return true;
				}
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public void spellWriter() {
		WordRecommender wr = new WordRecommender("./wordtester_good");
		
		
		
		
		
			Scanner s = new Scanner(wr.getFileName());
			System.out.println(wr.getFileName());
			FileWriter fw;
			try {
				fw = new FileWriter("tester_fix", true);
				while (s.hasNext()) {
					fw.write(s.next());
					}
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}

	public static void main(String[] args) {
		WordRunner w = new WordRunner();
		w.spellWriter();
		
		
		

	}

}
