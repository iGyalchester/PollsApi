package api.quickpolls.repositories;

import api.quickpolls.domains.POption;
import org.springframework.data.repository.CrudRepository;

public interface OptionRepository extends CrudRepository<POption, Long> {

}
