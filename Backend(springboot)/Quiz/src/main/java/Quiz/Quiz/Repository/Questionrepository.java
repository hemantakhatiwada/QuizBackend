package Quiz.Quiz.Repository;


import Quiz.Quiz.Model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Questionrepository extends JpaRepository<Questions,Long> {

}
