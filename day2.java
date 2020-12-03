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

                String[] split = line.split(" ");
                String[] strRange = split[0].split("-");
                int[] range = {Integer.parseInt(strRange[0]), Integer.parseInt(strRange[1])};
                char c = split[1].charAt(0);

                if (confirmPolicy(split, range,  c, "Regular")) {
                    valid++;
                }
                if (confirmPolicy(split, range,  c, "Updated")) {
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

    public static boolean confirmPolicy(String[] split, int[] range,  char c, String policyType) {
        int count = 0;

        if (policyType.equals("Updated")) {
            return (split[2].charAt(range[0] - 1) == c &&  split[2].charAt(range[1] - 1) != c) || (split[2].charAt(range[0] - 1) != c &&  split[2].charAt(range[1] - 1) == c);
        }

        for (int i = 0; i<split[2].length(); i++) {
            if (split[2].charAt(i) == c) {
                count++;
            }
        }

        return count <= range[1] && count >= range[0];
    }
}
