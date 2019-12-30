package jpabook.jpa.shop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: june
 * Date: 24/12/2019
 * Time: 11:28 오후
 **/
@Entity
public class Category extends BaseEntity {

    @Id @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "CATEGORY_ITEM",
        joinColumns = @JoinColumn(name = "CATEGORY_ID"), // 내가 조인할 컬럼
        inverseJoinColumns = @JoinColumn(name = "ITEM_ID") // 반대편이 조인할 컬럼
    )
    private List<Item> items = new ArrayList<>();
}
