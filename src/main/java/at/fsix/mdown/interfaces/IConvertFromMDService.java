package at.fsix.mdown.interfaces;

import javax.swing.text.html.HTMLDocument;

public interface IConvertFromMDService {
    String convertToHTML(String input);
    String convertToPDF(String input);
    String convertToPlain(String input);
}
