import java.util.Arrays;
import java.lang.reflect.Array;
import java.util.stream.*;
import java.io.*;
import java.text.NumberFormat;

public class AdmitLine {

  private static double[] averageA = {0,0,0,0};
  private static double[] averageL = {0,0,0,0};
  //LD=line Difference线差, AD=Average
  private static String percentCal(double mark, double[] line, double[] average, double[] lowest){
    for(int i=0; i<Array.getLength(line); i++){
      averageA[i] = average[i] - line[i];
      averageL[i] = lowest[i] - line[i];
      System.out.println(averageA[i] + " -- " + averageL[i]);
    }
    double averageAA = Arrays.stream(averageA).average().orElse(0);
    double averageLA = Arrays.stream(averageL).average().orElse(0);
    double percent = (mark-averageLA)/(averageAA-averageLA)*0.5+0.5;
    // percent = 0.5;
    System.out.println(averageAA + " -- " + averageLA);
    System.out.println(percent);
    NumberFormat nf = NumberFormat.getPercentInstance();
    // nf.setMinimumFractionDigits(1);
    System.out.println(nf.format(percent));
    return nf.format(percent);
  }
  
  public static void main(String[] args) {
    double[] m = {6,8,9,66};
	  double[] t = {10.5,12.6,11.789,65.4};
    percentCal(6,m,t,t);
  }
}