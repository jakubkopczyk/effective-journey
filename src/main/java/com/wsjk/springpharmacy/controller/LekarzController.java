package com.wsjk.springpharmacy.controller;

import com.wsjk.springpharmacy.Services.LekarzService;
import com.wsjk.springpharmacy.model.LekarzEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/lekarz")
public class LekarzController {
    @Autowired
    LekarzService lekarzService;

    @GetMapping(produces = {"application/json"})
    public List<LekarzEntity> returnAllLekarz() {
        return lekarzService.findAll();
    }

    @GetMapping(value = "/{id}", produces = {"application/json"})
    public LekarzEntity returnNfzById (@PathVariable("id") @Valid int id) {
        return lekarzService.findOne(id);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<LekarzEntity> addLekarz(@RequestBody @Valid LekarzEntity lekarzEntity) {
        lekarzService.create(lekarzEntity);
        return new ResponseEntity<>(lekarzEntity, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{id}", produces = {"application/json"})
    public String deleteLekarz(@PathVariable("id") int id){
        lekarzService.deleteById(id);
        return "Deleted item with id: "+id;
    }

    @PutMapping(value = "/update", produces = {"application/json"})
    public ResponseEntity<LekarzEntity> updateLekarz(@RequestBody LekarzEntity lekarzEntity){
        lekarzService.saveOrUpdate(lekarzEntity);
        return new ResponseEntity<>(lekarzEntity, HttpStatus.OK);
    }
}
