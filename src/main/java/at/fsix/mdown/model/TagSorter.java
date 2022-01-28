package at.fsix.mdown.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TagSorter {

    public static String fromHTML(String[] lines){  //eigentlich statt String: List<DocumentElement>
        String name =""; //Todo entfernen
        for (String line: lines) {
            List<String> tmp = new ArrayList<>(Arrays.asList(line.split("[<>]")));
            tmp.removeAll(Arrays.asList("", null));
            //entfernen:
            name += tmp;
        }
        return name;
    }

    public static List<List<String>> fromMD(String[] lines){
        List<List<String>> retList = new ArrayList<>();
        //The (?<=[char]{how often})|(?=[char]{how often}) - method ensures that the separators stay in the result array
        String MDRegex = "(?<=(?:\\*\\s))|(?=(?:\\*\\s))"+
                "|(?<=[*]{1,2})|(?=[*]{1,2})" +          // **bold** and *cursive* in +-Variant
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
        }
        return retList;
    }

    public static String fromPdf(String[] lines){return null;}
    public static String fromDocx(String[] lines){return null;}
}
