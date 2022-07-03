package com.spring.crud.demo.service;

import com.spring.crud.demo.model.Transfer;

import java.util.List;

public interface TransferService {

    List<?> findAll();

    Transfer findById(int id);

    Transfer save(Transfer transfer);

    Transfer update(int id, Transfer transfer);

    void delete(int id);
}