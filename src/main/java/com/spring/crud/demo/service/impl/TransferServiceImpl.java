package com.spring.crud.demo.service.impl;

import com.spring.crud.demo.dto.TransferDTO;
import com.spring.crud.demo.model.Transfer;
import com.spring.crud.demo.repository.TeamRepository;
import com.spring.crud.demo.repository.TransferRepository;
import com.spring.crud.demo.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class TransferServiceImpl implements TransferService {

    @Autowired
    private TransferRepository transferRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public List<Transfer> findAll() {
        return transferRepository.findAll();
    }

    @Override
    public Transfer findById(int id) {
        return transferRepository.findById(id).orElseThrow(() -> new NotFoundException("** Transfer not found for id :: " + id));
    }

    @Override
    public Transfer save(TransferDTO transferDTO) {
        Transfer transfer = Transfer.builder()
                .country(transferDTO.getCountry())
                .value(transferDTO.getValue())
                .originTeam(teamRepository.findById(transferDTO.getOriginTeamId()).orElseThrow(() -> new NotFoundException("** Origin Team not found for id :: " + transferDTO.getOriginTeamId())))
                .destinyTeam(teamRepository.findById(transferDTO.getDestinyTeamId()).orElseThrow(() -> new NotFoundException("** Destiny Team not found for id :: " + transferDTO.getDestinyTeamId())))
                .build();
        return transferRepository.save(transfer);
    }

    @Override
    public Transfer update(int id, TransferDTO transferDTO) {
    	transferRepository.findById(id).orElseThrow(() -> new NotFoundException("** Transfer not found for id :: " + id));

        Transfer transfer = Transfer.builder()
                .id(id)
                .country(transferDTO.getCountry())
                .value(transferDTO.getValue())
                .originTeam(teamRepository.findById(transferDTO.getOriginTeamId()).orElseThrow(() -> new NotFoundException("** Origin Team not found for id :: " + transferDTO.getOriginTeamId())))
                .destinyTeam(teamRepository.findById(transferDTO.getDestinyTeamId()).orElseThrow(() -> new NotFoundException("** Destiny Team not found for id :: " + transferDTO.getDestinyTeamId())))
                .build();
        return transferRepository.save(transfer);
    }

    @Override
    public void delete(int id) {
        transferRepository.findById(id).ifPresent(transfer -> transferRepository.delete(transfer));
    }
}