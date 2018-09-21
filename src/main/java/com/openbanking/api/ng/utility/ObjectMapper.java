package com.openbanking.api.ng.utility;

public interface ObjectMapper<D, E, R> {

    D convertToDto(E entity);

    E convertToEntity(D dto);

    R converToResponseDTO(E entity);
}
