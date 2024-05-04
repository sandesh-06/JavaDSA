package HashMap.Concepts;

import java.util.HashMap;
import java.util.Map;

public class HM_1_Basics {
    public static void main(String[] args) {
        //1. SYNTAX
        Map<String, Integer> mp = new HashMap<>(); //key-string, value-int

        //2. ADDING ELEMENTS using PUT
        mp.put("Akash", 21);
        mp.put("Yash", 16);
        mp.put("Roshan", 18);
        mp.put("Rithika", 20);
        mp.put("Hitesh", 28);

        //3. GETTING VALUE OF A KEY using GET
        System.out.println(mp.get("Roshan")); //returns 18
        System.out.println(mp.get("Manan")); //returns null, as key doesn't exist

        //4. CHANGING / UPDATING THE VALUES
        mp.put("Rithika", 25); //now age of Rithika will change to 25
        //if the key doesn't exist a new entry will be added

        //5. REMOVE A ENTRY FROM HASHMAP
        System.out.println(mp.remove("Roshan")); //if key exists returns value
        System.out.println(mp.remove("Manny")); //if not returns null

        //6. CHECKING IF KEY EXISTS IN MAP
        System.out.println(mp.containsKey("Hitesh")); //true
        System.out.println(mp.containsKey("Yahsna")); //false

        //7. ADDING AN ENTRY ONLY IF THE KEY DOESN'T EXIST
        mp.putIfAbsent("Roshan", 23); //will not be added
        mp.putIfAbsent("Viraj", 31); //will be added

        //8. GET ALL THE KEYS
        System.out.println(mp.keySet()); //returns array

        //9. GET ALL VALUES
        System.out.println(mp.values()); //returns array

        //10. GET ALL THE ENTRIES
        System.out.println(mp.entrySet()); //returns array

        //11. TRAVERSING HASHMAP
        for(String key: mp.keySet()){
            System.out.printf("Age of %s is %d\n", key, mp.get(key));
        }

        //12. SIZE OF HASHMAP
        System.out.println(mp.size());

        System.out.println();
        for(Map.Entry<String, Integer> entry: mp.entrySet()){
            System.out.printf("Age of %s is %d\n", entry.getKey(), entry.getValue());
        }
        System.out.println();
        //NEW FOR EACH SYNTAX
        for(var entry: mp.entrySet()){
            System.out.printf("Age of %s is %d\n", entry.getKey(), entry.getValue());
        }
    }
}
