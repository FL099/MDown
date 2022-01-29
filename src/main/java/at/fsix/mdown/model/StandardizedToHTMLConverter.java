package at.fsix.mdown.model;

public class StandardizedToHTMLConverter {

    private static final String template = "<!doctype html>\n" +
            "<html lang=\"en\">\n" +
            "  <head>\n" +
            "    <!-- Required meta tags -->\n" +
            "    <meta charset=\"utf-8\">\n" +
            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
            "\n" +
            "    <!-- Bootstrap CSS -->\n" +
            "" +
            "\n" +
            "    <title>Hello, world!</title>\n" +
            "  </head>\n" +
            "  <body>";


    public static String convertToHTML(MarkedUpDocument doc){
        StringBuilder result = new StringBuilder("<!doctype html>\n" + "<html lang=\"en\">\n" + "  <head>\n");
        result.append("    <meta charset=\"" + doc.getEncoding() + "\">\n");
        result.append("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" \n");
        result.append("<title>" + doc.getName() + "</title>");
        result.append("  </head>\n  <body>\n");

        for (DocumentElement element : doc.getContentElements() ) {
            result.append(makeHtml(element));
        }


        result.append("</body>\n" + "</html>");
        return result.toString();
    }

    private static String makeHtml(DocumentElement element){
        if (element.getContentElements().size() <= 1){

        }
        return "";
    }
}
