package Quiz.Quiz.Service;

import Quiz.Quiz.Model.Questions;
import Quiz.Quiz.Repository.Questionrepository;
import Quiz.Quiz.Repository.Scorerepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Service
public class Correctanswercheck {
    @Autowired
    private Questionrepository questionrepository;
    @Autowired
    private Scoreservice scoreservice;

    public boolean submitanswer(Long questionid,String selectedoption)
    {
       Optional<Questions> questionn =questionrepository.findById(questionid);
       //This is to find which question to check
        Questions question = questionn.get();
        if (question.getCorrectoption().equalsIgnoreCase(selectedoption))
        {
            scoreservice.increasescore();
return true;
        }
        else
        {
            return false;
        }
    }


}
