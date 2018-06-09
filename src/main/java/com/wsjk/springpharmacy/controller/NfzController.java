package com.wsjk.springpharmacy.controller;

import com.wsjk.springpharmacy.DAO.NfzDAO;
import com.wsjk.springpharmacy.Services.NfzService;
import com.wsjk.springpharmacy.model.NfzEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/nfz")
public class NfzController {

    @Autowired
    NfzService nfzService;

    @GetMapping(produces = {"application/json"})
    public List<NfzEntity> returnAllNfz() {
        return nfzService.findAll();
    }

    @GetMapping(value = "/{id}", produces = {"application/json"})
    public NfzEntity returnNfzById (@PathVariable("id") @Valid int id) {
        return nfzService.findOne(id);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<NfzEntity> addNfz(@RequestBody @Valid NfzEntity nfzEntity) {
        nfzService.create(nfzEntity);
        return new ResponseEntity<>(nfzEntity, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{id}", produces = {"application/json"})
    public String deleteNfz(@PathVariable("id") int id){
        nfzService.deleteById(id);
        return "Deleted item with id: "+id;
    }

    @PutMapping(value = "/update", produces = {"application/json"})
    public ResponseEntity<NfzEntity> updateNfz(@RequestBody NfzEntity nfzEntity){
        nfzService.saveOrUpdate(nfzEntity);
        return new ResponseEntity<>(nfzEntity, HttpStatus.OK);
    }

}
