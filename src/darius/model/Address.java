package darius.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Address implements Serializable {
    @Column(name = "house_number")
    private String houseNumber;
    private String city;
    private String country;

    public Address() {
    }

    public Address(String houseNumber, String city, String country) {
        this.houseNumber = houseNumber;
        this.city = city;
        this.country = country;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(houseNumber, address.houseNumber) && Objects.equals(city, address.city) && Objects.equals(country, address.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(houseNumber, city, country);
    }

    @Override
    public String toString() {
        return "Address{" +
                "houseNumber='" + houseNumber + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
