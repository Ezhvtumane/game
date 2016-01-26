/**
 * Created by georgy on 25.01.16.
 */
public class Main {

     public static void main(String agrs[])
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
