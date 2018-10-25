import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
public class Client {
    public static void main(String[] args){
        try{          
            String sentence;
            String modifiedSentence;
            while (true) { 
                System.out.print("> ");
                BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
                Socket clientSocket = new Socket("localhost", 7000);
                DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
                BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                sentence = inFromUser.readLine();
                switch(sentence){
                    case "add":
                        System.out.print("ID in: ");
                        String id = inFromUser.readLine();
                        //System.out.println(id);
                        System.out.print("Name in: ");
                        String name = inFromUser.readLine();
                        System.out.println(name);
                        String buffer = "add|"+id+"|"+name;
                        outToServer.writeBytes(buffer);
                        outToServer.flush();
                        break;
                    case "exit":
                        System.out.println("terminate...");
                        System.exit(0);
                }
                outToServer.writeBytes(sentence);
                outToServer.flush();
                outToServer.close();
            }
        }catch (IOException e){
            System.out.println(e);
        }
    }
}
