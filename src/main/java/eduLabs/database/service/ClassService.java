package eduLabs.database.service;


import eduLabs.database.model.DTOs.ClassFeesInfoDto;

import java.util.List;

public interface ClassService {

    public List<ClassFeesInfoDto> getClassFeesInfo();

    public void updateClassFees(ClassFeesInfoDto newClassFeesInfo);
}
