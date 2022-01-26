package at.fsix.mdown.model;

import java.util.List;
import java.util.Stack;

public class MarkedUpDocument {

    private String name;
    private FileType extension;
    private List<DocumentElement> contentElements;
    private Stack<String> hierarchy;
    private String encoding = "utf-8";

    public MarkedUpDocument(String text){

    }


}
