package at.fsix.mdown.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MarkedUpDocument {

    private String name;
    private FileType extension;
    private List<DocumentElement> contentElements;
    private Stack<String> hierarchy;
    private String encoding = "utf-8";

    public MarkedUpDocument(String text, FileType input, String name, FileType extension, String encoding){
        this.name = name;
        this.extension = extension;
        this.encoding = encoding;
        String[] lines = text.split("\n");
        switch (input){
            case md:
                this.name = TagSorter.fromMD(lines);
                break;
            case html:
                this.name = TagSorter.fromHTML(lines);
                break;
            default:
                this.name = TagSorter.fromMD(lines);
                break;
        }
    }

    public MarkedUpDocument(String text, String name, FileType extension, String encoding){
        this(text, FileType.md, name, extension, encoding);
    }

    public MarkedUpDocument(String text){
        this(text, "", FileType.html, "utf-8");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FileType getExtension() {
        return extension;
    }

    public void setExtension(FileType extension) {
        this.extension = extension;
    }

    public List<DocumentElement> getContentElements() {
        return contentElements;
    }

    public void setContentElements(List<DocumentElement> contentElements) {
        this.contentElements = contentElements;
    }

    public Stack<String> getHierarchy() {
        return hierarchy;
    }

    public void setHierarchy(Stack<String> hierarchy) {
        this.hierarchy = hierarchy;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }
}
