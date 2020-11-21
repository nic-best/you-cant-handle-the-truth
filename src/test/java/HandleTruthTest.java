import org.junit.Test;

import java.util.*;
import static org.junit.Assert.*;

public class HandleTruthTest {
    @Test
    public void makeshiftTest() {
        String msg = "son we live in a world that has walls and those walls have to be guarded by men with guns whos gonna do it you you lieutenant weinberg i have a greater responsibility than you can possibly fathom you weep for santiago and you curse the marines you have that luxury you have the luxury of not knowing what i know that santiagos death while tragic probably saved lives and my existence while grotesque and incomprehensible to you saves lives you dont want the truth because deep down in places you dont talk about at parties you want me on that wall you need me on that wall we use words like honor code loyalty we use these words as the backbone of a life spent defending something you use them as a punchline i have neither the time nor the inclination to explain myself to a man who rises and sleeps under the blanket of the very freedom that i provide and then questions the manner in which i provide it i would rather you just said thank you and went on your way otherwise i suggest you pick up a weapon and stand a post either way i dont give a damn what you think you are entitled to";

        ArrayList<AbstractMap> mapList = HandleTruth.wordCount(msg);
        HashMap<String, Integer> wordMap = (HashMap<String, Integer>) mapList.get(0);
        TreeMap<Integer, Set<String>> sortedMap = (TreeMap<Integer, Set<String>>) mapList.get(1);

        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            System.out.println(entry);
        }


        for (Map.Entry<Integer, Set<String>> entry : sortedMap.entrySet()) {
            System.out.println(entry);
        }

    }


    //this tests that the casts on the maps are working correctly, as well as the iteration is able to retrieve items correctly from the lists
    @Test
    public void testMapIteration(){
        String msg = "hi hi hi wow wow boo wow";
        ArrayList<AbstractMap> mapList = HandleTruth.wordCount(msg);
        HashMap<String, Integer> wordMap = (HashMap<String, Integer>) mapList.get(0);
        TreeMap<Integer, Set<String>> sortedMap = (TreeMap<Integer, Set<String>>) mapList.get(1);


        String actualWordMap = "";
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            actualWordMap+=entry;
        }
        String expectedWordMap = "hi=3boo=1wow=3";
        assertEquals(expectedWordMap, actualWordMap);

        String actualSortedMap = "";
        for (Map.Entry<Integer, Set<String>> entry : sortedMap.entrySet()) {
            actualSortedMap+=entry;
        }
        String expectedSortedMap = "3=[hi, wow]1=[boo]";
        assertEquals(expectedSortedMap, actualSortedMap);
    }

    @Test
    public void tests() {
        ArrayList<String> testStrings = new ArrayList<String>();
        ArrayList<String> expectedWordMaps = new ArrayList<String>();
        ArrayList<String> expectedSortedMaps = new ArrayList<String>();

        //test case empty string
        testStrings.add("");
        expectedWordMaps.add("");
        expectedSortedMaps.add("");

        //test case one word
        testStrings.add("wow");
        expectedWordMaps.add("wow=1");
        expectedSortedMaps.add("1=[wow]");

        //test case sensitivity
        testStrings.add("wow WoW wOW");
        expectedWordMaps.add("wow=1WoW=1wOW=1");
        expectedSortedMaps.add("1=[wow, WoW, wOW]");

        //test case sensitivity multiple
        testStrings.add("wow WoW wOW crazy CrAzy CrAzy");
        expectedWordMaps.add("CrAzy=2crazy=1wow=1WoW=1wOW=1");
        expectedSortedMaps.add("2=[CrAzy]1=[crazy, wow, WoW, wOW]");

        //test ordering
        testStrings.add("wordone wordtwo wordtwo wordthree");
        expectedWordMaps.add("wordthree=1wordtwo=2wordone=1");
        expectedSortedMaps.add("2=[wordtwo]1=[wordthree, wordone]");


        for (int i = 0; i < testStrings.size(); i++) {
            ArrayList<AbstractMap> mapList = HandleTruth.wordCount(testStrings.get(i));
            HashMap<String, Integer> wordMap = (HashMap<String, Integer>) mapList.get(0);
            TreeMap<Integer, Set<String>> sortedMap = (TreeMap<Integer, Set<String>>) mapList.get(1);


            String actualWordMap = "";
            for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
                actualWordMap+=entry;
            }
            assertEquals(expectedWordMaps.get(i), actualWordMap);

            String actualSortedMap = "";
            for (Map.Entry<Integer, Set<String>> entry : sortedMap.entrySet()) {
                actualSortedMap+=entry;
            }
            assertEquals(expectedSortedMaps.get(i), actualSortedMap);
        }
    }
}