package com.motorsSmart.domain.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cherges")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Charge implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

}
