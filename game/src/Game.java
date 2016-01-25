import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;

/**
 * Created by OrlovGS on 25.01.2016.
 */
public class Game {

    static final Integer num = 0 + (int)(Math.random() * ((99 - 0) + 1));

    static Integer counter=0;

    public static void main (String args[])
    {
        System.out.println(num);
        System.out.println("Введите число:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (!num.equals(Integer.parseInt(reader.readLine()))) {
                System.out.println("попробуйте еще раз:");
                counter++;
            }
            System.out.println("Угадали");
        }catch (Exception e) {
            System.out.println("Некорректный ввод");

        }
    }
}
