import java.io.File;

/**
 * Created by barin.huseyin on 2/21/2016.
 */
public class FileManager {




    public static void main(String[] args) {
        new FileManager();
    }



    public FileManager() {
        FileSaver fileSaver = getFileSaver();
        System.out.println(saveFile(fileSaver));

    }

    public FileSaver getFileSaver() {
        return file -> file.getName().toUpperCase() + " is saved successfully";
    }

    public String saveFile(FileSaver fileSaver) {
        File file = new File("test.txt");
        return fileSaver.saveFile(file);
    }


    @java.lang.FunctionalInterface
    public interface FileSaver {
        String saveFile(File file);
    }

}
