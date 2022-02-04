package org.learning.todolist.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.learning.todolist.dto.OwnerDto;
import org.learning.todolist.mapper.OwnerMapper;
import org.learning.todolist.model.Owner;
import org.learning.todolist.repository.OwnerRepository;
import org.learning.todolist.service.OwnerService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class OwnerServiceImpl implements OwnerService {
    private final OwnerRepository ownerRepository;
    private final OwnerMapper ownerMapper;

    @Override
    @Transactional
    public OwnerDto createOwner(OwnerDto ownerDto) {
        Owner owner = ownerMapper.mapOwnerDtoToOwner(ownerDto);
        Owner savedOwner = ownerRepository.saveAndFlush(owner);
        return ownerMapper.mapOwnerToOwnerDto(savedOwner);
    }

    @Override
    @Transactional
    public List<OwnerDto> getAll() {
        List<Owner> ownerList = ownerRepository.findAll();
        List<OwnerDto> ownerDtos = new ArrayList<>();
        for (Owner owner : ownerList) {
            OwnerDto ownerDto = ownerMapper.mapOwnerToOwnerDto(owner);
            ownerDtos.add(ownerDto);
        }
        return ownerDtos;
    }

    @Override
    @Transactional
    public OwnerDto getOwner(Long id) {
        OwnerDto ownerDto = null;
        Optional<Owner> ownerOptional = ownerRepository.findById(id);
        if (ownerOptional.isPresent()) {
            ownerDto = ownerMapper.mapOwnerToOwnerDto(ownerOptional.get());
        }
        return ownerDto;
    }
}
