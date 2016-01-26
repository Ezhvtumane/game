/**
 * Created by georgy on 25.01.16.
 */
public class Main {

     public static void main(String agrs[])
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
