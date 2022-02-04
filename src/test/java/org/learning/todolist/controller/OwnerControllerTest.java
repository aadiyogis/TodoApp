package org.learning.todolist.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.learning.todolist.dto.OwnerDto;
import org.learning.todolist.service.OwnerService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @Mock
    private OwnerService ownerService;

    @InjectMocks
    private OwnerController ownerController;

    private OwnerDto ownerDto1;

    @BeforeEach
    void setUp() {
        ownerDto1 = new OwnerDto();
        ownerDto1.setFirstName("John");
        ownerDto1.setLastName("Dew");
        ownerDto1.setEmail("john.dew@mail.com");

    }

    @Test
    void createOwner() {
        given(ownerService.createOwner(any()))
                .willReturn(ownerDto1);

        OwnerDto owner = ownerController.createOwner(ownerDto1);

        assertThat(owner).isNotNull();
        assertThat(owner.getFirstName()).isEqualTo("John");
    }

    @Test
    void getAllOwners() {
        List<OwnerDto> ownerDtos = new ArrayList<>();
        ownerDtos.add(ownerDto1);

        given(ownerService.getAll()).willReturn(ownerDtos);

        List<OwnerDto> allOwners = ownerController.getAllOwners();

        assertThat(allOwners).isNotNull();
        assertThat(allOwners.size()).isEqualTo(1);
    }

    @Test
    void getOwnerById() {
        given(ownerService.getOwner(any()))
                .willReturn(ownerDto1);

        OwnerDto owner = ownerController.getOwnerById(1L);

        assertThat(owner).isNotNull();
        assertThat(owner.getLastName()).isEqualTo("Dew");
    }
}