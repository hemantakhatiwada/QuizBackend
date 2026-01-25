package Quiz.Quiz.Controller;

import Quiz.Quiz.Model.Score;
import Quiz.Quiz.Service.Scoreservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Scorecontroller {
    @Autowired
    private Scoreservice scoreservice;

    @PostMapping("/reset")
    public void resetscore()
    {
      scoreservice.resetscore();
    }

    @PostMapping("/increasescore")
    public void increasescore()
    {
        scoreservice.increasescore();
    }
    @GetMapping("/getscore")
    public int getscore()
    {
      return  scoreservice.getscore();

    }


}
