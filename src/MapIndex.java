import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * This code gets the lines on which a certain word is held
 * (kinda like grep)
 * @author benpazienza derekmorales
 * @version 1.0 11/27/2018
 *
 */
public class MapIndex {

	protected static String FILE = "darthplagueis.txt";

	public static void main(String[] args) throws FileNotFoundException {
		TreeMapIndex t = new TreeMapIndex();
		Scanner stan = new Scanner(new File(FILE));

		String ln = "";
		int lnCount = 1;
		while (stan.hasNextLine()) {
			ln = stan.nextLine();
			
			if(ln.equals(""))
				continue;
			
			String[] lnBreak = ln.split(" ");
			for (String s : lnBreak)
			{
				if(!s.equals("\n"))
					t.add(s, lnCount);
			}

			lnCount++;
		}
		
		t.print();
	}
}

