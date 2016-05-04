package es.uniovi.asw.results.controller;

import es.uniovi.asw.results.model.CurrentResults;
import es.uniovi.asw.results.service.exceptions.PartieNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;


@Controller
public class Main {

    private static final Logger LOG = LoggerFactory.getLogger(Main.class);
/*
  @Autowired
  private ResultsService resultsService;
*/

    /**
     * Displays the home page of the voting system
     * on path (/)
     *
     * @param model Spring model
     * @return The voting homepage
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String landing(Model model) {
        // no debe funcionar así, ya que un resultDTO es sólo un resultado
        model.addAttribute("results", new CurrentResults().getResults());
        return "results";
    }


    /**
     * @return a partie not found error
     */
    @ExceptionHandler(PartieNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handlePartieNotFoundException() {

        return "error/partie_not_found";
    }

}