package com.ducninh.controller;

import com.ducninh.model.Province;
import com.ducninh.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProvinceController {
    @Autowired
    private ProvinceService provinceService;

    @GetMapping("/api/province")
    public ResponseEntity<List<Province>>listAllProvince(){
        List<Province>provinceList =(List<Province>) provinceService.findAll();
        if (provinceList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(provinceList, HttpStatus.OK);
    }

    @PostMapping("/api/province")
    public ResponseEntity<Province>createProvince(@RequestBody Province province){
        provinceService.save(province);
        return new ResponseEntity<>(province, HttpStatus.OK);
    }

    @PutMapping("/api/province/{id}")
    public ResponseEntity<Province>updateProvince(@PathVariable Long id, @RequestBody Province province){
        Province currentProvince = provinceService.findById(id);
        if (currentProvince==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentProvince.setNameProvince(province.getNameProvince());
        provinceService.save(currentProvince);

        return new ResponseEntity<>(currentProvince, HttpStatus.OK);
    }

    @DeleteMapping("/api/province/{id}")
    public ResponseEntity<Province>deleteProvince(@PathVariable Long id, @RequestBody Province province){
        provinceService.findById(id);
        if (province==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        provinceService.remove(id);
        return new ResponseEntity<>(province, HttpStatus.OK);


    }












}
