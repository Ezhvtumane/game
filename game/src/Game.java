
/*
Игра: "Угадай число"
Суть игры состоит в том что бы угадать число загаданное компьютером за как можно меньшее количество ходов.

Требование:
Игру можно сделтаь в консольном режиме, но можно и любыми другими способами.
Игра должна содержать несколько уровней:
1 Уровень: Пользователь угадывает число от 0 до 9
2 Уровень: Пользователь угадывает число от 0 до 99
3 Уровень: Пользователь угадывает число от 0 до 999
При вводе пользователем числа, программа должна сообщать играку, больше или меньше введенное число загаданнго.
Когда пользователь угадывает число, игроку показываться количество ходов. После этого пользователю необходимо ввести своё имя и программа должна показать рейтин игроков.
Рейтинг игроков должен сохранятся и после переоткрытия программы он не должен теряться (можно сохранить в файл или любыми другими способами).
Желатель написать юнит тесты.
*/

/**
 * Расписать по методам каждый шаг.
 * **/
import java.io.*;
import java.lang.Math;

/**
 * Created by OrlovGS on 25.01.2016.
 */
public class Game {

    private Integer counter=0;
    private String level="";
    private Integer num=0;
    private String name="";

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void levelChoose() throws Exception
    {
        System.out.println("Выберите уровень(1-3):");
            level=reader.readLine();
            while(!level.equals("1") && !level.equals("2") && !level.equals("3"))
            {
                System.out.println("Введите номер уровня, попробуйте еще раз:");
                level=reader.readLine();
            }
            System.out.println("Выбран "+level+" уровень.");
    }

    public void makeNum() throws Exception
    {
        switch (Integer.parseInt(level)) {
            case 1:
                num = (int) (Math.random() * (10));
                System.out.println("Загаданно число от 0 до 9 включительно.");break;
            case 2:
                num = (int) (Math.random() * (100));
                System.out.println("Загаданно число от 0 до 99 включительно.");break;
            case 3:
                num = (int) (Math.random() * (1000));
                System.out.println("Загаданно число от 0 до 999 включительно.");break;
        }
        System.out.println(num);
    }

    public void game() throws Exception
    {
        String nums;
        int i;
        System.out.println("Введите Ваш вариант числа:");

        while(true)
        {
            if(checkNum(nums=reader.readLine()))
            {
                if (!num.equals(i = Integer.parseInt(nums))) {
                    if (i < num) System.out.print("Введенное число меньше,");
                        else if (i > num) System.out.print("Введенное число больше,");
                    System.out.println("попробуйте еще раз:");
                    counter++;
                }
                else {counter++; break;}
            }
            else {counter++; System.out.println("Введите, пожалуйста, число!");}
        }
        System.out.println("Угадали с " + counter + " раза.");
    }

    public void setName() throws Exception
    {
        System.out.println("Введите Ваше имя для доски почета:");
        name = reader.readLine();
    }

    public void saveFile() throws Exception
    {
        int bufread;

        FileWriter fw = new FileWriter("res.txt", true);
        fw.write(name+" "+counter);
        fw.append('\n');
        fw.close();

        FileReader fr = new FileReader("res.txt");
        System.out.println("\nТаблица результатов:");
            while((bufread=fr.read())!=-1)
                System.out.print((char)bufread);

    }

    boolean checkNum(String num) throws Exception
    {
        try
        {
            Integer.parseInt(num);
            return true;
        }
        catch(Exception e){return false;}


    }

    public static void main (String args[])
    {
        Game game = new Game();

        try {
            game.levelChoose();
            game.makeNum();
            game.game();
            game.setName();
            game.saveFile();
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
}
