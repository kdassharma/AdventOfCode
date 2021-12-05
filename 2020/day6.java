import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.HashMap;

public class day6 {
    public static void main(String[] args) {
        getDay6part1(); //6686
        getDay6part2(); //3476
    }

    public static void getDay6part1() {
        BufferedReader reader;
        int sum = 0;

        try {
            reader = new BufferedReader(new FileReader(
                    "./data/Day6.data"));
            String line = reader.readLine();
            HashSet<Character> distinctChars = new HashSet<>();

            while (line != null) {
                if (line.length() == 0) {
                    sum += distinctChars.size();
                    distinctChars.clear();
                }
                else {
                    for (int i = 0; i<line.length(); i++ ) {
                        distinctChars.add(line.charAt(i));
                    }
                }
                line = reader.readLine();
            }
            sum += distinctChars.size();
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(sum);
    }

    public static void getDay6part2() {
        BufferedReader reader;
        int sum = 0;

        try {
            reader = new BufferedReader(new FileReader(
                    "./data/Day6.data"));
            String line = reader.readLine();
            HashMap<Character, Integer> chars = new HashMap<>();
            int people = 0;

            while (line != null) {
                if (line.length() == 0) {
                    for (Integer value:chars.values()) {
                        if (value == people) {
                            sum++;
                        }
                    }
                    people = 0;
                    chars.clear();
                }
                else {
                    for (int i = 0; i<line.length(); i++ ) {
                        if (chars.containsKey(line.charAt(i))) {
                            chars.replace(line.charAt(i), chars.get(line.charAt(i)) + 1);
                        }
                        else {
                            chars.put(line.charAt(i), 1);
                        }
                    }
                    people++;
                }
                line = reader.readLine();
            }
            for (Integer value:chars.values()) {
                if (value == people) {
                    sum++;
                }
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(sum);
    }   
}
