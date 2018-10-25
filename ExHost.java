/**
 * @author Arm
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.*;

public class ExHost {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String strLine = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:/host.txt"));
            while(strLine != null){
                if(strLine == null) break;
//                System.out.println(strLine);
                try {
                    if(strLine!=""){
                        InetAddress IPad = InetAddress.getByName(strLine);
                        System.out.printf("%s  :  %s\n",strLine,IPad.getHostAddress());
                    }
                } catch (UnknownHostException e) {
                    System.out.printf("%s  :  unknown host\n",strLine);
                }
                strLine = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            System.out.println("file not found!");
        }
    }
}
