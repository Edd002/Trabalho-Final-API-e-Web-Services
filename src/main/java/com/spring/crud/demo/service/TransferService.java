package com.spring.crud.demo.service;

import com.spring.crud.demo.dto.TransferDTO;
import com.spring.crud.demo.model.Transfer;

import java.util.List;

public interface TransferService {

    List<?> findAll();

    Transfer findById(int id);

    Transfer save(TransferDTO transferDTO);

    Transfer update(int id, TransferDTO transferDTO);

    void delete(int id);
}