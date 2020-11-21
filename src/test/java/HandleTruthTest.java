import org.junit.Test;

import java.util.*;

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

}