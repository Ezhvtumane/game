
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
 * Расписать по методам каждый шаг. Ввести входные параметры методам - вывести ввод строки за скобки.
 * **/
import java.io.*;
import java.lang.Math;

public class Game {

    private Integer counter=0;  // счетчик попыток
    private String level="";    // переменная для задания уровня
    private Integer num=0;      // загадываемое число
    private String name="";     // имя игрока

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // чтение с консоли

    public void levelChoose() throws Exception //выбор уровня
    {
        System.out.println("Выберите уровень(1-3):");
            level=reader.readLine();        // считываем строку
            while(!level.equals("1") & !level.equals("2") & !level.equals("3") & !level.equals("exit"))       // проверяем соответствие уровню
            {
                System.out.println("Введите номер уровня, попробуйте еще раз:");
                level=reader.readLine();        // если ввели некорректное значение - переспрашиваем
            }
        if(level.equals("exit")) {
            System.out.println("Всего доброго! Ждем Вас снова!");System.exit(-1);}
        else
            System.out.println("Выбран "+level+" уровень.");        // выбрали уровень, записали в глобальную переменую
    }

    public void makeNum() throws Exception      // генерация случайного числа, в зависимости от выбранного уровня
    {
        switch (Integer.parseInt(level)) {
            case 1:
                num = (int) (Math.random() * (10));     // от 0 до 9
                System.out.println("Загадано число от 0 до 9 включительно.");break;
            case 2:
                num = (int) (Math.random() * (100));        // от 0 до 99
                System.out.println("Загадано число от 0 до 99 включительно.");break;
            case 3:
                num = (int) (Math.random() * (1000));       // от 0 до 999
                System.out.println("Загадано число от 0 до 999 включительно.");break;
        }
        //System.out.println(num);
    }

    public void game() throws Exception     // игровой процесс
    {
        String nums;
        int i;
        System.out.println("Введите Ваш вариант числа:");

        while(true)
        {
            if(checkNum(nums=reader.readLine()))        // проверяем число ли введено, если нет, то увеличиваем счетчик попыток и просим ввести число
            {
                if (!num.equals(i = Integer.parseInt(nums))) {      // сравниваем введенное значение с загаданным, если угадали, то увеличиваем сетчик попыток и выходим из цикла
                    if (i < num) System.out.print("Загаданное число больше,");       // если не угадали и число меньше
                        else if (i > num) System.out.print("Загаданное число меньше,");      // если не угадали и число больше
                    System.out.println("попробуйте еще раз:");
                    counter++;      // увеличиваем счетчик попыток
                }
                else {counter++; break;}
            }
            else if(nums.equals("exit")){System.out.println("Всего доброго! Ждем Вас снова!");System.exit(-1);}
            else
            {counter++; System.out.println("Введите, пожалуйста, целое число!");}
        }
        System.out.println("Угадали с " + counter + " раза.");
    }

    public void setName() throws Exception      // ввод имени
    {
        System.out.println("Введите Ваше имя для доски почета:");
        if((name = reader.readLine()).equals("exit"))
        {System.out.println("Всего доброго! Ждем Вас снова!");System.exit(-1);}
    }

    public void saveFile() throws Exception     // запись в файл и вывод таблицы результатов из файла
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

    boolean checkNum(String num) throws Exception       // проверка строки
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
        System.out.println("Игра \"Угадай число\". " +
                "Нужно угадать число, которое загадал компьютер. Для Вашего удобства число целое.\nВ игре 3 уровня сложности.\n" +
                "В любой момент можно выйти из игры введя команду \"exit\"");
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
