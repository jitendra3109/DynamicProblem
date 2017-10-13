import java.io.*;
import java.util.*;

public class Assignment {
    long M = 1000000007;
    HashMap<Long,Long> map = new HashMap<>();
    public long countStrings(long n) {
        //long a = 1, b = 1, c =0;  
        // linear apporuce O(n);
        // for (long i = 1; i < n+1; i++) {
        //     c = (a + b)/1000000007;
        //     b = a;
        //     a = c;
        // }        
        if (map.containsKey(n)) {
            return map.get(n);
        }
        long k=n/2;
        if (n%2==0) { // n=2*k
            return map.put(n, (countStrings(k)*countStrings(k) + countStrings(k-1)*countStrings(k-1))%M);
        }
        else { // n=2*k+1
        return map.put(n, (countStrings(k)*countStrings(k+1) + countStrings(k-1)*countStrings(k))% M);
    }
}
    
    public static void main (String args[]) {
        Scanner in = new Scanner(System.in);
        long m = in.nextLong();
        Assignment as = new Assignment();
        if (m == 1) {
            System.out.println("2");
            return ;
        }
        as.map.put(1L,1L);
        while(m > 0){
            long n = in.nextLong();
            System.out.println(as.countStrings(n));
            m--;
        }
     return ;   
    }
}