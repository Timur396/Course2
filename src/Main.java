

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    private static Calendar calendar;

    public static void main(String[] args) {
        calendar = new Calendar();
        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            inputTask(scanner);
                            break;
                        case 2:
                            // todo: обрабатываем пункт меню 2
                            break;
                        case 3:
                            getTasksForDay(scanner);
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
    }

    private static void inputTask(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Введите название задачи:");
        String title = scanner.nextLine();
        System.out.println("Введите описание задачи:");
        String description = scanner.nextLine();
        boolean isWork;
        System.out.println("Эта задача рабочая?");
        switch (scanner.nextLine()) {
            case "да":
            case "y":
                isWork = true;
                break;
            default:
                isWork = false;
        }
        LocalDateTime date = null;
        System.out.println("Введите дату и время задачи (05.06.1992 00:00:00):");
        boolean shouldEnterAgain = true;
        while (shouldEnterAgain) {
            try {
                date = LocalDateTime.parse(scanner.nextLine(), Task.DATE_TIME_FORMATTER);
                shouldEnterAgain = false;
            } catch (DateTimeParseException e) {
                System.out.println("Не правильный формат даты, введите по образцу");
            }
        }
        Task task;
        System.out.println("Повторяемость задания:");
        System.out.println("\t • 0 – не повторяется (default)");
        System.out.println("\t • 1 – ежедневно");
        System.out.println("\t • 2 – еженедельно");
        System.out.println("\t • 3 – ежемесячно");
        System.out.println("\t • 4 – ежегодно");
        switch (scanner.next()) {
            case "1":
                task = new DailyTask(title, description, isWork, date);
                break;
            case "2":
                task = new WeeklyTask(title, description, isWork, date);
                break;
            case "3":
                task = new MounthTask(title, description, isWork, date);
                break;
            case "4":
                task = new YearTask(title, description, isWork, date);
                break;
            default:
                task = new OneTimeTask(title, description, isWork, date);
        }
        calendar.addTask(task);
    }

    public static void getTasksForDay(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Введите дату (01.01.1970):");
        LocalDate date = null;
        boolean shouldEnterAgain = true;
        while (shouldEnterAgain) {
            try {
                date = LocalDate.parse(scanner.nextLine(), Task.DATE_FORMATTER);
                shouldEnterAgain = false;
            } catch (DateTimeParseException e) {
                System.out.println("Wrong format, enter again");
            }
        }
        System.out.println(calendar.getTasksForOneDay(date));
    }

    private static void printMenu() {
        System.out.println(
                        "1. Добавить задачу\n" +
                        "2. Удалить задачу\n" +
                        "3. Получить задачу на указанный день\n" +
                        "0. Выход"
        );
    }
}