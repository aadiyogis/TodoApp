package org.learning.todolist.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.learning.todolist.dto.OwnerDto;
import org.learning.todolist.model.Owner;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapperTest {

    private OwnerMapper ownerMapper;
    private Owner owner1;
    private OwnerDto ownerDto1;

    @BeforeEach
    void setUp() {
        ownerMapper = new OwnerMapper();

        owner1 = new Owner();
        owner1.setFirstName("John");
        owner1.setLastName("Doe");
        owner1.setEmail("john.doe@mail.com");

        ownerDto1 = new OwnerDto();
        ownerDto1.setFirstName("Jane");
        ownerDto1.setLastName("Doe");
        ownerDto1.setEmail("jane.doe@mail.com");
    }

    @Test
    void mapOwnerToOwnerDto() {
        OwnerDto ownerDto = ownerMapper.mapOwnerToOwnerDto(owner1);
        assertEquals("John", ownerDto.getFirstName());
        assertEquals("Doe", ownerDto.getLastName());
        assertEquals("john.doe@mail.com", ownerDto.getEmail());
    }

    @Test
    void mapOwnerDtoToOwner() {
        Owner owner = ownerMapper.mapOwnerDtoToOwner(ownerDto1);
        assertEquals("Jane", owner.getFirstName());
        assertEquals("Doe", owner.getLastName());
        assertEquals("jane.doe@mail.com", owner.getEmail());
        assertNull(owner.getId());
    }
}