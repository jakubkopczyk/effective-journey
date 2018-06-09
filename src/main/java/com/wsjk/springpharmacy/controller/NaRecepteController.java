package com.wsjk.springpharmacy.controller;

import com.wsjk.springpharmacy.Services.BezReceptyService;
import com.wsjk.springpharmacy.Services.NaRecepteService;
import com.wsjk.springpharmacy.model.BezReceptyEntity;
import com.wsjk.springpharmacy.model.NaRecepteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/narecepte")
public class NaRecepteController {

    @Autowired
    NaRecepteService naRecepteService;

    @GetMapping(produces = {"application/json"})
    public List<NaRecepteEntity> returnAllNaRecepte() {
        return naRecepteService.findAll();
    }

    @GetMapping(value = "/{id}", produces = {"application/json"})
    public NaRecepteEntity returnNaRecepteById (@PathVariable("id") @Valid int id) {
        return naRecepteService.findOne(id);
    }

    @GetMapping(value = "/nazwa/{name}", produces = {"application/json"})
    public NaRecepteEntity returnNaRecepteById (@PathVariable("name") @Valid String name) {
        return naRecepteService.findByName(name);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<NaRecepteEntity> addNaRecepte(@RequestBody @Valid NaRecepteEntity naRecepteEntity) {
        naRecepteService.create(naRecepteEntity);
        return new ResponseEntity<>(naRecepteEntity, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{id}", produces = {"application/json"})
    public String deleteNaRecepte(@PathVariable("id") int id){
        naRecepteService.deleteById(id);
        return "Deleted item with id: "+id;
    }

    @PutMapping(value = "/update", produces = {"application/json"})
    public ResponseEntity<NaRecepteEntity> updateNaRecepte(@RequestBody NaRecepteEntity naRecepteEntity){
        naRecepteService.saveOrUpdate(naRecepteEntity);
        return new ResponseEntity<>(naRecepteEntity, HttpStatus.OK);
    }
}
