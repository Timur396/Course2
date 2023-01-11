
import java.time.LocalDateTime;

public class DateTime {
    public static void main(String[] args) {
        LocalDateTime dateTime= LocalDateTime.of(2023,02,01,12,00);
        dateTime = dateTime.plusWeeks(1);

    }
}
