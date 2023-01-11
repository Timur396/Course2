import java.time.LocalDate;
import java.time.LocalDateTime;

public class YearTask extends Task implements Repeatable {
    public YearTask(String title, String description, boolean isWork, LocalDateTime dateTime) {
        super(title, description, isWork, dateTime);
    }

    @Override
    public boolean checkIfSuitable(LocalDate date) {
        return date.getDayOfYear() == dateTime.getDayOfYear()
                && date.getMonth() ==dateTime.getMonth();

    }
}
