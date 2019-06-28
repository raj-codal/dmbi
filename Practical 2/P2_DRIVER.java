package dmbi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Raj Dhanani
 */
public class P2_DRIVER {

    public static void main(String[] args) {
        /*
        
        Eg. Input DataSet : 
        10 12 3 6 5 25 17 100 1000 98 11 27 78 33 9 18 23 44 690 200
        
         */

        String y;
        System.out.println("Enter data set");
        Scanner in = new Scanner(System.in);
        y = in.nextLine();
        String Sdata[] = y.split(" ");
        ArrayList dataSet = new ArrayList();
        for (String o : Sdata) {
            dataSet.add(Integer.parseInt(o));
        }
        Normalize n = new Normalize(dataSet);
        System.out.println("z-score for the data set:");
        dataSet.forEach(x -> {
            System.out.println((int) x + "\t->\t" + n.zScore((int) x));
        });
        System.out.println("Decimal Scaling for the data set:");
        dataSet.forEach(x -> {
            System.out.println((int) x + "\t->\t" + n.decimalScaling((int) x));
        });
        System.out.println("Enter new min and max value for dataset:");
        n.initMinMax(in.nextInt(), in.nextInt());
        System.out.println("Min Max normalization for the data set:");
        dataSet.forEach(x -> {
            System.out.println((int) x + "\t->\t" + n.minMax((int) x));
        });
    }
}
