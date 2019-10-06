package kmean;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;

//SINGLE DIMENSION
/**
 *
 * @author Raj Dhanani
 */
class Cluster {

    ArrayList data = new ArrayList();
    double mean;
}

public class Kmean {

    static ArrayList data = new ArrayList();

    static Cluster c[];

    public static void initializeClusters() {
        int r1 = -1;
        for (int i = 0; i < c.length; i++) {
//            int r = ((int)(Math.random() * data.size())) % data.size();
//            c[i] = new Cluster();
//            if(r1 != r){
//                c[i].mean = (double)data.get(r);
//            } else {
//                c[i].mean = (double)data.get((r+1)%data.size());
//            }
//            r1 = r;
            c[i] = new Cluster();
            c[i].mean = (double) data.get(i);

        }
    }

    public static double distance(double mean, double v) {
        return Math.abs(mean - v);
    }

    public static int minIndexFromArray(double a[]) {
        int i = 0;
        double min = a[0];
        for (int j = 1; j < a.length; j++) {
            if (a[j] < min) {
                i = j;
                min = a[j];
            }
        }
        return i;
    }

    public static double mean(ArrayList x) throws Exception {
        if (x.size() > 0) {
            BigDecimal total = BigDecimal.ZERO;

            for (Object y : x) {
                total = total.add(new BigDecimal(Double.toString((double) y)));
            };

            BigDecimal meanValue = total.divide(new BigDecimal(Double.toString((double) x.size())), 1, RoundingMode.HALF_UP);
            return meanValue.doubleValue();
        } else {
            return 0;
        }
    }

    public static double percentDifference(double a1[], double a2[]) {
        double percent = 0;
        double b[] = a2.clone();
        for (int i = 0; i < b.length; i++) {
            b[i] = Math.abs(a1[i] - a2[i]);
            percent = b[i] / (a2[i] * a2.length);
        }
        return percent;
    }

    public static void itterate(int n) throws Exception {
        double meanArray1[] = new double[c.length];
        double meanArray2[] = new double[c.length];
        for (int i = 0; i < meanArray1.length; i++) {
            meanArray1[i] = 0;
            meanArray2[i] = 0;
        }
        double distanceMatrix[] = new double[c.length];
        boolean flag = true;
        int itt = 1;
        while (flag && n-- != 0) {

            for (int x = 0; x < c.length; x++) {
                c[x].data.clear();
            }
            data.forEach((Object v) -> {
                for (int i = 0; i < distanceMatrix.length; i++) {
                    distanceMatrix[i] = distance(c[i].mean, (double) v);
                }
                int minIndex = minIndexFromArray(distanceMatrix);
                c[minIndex].data.add(v);
            });
            int temp = 0;
            for (Cluster c1 : c) {
                try {
                    c1.mean = mean(c1.data);
                    meanArray2[temp] = c1.mean;
                    temp++;
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
            if (percentDifference(meanArray1, meanArray2) == 0) {
                flag = false;
            } else {
                meanArray1 = meanArray2.clone();
            }
            System.out.println("Itteration " + itt + ":");
            int p = 1;
            for (Cluster x : c) {
                System.out.println("cluster" + p + " : " + x.data);
                p++;
            }
            itt++;

        }

    }

    public static void main(String[] args) throws Exception {
        
        /*
                ENTER SIZE OF DATA SET:
                10
                ENTER THE DATA SET:
                10 11 1 3 25 50 21 2 70 22
                ENTER VALUE OF K:
                2
                ENTER MAX NUMBER OF ITTERTATIONS:
                100
                Itteration 1:
                cluster1 : [10.0, 1.0, 3.0, 2.0]
                cluster2 : [11.0, 25.0, 50.0, 21.0, 70.0, 22.0]
                Itteration 2:
                cluster1 : [10.0, 11.0, 1.0, 3.0, 2.0]
                cluster2 : [25.0, 50.0, 21.0, 70.0, 22.0]
                Itteration 3:
                cluster1 : [10.0, 11.0, 1.0, 3.0, 21.0, 2.0]
                cluster2 : [25.0, 50.0, 70.0, 22.0]
                Itteration 4:
                cluster1 : [10.0, 11.0, 1.0, 3.0, 21.0, 2.0, 22.0]
                cluster2 : [25.0, 50.0, 70.0]
                Itteration 5:
                cluster1 : [10.0, 11.0, 1.0, 3.0, 25.0, 21.0, 2.0, 22.0]
                cluster2 : [50.0, 70.0]
                Itteration 6:
                cluster1 : [10.0, 11.0, 1.0, 3.0, 25.0, 21.0, 2.0, 22.0]
                cluster2 : [50.0, 70.0]

                FINAL:
                cluster1( mean-11.9) : [10.0, 11.0, 1.0, 3.0, 25.0, 21.0, 2.0, 22.0]
                cluster2( mean-60.0) : [50.0, 70.0]
        */
        
        Scanner in = new Scanner(System.in);
        System.out.println("ENTER SIZE OF DATA SET:");
        double set[];// = {3, 10, 11, 12, 4, 20, 25, 2, 30};
        set = new double[in.nextInt()];
        in.nextLine();
        System.out.println("ENTER THE DATA SET:");
        for (int i = 0; i < set.length; i++) {
            set[i] = in.nextInt();
        }
        in.nextLine();
        System.out.println("ENTER VALUE OF K:");
        int k = in.nextInt();
        in.nextLine();
        System.out.println("ENTER MAX NUMBER OF ITTERTATIONS:");
        int t = in.nextInt();
        c = new Cluster[k];
        for (double x : set) {
            data.add(x);
        }
        initializeClusters();
        itterate(t);
        System.out.println();
        int i = 1;
        System.out.println("FINAL:");
        for (Cluster x : c) {
            System.out.println("cluster" + i + "( mean-" + x.mean + ") : " + x.data);
            i++;
        }
    }

}
