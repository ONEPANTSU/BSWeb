package BSWeb.repo;

import BSWeb.models.Achievments;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SECAchievmentsRepository extends CrudRepository<Achievments, Long> {
    
}
