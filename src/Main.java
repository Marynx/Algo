import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    
    public static void main(String[] args) throws IOException {
        double q=MathUtils.FROM;
        List<List<String>>rows=new ArrayList<>();
    
    //roznica miedzy dodawaniem od poczatku i od konca
        CosineUtils.generateList(rows,20,MathUtils.FROM,"taylorZeWzoru.csv",false);
    
        //roznica miedzy zliaczniem na podstawie poprzedniego
        CosineUtils.generateList(rows,20,q,"taylorPoprzedni.csv",true);

       //roznica miedzy zliaczniem ze wzoru a poprzedzajacym
        CosineUtils.generateListPrev(rows,20,q,"taylorWzorAPoprzedni.csv");
        
        //roznica miedzy innymi n
        CosineUtils.generateListDifferentN(rows,q,"taylorRozneN");
    }
}
