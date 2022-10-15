package com.electro.entity.address;

import com.electro.entity.BaseEntity;
import com.electro.entity.authentication.User;
import com.electro.entity.employee.Office;
import com.electro.entity.inventory.Destination;
import com.electro.entity.inventory.Warehouse;
import com.electro.entity.product.Supplier;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "address")
public class Address extends BaseEntity {
    @Column(name = "line")
    private String line;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "province_id")
    @JsonBackReference
    private Province province;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "district_id")
    @JsonBackReference
    private District district;

    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
    private User user;

    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
    private Office office;

    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
    private Supplier supplier;

    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
    private Warehouse warehouse;

    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
    private Destination destination;

//    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
//    private Shipper shipper;
}
