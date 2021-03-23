package com.motorsSmart.assemblers;

import com.motorsSmart.domain.dtos.ChargeDTO;
import com.motorsSmart.domain.entities.Charge;

public class ChargeAssembler {

    public static Charge convertToDTOToDomain(ChargeDTO chargeDTO){
        return new Charge().builder().name(chargeDTO.getName()).build();
    }

}
