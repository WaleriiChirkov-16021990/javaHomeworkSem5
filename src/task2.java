/*
Пусть дан список сотрудников:Иван Иванов
Светлана Петрова

Кристина Белова

Анна Мусина

Анна Крутова

Иван Юрин

Петр Лыков

Павел Чернов

Петр Чернышов

Мария Федорова

Марина Светлова

Мария Савина

Мария Рыкова

Марина Лугова

Анна Владимирова

Иван Мечников

Петр Петин

Иван Ежов

Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
 */


import java.util.*;
import java.util.stream.Collectors;

public class task2 {
    public static void main(String[] args) {
        ArrayList<String> users = new ArrayList<>(Arrays.asList(
                "Иван Иванов",
                "Светлана Петрова",
                "Кристина Белова",
                "Анна Мусина",
                "Анна Крутова",
                "Иван Юрин",
                "Петр Лыков",
                "Павел Чернов",
                "Петр Чернышов",
                "Мария Федорова",
                "Марина Светлова",
                "Мария Савина",
                "Мария Рыкова",
                "Марина Лугова",
                "Анна Владимирова",
                "Иван Мечников",
                "Петр Петин"
                ,"Иван Ежов"));
        System.out.println("Исходный список: \n" + users);
        Map<String,Integer> usersRecurring = getRecurringName(users);
        Map<String,Integer> sortedMapPopularity = usersRecurring.entrySet().stream().sorted(Comparator.comparingInt(i -> -i.getValue())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a,b)-> {throw new AssertionError();}, LinkedHashMap::new));
        System.out.println("Выведем отсортированный список падения популярности имени: \n");
        sortedMapPopularity.entrySet().forEach(System.out::println);
    }
    public static Map<String,Integer> getRecurringName(ArrayList object){
        Map<String,Integer> usersRecurring = new HashMap<>();
        String[] temp;
        for (Object s: object
             ) {
            String value = (String) s;
            temp = value.split(" ");
            if(usersRecurring.containsKey(temp[0])){
                usersRecurring.put(temp[0], usersRecurring.get(temp[0]) + 1);
            } else usersRecurring.put(temp[0], 1);
        }
        System.out.println("Словарь , где ключи = имена из списка, а значение = количество повторений в списке : \n" + usersRecurring);
        return usersRecurring;
    }
}
