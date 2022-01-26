package at.fsix.mdown.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Is supposed to be a connector/adapter between Markdown and HTML/docx/Pdf or the other Way around
 *
 * One DocumentElement corresponds to one complete HTML Tag with id and content
 *
 */
public class DocumentElement {

    private String id;
    private String content;
    private ElementTag tag;
    private String childOf;
    private List<DocumentElement> contentElements;

    /**
     *
     * @param id The id to reference this tag in the document
     * @param content The Elements content
     * @param tag What kind of element it is (e.g. html tag)
     */
    public DocumentElement(String id, String content, ElementTag tag, String childOf){
        this.id = id;
        this.content = content;
        this.tag = tag;
    }

    /**
     *
     * @param id The id to reference this tag in the document
     * @param content The Elements content
     * @param tag What kind of element it is (e.g. html tag)
     */
    public DocumentElement(String id, String content, ElementTag tag){
        this(id, content, tag, "");
    }

    /**
     *
     * @param content The Elements content
     * @param tag What kind of element it is (e.g. html tag)
     */
    public DocumentElement(String content, ElementTag tag){
        this("", content, tag);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ElementTag getTag() {
        return tag;
    }

    public void setTag(ElementTag tag) {
        this.tag = tag;
    }

    public List<DocumentElement> getContentElements() {
        return contentElements;
    }

    public void setContentElements(DocumentElement contentElement) {
        if (this.contentElements != null && !this.contentElements.isEmpty()){
            this.contentElements.add(contentElement);
        }else {
            this.contentElements = new ArrayList<>();
            this.contentElements.add(contentElement);
        }
    }

    public String getChildOf() {
        return childOf;
    }

    public void setChildOf(String childOf) {
        this.childOf = childOf;
    }

    public String toHTMLString(){
        return String.format("<%s id=\"%s\">%s</%s>", tag.toString(), id, content, tag.toString());
    }
}
