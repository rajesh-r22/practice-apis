package com.example.practice_api.service;

import com.example.practice_api.entity.Workers;
import com.example.practice_api.repository.WorkersRepository;

import java.util.List;

public class WorkersService {

    private final WorkersRepository workersRepository;
    WorkersService(WorkersRepository workersRepository){
        this.workersRepository = workersRepository;
    }

    public List<Workers> getAll(){
        return workersRepository.findAll();
    }

    public Workers addWorker(Workers worker){
        if(worker.getName().equals("")){
            throw new IllegalArgumentException("Worker name cannot be empty");
        }
        return workersRepository.save(worker);
    }
    public Workers updateWorker(Workers worker){
        Workers  w=new Workers();
        w.setName(worker.getName());
        w.setEmail(worker.getEmail());
        w.setDepartment(worker.getDepartment());
        return workersRepository.save(w);
    }
    public void deleteWorker(Long id){
        Workers worker=workersRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Worker not found"));
        workersRepository.delete(worker);
    }
}
