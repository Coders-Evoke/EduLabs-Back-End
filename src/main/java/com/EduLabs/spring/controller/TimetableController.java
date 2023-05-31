package com.EduLabs.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.EduLabs.spring.model.Timetable;
import com.EduLabs.spring.repository.TimetableRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class TimetableController {

    @Autowired
    TimetableRepository timeTableRepository;

    @GetMapping("/timetables")
    public ResponseEntity<List<Timetable>> getAllTimetables(@RequestParam(required = false) String date) {
        try {
            List<Timetable> timetables = new ArrayList<Timetable>();

            if (date == null)
                timeTableRepository.findAll().forEach(timetables::add);
            else
                timeTableRepository.findByDateContaining(date).forEach(timetables::add);

            if (timetables.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(timetables, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/timetables/{id}")
    public ResponseEntity<Timetable> getTimetableById(@PathVariable("id") long id) {
        Optional<Timetable> timetableData = timeTableRepository.findById(id);

        if (timetableData.isPresent()) {
            return new ResponseEntity<>(timetableData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/timetables")
    public ResponseEntity<Timetable> createTimetable(@RequestBody Timetable timetable) {
        try {

            Timetable _timetable = timeTableRepository
                    .save(new Timetable(timetable.getDate(), timetable.getTime(), timetable.getSubjectID(),
                            timetable.getSubjectName()));
            return new ResponseEntity<>(_timetable, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/timetables/{id}")
    public ResponseEntity<Timetable> updateTimetable(@PathVariable("id") long id, @RequestBody Timetable timetable) {
        Optional<Timetable> timatableData = timeTableRepository.findById(id);

        if (timatableData.isPresent()) {
            Timetable _timetable = timatableData.get();

            _timetable.setDate(timetable.getDate());
            _timetable.setTime(timetable.getTime());
            _timetable.setSubjectID(timetable.getSubjectID());
            _timetable.setSubjectName(timetable.getSubjectName());
            return new ResponseEntity<>(timeTableRepository.save(_timetable), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/timetables/{id}")
    public ResponseEntity<HttpStatus> deleteTimetable(@PathVariable("id") long id) {
        try {
            timeTableRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/timetables")
    public ResponseEntity<HttpStatus> deleteAllTimetables() {
        try {
            timeTableRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
