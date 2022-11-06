package DP;//{ Driver Code Starts

import java.lang.*;
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int size = Integer.parseInt(br.readLine());
            String[] arrStr = ((String) br.readLine()).split("\\s+");
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = Integer.parseInt(arrStr[i]);
            }
            System.out.println(new minJump().minJumps(arr));
        }
    }

}

// } Driver Code Ends

class minJump {

    static int minJumps(int[] arr) {
        int n = arr.length;
        //System.out.println(n);
        if (n == 1)
            return 0;
        int[] jump = new int[n];
        jump[0] = 0;
        for (int i = 1; i < n; i++) {
            jump[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {

                if (j + arr[j] >= i && jump[j] != Integer.MAX_VALUE) {
                    jump[i] = Math.min(jump[i], jump[j] + 1);
                }
            }
        }
        if (jump[n - 1] == Integer.MAX_VALUE)
            return -1;
        return jump[n - 1];
    }
}