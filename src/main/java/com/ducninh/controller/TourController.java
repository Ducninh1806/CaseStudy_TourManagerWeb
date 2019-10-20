package com.ducninh.controller;

import com.ducninh.model.Tour;
import com.ducninh.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TourController {

    @Autowired
    public TourService tourService;

    @GetMapping("/api/tour")
    public ResponseEntity <List<Tour>> listAllTour(){
        List<Tour> tours = (List<Tour>) tourService.findAll();
        if (tours.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tours, HttpStatus.OK);
    }


    @PostMapping("/api/tour")
    public ResponseEntity<Tour> createTour(@RequestBody Tour tour){
        tourService.save(tour);
        return new ResponseEntity<>(tour, HttpStatus.OK);

    }

    @PutMapping("/api/tour/{id}")
    public ResponseEntity<Tour>updateTour(@PathVariable("id") Long id , @RequestBody Tour tour){
        Tour currentTour = tourService.findById(id);
        if (currentTour==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentTour.setNameTour(tour.getNameTour());
        currentTour.setIsDate(tour.getIsDate());
        currentTour.setPrice(tour.getPrice());
        currentTour.setRoute(tour.getRoute());
        currentTour.setTourPriceIncluded(tour.getTourPriceIncluded());
        currentTour.setTourPriceIsNotIncluded(tour.getTourPriceIsNotIncluded());
        currentTour.setChildren(tour.getChildren());

        tourService.save(currentTour);
        return new ResponseEntity<>(currentTour, HttpStatus.OK);

    }

    @DeleteMapping("/api/tour/{id}")
    public ResponseEntity<Tour>deleteTour(@PathVariable Long id, @RequestBody Tour tour){
        Tour tour1 = tourService.findById(id);

        if (tour1 == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        tourService.remove(id);
        return new ResponseEntity<>(tour1, HttpStatus.OK);
    }



}
