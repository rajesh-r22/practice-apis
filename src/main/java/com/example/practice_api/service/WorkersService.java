package com.example.practice_api.service;

import com.example.practice_api.entity.Workers;
import com.example.practice_api.repository.WorkersRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WorkersService {

    private final WorkersRepository workersRepository;
    WorkersService(WorkersRepository workersRepository){
        this.workersRepository = workersRepository;
    }

    public List<Workers> getAll(){
        return workersRepository.findAll();
    }
    public Workers  getById(Long id){
        Workers worker=workersRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Worker with id: "+id+" not found"));
        return worker;
    }

    public Workers addWorker(Workers worker){
        if(worker.getName().equals("")){
            throw new IllegalArgumentException("Worker name cannot be empty");
        }
        return workersRepository.save(worker);
    }
    public Workers updateWorker(Long id, Workers workerDetails) {
        Workers worker = workersRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Worker not found"));
        worker.setName(workerDetails.getName());
        worker.setEmail(workerDetails.getEmail());
        worker.setDepartment(workerDetails.getDepartment());

        return workersRepository.save(worker);

    }
    public  Workers deleteWorker(Long id){
        Workers worker=workersRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Worker not found"));
        return deleteWorker(id);
    }
}
