package Quiz.Quiz.Controller;



import Quiz.Quiz.Service.Correctanswercheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class Correctanswerchekcontroller {

    @Autowired
    private Correctanswercheck correctanswercheck;
    //answer submit
    @PostMapping("/submit")
    public boolean submitAnswer(
            @RequestParam Long questionId,
            @RequestParam String selectedOption
    ) {
        return correctanswercheck.submitanswer(questionId, selectedOption);
    }
}

