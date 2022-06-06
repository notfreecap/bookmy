package com.homesource.bookmy.persistence.mapper;

import com.homesource.bookmy.domain.dto.PersonDto;
import com.homesource.bookmy.persistence.entity.Persona;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PersonMapper {

    @Mappings({
            @Mapping(source = "id", target = "personId"),
            @Mapping(source = "documento", target = "numberId"),
            @Mapping(source = "nombres", target = "firstName"),
            @Mapping(source = "apellidos", target = "lastName"),
            @Mapping(source = "fechaNacimiento", target = "birthDate"),
            @Mapping(source = "perfil", target = "profile")
    })
    PersonDto toPersonDto(Persona personas);
    List<PersonDto> toPersonDtoList(List<Persona> personas);


    /*@Mappings({
            @Mapping(target = "fechaCreacion", ignore = true),
            @Mapping(target = "fechaCreacion", ignore = true)
    })*/
    @InheritInverseConfiguration
    Persona toPersona(PersonDto personDto);

}
