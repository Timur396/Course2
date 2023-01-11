package fibonachi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Fibonachi {
    public static void main(String[] args) {


        int f1 = 1;
        int f2 = 1;
        int f3;
        System.out.print(f1 + " " + f2 + " ");

        for (int i = 0; i < 10; i++) {
            f3 = f1 + f2;
            System.out.print(f3 + " ");
            f1 = f2;
            f2 = f3;

        }


        //        Создать метод, который преобразует массив объектов User (c полями name, age, phone) в карту Номер телефона -> Имя пользователя.


        User dima = new User("Дима", 10, null);
        User vasya = new User("Вася", 14, "89129177871");
        User alena = new User("Алена", 20, "89129177827");
        User nastya = new User("Настя", 37, "89129176877");
        User sveta = new User("Света", 26, "89129177677");
        User petr = new User("Петр", 24, "89129177877");

        List<User> listOfUser = new ArrayList<>();
        listOfUser.add(dima);
        listOfUser.add(vasya);
        listOfUser.add(alena);
        listOfUser.add(nastya);
        listOfUser.add(sveta);
        listOfUser.add(petr);

        System.out.println(listOfUser);

        System.out.println(addToMap(listOfUser));


    }

    public static HashMap<String, String> addToMap(List<User> o) {
        HashMap<String, String> listOfUsers2 = new HashMap<>();
        for (int i = 0; i < o.size(); i++) {
            listOfUsers2.put("Имя: " + o.get(i).name+" ","> " + "Телефон: " + o.get(i).phone + '\n');
        }
        return listOfUsers2;
    }

}




