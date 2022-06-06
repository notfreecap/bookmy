package com.homesource.bookmy.domain.repository;

import com.homesource.bookmy.domain.dto.PersonDto;

import java.util.List;

public interface PersonRepository {
    List<PersonDto> getAll();

    PersonDto save(PersonDto personDto);

    PersonDto findById(Long id);

    PersonDto update(PersonDto personDto);
}
