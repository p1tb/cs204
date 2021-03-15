package restanakin.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PageController {
    private final JediOrder repository;

    public PageController(JediOrder repository) {
        this.repository = repository;
    }

    @GetMapping ("/add")
    public String addForm(Model model){
        model.addAttribute("jedi", new Jedi());
        return "add";
    }

    @PostMapping ("/add")
    public String postForm(@ModelAttribute Jedi jedi, Model model){
        model.addAttribute("jedi", jedi);
        repository.save(jedi);
        return "result";
    }
}
