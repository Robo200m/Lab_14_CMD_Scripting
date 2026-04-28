import java.util.Scanner;

public class SafeInput {
    private static final Scanner in = new Scanner(System.in);

    public static String getNonZeroLenString(String prompt) {
        String retVal;
        do {
            System.out.print(prompt + ": ");
            retVal = in.nextLine().trim();
        } while (retVal.isEmpty());
        return retVal;
    }

    public static int getRangedInt(String prompt, int low, int high) {
        boolean valid = false;
        int retVal = 0;
        do {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");
            if (in.hasNextInt()) {
                int temp = in.nextInt();
                if (temp >= low && temp <= high) {
                    retVal = temp;
                    valid = true;
                }
            }
            in.nextLine();
        } while (!valid);
        return retVal;
    }

    public static boolean getYNConfirm(String prompt) {
        String response;
        do {
            System.out.print(prompt + " [Y/N]: ");
            response = in.nextLine().trim().toUpperCase();
        } while (!response.equals("Y") && !response.equals("N"));
        return response.equals("Y");
    }
}