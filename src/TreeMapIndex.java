import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class TreeMapIndex {
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