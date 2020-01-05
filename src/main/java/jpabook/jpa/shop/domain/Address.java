package jpabook.jpa.shop.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

/**
 * Created by IntelliJ IDEA.
 * User: june
 * Date: 05/01/2020
 * Time: 9:15 오후
 **/
@Embeddable
public class Address {

    @Column(length = 10)
    private String city;

    @Column(length = 20)
    private String street;

    @Column(length = 5)
    private String zipcode;

    // 의미있는 비즈니스 메서드를 만들수 있다.
    public String fullAddress () {
        return getCity() + getCity() + " " + getZipcode();
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getZipcode() {
        return zipcode;
    }

    // getter로 호출해야 프록시객체일때 문제가 발생하지 않는다.
    // 대부분의 코드를 메소드를 호출하는 방식으로 짜는것이 안전하다.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(getCity(), address.getCity()) &&
                Objects.equals(getStreet(), address.getStreet()) &&
                Objects.equals(getZipcode(), address.getZipcode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity(), getStreet(), getZipcode());
    }
}
