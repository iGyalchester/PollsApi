package api.quickpolls.domains;

import javax.persistence.*;

@Entity
public class Vote {

    @Id
    @GeneratedValue
    @Column(name = "VOTE_ID")
    private Long voteId;

    @ManyToOne
    @JoinColumn(name = "OPTION_ID")
    private POption pOption;

    public Vote(Long voteId, POption option) {
        this.voteId = voteId;
        this.pOption = option;
    }

    public Vote() {

    }

    public Long getVoteId() {
        return voteId;
    }

    public void setVoteId(Long voteId) {
        this.voteId = voteId;
    }

    public POption getOption() {
        return pOption;
    }

    public void setOption(POption option) {
        this.pOption = option;
    }
}
