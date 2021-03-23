package com.motorsSmart.domain.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "products")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String productName;

    private Integer quantity;

    private Timestamp dateAdmission;

    @OneToOne
    @JoinColumn(name = "id_user_register", referencedColumnName = "id")
    private User userRegister;

    @OneToOne
    @JoinColumn(name = "id_user_update", referencedColumnName = "id")
    private User userUpdate;

}
