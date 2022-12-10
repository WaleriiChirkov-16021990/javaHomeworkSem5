/*
На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class task4 {
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> gameField = new ArrayList<>();
        gameField = getGameField();
        gameField.forEach(System.out :: println);
        ArrayList<ArrayList<String>> queenONField = new ArrayList<>();
        queenONField = getGameFieldQueenOn(gameField);
        System.out.println();
        queenONField.forEach(System.out::println );


    }
    private static ArrayList<ArrayList<String>> getGameField (){
        ArrayList<ArrayList<String>> multiArray = new ArrayList<>();
        ArrayList<String> unoArray = new ArrayList<>();
        String[] abc = new String[] {"A", "B", "C", "D", "E", "F", "G", "H"};
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                unoArray.add(abc[j] + String.valueOf(i + 1));
            }
            multiArray.add(unoArray);
            unoArray = new ArrayList<>();
        }
        return multiArray;
    }

    private static ArrayList<ArrayList<String>> getGameFieldQueenOn ( ArrayList<ArrayList<String>> arrayList){
        String queen = "W";
        Map<Integer, Integer> history = new HashMap<>();
        while (true){
            int i = 0;
            while ( i < arrayList.size()/2) {
                int j = 0;
                while (j < arrayList.size()) {
                    if(i == 0 || i == 1 || i == 2){
                        if(j >= arrayList.size()/2 - 1){
                            if (isEmptyPosition(arrayList, i, j)){
                                history.put(i, j);
                                arrayList.get(i).set(j, queen);
                                if (isEmptyPosition(arrayList, arrayList.size() - 1 -i, arrayList.size() - 1 -j)){
                                    history.put(arrayList.size() - 1 -i, arrayList.size() - 1 - j);
                                    arrayList.get(7-i).set(arrayList.size() - 1 -j, queen);
                                }
                                break;
                            }
                        }
                    } else {
                        if (isEmptyPosition(arrayList, i, j)){
                            history.put(i, j);
                            arrayList.get(i).set(j, queen);
                            if (isEmptyPosition(arrayList, arrayList.size() - 1 -i, arrayList.size() - 1 -j)){
                                history.put(arrayList.size() - 1-i, arrayList.size() - 1 - j);
                                arrayList.get(arrayList.size() - 1 -i).set(arrayList.size() - 1- j, queen);
                            }
                            break;
                        }
                    }
                    j++;
                }
                i++;
            System.out.println();
            arrayList.forEach(System.out::println);
            }
            break;
        }
        return arrayList;
    }
    private static boolean isEmptyPosition (ArrayList<ArrayList<String>> arrayList, int rows, int columns ){
        int limitRows = arrayList.size();
        int limitColumns = arrayList.get(0).size();
        int a = rows;
        int b = columns;
        for (int i = 0; i < limitColumns; i++) {
            if(arrayList.get(rows).get(i).equalsIgnoreCase("W")) return false;
        }
        for (int i = 0; i < limitRows; i++) {
            if ((arrayList.get(i).get(columns).equalsIgnoreCase("W"))) return false;
        }
         while (b >= 0 && a >= 0){
             if (arrayList.get(a).get(b).equalsIgnoreCase("W")) return false;
             else {
                 b--;
                 a--;
             }
         }
        a = rows;
        b = columns;
         while (b >= 0 && a < 8){
             if (arrayList.get(a).get(b).equalsIgnoreCase("W")) return false;
             else {
                 b--;
                 a++;
             }
         }
        a = rows;
        b = columns;
        while (b < 8 && a < 8){
            if (arrayList.get(a).get(b).equalsIgnoreCase("W")) return false;
            else {
                b++;
                a++;
            }
        }
        a = rows;
        b = columns;
        while (b < 8 && a >= 0){
            if (arrayList.get(a).get(b).equalsIgnoreCase("W")) return false;
            else {
                b++;
                a-- ;
            }
        }
        return true ;
    }
}
