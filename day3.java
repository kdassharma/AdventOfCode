import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class day3 {
    public static void main(String[] args) {
        double a = getDay3(1,1); //60
        System.out.println(a);
        double b = getDay3(3,1); //286
        System.out.println(b);
        double c = getDay3(5,1); //76
        System.out.println(c);
        double d = getDay3(7,1); //62
        System.out.println(d);
        double e = getDay3(1,2); //45
        System.out.println(a*b*c*d*e);
    }

    public static double getDay3(double right, double down) {
        BufferedReader reader;
        int pos = 0;
        double trees = 0;
        int lineCount = 0;

        try {
            reader = new BufferedReader(new FileReader(
                    "./data/Day3.data"));
            String line = reader.readLine();
            while (line != null) {
                if (lineCount%down == 0) {
                    pos = pos%line.length();
                    if (line.charAt(pos) == '#') {
                        trees++;
                    }
                    pos += right;
                }

                lineCount++;
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return trees;
    }
}
