package dmbi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Raj Dhanani
 */
public class P3_DRIVER {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size;
        ArrayList n = new ArrayList();
        System.out.println("ENTER SIZE OF DATASET");
        size = in.nextInt();
        System.out.println("ENTER NUMERICAL DATA SET:");
        for (int i = 0; i < size; i++) {
            n.add(in.nextInt());
        }
        System.out.println("ENTER BIN SIZE:");
        Bin b = new Bin(n,in.nextInt());
        b.smoothingByBoundary().forEach(m -> {
            System.out.println(">"+(int)m);
        });
    }
}
