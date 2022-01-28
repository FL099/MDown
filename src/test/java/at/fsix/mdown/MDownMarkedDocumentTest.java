package at.fsix.mdown;

import at.fsix.mdown.model.MarkedUpDocument;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MDownMarkedDocumentTest {
    @Test
    void newMDTest(){
        String teststr = "#hi\n* Howdy";
        MarkedUpDocument md = new MarkedUpDocument(teststr);
        assertEquals("id: , content: hi, tag: h1, parent: document, contentElements: {},\nid: , content: Howdy, tag: li, parent: document, contentElements: {},\n", md.getContentElements(true));
    }

    @Test
    void hopefullyWorkingTest(){
        String teststr = "#hi\n";
        MarkedUpDocument md = new MarkedUpDocument(teststr);
        assertEquals("id: , content: hi, tag: h1, parent: document, contentElements: {},\nid: , content: , tag: p, parent: document, contentElements: {},\n", md.getContentElements(true));
    }

    @Test
    void hopefullyWorkingTest2(){
        String teststr = "#hi\n$$\n* Howdy\n";
        MarkedUpDocument md = new MarkedUpDocument(teststr);
        assertEquals("id: , content: hi, tag: h1, parent: document, contentElements: {},\nid: , content: , tag: br, parent: document, contentElements: {},\nid: , content: Howdy, tag: li, parent: document, contentElements: {},\n", md.getContentElements(true));
    }
}
