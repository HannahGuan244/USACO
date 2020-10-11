import java.util.*;
//import java.lang.*;
import java.io.*;

public class backforth {
  public static void main(String args[]) throws IOException{
    BufferedReader br = new BufferedReader(new FileReader("backforth.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("backforth.out")));
    
    int barn1 = 1000;
    int[] b1 = new int[10];
    int[] b2 = new int[10];
    
    int[] bucket1 = new int[10];
    int[] bucket2 = new int[11];
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i< 10; i++)
      b1[i] = Integer.parseInt(st.nextToken());
    
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i< 10; i++)
      b2[i] = Integer.parseInt(st.nextToken());
    
    int[] t = new int[10*11*10*11];
    for (int i = 0; i< 10*10*11*11; i++)
      t[i] = 0;
    int s = 0;
    
    for (int i= 0; i< 10; i++)
      bucket1[i] = b1[i];
    
    for (int i= 0; i< 10; i++)
      bucket2[i] = b2[i];
      bucket2[10] = 0;
    
    for (int Tues= 0; Tues< 10; Tues++){
      for (int Wed = 0; Wed<11; Wed++){
        for (int Thur = 0; Thur<10; Thur++){
          for (int Fri = 0; Fri<11; Fri++){
            
            for (int p= 0; p< 10; p++)
              bucket1[p] = b1[p];
    
            for (int p= 0; p< 10; p++)
              bucket2[p] = b2[p];
            //bucket2[10] = 0;
           
            barn1 = 1000 - bucket1[Tues];
      
            bucket2[10] = bucket1[Tues];
      
            barn1 = barn1 + bucket2[Wed];
            bucket1[Tues] = bucket2[Wed];
    
            barn1 = barn1 - bucket1[Thur];
            bucket2[Wed] = bucket1[Thur];
    
            barn1 = barn1 + bucket2[Fri];
            t[s] = barn1;
            s++;

          }//for Fri
        }//for Thur       
      }//for Wed
    }//for Tues
    
    //print(t);
    pw.println(unique(t));
    
    
    br.close();
    pw.close();
  }//mai1
  
  
  public static int unique(int[] arr){
    int flag, count=1;
      
    for(int i = 1; i < arr.length; i++){
      flag = 0;
      for(int j = 0; j < i; j++){
        if(arr[i] == arr[j]){
          flag = 1;
          break;
        }
      }//for
      if (flag == 0){
        count++;
       // System.out.print(arr[i] + " ");
      }
      //System.out.println();
    }//for
    
    return count;
    
  }
 
  public static void print(int[] t){
    for (int i=0; i<t.length; i++)
      System.out.print(t[i]+ " ");
    System.out.println();
  }//print
}//class
  
