package com.motorsSmart.domain.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "users")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer age;

    @OneToOne
    @JoinColumn(name = "id_charge", referencedColumnName = "id")
    private Charge charge;

    @Column(name = "date_admission")
    private Timestamp dateAdmission;

}
