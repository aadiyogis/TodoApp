package org.learning.todolist.service;

import org.learning.todolist.dto.OwnerDto;

import java.util.List;

public interface OwnerService {

    OwnerDto createOwner(OwnerDto ownerDto);

    List<OwnerDto> getAll();

    OwnerDto getOwner(Long id);
}
