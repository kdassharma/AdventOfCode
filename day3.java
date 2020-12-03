import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class day3 {
    public static void main(String[] args) {
        int a = getDay3(1,1); //60
        System.out.println(a);
        int b = getDay3(3,1); //286
        System.out.println(b);
        int c = getDay3(5,1); //76
        System.out.println(c);
        int d = getDay3(7,1); //62
        System.out.println(d);
        int e = getDay3(1,2); //45
        System.out.println(e);
    }

    public static int getDay3(int right, int down) {
        BufferedReader reader;
        // int[][] grid = new int[323][31];
        int pos = 0;
        int trees = 0;
        int lineCount = 0;

        try {
            reader = new BufferedReader(new FileReader(
                    "./data/Day3.data"));
            String line = reader.readLine();
            while (line != null) {

                if (lineCount%down != 0) {
                    lineCount++;
                    line = reader.readLine();
                    continue;
                }

                if (pos > line.length() - 1) {
                    pos = pos - line.length();
                }

                // System.out.println(pos+","+lineCount);
                
                if (line.charAt(pos) == '#') {
                    trees++;
                }

                pos += right;
                lineCount++;
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return trees;
    }
    
}
