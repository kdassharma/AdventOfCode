import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class day2 {

    public static void main(String[] args) {
        getDay2(); //=410, 694
    }

    // How many passwords are valid according to their policies?
    public static void getDay2() {
        int valid = 0;
        int updateValid = 0;

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "./data/Day2.data"));
            String line = reader.readLine();
            while (line != null) {

                if (confirmPolicy(line)) {
                    valid++;
                }
                if (confirmUpdatedPolicy(line)) {
                    updateValid++;
                }
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println(valid);
        System.out.println(updateValid);

    }

    public static boolean confirmPolicy(String s) {
        String[] split = s.split(" ");
        int[] range = findRange(split[0]);
        char c = split[1].charAt(0);
        int count = 0;

        for (int i = 0; i<split[2].length(); i++) {
            if (split[2].charAt(i) == c) {
                count++;
            }
        }

        return count <= range[1] && count >= range[0];
    }

    public static boolean confirmUpdatedPolicy(String s) {
        String[] split = s.split(" ");
        int[] range = findRange(split[0]);
        char c = split[1].charAt(0);

        return (split[2].charAt(range[0] - 1) == c &&  split[2].charAt(range[1] - 1) != c) || (split[2].charAt(range[0] - 1) != c &&  split[2].charAt(range[1] - 1) == c);
    }

    public static int[] findRange(String s) {
        int[] out = {0,0};
        String num1 = "";
        String num2 = "";
        boolean found = false;

        for (int i = 0; i<s.length(); i++) {
            if (s.charAt(i) == '-') {
                found = true;
            }
            else if (found) {
                num2 += s.charAt(i);
            }
            else {
                num1 += s.charAt(i);
            }
        }

        out[0] = Integer.parseInt(num1); 
        out[1] = Integer.parseInt(num2); 
        return out;
    }

}
