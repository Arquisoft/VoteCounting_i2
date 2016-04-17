package es.uniovi.asw.results.controller;

import es.uniovi.asw.results.model.ResultsDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class Main {

  private static final Logger LOG = LoggerFactory.getLogger(Main.class);

  /*@Autowired
  private VoterService voterService; */

  /**
   * Displays the home page of the voting system
   * on path (/)
   *
   * @param model Spring model
   * @return The voting homepage
   */
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String landing(Model model) {
    model.addAttribute("results", new ResultsDTO());
    return "results";
  }
  
}