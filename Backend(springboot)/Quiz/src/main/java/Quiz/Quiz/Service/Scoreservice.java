package Quiz.Quiz.Service;

import Quiz.Quiz.Model.Score;
import Quiz.Quiz.Repository.Scorerepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Scoreservice {

    @Autowired
    private Scorerepository scorerepository;

    public Score score()
    {

    }


}
