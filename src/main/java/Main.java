import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static String getJarName(){
        String jarFilePath = Main.class.getProtectionDomain()
                .getCodeSource()
                .getLocation()
                .getPath();
        String decodedPath = "";
        try {
            decodedPath = java.net.URLDecoder.decode(jarFilePath, "UTF-8");
        } catch (java.io.UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        File jarFile = new File(decodedPath);
        String jarFileName = jarFile.getName();
        return jarFileName;
    }
    // 哈哈
    public static void main(String[] args) {
        if (args.length < 1){
            try {
                FileWriter writer = new FileWriter("Start.bat");
                BufferedWriter bufferedWriter = new BufferedWriter(writer);
                bufferedWriter.write("@echo off\njava -jar " + getJarName() + " start");
                bufferedWriter.flush();
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
