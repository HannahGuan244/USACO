import java.util.*;
//import java.lang.*;
import java.io.*;

public class blist {
  public static void main(String args[]) throws IOException{
    BufferedReader br = new BufferedReader(new FileReader("blist.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("blist.out")));
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    
    int[] s = new int[N];
    int[] t = new int[N];
    int[] b = new int[N];
    
    for (int i=0; i<N; i++){
      st = new StringTokenizer(br.readLine());
    
      s[i] = Integer.parseInt(st.nextToken());
      t[i] = Integer.parseInt(st.nextToken());
      b[i] = Integer.parseInt(st.nextToken());
    }
    
    int[] buckets = new int[N*10];
    for (int i = 0; i< N * 10; i++)
      buckets[i] = 0;
    
    
    int use = 0;
    int max = 0;
      
    for (int T = 1; T <= 1000; T++){
      for (int i = 0; i < N; i++){
        
        if (T >= t[i]){
          for (int j = 0; j<N*10; j++){
            if (buckets[j] == i + 1)
              buckets[j] = 0;
            
          }//for
        }//if t
      
        if (T == s[i]){
          use = 0;
          for (int j = 0; j< N * 10; j++){
            if ((buckets[j] == 0) && (use < b[i])){
              buckets[j] = i+1;
              use++;
              if (j+1 > max){
                max = j + 1;
              }//if j
            }//if buckets
          }//for j  
        }//if t
          
        
      }//for i
    }//for t
    
    pw.println(max);
    br.close();
    pw.close();
  }//main
  
  public static void print(int[] t){
    for (int i=0; i<t.length; i++)
      System.out.print(t[i] + " ");
    System.out.println();
  }//print
}//class
  