package at.fsix.mdown.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/md")
public class ConvertFromMDController {

    //TODO: verschiedene Möglichkeiten (als file/ json/ text)

    @GetMapping
    public String showOptions(){
        return "{ \"POSToptions\" : [ \"/html: convert to html\", \"/pdf: convert to pdf\"] }";
    }

    @PostMapping("/html")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String convertToHTML(){
        return "<html><h1>Hi!</h1></html>";
    }

    @PostMapping("/pdf")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String convertToPDF(){
        return "<html></html>";
    }

}
