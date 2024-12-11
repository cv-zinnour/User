package ca.uqtr.Account.Entity.VO;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Institution {

    @Column(name = "institution_name")
    private String institutionName;
    @Column(name = "institution_code")
    private String institutionCode;

}
