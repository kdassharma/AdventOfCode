import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
// import java.util.HashSet;
import java.util.HashMap;
import java.util.Arrays;

public class day7 {
    public static void main(String[] args) {
        getDay7();
    }

    public static void getDay7() {
        HashMap<String, String[]> bags = new HashMap<>();
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(
                    "./data/Day7.data"));
            String line = reader.readLine();

            while (line != null) {
                String[] rule = line.split(" ");

                String typeOfBag = "" + rule[0] + "  "+ rule[1];
                // printArr(Arrays.copyOfRange(rule, 4, rule.length).toString());
                // printArr(Arrays.copyOfRange(rule, 4, rule.length));
                System.out.println(Arrays.copyOfRange(rule, 4, rule.length).toString());
                // addRule(bags, typeOfBag, Arrays.copyOfRange(rule, 4, rule.length).toString());

                line = reader.readLine();
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addRule(HashMap<String, String[]> bags,String typeOfBag, String bagsInside) {
        if (bags.containsKey(typeOfBag)) {
            return;
        }
        bags.put(typeOfBag, bagsInside.split(","));
    }

    public static void printArr(String[] arr) {
        for (int i = 0; i<arr.length; i++) {
            System.out.print(arr[i]+",");
        }
        System.out.println("");
    }
}
