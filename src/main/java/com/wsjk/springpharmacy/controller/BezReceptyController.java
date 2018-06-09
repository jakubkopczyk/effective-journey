package com.wsjk.springpharmacy.controller;


import com.wsjk.springpharmacy.Services.BezReceptyService;
import com.wsjk.springpharmacy.Services.LekarzService;
import com.wsjk.springpharmacy.model.BezReceptyEntity;
import com.wsjk.springpharmacy.model.LekarzEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/bezrecepty")
public class BezReceptyController {
    @Autowired
    BezReceptyService bezReceptyService;

    @GetMapping(produces = {"application/json"})
    public List<BezReceptyEntity> returnAllBezRecepty() {
        return bezReceptyService.findAll();
    }

    @GetMapping(value = "/{id}", produces = {"application/json"})
    public BezReceptyEntity returnBezReceptyById (@PathVariable("id") @Valid int id) {
        return bezReceptyService.findOne(id);
    }

    @GetMapping(value = "/nazwa/{name}", produces = {"application/json"})
    public BezReceptyEntity returnNaRecepteById (@PathVariable("name") @Valid String name) {
        return bezReceptyService.findByName(name);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<BezReceptyEntity> addBezRecepty(@RequestBody @Valid BezReceptyEntity bezReceptyEntity) {
        bezReceptyService.create(bezReceptyEntity);
        return new ResponseEntity<>(bezReceptyEntity, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{id}", produces = {"application/json"})
    public String deleteBezRecepty(@PathVariable("id") int id){
        bezReceptyService.deleteById(id);
        return "Deleted item with id: "+id;
    }

    @PutMapping(value = "/update", produces = {"application/json"})
    public ResponseEntity<BezReceptyEntity> updateBezRecepty(@RequestBody BezReceptyEntity bezReceptyEntity){
        bezReceptyService.saveOrUpdate(bezReceptyEntity);
        return new ResponseEntity<>(bezReceptyEntity, HttpStatus.OK);
    }
}
