import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CosineUtils {
    
//    public static double getCosineElement(int n,double x){
//        return MathUtils.checkSign(n)* MathUtils.power(x,2*n)/ MathUtils.fact(2*n);
//    }
//    public static List<Double> getCosines(int n,double x){
//        List<Double> cosines=new ArrayList<>();
//        for(int i=0;i<n;i++){
//            cosines.add(getCosineElement(i,x));
//        }
//        return cosines;
//    }
//    public static double getCosineSum(List<Double> cosines){
//        double result=0;
//        for(double cos:cosines){
//            result+=cos;
//        }
//        return result;
//    }
//    public static double getCosineSumEnd(List<Double> cosines){
//        double result=0;
//        Collections.reverse(cosines);
//        for(double cos:cosines){
//            result+=cos;
//        }
//        return result;
//    }
    
    
    
    public static double[] getCosinesTab(int n,double x){
       double tab[]=new double[n];
        for(int i=0;i<n;i++){
            tab[i]=MathUtils.checkSign(i)* MathUtils.power(x,2*i)/ MathUtils.fact(2*i);
        }
        return tab;
    }
    public static double getCosineSumTab(double[] tab){
        double result=0;
        for(int i=0;i<tab.length;i++){
            result+=tab[i];
        }
        return result;
    }
    public static double getCosineSumEndTab(double[] tab){
        double result=0;
        for(int i=tab.length-1;i>=0;i--){
            result+=tab[i];
        }
        return result;
    }
    
    public static double[] getCosStartPrevTab(int n,double x){
        double tab[]=new double[n];
        double result=0;
        tab[0]=1.0;
        for(int i=0;i<n-1;i++) {
           // tab[i]= ((-1) * tab[i - 1] * MathUtils.power(x, 2)) / (2 * i * (2 * i - 1));
            tab[i+1]= ((-1) * tab[i] * MathUtils.power(x, 2)) / ((2 * i +2)*(2 * i + 1));
        }
    return tab;
    }
    
    public static double addCosPrevTabStart(double [] tab){
        double result=0;
        for(int i=0;i<tab.length;i++){
            result+=tab[i];
        }
        return result;
    }
    public static double addCosPrevTabEnd(double [] tab){
        double result=0;
        for(int i=tab.length-1;i>=0;i--){
            result+=tab[i];
        }
        return result;
    }
    
    public static void generateList(List<List<String>> list,int n, double x,String fileName,boolean prev) throws IOException {
        double avgMyCosError=0;
        double avgMyCosEndError=0;
        double tab[]=new double[n];
        list.add(Arrays.asList("x", "Od poczatku", "Od konca"));
        for(int i=0;i<1000000;i++){
            if(!prev) {
                 tab = CosineUtils.getCosinesTab(n, x);
                avgMyCosError+=Math.abs(Math.cos(x)-CosineUtils.getCosineSumTab(tab));
                avgMyCosEndError+=Math.abs(Math.cos(x)-CosineUtils.getCosineSumEndTab(tab));
            }else{
               tab= CosineUtils.getCosStartPrevTab(20,x);
                avgMyCosError+=Math.abs(Math.cos(x)-CosineUtils.addCosPrevTabStart(tab));
                avgMyCosEndError+=Math.abs(Math.cos(x)-CosineUtils.addCosPrevTabEnd(tab));
            }
           
            if(i%1000==0 && i!=0) {
            
                avgMyCosError=avgMyCosError/1000;
                avgMyCosEndError=avgMyCosEndError/1000;
                list.add(Arrays.asList(
                        Double.toString(x),
//                     Double.toString(cosFromStart(5,i)),
//                                   Double.toString(cosFromEnd(5,i)),
//                                   Double.toString(Math.cos(i)),
                        Double.toString(avgMyCosError),
                        Double.toString(avgMyCosEndError)));
            
                avgMyCosEndError=0;
                avgMyCosError=0;
            }
            x+= 0.0000041021;
        }
        CsvUtil.saveToFile(list,fileName);
        list.clear();
        x=MathUtils.FROM;
//        avgMyCosError=0;
//        avgMyCosEndError=0;
    }
    public static void generateListPrev(List<List<String>> list,int n,double x,String fileName) throws IOException {
        list.add(Arrays.asList("x", "Ze wzoru Taylora", "Uzywajac poprzedzniego wyrazu"));
        double avgMyCosError=0;
        double avgMyCosEndError=0;
        for ( int i = 0; i < 1000000; i++ ) {
            double tab[] = CosineUtils.getCosinesTab(n, x);
            double tab1[] = CosineUtils.getCosStartPrevTab(n, x);
            avgMyCosError += Math.abs(Math.cos(x) - CosineUtils.getCosineSumTab(tab));
            avgMyCosEndError += Math.abs(Math.cos(x) - CosineUtils.addCosPrevTabStart(tab1));
            if ( i % 1000 == 0 && i != 0 ) {
            
                avgMyCosError = avgMyCosError / 1000;
                avgMyCosEndError = avgMyCosEndError / 1000;
                list.add(Arrays.asList(
                        Double.toString(x),
//                     Double.toString(cosFromStart(5,i)),
//                                   Double.toString(cosFromEnd(5,i)),
//                                   Double.toString(Math.cos(i)),
                        Double.toString(avgMyCosError),
                        Double.toString(avgMyCosEndError)));
            
                avgMyCosEndError = 0;
                avgMyCosError = 0;
            }
            x += 0.0000041021;
        }
    
        CsvUtil.saveToFile(list, fileName);
        list.clear();
        x = MathUtils.FROM;
    }
    
    public static void generateListDifferentN(List<List<String>> list,double x,String fileName) throws IOException {
        double avgError5=0;
        double avgError10=0;
        double avgError15=0.0;
        double avgError20=0.0;
    
        //roznica miedzy innymi n
       list.add(Arrays.asList("x","n=5","n=10","n=15","n=20"));
        for(int i=0;i<1000000;i++){
            double tab[]=CosineUtils.getCosinesTab(5,x);
            double tab10[]=CosineUtils.getCosinesTab(10,x);
            double tab15[]=CosineUtils.getCosinesTab(15,x);
            double tab20[]=CosineUtils.getCosinesTab(20,x);
            avgError5+=Math.abs(Math.cos(x)-CosineUtils.getCosineSumTab(tab));
            avgError10+=Math.abs(Math.cos(x)-CosineUtils.getCosineSumTab(tab10));
            avgError15+=Math.abs(Math.cos(x)-CosineUtils.getCosineSumTab(tab15));
            avgError20+=Math.abs(Math.cos(x)-CosineUtils.getCosineSumTab(tab20));
            if(i%1000==0 && i!=0) {
            
                avgError5=avgError5/1000;
                avgError10=avgError10/1000;
                avgError15=avgError15/1000;
                avgError20=avgError20/1000;
                list.add(Arrays.asList(
                        Double.toString(x),
//                     Double.toString(cosFromStart(5,i)),
//                                   Double.toString(cosFromEnd(5,i)),
//                                   Double.toString(Math.cos(i)),
                        Double.toString(avgError5),
                        Double.toString(avgError10),
                        Double.toString(avgError15),
                        Double.toString(avgError20)));
            
                avgError5=0;
                avgError10=0;
                avgError15=0;
                avgError20=0;
            }
            x+= 0.0000041021;
        }
    
    
        CsvUtil.saveToFile(list,fileName);
        list.clear();
        x=MathUtils.FROM;
    }
}
