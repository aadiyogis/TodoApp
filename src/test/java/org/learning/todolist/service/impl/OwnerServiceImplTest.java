package org.learning.todolist.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.learning.todolist.dto.OwnerDto;
import org.learning.todolist.mapper.OwnerMapper;
import org.learning.todolist.model.Owner;
import org.learning.todolist.repository.OwnerRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class OwnerServiceImplTest {
    @Mock
    private OwnerRepository ownerRepository;

    @Mock
    private OwnerMapper ownerMapper;

    @InjectMocks
    private OwnerServiceImpl ownerService;

    private OwnerDto ownerDto1;
    private Owner owner1;

    @BeforeEach
    void setUp() {
        ownerDto1 = new OwnerDto();
        ownerDto1.setFirstName("John");
        ownerDto1.setLastName("Dew");
        ownerDto1.setEmail("john.dew@mail.com");

        owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("John");
        owner1.setLastName("Dew");
        owner1.setEmail("john.dew@mail.com");
    }

    @Test
    void createOwner() {

        given(ownerMapper.mapOwnerDtoToOwner(any()))
                .willReturn(owner1);
        given(ownerRepository.saveAndFlush(any()))
                .willReturn(owner1);
        given(ownerMapper.mapOwnerToOwnerDto(any()))
                .willReturn(ownerDto1);

        OwnerDto owner = ownerService.createOwner(ownerDto1);

        assertThat(owner).isNotNull();
        assertThat(owner.getFirstName()).isEqualTo("John");
    }

    @Test
    void getAll() {
        List<Owner> ownerList = new ArrayList<>();
        ownerList.add(owner1);

        given(ownerRepository.findAll()).willReturn(ownerList);
        given(ownerMapper.mapOwnerToOwnerDto(any()))
                .willReturn(ownerDto1);

        List<OwnerDto> ownerDtos = ownerService.getAll();

        assertThat(ownerDtos).isNotNull();
        assertThat(ownerDtos.size()).isEqualTo(1);
        assertThat(ownerDtos.get(0).getLastName()).isEqualTo("Dew");
    }

    @Test
    void getOwner() {
        given(ownerRepository.findById(any()))
                .willReturn(Optional.of(owner1));
        given(ownerMapper.mapOwnerToOwnerDto(owner1))
                .willReturn(ownerDto1);

        OwnerDto owner = ownerService.getOwner(1L);

        assertThat(owner).isNotNull();
        assertThat(owner.getLastName()).isEqualTo("Dew");
    }
}