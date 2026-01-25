package Quiz.Quiz.Repository;

import Quiz.Quiz.Model.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Scorerepository extends JpaRepository<Score,Long> {
}
