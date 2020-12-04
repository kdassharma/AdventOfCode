import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class day4 {
    public static void main(String[] args) {
        getDay4(); //104

    }

    public static void getDay4() {
        BufferedReader reader;
        int valid = 0;
    
        try {
            reader = new BufferedReader(new FileReader(
                    "./data/Day4.data"));
            String line = reader.readLine();
            String passport = "";
            while (line != null) {
                if (line.length() == 0) {
                    if (checkValid(passport)) {  
                        valid++;
                    }
                    passport= "";
                }
                else {
                    passport += line +  " ";
                }
                line = reader.readLine();
            }
            reader.close();
            if (checkValid(passport)) {
                valid++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(valid);

    }

    public static boolean checkValid(String s) {
        // System.out.println(s);
        String[] fields = s.split(" ");
        int count = 0;
        for (int i = 0; i<fields.length; i++) {
            String key = fields[i].split(":")[0];

            if (key.equals("byr")) {
                int value = Integer.parseInt(fields[i].split(":")[1]);
                if (value >= 1920 && value <= 2002) {
                    count++;
                }
                else {
                    break;
                }
            }
            else if (key.equals("iyr")) {
                int value = Integer.parseInt(fields[i].split(":")[1]);
                if (value >= 2010 && value <= 2020) {
                    count++;
                }
                else {
                    break;
                }
            }
            else if (key.equals("eyr")) {
                int value = Integer.parseInt(fields[i].split(":")[1]);
                if (value >= 2020 && value <= 2030) {
                    count++;
                }
                else {
                    break;
                }
            }
            else if (key.equals("hgt")) {
                String value = fields[i].split(":")[1];
                String unit = "" + value.charAt(value.length() - 2)+value.charAt(value.length() - 1);
                if (unit.contains("cm") == false && unit.contains("in") == false) {
                    break;
                }
                int val = Integer.parseInt(value.substring(0, value.length() - 2));

                if (unit.equals("cm") && (val >= 150 && val <= 193)) {
                    count++;
                }
                else if (val >= 59 && val <= 76) {
                    count++;
                }
                else {
                    break;
                }
            }
            else if (key.equals("hcl")) {
                String value = fields[i].split(":")[1];
                boolean hclValid = true;
                if (value.charAt(0) == '#' && value.length() == 7) {
                    for (int j = 1; j<value.length(); j++) {
                        if ((value.charAt(j) < '0' && value.charAt(j) > '9') || (value.charAt(j) < 'a' && value.charAt(j) > 'f')) {
                            hclValid = false;
                            break;
                        }
                    }

                    if (hclValid) {
                        count++;
                    }
                    else {
                        break;
                    }
                }
            }
            else if (key.equals("ecl")) {
                String value = fields[i].split(":")[1];
                if (value.equals("amb") || value.equals("blu") || value.equals("brn") || value.equals("gry") || value.equals("grn") || value.equals("hzl") || 
                value.equals("oth")) {
                    count++;
                }
                else {
                    break;
                }
            }
            else if (key.equals("pid")) {
                boolean valid = true;
                String value = fields[i].split(":")[1];
                try {
                    Long.parseLong(value);
                }
                catch (Exception e) {
                    valid = false;
                }
                if (value.length() == 9 && valid) {
                    count++;
                }
                else {
                    break;
                }
            }
        }

        return count == 7;
        // return s.contains("ecl") && s.contains("pid") && s.contains("eyr") && s.contains("hcl") 
        // && s.contains("byr") && s.contains("iyr") && s.contains("hgt");
    }
}
