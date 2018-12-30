
package sec.project.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sec.project.domain.Signup;
import sec.project.repository.SignupRepository;

@Controller
public class EventController {

    @Autowired
    private HttpSession session;

    @Autowired
    private SignupRepository signupRepository;
    
    @RequestMapping(value = "/event", method = RequestMethod.GET)
        public String ParticipantList(Model model) {
        List<Signup> participants = signupRepository.findAll();
        model.addAttribute("participants", participants);
        model.addAttribute("name", session.getAttribute("name"));
        model.addAttribute("address", session.getAttribute("address"));
        return "event";
    }
        
  //  @RequestMapping(value = "/event", method = RequestMethod.POST)
 //   public String list(Model model, Principal principal, @RequestParam(required = false) String search) {
 //       List<Signup> participants;       
 //       if(search!= null) {
 //           participants = signupRepository.customFind(principal.getName(), search);
 //       }
 //       model.addAttribute("participants", participants);
 //       model.addAttribute("search", search);
 //       return "event";
 //   }
        
}
