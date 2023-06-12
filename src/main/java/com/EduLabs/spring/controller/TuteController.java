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

import com.EduLabs.spring.model.Tute;
import com.EduLabs.spring.repository.TuteRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TuteController {

	@Autowired
	TuteRepository tuteRepository;

	@GetMapping("/tutes")
	public ResponseEntity<List<Tute>> getAllTutes(@RequestParam(required = false) String title) {
		try {
			List<Tute> tutes = new ArrayList<Tute>();

			if (title == null)
				tuteRepository.findAll().forEach(tutes::add);
			else
				tuteRepository.findByTitleContaining(title).forEach(tutes::add);

			if (tutes.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(tutes, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/tutes/{id}")
	public ResponseEntity<Tute> getTuteById(@PathVariable("id") long id) {
		Optional<Tute> tuteData = tuteRepository.findById(id);

		if (tuteData.isPresent()) {
			return new ResponseEntity<>(tuteData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/tutes")
	public ResponseEntity<Tute> createTute(@RequestBody Tute tute) {
		try {

			Tute _tute = tuteRepository
					.save(new Tute(tute.getClassID(), tute.getTitle(), tute.getTotalCount(), tute.getRemainingCount()));
			return new ResponseEntity<>(_tute, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/tutes/{id}")
	public ResponseEntity<Tute> updateTute(@PathVariable("id") long id, @RequestBody Tute tute) {
		Optional<Tute> tuteData = tuteRepository.findById(id);

		if (tuteData.isPresent()) {
			Tute _tutorial = tuteData.get();

			_tutorial.setClassID(tute.getClassID());
			_tutorial.setTitle(tute.getTitle());
			_tutorial.setTotalCount(tute.getTotalCount());
			_tutorial.setRemainingCount(tute.getRemainingCount());
			return new ResponseEntity<>(tuteRepository.save(_tutorial), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/tutes/{id}")
	public ResponseEntity<HttpStatus> deleteTute(@PathVariable("id") long id) {
		try {
			tuteRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/tutes")
	public ResponseEntity<HttpStatus> deleteAllTutes() {
		try {
			tuteRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
