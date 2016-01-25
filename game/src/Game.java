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
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Math;

/**
 * Created by OrlovGS on 25.01.2016.
 */
public class Game {

            static Integer counter=0;

    public static void main (String args[])
    {
        int i=0;
        Integer num=0;
        Integer level=0;
        String name;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Выберите уровень(1-3):");
            try {
                level=Integer.parseInt(reader.readLine());
                while(!level.equals(1) && !level.equals(2) && !level.equals(3))
                {
                    System.out.println("More:");
                    level=Integer.parseInt(reader.readLine());
                }
                System.out.println("Выбран "+level+" уровень");
            }
            catch(Exception e) {
                System.out.println("ololo");
            }
        switch (level) {
            case 1:
                num = 0 + (int) (Math.random() * ((9 - 0) + 1)); break;
            case 2:
                num = 0 + (int) (Math.random() * ((99 - 0) + 1)); break;
            case 3:
                num = 0 + (int) (Math.random() * ((999 - 0) + 1)); break;
        }

        System.out.println(num);

        System.out.println("Введите число:");

        try {
            while (!num.equals(i=Integer.parseInt(reader.readLine()))) {
                if(i < num) System.out.println("Введенное число меньше.");
                else if(i > num) System.out.println("Введенное число больше.");
                System.out.println("попробуйте еще раз:");
                counter++;
            }
            counter++;
            System.out.println("Угадали за " + counter +" попыток.");

        }catch (Exception e) {
            System.out.println("Некорректный ввод");
        }

        System.out.println("Введите Ваше имя:");

        try {
            name = reader.readLine();
        }
        catch (Exception e){
            System.out.println("?!");
        }

        //Запись в файл.


    }
}
