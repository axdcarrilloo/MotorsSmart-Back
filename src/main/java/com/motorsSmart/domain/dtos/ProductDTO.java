package com.motorsSmart.domain.dtos;

import lombok.*;

import java.sql.Timestamp;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProductDTO {

    private String productName;

    private Integer quantity;

    private Timestamp dateAdmission;

    private Long idUser;

}
