package utils.ext;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cmd {

    public static void executeCommand(String command) {
        //TODO check why error with SH
//        try {
//            Process p = Runtime.getRuntime().exec("cmd /c start sh -c \'" + command + "\'");
//            BufferedReader stdOut = new BufferedReader(new InputStreamReader(p.getInputStream()));
//            stdOut.readLine();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }



}
