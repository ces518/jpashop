package jpabook.jpa.shop.domain;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: june
 * Date: 24/12/2019
 * Time: 11:27 오후
 **/
@Entity
public class Delivery extends BaseEntity{

    @Id @GeneratedValue
    private Long id;

    private String city;

    private String street;

    private String zipcode;

    private DeliveryStatus status;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;
}
