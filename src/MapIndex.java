import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

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

class TreeMapIndex {
	protected Map<String, TreeSet<Integer>> index;

	public TreeMapIndex() {
		index = new TreeMap<>();
	}

	public void add(String w, int lineNum) {
		TreeSet<Integer> i = null;
		if (!index.containsKey(w))
		{
			i = new TreeSet<Integer>();
			index.put(w, i);
		}
		i = index.get(w);
		i.add(lineNum);
	}
	
	public void print()
	{
		for(String s:index.keySet())
			System.out.println(s + " - " + index.get(s).toString());
	}
	
}
