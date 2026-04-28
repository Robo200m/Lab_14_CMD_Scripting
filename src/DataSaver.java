import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class DataSaver {
    public static void main(String[] args) {
        ArrayList<String> records = new ArrayList<>();
        boolean keepGoing = true;
        int idCounter = 1;

        while (keepGoing) {
            String first = SafeInput.getNonZeroLenString("Enter First Name");
            String last = SafeInput.getNonZeroLenString("Enter Last Name");
            String id = String.format("%06d", idCounter);
            idCounter++;
            String email = SafeInput.getNonZeroLenString("Enter Email");
            int yob = SafeInput.getRangedInt("Enter Year of Birth", 1900, 2024);

            String record = first + ", " + last + ", " + id + ", " + email + ", " + yob;
            records.add(record);

            keepGoing = SafeInput.getYNConfirm("Add another record?");
        }

        String filename = SafeInput.getNonZeroLenString("Enter filename (include .csv)");
        File file = new File("src/" + filename);

        try (PrintWriter out = new PrintWriter(file)) {
            for (String rec : records) {
                out.println(rec);
            }
            System.out.println("File saved successfully.");
        } catch (IOException e) {
            System.out.println("Error writing file.");
        }
    }
}