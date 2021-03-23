package com.motorsSmart.services;

import com.motorsSmart.assemblers.ChargeAssembler;
import com.motorsSmart.domain.dtos.ChargeDTO;
import com.motorsSmart.domain.entities.Charge;
import com.motorsSmart.repositories.ChargeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ChargeService {

    @Autowired
    private ChargeRepository chargeRepository;

    public Long saveCharge(ChargeDTO chargeDto){
        Long result = 0l;
        if(Objects.isNull(getChargeByName(chargeDto.getName()))){
            result = chargeRepository.save(ChargeAssembler.convertToDTOToDomain(chargeDto)).getId();
        }
        return result;
    }

    public Charge getChargeByName(String name){
        return chargeRepository.findByName(name);
    }

}
