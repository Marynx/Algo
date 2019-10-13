import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    
    public static void main(String[] args) throws IOException {
        double q=MathUtils.FROM;
        List<List<String>>rows=new ArrayList<>();

        double avgMath=0;
        double avgMycosError=0;
        double avgMycosEndError=0;
    
    //roznica miedzy dodawaniem od poczatku i od konca
        CosineUtils.generateList(rows,20,MathUtils.FROM,"taylorZeWzoru.csv",false);
//        rows.add(Arrays.asList("x","Od poczatku","Od konca"));
//        for(int i=0;i<1000000;i++){
//            double tab[]=CosineUtils.getCosinesTab(20,q);
//            avgMycosError+=Math.abs(Math.cos(q)-CosineUtils.getCosineSumTab(tab));
//            avgMycosEndError+=Math.abs(Math.cos(q)-CosineUtils.getCosineSumEndTab(tab));
//            if(i%1000==0 && i!=0) {
//
//                avgMycosError=avgMycosError/1000;
//                avgMycosEndError=avgMycosEndError/1000;
//                rows.add(Arrays.asList(
//                        Double.toString(q),
////                     Double.toString(cosFromStart(5,i)),
////                                   Double.toString(cosFromEnd(5,i)),
////                                   Double.toString(Math.cos(i)),
//                        Double.toString(avgMycosError),
//                        Double.toString(avgMycosEndError)));
//
//                avgMycosEndError=0;
//                avgMycosError=0;
//            }
//            q+= 0.0000041021;
//        }
//        CsvUtil.saveToFile(rows,"taylorZeWzoru.csv");
//        rows.clear();
//        q=MathUtils.FROM;
//        avgMath=0;
//        avgMycosError=0;
//        avgMycosEndError=0;
    
        //roznica miedzy zliaczniem na podstawie poprzedniego
        CosineUtils.generateList(rows,20,q,"taylorPoprzedni.csv",true);
//        rows.add(Arrays.asList("x","Od poczatku","Od konca"));
//        for(int i=0;i<1000000;i++){
//            double tab[]=CosineUtils.getCosStartPrevTab(20,q);
//            //double tab1[]=CosineUtils.getCosEPrevTab(20,q);
//            avgMycosError+=Math.abs(Math.cos(q)-CosineUtils.addCosPrevTabStart(tab));
//            avgMycosEndError+=Math.abs(Math.cos(q)-CosineUtils.addCosPrevTabEnd(tab));
//            if(i%1000==0 && i!=0) {
//
//                avgMycosError=avgMycosError/1000;
//                avgMycosEndError=avgMycosEndError/1000;
//                rows.add(Arrays.asList(
//                        Double.toString(q),
////                     Double.toString(cosFromStart(5,i)),
////                                   Double.toString(cosFromEnd(5,i)),
////                                   Double.toString(Math.cos(i)),
//                        Double.toString(avgMycosError),
//                        Double.toString(avgMycosEndError)));
//
//                avgMycosEndError=0;
//                avgMycosError=0;
//            }
//            q+= 0.0000041021;
//        }
//
//        CsvUtil.saveToFile(rows,"taylorPoprzedni.csv");
//        rows.clear();
//        q=MathUtils.FROM;
//        avgMath=0;
//        avgMycosError=0;
//        avgMycosEndError=0;
//
       //roznica miedzy zliaczniem ze wzoru a poprzedzajacym
        CosineUtils.generateListPrev(rows,20,q,"taylorWzorAPoprzedni.csv");
//        rows.add(Arrays.asList("x","Ze wzoru Taylora","Uzywajac poprzedzniego wyrazu"));
//       for(int i=0;i<1000000;i++){
//           double tab[]=CosineUtils.getCosinesTab(20,q);
//           double tab1[]=CosineUtils.getCosStartPrevTab(20,q);
//           avgMycosError+=Math.abs(Math.cos(q)-CosineUtils.getCosineSumEndTab(tab));
//           avgMycosEndError+=Math.abs(Math.cos(q)-CosineUtils.addCosPrevTabEnd(tab1));
//           if(i%1000==0 && i!=0) {
//
//               avgMycosError=avgMycosError/1000;
//               avgMycosEndError=avgMycosEndError/1000;
//               rows.add(Arrays.asList(
//                       Double.toString(q),
////                     Double.toString(cosFromStart(5,i)),
////                                   Double.toString(cosFromEnd(5,i)),
////                                   Double.toString(Math.cos(i)),
//                       Double.toString(avgMycosError),
//                       Double.toString(avgMycosEndError)));
//
//               avgMycosEndError=0;
//               avgMycosError=0;
//           }
//           q+= 0.0000041021;
//       }
//
//        CsvUtil.saveToFile(rows,"taylorWzorAPoprzedni.csv");
//        rows.clear();
//        q=MathUtils.FROM;
//        avgMath=0;
//        avgMycosError=0;
//        avgMycosEndError=0;
       
//        double avgError15=0.0;
//        double avgError20=0.0;
        
        //roznica miedzy innymi n
        CosineUtils.generateListDifferentN(rows,q,"taylorRozneN.csv");
//        rows.add(Arrays.asList("x","n=5","n=10","n=15","n=20"));
//        for(int i=0;i<1000000;i++){
//            double tab[]=CosineUtils.getCosinesTab(5,q);
//            double tab10[]=CosineUtils.getCosinesTab(10,q);
//            double tab15[]=CosineUtils.getCosinesTab(15,q);
//            double tab20[]=CosineUtils.getCosinesTab(20,q);
//            avgMycosError+=Math.abs(Math.cos(q)-CosineUtils.getCosineSumTab(tab));
//            avgMycosEndError+=Math.abs(Math.cos(q)-CosineUtils.getCosineSumEndTab(tab10));
//            avgError15+=Math.abs(Math.cos(q)-CosineUtils.getCosineSumTab(tab15));
//            avgError20+=Math.abs(Math.cos(q)-CosineUtils.getCosineSumTab(tab20));
//            if(i%1000==0 && i!=0) {
//
//                avgMycosError=avgMycosError/1000;
//                avgMycosEndError=avgMycosEndError/1000;
//                avgError15=avgMycosEndError/1000;
//                avgError20=avgMycosEndError/1000;
//                rows.add(Arrays.asList(
//                        Double.toString(q),
////                     Double.toString(cosFromStart(5,i)),
////                                   Double.toString(cosFromEnd(5,i)),
////                                   Double.toString(Math.cos(i)),
//                        Double.toString(avgMycosError),
//                        Double.toString(avgMycosEndError),
//                        Double.toString(avgError15),
//                        Double.toString(avgError20)));
//
//                avgMycosEndError=0;
//                avgMycosError=0;
//                avgError15=0;
//                avgError20=0;
//            }
//            q+= 0.0000041021;
//        }
//
//
//        CsvUtil.saveToFile(rows,"taylorRozneN.csv");
//        rows.clear();
//        q=MathUtils.FROM;
//        avgMath=0;
//        avgMycosError=0;
//        avgMycosEndError=0;
//        avgError15=0;
//        avgError20=0;
    }
}
