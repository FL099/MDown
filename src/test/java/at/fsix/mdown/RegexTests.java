package at.fsix.mdown;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class RegexTests {

    @Test
    void selectStarListTest(){
        String testString ="* Test";
        String regex = "(?<=(?:\\*\\s))|(?=(?:\\*\\s))";
        List<String> tmp = new ArrayList<>(Arrays.asList(testString.split(regex)));
        tmp.removeAll(Arrays.asList(" ", "", null));
        String test = "";
        test += tmp;
        assertEquals("[* , Test]", test);
    }

    @Test
    void selectMinusListTest(){
        String testString ="- Test";
        String regex = "(?<=(?:-\\s))|(?=(?:-\\s))";
        List<String> tmp = new ArrayList<>(Arrays.asList(testString.split(regex)));
        tmp.removeAll(Arrays.asList(" ", "", null));
        String test = "";
        test += tmp;
        assertEquals("[- , Test]", test);
    }

    @Test
    void selectStarBoldTest(){
        String testString ="**Test**";
        String regex = "(?<=[*]{2})|(?=[*]{2})";
        List<String> tmp = new ArrayList<>(Arrays.asList(testString.split(regex)));
        tmp.removeAll(Arrays.asList(" ", "", null));
        String test = "";
        test += tmp;
        assertEquals("[**, Test, **]", test);
    }

    @Test
    void selectStarCursiveTest(){
        String testString ="*Test*";
        String regex = "(?<=[*])|(?=[*])";
        List<String> tmp = new ArrayList<>(Arrays.asList(testString.split(regex)));
        tmp.removeAll(Arrays.asList(" ", "", null));
        String test = "";
        test += tmp;
        assertEquals("[*, Test, *]", test);
    }

    @Test
    void selectUnderscoreBoldTest(){
        String testString ="__Test__";
        String regex = "(?<=[_]{2})|(?=[_]{2})";
        List<String> tmp = new ArrayList<>(Arrays.asList(testString.split(regex)));
        tmp.removeAll(Arrays.asList(" ", "", null));
        String test = "";
        test += tmp;
        assertEquals("[__, Test, __]", test);
    }

    @Test
    void selectUnderscoreCursiveTest(){
        String testString ="_Test_";
        String regex = "(?<=[_])|(?=[_])";
        List<String> tmp = new ArrayList<>(Arrays.asList(testString.split(regex)));
        tmp.removeAll(Arrays.asList(" ", "", null));
        String test = "";
        test += tmp;
        assertEquals("[_, Test, _]", test);
    }

    @Test
    void selectUScoreAndStarTest(){
        String testString ="_**Test**_";
        String regex = "(?<=[_])|(?=[_])|(?<=[*]{2})|(?=[*]{2})";
        List<String> tmp = new ArrayList<>(Arrays.asList(testString.split(regex)));
        tmp.removeAll(Arrays.asList(" ", "", null));
        String test = "";
        test += tmp;
        assertEquals("[_, **, Test, **, _]", test);
    }

    @Test
    void selectUnderscoreCombiTest(){
        String testString ="___Test___ _Bspl_";
        String regex = "(?<=[_]{3})|(?=[_]{3})";
        List<String> tmp = new ArrayList<>(Arrays.asList(testString.split(regex)));
        tmp.removeAll(Arrays.asList(" ", "", null));
        String test = "";
        test += tmp;
        assertEquals("[___, Test, ___, _, Bspl, _]", test);
    }

    /*String MDRegex = "(?<=(?:\\*\\s))|(?=(?:\\*\\s))"+
                "|(?<=[*]{1,2})|(?=[*]{1,2})" +          // **bold** and *cursive* in *-Variant
                "|(?<=[_]{2})|(?=[_]{2})" +         // __bold__ and _cursive_ in _-Variant TODO: so anpassen, dass es auch "kombi" aus _ + __ erkennt
                "|(?<=[_])|(?=[_])" +         // __bold__ and _cursive_ in _-Variant TODO: so anpassen, dass es auch "kombi" aus _ + __ erkennt
                "|(?<=[~]{2})|(?=[~]{2})" +             // strikethrough
                "|(?<=[#]{1,6})|(?=[#]{1,6})" +         // headings level 1-6
                "|(?<=[`]{3})|(?=[`]{3})" +             // Code Fragment
                "|(?<=[|])|(?=[|])";                    // Table
                //TODO erweitern

        for (String line: lines) {
            List<String> tmp = new ArrayList<>(Arrays.asList(line.split(MDRegex)));
            //TODO: replace all "    "(four spaces or tab) with \t
            tmp.removeAll(Arrays.asList(" ", "", null));
            retList.add(tmp);
        }*/
}
