package ca.uqtr.Account.Entity.VO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address {

    @Column(name = "street")
    private String street;
    @Column(name = "street_number")
    private Integer streetNumber;
    @Column(name = "city")
    private String city;
    @Column(name = "postal_code")
    private String postalCode;
    @Column(name = "province")
    private String province;

}
