/*
Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
Добавить функции 1) Добавление номера
                 2) Вывод всего
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class task1{

    // Добавление номера
    public static void addNumber(String key, int value, Map<String, ArrayList<Integer>> map){
        if (map.containsKey(key)) {
            map.get(key).add(value);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(value);
            map.put(key, list);
        }

    }
    // Вывод всего
    public static void printBook(Map<String, ArrayList<Integer>> map){
        for (var item : map.entrySet()) {
            String phones = "";
            for(int el: item.getValue()){
                phones = phones + el + ", ";
            }
            System.out.printf("%s: %s \n", item.getKey(), phones);
        }
    }
    public static void main(String[] args) {
        Scanner iscanner = new Scanner(System.in);
        Map<String, ArrayList<Integer>> bookPhone = new HashMap<>();
        addNumber("Ivanov", 123, bookPhone);
        while (true){
            System.out.println("1-Внести данные, 2-Вывести данные, 3-Отмена");
            int action = iscanner.nextInt();
            iscanner.skip("\r\n|[\n\r\u2028\u2029\u0085]");
            if (action==1){
                System.out.println("Введите фамилию");
                String lastName = iscanner.nextLine();
                System.out.println("Введите номер");
                int telNum = iscanner.nextInt();
                addNumber(lastName, telNum, bookPhone);
            }
            if (action==2){
                printBook(bookPhone);
            }
            if (action==3){
                break;
            }
        }
        iscanner.close();
    }
}