import java.io.FileReader;
import java.io.FileWriter;

public class SaveFile {

    public SaveFile(String name, int counter) throws Exception
    {
        int bufread;        // буфер для записи в файл

        FileWriter fw = new FileWriter("res.txt", true);
        fw.write(name+" "+counter);
        fw.append('\n');
        fw.close();

        FileReader fr = new FileReader("res.txt");
        System.out.println("\nТаблица результатов:");
        while((bufread=fr.read())!=-1)
            System.out.print((char)bufread);
    }
}
