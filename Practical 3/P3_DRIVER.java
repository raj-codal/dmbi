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
        b.data.forEach(m -> {
            System.out.print((int)m+" ");
        });
        System.out.println("\nBY BOUNDARY");
        b.smoothingByBoundary().forEach(m -> {
            System.out.print((int)m+" ");
        });
        System.out.println("\nBY MEAN");
        b.smoothingByMean().forEach(m -> {
            System.out.print((int)m+" ");
        });
        System.out.println("\nBY MEDIAN");
        b.smoothingByMedian().forEach(m -> {
            System.out.print((int)m+" ");
        });
    }
}
