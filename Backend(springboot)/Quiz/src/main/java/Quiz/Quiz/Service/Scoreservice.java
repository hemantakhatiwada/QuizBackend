package Quiz.Quiz.Service;

import Quiz.Quiz.Model.Score;
import Quiz.Quiz.Repository.Scorerepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Scoreservice {

//    @Autowired
//    private Scorerepository scorerepository;
    //Hamile DB maa save nagarneh bhaera scorerepository use nagareko.Yedi user thyo bhane scorerepository use garnu parthyo.

private int score=0;

public void resetscore()
{
    score=0;
}
public void increasescore()
{
    score++;
}
public int getscore()
{
    return score;

}


}
