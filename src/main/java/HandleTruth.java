import java.util.*;

public class HandleTruth {
    public static ArrayList<AbstractMap> wordCount(String msg) {

        //if we are given an empty string, return empty debug lists
        /*
        this prevents the rest of the method being run, which would print the incorrect information due to
        regex functionality in msg.split
         */
        if(msg.length()==0){
            ArrayList<AbstractMap> mapList = new ArrayList<>();
            HashMap<String, Integer> wordMap = new HashMap<>();
            TreeMap<Integer, Set<String>> sortedMap = new TreeMap<>(Collections.reverseOrder());
            mapList.add(wordMap);
            mapList.add(sortedMap);
            return mapList;
        }

        // split the message into word set
        String[] words = msg.split(" ");

        // use map to count the occurrences of each word
        HashMap<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            if (wordMap.containsKey(word)) {
                wordMap.put(word, wordMap.get(word) + 1);
                continue;
            }
            wordMap.put(word, 1);
        }
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            System.out.println(entry);
        }

        // sort the map based on number of occurrences
        TreeMap<Integer, Set<String>> sortedMap = new TreeMap<>(Collections.reverseOrder());
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            int key = entry.getValue();
            Set<String> values = sortedMap.containsKey(key) ?
                    sortedMap.get(key) : new HashSet<>();
            values.add(entry.getKey());
            sortedMap.put(entry.getValue(), values);
        }

        for (Map.Entry<Integer, Set<String>> entry : sortedMap.entrySet()) {
            System.out.println(entry);
        }

        //return values for debug
        ArrayList<AbstractMap> mapList = new ArrayList<>();
        mapList.add(wordMap);
        mapList.add(sortedMap);
        return mapList;
    }
}