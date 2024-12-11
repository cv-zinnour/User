package ca.uqtr.Account.Entity.VO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Email {

    @Column(name = "email")
    private String value;

    public Email() {
    }

    public Email(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
