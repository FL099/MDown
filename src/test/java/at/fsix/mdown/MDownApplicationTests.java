package at.fsix.mdown;

import at.fsix.mdown.model.DocumentElement;
import at.fsix.mdown.model.ElementTag;
import at.fsix.mdown.model.MarkedUpDocument;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MDownApplicationTests {

    @Test
    void htmlThingsWork() {
        DocumentElement docEL = new DocumentElement("ue1","Ueberschrift 1", ElementTag.h1);
        assertEquals(docEL.toHTMLString(), "<h1 id=\"ue1\">Ueberschrift 1</h1>");
    }

    @Test
    void markedUpMDDocumentTest(){
        String teststr = "#hi\n~~Hallo~~";
        MarkedUpDocument md = new MarkedUpDocument(teststr);
        assertEquals("[#, hi][~~, Hallo, ~~]", md.getName());
    }

    @Test
    void markedUpMDDocumentTestCombi(){
        String teststr = "#hi\n~~Hallo~~\n___Was los?___";
        MarkedUpDocument md = new MarkedUpDocument(teststr);
        assertEquals("[#, hi][~~, Hallo, ~~][_, _, _, Was los?, _, _, _]", md.getName());
    }

    @Test
    void markedUpMDDocumentTestList(){
        String teststr = "#hi\n~~Hallo~~\n* z1\n* z2";
        MarkedUpDocument md = new MarkedUpDocument(teststr);
        assertEquals("[#, hi][~~, Hallo, ~~][* , z1][* , z2]", md.getName());
    }

    /*@Test
    void markedUpMDDocumentTestListBold(){
        String teststr = "#hi\n~~Hallo~~\n* z1\n* **z2**";
        MarkedUpDocument md = new MarkedUpDocument(teststr);
        assertEquals("[#, hi][~~, Hallo, ~~][* , z1][* , **, z2, **]", md.getName());
    }*/

    @Test
    void markedUpHTMLDocumentTest(){
        String teststr = "<h1>hi</h1><a href=\"link.com\">ein link</a>";
        MarkedUpDocument md = new MarkedUpDocument(teststr);
        assertEquals("[<, h1, >, hi, <, /h1, >, <, a href=\"link.com\", >, ein link, <, /a, >]", md.getName());
    }

}
