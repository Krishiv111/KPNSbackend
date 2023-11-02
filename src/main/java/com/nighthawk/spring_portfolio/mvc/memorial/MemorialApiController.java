package com.nighthawk.spring_portfolio.mvc.memorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST})
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

    @PostMapping("/post")
    public ResponseEntity<Object> postMemorial(
            @RequestParam("name") String name,
            @RequestParam("age") int age,
            @RequestParam("cancerType") String cancerType,
            @RequestParam("favoriteMemory") String favoriteMemory,
            @RequestParam("treatmentType") String treatmentType) {
        
    // Create a new Memorial object with the provided parameters
    Memorial memorial = new Memorial();
    memorial.setName(name);
    memorial.setAge(age);
    memorial.setCancerType(cancerType);
    memorial.setFavoriteMemory(favoriteMemory);
    memorial.setTreatmentType(treatmentType);
    
    // Save the Memorial to the repository
    repository.save(memorial);

    return new ResponseEntity<>(memorial, HttpStatus.CREATED);
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
