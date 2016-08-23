package com.eun;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Form {
    @Size(min=1)
    private String address;

    private String apt;

    @Size(min=1, max=20)
    private String city;

    @NotNull
    private StateEnum state;

    @NotNull
    private Integer zip;

    public enum StateEnum {
        AL("Alabama"), AK("Alaska"), AZ("Arizona"), AR("Arkansas"), CA("California"), CO("Colorado"),
        CT("Connecticut"), DE("Delaware"), FL("Florida"), GA("Georgia"), HI("Hawaii"), ID("Idaho"),
        IL("Illinois"), IN("Indiana"), IA("Iowa"), KS("Kansas"), KY("Kentucky"), LA("Louisiana"),
        ME("Maine"), MD("Maryland"), MA("Massachusetts"), MI("Michigan"), MN("Minnesota"),
        MS("Mississippi"), MO("Missouri"), MT("Montana"), NE("Nebraska"), NV("Nevada"), NH("New Hampshire"),
        NJ("New Jersey"), NM("New Mexico"), NY("New York"), NC("North Carolina"), ND("North Dakota"),
        OH("Ohio"), OK("Oklahoma"), OR("Oregon"), PA("Pennsylvania"), RI("Rhode Island"), SC("South Carolina"),
        SD("South Dakota"), TN("Tennessee"), TX("Texas"), UT("Utah"), VT("Vermont"), VA("Virginia"),
        WA("Washington"), WV("West Virginia"), WI("Wisconsin"), WY("Wyoming");

        private String name;

        private StateEnum (String value) {
            this.name = value;
        }

        public String getName () {
            return this.name;
        }
    }

    public void setAddress (String adr) {
        this.address = adr;
    }

    public String getAddress () {
        return this.address;
    }

    public void setApt (String apt) {
        this.apt = apt;
    }

    public String getApt () {
        return this.apt;
    }

    public void setCity (String city) {
        this.city = city;
    }

    public String getCity () {
        return this.city;
    }

    public void setState (StateEnum state) {
        this.state = state;
    }

    public StateEnum getState () {
        return this.state;
    }

    public void setZip (Integer zip) {
        this.zip = zip;
    }

    public Integer getZip () {
        return this.zip;
    }

    public String toString () {
        return this.address + " " + this.apt + "\n" + this.city + ", " + this.state.getName() + " " + this.zip;
    }
}
