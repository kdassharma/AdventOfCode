import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
// import java.util.HashSet;

public class Advent{

    public static void main(String[] args) {
        
        // day1Part1(); //=290784
        // day1Part2(); //=177337980

    } 

    // Find the two entries that sum to 2020; what do you get if you multiply them together?
    public static void day1Part1(){

        int expense1 = 0;
        int expense2 = 0;
        boolean found = false;
        // HashSet<Integer> dividend = new HashSet<Integer>();
        ArrayList<Integer> expenseReport = new ArrayList<Integer>();

        BufferedReader reader;
        
        try {
			reader = new BufferedReader(new FileReader(
					"./data/Day1.data"));
			String line = reader.readLine();
			while (line != null) {
                // dividend.add(2020 - Integer.parseInt(line));
                expenseReport.add(Integer.parseInt(line));
				// System.out.println(line);
				// read next line
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
        }
        
        for (int i = 0; i<expenseReport.size()-1; i++) {
            Integer expense = expenseReport.get(i);
            for (int j = i+1; j<expenseReport.size(); j++) {
                if (expense+expenseReport.get(j) == 2020) {
                    expense1 = expense;
                    expense2 = expenseReport.get(j);
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }

        System.out.println(expense1*expense2);
    }

    // What is the product of the three entries that sum to 2020?
    public static void day1Part2() {

        int expense1 = 0;
        int expense2 = 0;
        int expense3 = 0;
        boolean found = false;
        // HashSet<Integer> dividend = new HashSet<Integer>();
        ArrayList<Integer> expenseReport = new ArrayList<Integer>();

        BufferedReader reader;
        
        try {
			reader = new BufferedReader(new FileReader(
					"./data/Day1.data"));
			String line = reader.readLine();
			while (line != null) {
                // dividend.add(2020 - Integer.parseInt(line));
                expenseReport.add(Integer.parseInt(line));
				// System.out.println(line);
				// read next line
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
        }
        
        for (int i = 0; i<expenseReport.size()-2; i++) {
            for (int j = i+1; j<expenseReport.size()-1; j++) {
                for (int k = j+1; k<expenseReport.size(); k++) {
                    if (expenseReport.get(i)+expenseReport.get(j)+expenseReport.get(k) == 2020) {
                        expense1 = expenseReport.get(i);
                        expense2 = expenseReport.get(j);
                        expense3 = expenseReport.get(k);
                        found = true;
			break;
                    }
                }
                if (found) {
                    break;
                }
            }
            if (found) {
                break;
            }
        }
        
        System.out.println(expense1*expense2*expense3);

    }

}
