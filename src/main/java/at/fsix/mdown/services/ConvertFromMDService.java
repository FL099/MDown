package at.fsix.mdown.services;

import at.fsix.mdown.interfaces.IConvertFromMDService;
import at.fsix.mdown.model.MarkedUpDocument;
import org.springframework.stereotype.Service;

@Service
public class ConvertFromMDService implements IConvertFromMDService {
    @Override
    public String convertToHTML(String input) {
        return new MarkedUpDocument(input).toString();
    }

    @Override
    public String convertToPDF(String input) {
        return new MarkedUpDocument(input).toString();
    }

    @Override
    public String convertToPlain(String input) {
        return new MarkedUpDocument(input).toString();
    }
}
