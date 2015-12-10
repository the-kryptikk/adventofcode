import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day6 {
	
	static int[][] lights;

	public static void main(String[] args) {
		lights = new int[1000][1000];
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 1000; j++) {
				lights[i][j] = 0;
			}
		}
		
		String file = args[0];
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			for(String line; (line = br.readLine()) != null;) {
				Pattern onP = Pattern.compile("turn on (\\d+),(\\d+) through (\\d+),(\\d+)");
				Pattern offP = Pattern.compile("turn off (\\d+),(\\d+) through (\\d+),(\\d+)");
				Pattern toggleP = Pattern.compile("toggle (\\d+),(\\d+) through (\\d+),(\\d+)");
				Matcher m = onP.matcher(line);
				if (m.find()) {
					turnOn(Integer.parseInt(m.group(1)), 
						   Integer.parseInt(m.group(2)), 
						   Integer.parseInt(m.group(3)), 
						   Integer.parseInt(m.group(4)));
					continue;
				}
				m = offP.matcher(line);
				if (m.find()) {
					turnOff(Integer.parseInt(m.group(1)), 
						   Integer.parseInt(m.group(2)), 
						   Integer.parseInt(m.group(3)), 
						   Integer.parseInt(m.group(4)));
					continue;
				}
				m = toggleP.matcher(line);
				if (m.find()) {
					toggle(Integer.parseInt(m.group(1)), 
						   Integer.parseInt(m.group(2)), 
						   Integer.parseInt(m.group(3)), 
						   Integer.parseInt(m.group(4)));
					continue;
				}
				System.out.println("Konnte nicht matchen");
				break;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		int count = 0;
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 1000; j++) {
				count += lights[i][j];
			}
		}
		System.out.println(count);
	}

	private static void toggle(int x1, int y1, int x2, int y2) {
		for(int i = x1; i <= x2; i++) {
			for(int j = y1; j <= y2; j++) {
				lights[i][j] += 2;
			}
		}
	}

	private static void turnOff(int x1, int y1, int x2, int y2) {
		for(int i = x1; i <= x2; i++) {
			for(int j = y1; j <= y2; j++) {
				if (lights[i][j] > 0)
					lights[i][j]--;
			}
		}
	}

	private static void turnOn(int x1, int y1, int x2, int y2) {
		for(int i = x1; i <= x2; i++) {
			for(int j = y1; j <= y2; j++) {
				lights[i][j]++;
			}
		}
	}

}
