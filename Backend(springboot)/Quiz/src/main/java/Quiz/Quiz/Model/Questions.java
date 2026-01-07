package Quiz.Quiz.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "questions")
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String questions;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String correctoption;
    public  Questions()
    {

    }

    public Questions(String questions, String optionA, String optionB, String optionC, String optionD, String correctoption) {
        this.questions = questions;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctoption = correctoption;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public String getCorrectoption() {
        return correctoption;
    }

    public void setCorrectoption(String correctoption) {
        this.correctoption = correctoption;
    }
}
