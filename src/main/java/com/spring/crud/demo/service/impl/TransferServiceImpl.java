package com.spring.crud.demo.service.impl;

import com.spring.crud.demo.model.Transfer;
import com.spring.crud.demo.repository.TransferRepository;
import com.spring.crud.demo.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class TransferServiceImpl implements TransferService {

    @Autowired
    private TransferRepository repository;

    @Override
    public List<Transfer> findAll() {
        return repository.findAll();
    }

    @Override
    public Transfer findById(int id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("** Transfer not found for id :: " + id));
    }

    @Override
    public Transfer save(Transfer transfer) {
        return repository.save(transfer);
    }

    @Override
    public Transfer update(int id, Transfer transfer) {
    	repository.findById(id).orElseThrow(() -> new NotFoundException("** Transfer not found for id :: " + id));
        
    	transfer.setId(id);
    	return repository.save(transfer);
    }

    @Override
    public void delete(int id) {
        repository.findById(id).ifPresent(Transfer -> repository.delete(Transfer));
    }
}