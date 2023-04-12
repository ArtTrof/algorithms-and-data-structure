import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 100;
        System.out.println(fibEffective(n));

        long[] mem = new long[n + 1];
        Arrays.fill(mem, -1);
        System.out.println(fibNaive(n, mem));
    }

    //O(2^N) without memoization
    private static long fibNaive(int n, long[] mem) {
        if (mem[n] != -1)
            return mem[n];
        if (n <= 1)
            return n;
        long result = fibNaive(n - 1, mem) + fibNaive(n - 2, mem);
        mem[n] = result;
        return result;
    }
    //O(N)
    private static long fibEffective(int n) {
        //O(N)
        long arr[] = new long[n + 1];
        arr[0] = 0;//O(1)
        arr[1] = 1;//O(1)
        //n=2=>1
        //n=3=>2
        //n=3=>2

        //O(n+n)=>O(2n)=>O(N)
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];//O(1)
    }//O(N)+O(1)+O(1)+O(N)+O(N)+O(1)=O(2n+3)=O(N)
}
