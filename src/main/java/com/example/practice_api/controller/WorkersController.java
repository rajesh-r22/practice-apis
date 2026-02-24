package com.example.practice_api.controller;

import com.example.practice_api.entity.Workers;
import com.example.practice_api.service.WorkersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workers")
public class WorkersController {

    private WorkersService workersService;
    WorkersController(WorkersService workersService) {
        this.workersService = workersService;
    }
    @GetMapping
    public List<Workers> findAll() {
        return workersService.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Workers> findById(@PathVariable Long id){
        Workers worker=workersService.getById(id);
        return ResponseEntity.ok().body(worker);
    }

    @PostMapping("/worker")
    public ResponseEntity<Workers> addWorker(@RequestBody Workers workers) {
        Workers w= workersService.addWorker(workers);
        return  ResponseEntity.status(HttpStatus.CREATED).body(w);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Workers> updateWorker(@PathVariable Long id, @RequestBody Workers workers) {
        Workers w= workersService.updateWorker(id, workers);
        return  ResponseEntity.ok(w);
    }

    @DeleteMapping("{id}")
    public  ResponseEntity<String>  deleteWorker(@PathVariable Long id) {
         workersService.deleteWorker(id);
         return ResponseEntity.ok("Worker deleted successfully");
    }


}
