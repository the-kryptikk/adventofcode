import java.util.HashSet;


public class Main {

	public static void main(String[] args) {
		String route = args[0];
		int curX = 0, curY = 0;
		HashSet<Coord<Integer, Integer>> list = new HashSet<Coord<Integer,Integer>>();
		list.add(new Coord<Integer, Integer>(0, 0));
		System.out.println(list.size());
	}

}
