package com.airbnb.airbnbapp.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

//for this class new table will not creat all the fields will add in hotel only as we have embbeded field inside hotel table
// in hotel table fields will like contact_Info_address,contact_Info_phone_number,contact_Info_email,
@Getter
@Setter
@Embeddable
public class HotelContactInfo {

    private String address;
    private String phoneNumber;
    private String email;
    private String location;

}
