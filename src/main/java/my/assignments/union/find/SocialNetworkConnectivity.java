package my.assignments.union.find;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class SocialNetworkConnectivity {

    /**
     * Reads in a sequence of timestamp and pairs of integers (between 0 and n-1) from standard input,
     * where each integer represents some object;
     * if the sites are in different components, merge the two components
     * when the number of components is equal to 1, print the earliest time at which all members are connected.
     * If the number of components is greater than 1, print "all members are not connectected."
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        int n = StdIn.readInt();
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(n);
        while (!StdIn.isEmpty()) {
            String timestamp = StdIn.readString();
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
//            StdOut.println(p + " " + q);
            if (uf.count() == 1) {
                StdOut.println("The earliest time at which all members are connected is: " + timestamp);
                break;
            }
        }
//        StdOut.println(uf.count() + " components");
        if (uf.count() > 1){
            StdOut.println("All members are not connected.");
        }
    }

}