package homework4;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Copy {
	public static void main(String[] args) throws IOException {

        File source = new File("/Users/zhumingxuan/Desktop/from");
        File destination = new File("/Users/zhumingxuan/Desktop/to");
        copy(source, destination);
    }
    private static void copy(File sourceFolder, File destinationFolder) throws IOException{
        if (sourceFolder.isDirectory()){
            if (!destinationFolder.exists()) {
                destinationFolder.mkdir();
            }
            String[] files = sourceFolder.list();
            for (String file : files){
                File srcFile = new File(sourceFolder, file);
                File destFile = new File(destinationFolder, file);
                copy(srcFile, destFile);
            }
        }
        else {
            Files.copy(sourceFolder.toPath(), destinationFolder.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copied :: " + destinationFolder);
        }
    }
}
