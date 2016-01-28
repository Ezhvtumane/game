package game;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GamerName {

    private String name;

    public void setName() throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите Ваше имя для доски почета:");
        if((name = reader.readLine()).equals("exit"))
        {System.out.println("Всего доброго! Ждем Вас снова!");System.exit(-1);}
    }

    public String getName()
    {
        return this.name;
    }
}
