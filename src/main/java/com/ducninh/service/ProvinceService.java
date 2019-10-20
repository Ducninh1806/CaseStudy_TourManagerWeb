package com.ducninh.service;

import com.ducninh.model.Province;
import javafx.print.PageOrientation;

public interface ProvinceService {

    Iterable<Province> findAll();

    Province findById(Long id);

    void save (Province province);

    void remove(Long id);











}
