package Quiz.Quiz.Controller;

import Quiz.Quiz.Model.Questions;
import Quiz.Quiz.Service.Questionservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class Questioncontroller {
    @Autowired
    private Questionservice questionservice;

    @GetMapping("/get5question")
    public List<Questions> get5questions()
    {
       return  questionservice.getrandom5question();

    }

    @GetMapping("/getnextquestion")
    public Questions getnextquestion()
    {
        return questionservice.getnextquestion();
    }



}
