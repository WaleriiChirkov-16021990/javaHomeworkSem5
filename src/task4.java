/*
На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.
 */

import java.util.ArrayList;

public class task4 {
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> gameField = new ArrayList<>();
        gameField = getGameField();
        gameField.forEach(System.out :: println);


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
        String queen = "U+2655";
        int rows = 0;
        int columns = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                arrayList.get(i).set(j, queen);
            }
        }
        return arrayList;
    }
    private static boolean isEmptyPosition (ArrayList<ArrayList<String>> arrayList, int rows, int columns ){
        boolean flag = false;
        int limitRows = arrayList.size();
        int limitColumns = arrayList.get(0).size();
        int a = rows;
        int b = columns;
        for (int i = 0; i < limitColumns; i++) {
            if(arrayList.get(rows).get(i).equalsIgnoreCase("U+2655")) return flag;
        }
        for (int i = 0; i < limitRows; i++) {
            if ((arrayList.get(i).get(columns).equalsIgnoreCase("U+2655"))) return flag;
        }
         while (b >= 0 && a >= 0){
             if arrayList.get(a).get(b).equalsIgnoreCase()
         }
        return  flag;
    }
}
