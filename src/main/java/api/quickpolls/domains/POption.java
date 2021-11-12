package api.quickpolls.domains;

import javax.persistence.*;

@Entity
public class POption {

    @Id
    @GeneratedValue
    @Column(name="OPTION_ID")
    private Long optionId;

    @Column(name="OPTION_VALUE")
    private String optionValue;

    public Long getOptionId() {
        return optionId;
    }

    public void setOptionId(Long optionId) {
        this.optionId = optionId;
    }

    public String getOptionValue() {
        return optionValue;
    }

    public void setOptionValue(String optionValue) {
        this.optionValue = optionValue;
    }
}
