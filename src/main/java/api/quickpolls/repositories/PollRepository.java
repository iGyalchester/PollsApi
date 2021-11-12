package api.quickpolls.repositories;


import api.quickpolls.domains.Poll;
import org.springframework.data.repository.CrudRepository;

public interface PollRepository extends CrudRepository<Poll, Long> {

}
