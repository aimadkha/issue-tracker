package com.code.issuestracker.util;

import com.code.issuestracker.dto.ProjectDto;
import com.code.issuestracker.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    void updateCustomerFromDto(ProjectDto dto, @MappingTarget Project project);
}
