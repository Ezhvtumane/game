import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

     public static void main(String agrs[])
    {
        System.out.println("Игра \"Угадай число\". " +
                 "Нужно угадать число, которое загадал компьютер. Для Вашего удобства число целое.\nВ игре 3 уровня сложности.\n" +
                 "В любой момент можно выйти из игры введя команду \"exit\"");
        Level level = new Level();
        Mistery mist = new Mistery();
        GameProcess game = new GameProcess();
        GamerName name = new GamerName();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Выберите уровень(1-3):");
            String s = reader.readLine();
            while (!level.setLevel(s)) {
                s = reader.readLine();
            }
            mist.makeMystery(level.getLevel());
            name.setName();
            SaveFile.SaveFile(name.getName(),game.makeGame(mist.getMistery()));
        }
        catch (Exception e){
            System.out.println(e.toString());
        }

     }

}
