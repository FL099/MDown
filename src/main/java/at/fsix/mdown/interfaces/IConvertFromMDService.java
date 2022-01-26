package at.fsix.mdown.interfaces;

import javax.swing.text.html.HTMLDocument;

public interface IConvertFromMDService {
    StringBuilder convertToHTML();
    StringBuilder convertToPDF();
}
