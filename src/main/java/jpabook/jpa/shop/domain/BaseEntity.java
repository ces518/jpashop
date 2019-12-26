package jpabook.jpa.shop.domain;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * Created by IntelliJ IDEA.
 * User: june
 * Date: 26/12/2019
 * Time: 10:04 오후
 **/
@MappedSuperclass
public class BaseEntity {
    private String createdBy;
    private String lastModifiedBy;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
}
