import java.util.*;
//import java.lang.*;
import java.io.*;

public class mixmilk {
  public static void main(String args[]) throws IOException{
    BufferedReader br = new BufferedReader(new FileReader("mixmilk.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mixmilk.out")));
    
    int[] c = new int[3];
    int[] v = new int[3];
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    c[0] = Integer.parseInt(st.nextToken());
    v[0] = Integer.parseInt(st.nextToken());
    
    st = new StringTokenizer(br.readLine());
    c[1] = Integer.parseInt(st.nextToken());
    v[1] = Integer.parseInt(st.nextToken());
    
    st = new StringTokenizer(br.readLine());
    c[2] = Integer.parseInt(st.nextToken());
    v[2] = Integer.parseInt(st.nextToken());
    
    for (int i = 1; i<=100; i++){
     int bucket = (i-1)%3;
     int bucket_next = i%3;
     
     int sum = v[bucket] + v[bucket_next];
     if (sum < c[bucket_next]){
       v[bucket_next] = sum;
       v[bucket] = 0;
     }//if
     else{
       v[bucket_next] = c[bucket_next];
       v[bucket] = sum - c[bucket_next];
     }//else
    }//for
    
    pw.println(v[0]);
    pw.println(v[1]);
    pw.println(v[2]);
    
    //print(v);
    
    br.close();
    pw.close();
  }//main
  
  public static void print(int[] b){
    for (int i=0; i<b.length; i++)
      System.out.print(b[i] + " ");
    System.out.println();
  }//print
}//class

class Bucket{
 int c;
 int m;
}