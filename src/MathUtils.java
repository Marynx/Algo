public class MathUtils {
    public static double FROM=-3;
    
    public static double fact(int n){
        double result = 1;
        for ( int i = 2; i <= n; i++ ) {
            result *= i;
        }
        return result;
    }
    public static double power(double x, int n){
        double result=1.0;
        for(int i=1;i<=n;i++){
            result*=x;
        }
        
        return result;
    }
    
    public static int checkSign(int n){
        return n%2==0?1:-1;
    }
  
}
