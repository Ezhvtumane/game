package game;
public class Level {

    private String level;

    public boolean setLevel(String level)
    {

        while(!level.equals("1") & !level.equals("2") & !level.equals("3") & !level.equals("exit"))       // проверяем соответствие уровню
        {
            System.out.println("Введите номер уровня, попробуйте еще раз:");
            return false;
            //level=reader.readLine();        // если ввели некорректное значение - переспрашиваем
        }
        if(level.equals("exit")) {
            System.out.println("Всего доброго! Ждем Вас снова!");System.exit(-1);}
        else {
            this.level=level;
            System.out.println("Выбран " + this.level + " уровень.");
        }
        return true;
    }

    public Integer getLevel()
    {
        return Integer.parseInt(this.level);
    }

}
