package Collections;

import java.util.HashMap;

public class MainClassColl {
    public static void main(String[] args) {

        String[] array = {"orange", "apple", "melon", "banana", "strawberry", "orange",
                "apple", "melon", "orange", "melon", "cherry", "orange"};

        HashMap<String, Integer> listFruits = new HashMap<>();
        String fruit = "";
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            fruit = array[i];
            for (String o : array) {
                if (o.equals(fruit)) {
                    sum += 1;
                }
            }
            if (!listFruits.containsKey(fruit)) listFruits.put(fruit, sum);
            sum = 0;
        }
        System.out.println(listFruits);
    }

}
