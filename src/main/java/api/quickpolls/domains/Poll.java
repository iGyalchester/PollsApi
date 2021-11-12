package api.quickpolls.domains;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Poll {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "POLL_ID")
    private Long pollId;

    @Column(name = "QUESTION")
    @NotEmpty(message = "Question cannot be empty")
    private String question;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "POLL_ID")
    @OrderBy
    @Size(min=2, max = 6)
    private Set<POption> options;

    public Long getPollId() {
        return pollId;
    }

    public void setPollId(Long pollId) {
        this.pollId = pollId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Set<POption> getOptions() {
        return options;
    }

    public void setOptions(Set<POption> options) {
        this.options = options;
    }
}
