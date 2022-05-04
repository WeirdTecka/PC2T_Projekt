

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Akce {
    protected static int CurrentID;

    public static void loadingBar() throws InterruptedException {

        final StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i <= 100 ; i++) {
            sb.setLength(0);
            for (int j = 0 ; j < i; j++) {
              sb.append("#");
            }
            Thread.sleep(10);
            System.out.print("[" + String.format("%-100s", sb.toString()) + "] " +  i + "%");
            System.out.print("\r");
        }
    }

    public static void pressAnyKey() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Pro pokracovani stisknete Enter");
        try {
            input.readLine();
            System.out.println("----------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     public static int onlyInt(int start, int end) {
        Scanner sc = new Scanner(System.in);
        try {
            int i = sc.nextInt();
            if (i > end || i < start)
            throw new CustomException("Zadané cislo je mimo rozsah! Zadejte znovu.");
            return i;
            }
        catch (InputMismatchException e) {
            System.out.println("Zadejte pouze cele cislo");
            return onlyInt(start, end);
            }
            catch (CustomException e) {
            System.out.format("%s (%d - %d)%n", e.getMessage(), start, end);
            return onlyInt(start, end);
            }
    }
    
}
