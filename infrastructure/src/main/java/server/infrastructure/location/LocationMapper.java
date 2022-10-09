package server.infrastructure.location;

import org.mapstruct.Mapper;
import server.domain.service.dto.Location;

@Mapper(componentModel = "spring")
interface LocationMapper {

    Location entityToDTO(LocationEntity location);

    LocationEntity dtoToEntity(Location location);


}
