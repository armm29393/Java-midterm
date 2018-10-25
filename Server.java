import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.FileWriter;
import java.net.*;
import java.util.StringTokenizer;
public class Server {
    public static void main(String[] args){
        String clientSentence;
        String capitalizedSentence;
        try{
            ServerSocket welcomeSocket = new ServerSocket(7000);
            while(true){
                Socket connectionSocket = welcomeSocket.accept();
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
                clientSentence = inFromClient.readLine();
                System.out.println("FROM CLIENT:"+clientSentence);
                StringTokenizer tokenizer = new StringTokenizer(clientSentence, "|");
                while (tokenizer.hasMoreTokens()){
                    if ("add".equals(tokenizer.nextToken())) {
                        String id = tokenizer.nextToken();
                        String name = tokenizer.nextToken();
                        name = name.substring(0, name.length()-3);
                        System.out.printf("[+] add Mode\r\n--------------------\r\nID:%s\r\nNAME:%s\r\n--------------------\r\n",id,name);
                        FileWriter w = new FileWriter("data.txt", true)
                        w.append(id+"|"+name+"\r\n");
                        w.close();
                    }
                }
                outToClient.close();
                inFromClient.close();
                connectionSocket.close();
            } 
        }catch (Exception e){
    System.out.println(e);
        }
    }
}
