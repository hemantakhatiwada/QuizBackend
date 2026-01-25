package Quiz.Quiz.Service;

import Quiz.Quiz.Model.Questions;
import Quiz.Quiz.Repository.Questionrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class Questionservice {
    @Autowired
    private Questionrepository questionrepository;

    private List<Questions> currentquizquestions=new ArrayList<>();
    private int currentindex=0;

    public List<Questions> getrandom5question(){
        List<Questions>allquestions=questionrepository.findAll();

        Collections.shuffle(allquestions);

        currentquizquestions=allquestions.
                             stream().
                             limit(5).
                             collect(Collectors.toList());
        currentindex=0;
        return currentquizquestions;
    }

    public Questions getnextquestion()
    {
        if (currentindex<currentquizquestions.size())
        {
            return currentquizquestions.get(currentindex++);
        }
        return null;
    }



}
