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
		WordRecommender wr = new WordRecommender("./good_words.txt");
		
		
		
		
			File myfile = new File ("/Users/jaymag/git/mcit/week6/src/bad_words.txt");
			//Scanner s = new Scanner(wr.getFileName());
			Scanner s;
			try {
				s = new Scanner(myfile);
				FileWriter fw = new FileWriter ("tester_fix.txt", true);
				
				while(s.hasNext()) {
					String temp = s.next().toLowerCase();
					
					if (spellChecker(temp) == true) {
						fw.write(temp);	
						fw.write(" ");
					} if (spellChecker(temp) == false) {
						Scanner d = new Scanner(System.in);
						System.out.println("The word " + temp + " is misspelled");
						System.out.println("The following suggestions are available:");
						System.out.println(wr.prettyPrint(wr.getWordSuggestions(temp, 2, 0.75, 3)));
						System.out.println("Press ‘r’ for replace, ‘a’ for accept as is, ‘t’ for type in manually.");
						String letter = d.nextLine();
						
						if (letter.equals("a")) {
							fw.write(temp);
							fw.write(" ");
						}
						
					}
					
				
					
				}
				
				
				fw.flush();
				fw.close();
				
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
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
