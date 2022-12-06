/*
Реализуйте структуру телефонной книги с помощью HashMap,
учитывая, что 1 человек может иметь несколько телефонов.
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Map<String, String>> phoneBook = new HashMap<>();
        ArrayList<String> category = new ArrayList<>((Arrays.asList("home"," work", "mobile")));
        Scanner scanner = new Scanner(System.in);
        String name;
        while (true) {
            System.out.println("\n1.Show phone book \n2.Add new user contact \n3. Remove user contact \n4.Exit");
            System.out.println("\n You enter: ");
            String enter = scanner.nextLine();
            if (enter.replace(" ", "").equals("1")) {
                System.out.println(phoneBook);
            } else if (enter.replace(" ", "").equals("2")) {
                System.out.println("Enter name usher: ");
                name = scanner.nextLine();
                phoneBook.put(name, getUserNumber(scanner, category));
            } else if (enter.replace(" ", "").equals("3")) {
                System.out.print("Entering a name to delete: ");
                String remove = scanner.nextLine();
                if (phoneBook.containsKey(remove)){
                    phoneBook.remove(remove);
                } else System.out.println("There is no such contact !");
            } else if (enter.replace(" ", "").equals("4")) {
                scanner.close();
                break;
            }
        }
        System.out.println("The application is closing");
    }

    private static Map<String,String> getUserNumber(Scanner scanner,ArrayList<String> category){
        Map<String, String> userNumber = new HashMap<>();
        String temp;
        for (int i = 0; i < category.size(); i++) {
            if (i == 0) {
                System.out.println("Enter home telephone: ");
                temp = scanner.nextLine();
                if (!(temp.equalsIgnoreCase("нет") || temp.equalsIgnoreCase("n") || temp.equalsIgnoreCase("no"))) {
                    userNumber.put(category.get(i), temp);
                }
            } else if (i == 1) {
                System.out.println("Enter work telephone: ");
                temp = scanner.nextLine();
                if (!(temp.equalsIgnoreCase("нет") || temp.equalsIgnoreCase("n") || temp.equalsIgnoreCase("no"))) {
                    userNumber.put(category.get(i), temp);
                }
            } else if (i == 2) {
                System.out.println("Enter mobile telephone: ");
                temp = scanner.nextLine();
                if (!(temp.equalsIgnoreCase("нет") || temp.equalsIgnoreCase("n") || temp.equalsIgnoreCase("no"))) {
                    userNumber.put(category.get(i), temp);
                }
            }
        }
        return userNumber ;
    }
}