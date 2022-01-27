package at.fsix.mdown.controller;

import at.fsix.mdown.interfaces.IConvertFromMDService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/md")
public class ConvertFromMDController {

    private final IConvertFromMDService convertFromMDService;

    public ConvertFromMDController(IConvertFromMDService convertFromMDService) {
        this.convertFromMDService = convertFromMDService;
    }

    //TODO: verschiedene Möglichkeiten (als file/ json/ text)

    @GetMapping
    public String showOptions(){
        return "{ \"POSToptions\" : [ \"/html: convert to html\", \"/pdf: convert to pdf\"] }";
    }

    @PostMapping("/html")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String convertToHTML(@RequestBody String input){
        return convertFromMDService.convertToHTML(input);
    }

    @PostMapping("/pdf")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String convertToPDF(@RequestBody String input){
        return convertFromMDService.convertToPDF(input);
    }

    @PostMapping("/txt")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String convertToTxt(@RequestBody String input){
        return convertFromMDService.convertToPlain(input);
    }

}
