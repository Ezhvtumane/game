public class Mistery {
    private Integer num;

    public void makeMystery(Integer level)
    {
        switch (level) {
            case 1:
                this.num = (int) (Math.random() * (10));     // от 0 до 9
                System.out.println("Загадано число от 0 до 9 включительно.");break;
            case 2:
                this.num = (int) (Math.random() * (100));        // от 0 до 99
                System.out.println("Загадано число от 0 до 99 включительно.");break;
            case 3:
                this.num = (int) (Math.random() * (1000));       // от 0 до 999
                System.out.println("Загадано число от 0 до 999 включительно.");break;
        }
    }

    public Integer getMistery()
    {
        return this.num;
    }
}
