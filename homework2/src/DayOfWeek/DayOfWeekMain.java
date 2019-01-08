package DayOfWeek;

public class DayOfWeekMain {
    public static void main(String[] args) {

        DayOfWeek day = DayOfWeek.THURSDAY;
        getWorkingHours(day);
    }

    private static void getWorkingHours(DayOfWeek day) {

        switch (day) {
            case MONDAY:
                System.out.println("До конца рабочей недели 40 часов!");
                break;
            case TUESDAY:
                System.out.println("До конца рабочей недели 32 часов!");
                break;
            case WEDNESDAY:
                System.out.println("До конца рабочей недели 24 часов!");
                break;
            case THURSDAY:
                System.out.println("До конца рабочей недели 16 часов!");
                break;
            case FRIDAY:
                System.out.println("До конца рабочей недели 8 часов!");
                break;
            case SATERDAY:
                System.out.println("Сегодня выходной!");
                break;
            case SUNDAY:
                System.out.println("Сегодня выходной!");
                break;
        }
    }
}
