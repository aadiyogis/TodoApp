package org.learning.todolist.mapper;

import org.learning.todolist.dto.OwnerDto;
import org.learning.todolist.model.Owner;
import org.springframework.stereotype.Component;

@Component
public class OwnerMapper {

    public OwnerDto mapOwnerToOwnerDto(Owner owner) {
        OwnerDto ownerDto = new OwnerDto();
        ownerDto.setEmail(owner.getEmail());
        ownerDto.setFirstName(owner.getFirstName());
        ownerDto.setLastName(owner.getLastName());
        return ownerDto;
    }

    public Owner mapOwnerDtoToOwner(OwnerDto ownerDto) {
        Owner owner = new Owner();
        owner.setEmail(ownerDto.getEmail());
        owner.setFirstName(ownerDto.getFirstName());
        owner.setLastName(ownerDto.getLastName());
        return owner;
    }
}
