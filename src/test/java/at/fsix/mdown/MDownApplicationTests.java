package at.fsix.mdown;

import at.fsix.mdown.model.DocumentElement;
import at.fsix.mdown.model.ElementTag;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MDownApplicationTests {

    @Test
    void htmlThingsWork() {
        DocumentElement docEL = new DocumentElement("ue1","Ueberschrift 1", ElementTag.h1);
        assertEquals(docEL.toHTMLString(), "<h1 id=\"ue1\">Ueberschrift 1</h1>");
    }


}
