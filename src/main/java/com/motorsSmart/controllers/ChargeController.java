package com.motorsSmart.controllers;

import com.motorsSmart.domain.dtos.ChargeDTO;
import com.motorsSmart.services.ChargeService;
import com.motorsSmart.utils.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = Route.BASE + Route.CHARGES, produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "${environmen.url.origins}", methods = {RequestMethod.GET, RequestMethod.POST})
public class ChargeController {

    @Autowired
    private ChargeService chargeService;

    @PostMapping(Route.REGISTER)
    public ResponseEntity<Long> registerCharge(@RequestBody ChargeDTO chargeDTO){
        return new ResponseEntity<Long>(chargeService.saveCharge(chargeDTO), HttpStatus.OK);
    }

}
