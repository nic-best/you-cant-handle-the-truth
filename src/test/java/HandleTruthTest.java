import org.junit.Test;

import java.util.*;
import static org.junit.Assert.*;

public class HandleTruthTest {
    //this tests that the casts on the maps are working correctly, as well as the iteration is able to retrieve items correctly from the lists
    //passing this test allows us to use this method to check for expected results
    @Test
    public void testMapIteration(){
        String msg = "hi hi hi wow wow boo wow";
        ArrayList<AbstractMap> mapList = HandleTruth.wordCount(msg);
        HashMap<String, Integer> wordMap = (HashMap<String, Integer>) mapList.get(0);
        TreeMap<Integer, Set<String>> sortedMap = (TreeMap<Integer, Set<String>>) mapList.get(1);


        String actualWordMap = "";
        //gets every value from wordMap and adds to string
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            actualWordMap+=entry;
        }
        String expectedWordMap = "hi=3boo=1wow=3";
        assertEquals(expectedWordMap, actualWordMap);

        String actualSortedMap = "";
        //gets every value from sortedMap and adds to string
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

        //hashMaps are not alphabetically ordered, TreeMaps are
        //test ordering
        testStrings.add("wordone wordtwo wordtwo wordthree");
        expectedWordMaps.add("wordthree=1wordtwo=2wordone=1");
        expectedSortedMaps.add("2=[wordtwo]1=[wordthree, wordone]");

        //test ordering2
        testStrings.add("b c e f z x a");
        //only in alphabetical order due to behavior of hashing function
        expectedWordMaps.add("a=1b=1c=1e=1f=1x=1z=1");
        expectedSortedMaps.add("1=[a, b, c, e, f, x, z]");

        //test given string
        testStrings.add("son we live in a world that has walls and those walls have to be guarded by men with guns whos gonna do it you you lieutenant weinberg i have a greater responsibility than you can possibly fathom you weep for santiago and you curse the marines you have that luxury you have the luxury of not knowing what i know that santiagos death while tragic probably saved lives and my existence while grotesque and incomprehensible to you saves lives you dont want the truth because deep down in places you dont talk about at parties you want me on that wall you need me on that wall we use words like honor code loyalty we use these words as the backbone of a life spent defending something you use them as a punchline i have neither the time nor the inclination to explain myself to a man who rises and sleeps under the blanket of the very freedom that i provide and then questions the manner in which i provide it i would rather you just said thank you and went on your way otherwise i suggest you pick up a weapon and stand a post either way i dont give a damn what you think you are entitled to");
        expectedWordMaps.add("explain=1very=1guns=1saved=1lieutenant=1about=1your=1these=1saves=1would=1pick=1fathom=1grotesque=1incomprehensible=1because=1greater=1you=18give=1sleeps=1went=1lives=2in=3want=2loyalty=1myself=1them=1it=2then=1something=1as=2at=1knowing=1provide=2santiago=1curse=1weinberg=1entitled=1whos=1be=1probably=1world=1walls=2freedom=1responsibility=1are=1by=1have=5tragic=1backbone=1man=1stand=1inclination=1a=8think=1gonna=1words=2i=8suggest=1the=9places=1thank=1to=5under=1punchline=1use=3honor=1existence=1defending=1questions=1do=1manner=1while=2down=1that=6either=1son=1post=1than=1me=2talk=1has=1up=1those=1possibly=1which=1otherwise=1need=1like=1my=1parties=1know=1santiagos=1rises=1dont=3who=1deep=1code=1death=1rather=1for=1we=3weep=1life=1nor=1guarded=1can=1weapon=1not=1and=8men=1of=3said=1just=1live=1on=3spent=1way=2damn=1with=1what=2truth=1marines=1neither=1luxury=2time=1blanket=1wall=2");
        expectedSortedMaps.add("18=[you]9=[the]8=[a, and, i]6=[that]5=[have, to]3=[in, use, of, dont, we, on]2=[lives, want, words, it, while, way, as, walls, what, provide, me, luxury, wall]1=[explain, very, guns, saved, lieutenant, about, your, these, saves, would, pick, fathom, grotesque, incomprehensible, because, greater, give, sleeps, went, loyalty, myself, them, then, something, at, knowing, santiago, curse, weinberg, entitled, whos, be, probably, world, freedom, responsibility, are, by, tragic, backbone, man, stand, inclination, think, gonna, suggest, places, thank, under, punchline, honor, existence, defending, questions, do, manner, down, either, son, post, than, talk, has, up, those, possibly, which, otherwise, need, like, my, parties, know, santiagos, rises, who, deep, code, death, rather, for, weep, life, nor, guarded, can, weapon, not, men, said, just, live, spent, damn, with, truth, marines, neither, time, blanket]");

        //test numbers
        testStrings.add("2 2 3 4 3 3 4 4 1 4");
        expectedWordMaps.add("1=12=23=34=4");
        expectedSortedMaps.add("4=[4]3=[3]2=[2]1=[1]");

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