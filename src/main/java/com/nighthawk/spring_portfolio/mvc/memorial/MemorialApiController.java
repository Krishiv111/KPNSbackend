package com.nighthawk.spring_portfolio.mvc.memorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/memorials")
public class MemorialApiController {

    @Autowired
    private MemorialJpaRepository repository; // Change this to the correct repository interface

    @GetMapping("/")
    public ResponseEntity<List<Memorial>> getMemorials() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Memorial> getMemorial(@PathVariable Long id) {
        Optional<Memorial> optional = repository.findById(id);
        return optional.map(memorial -> new ResponseEntity<>(memorial, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/byAge/{age}")
    public ResponseEntity<List<Memorial>> getMemorialsByAge(@PathVariable int age) {
        List<Memorial> memorials = repository.findByAge(age);
        if (memorials.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(memorials, HttpStatus.OK);
    }

    @GetMapping("/byCancerType/{cancerType}")
    public ResponseEntity<List<Memorial>> getMemorialsByCancerType(@PathVariable String cancerType) {
        List<Memorial> memorials = repository.findByCancerTypeIgnoreCase(cancerType);
        if (memorials.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(memorials, HttpStatus.OK);
    }

    @GetMapping("/byFavoriteMemory/{favoriteMemory}")
    public ResponseEntity<List<Memorial>> getMemorialsByFavoriteMemory(@PathVariable String favoriteMemory) {
        List<Memorial> memorials = repository.findByFavoriteMemory(favoriteMemory);
        if (memorials.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(memorials, HttpStatus.OK);
    }

    @GetMapping("/byTreatmentType/{treatmentType}")
    public ResponseEntity<List<Memorial>> getMemorialsByTreatmentType(@PathVariable String treatmentType) {
        List<Memorial> memorials = repository.findByTreatmentType(treatmentType);
        if (memorials.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(memorials, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Memorial> addMemorial(@RequestBody Memorial memorial) {
        repository.save(memorial);
        return new ResponseEntity<>(memorial, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Memorial> updateMemorial(@PathVariable Long id, @RequestBody Memorial updatedMemorial) {
        Optional<Memorial> optional = repository.findById(id);
        if (optional.isPresent()) {
            Memorial existingMemorial = optional.get();
            existingMemorial.setName(updatedMemorial.getName());
            existingMemorial.setAge(updatedMemorial.getAge());
            existingMemorial.setCancerType(updatedMemorial.getCancerType());
            existingMemorial.setFavoriteMemory(updatedMemorial.getFavoriteMemory());
            existingMemorial.setTreatmentType(updatedMemorial.getTreatmentType());

            repository.save(existingMemorial);
            return new ResponseEntity<>(existingMemorial, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMemorial(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
