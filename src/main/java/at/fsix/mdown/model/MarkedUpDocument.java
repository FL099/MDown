package at.fsix.mdown.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MarkedUpDocument {

    private String name;
    private FileType extension;
    private List<DocumentElement> contentElements;
    private Stack<ElementTag> hierarchy;//TODO: delete
    private int hierarchyLevel = 0;
    private String encoding = "utf-8";

    public MarkedUpDocument(String text, FileType input, String name, FileType extension, String encoding){
        this.name = name;
        this.extension = extension;
        this.contentElements = new ArrayList<>();
        this.hierarchy = new Stack<>();
        this.hierarchy.push(ElementTag.document);
        String[] lines = text.split("\n");
        switch (input){
            case md:
                List<List<String>> content = TagSorter.fromMD(lines);
                MDToStandardFormat(content);
                break;
            case html:
                this.name = TagSorter.fromHTML(lines);
                break;
            case pdf:
                this.name = TagSorter.fromPdf(lines);
                break;
            case docx:
                this.name = TagSorter.fromDocx(lines);
                break;
            default:
                //this.name = TagSorter.fromMD(lines);
                break;
        }
    }

    public MarkedUpDocument(String text, String name, FileType extension, String encoding){
        this(text, FileType.md, name, extension, encoding);
    }

    public MarkedUpDocument(String text){
        this(text, "", FileType.none, "utf-8");
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

    public String getContentElements(boolean s){
        StringBuilder str = new StringBuilder();
        for (DocumentElement content: contentElements) {
            str.append(content.toString());
        }
        return  str.toString();
    }

    public void setContentElements(List<DocumentElement> contentElements) {
        this.contentElements = contentElements;
    }

    public Stack<ElementTag> getHierarchy() {
        return hierarchy;
    }

    public void setHierarchy(Stack<ElementTag> hierarchy) {
        this.hierarchy = hierarchy;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String toString(){
        return name + "\n" + encoding; // TODO
    }

    private void MDToStandardFormat(List<List<String>> content){
        //Neues DocumentElement erstellen (repräsentiert in diesem Fall eine Zeile oder Element wie p bzw div)
        DocumentElement tmp = new DocumentElement("", ElementTag.p, "document");
        for (List<String> line :content) {
            boolean addIt = false;

            //Testen, ob Aufzählung, Überschrift, Checkbox, usw
            switch (line.get(0)){

                case "*":   //Aufzählung
                case "-":
                    hierarchy.push(ElementTag.li);
                    hierarchyLevel++;
                    line.remove(0);
                    tmp.setTag(ElementTag.li);
                    this.name += line.toString();
                    break;
                case "#":   //Überschrift
                    hierarchy.push(ElementTag.h1);
                    hierarchyLevel++;
                    line.remove(0);
                    tmp.setTag(ElementTag.h1);
                    this.name += line.toString();
                    addIt= true;
                    break;
                case "|":
                    hierarchy.push(ElementTag.table);
                    hierarchyLevel++;
                    line.remove(0);
                    tmp.setTag(ElementTag.table);
                    this.name += line.toString();
                    break;
                default:
                    break;
            }


            String tmpContent = "";
            boolean specialCont = false;
            for (String thing: line) {
                if (thing.equals("_") || thing.equals("*")){
                    if (hierarchy.peek() == ElementTag.i){
                        hierarchy.pop();
                        tmp.setContentElements(new DocumentElement(tmpContent, ElementTag.i, "document"));  // hierarchy.peek() statt document
                        tmpContent = "";
                        hierarchyLevel--;
                        specialCont=false;
                    }
                    else {
                        hierarchy.push(ElementTag.i);
                        hierarchyLevel++;
                        specialCont = true;
                    }
                }else if (thing.equals("__")||thing.equals("**")){
                    hierarchy.push(ElementTag.strong);
                    specialCont = true;
                }else if (thing.equals("~~")){
                    hierarchy.push(ElementTag.del);
                    specialCont = true;
                }else {
                    tmpContent += thing;

                }
            }
            tmp.setContent(tmp.getContent()+tmpContent.strip());

            try {
                if (line.get(line.size()-1).equals("$$")){      //TODO: gegen doppeltes Leerzeichen tauschen!!!!
                    addIt = true;
                }
            }catch (IndexOutOfBoundsException e){
                if (line.get(0).equals("$$")){
                    tmp.setTag(ElementTag.br);
                    tmp.setContent("");
                    addIt = true;
                }
            }



            if (addIt){

                this.contentElements.add(tmp);
                tmp = new DocumentElement("", ElementTag.p, "document");
                addIt = false;
                hierarchyLevel--;
            }

        }
        this.contentElements.add(tmp);
    }
}
