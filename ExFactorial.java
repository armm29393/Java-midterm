/**
 * @author Arm
 */
public class ExFactorial {
    public static void main(String[] args) {
        ExFactorial a = new ExFactorial();
        System.out.println(a.factorial(15)); //1307674368000
    }
    long factorial(int num){
        if (num==1) return 1;
        else return num * factorial(num-1);
    }
}
