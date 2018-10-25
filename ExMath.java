import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * @author Arm
 */
public class ExMath {
    public static void main(String[] args) {
        ExMath c = new ExMath();
        c.calc(8,12);
    }
    void calc(float a,float b){
        float sum = a+b;
        float sub = a-b;
        float mul = a*b;
        //System.out.printf("%.2f\n%.2f\n%.2f\n",sum,sub,mul);
        try {
            // ----------- SUM -----------
            FileWriter wsum = new FileWriter("C:/sum.txt");
            wsum.write(String.valueOf(sum));
            wsum.close();
            // ----------- SUB -----------
            FileWriter wsub = new FileWriter("C:/sub.txt");
            wsub.write(String.valueOf(sub));
            wsub.close();
            // ----------- MUL -----------
            FileWriter wmul = new FileWriter("C:/mul.txt");
            wmul.write(String.valueOf(mul));
            wmul.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
