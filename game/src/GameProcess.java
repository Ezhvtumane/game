
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GameProcess {

    private int counter;

    public Integer makeGame(Integer num) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
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
        return counter;
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
}
