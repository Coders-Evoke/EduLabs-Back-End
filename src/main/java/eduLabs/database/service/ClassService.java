package eduLabs.database.service;


import eduLabs.database.model.DTOs.ClassFeesInfoDto;
import eduLabs.database.model.DTOs.ClassTableDto;

import java.util.List;

public interface ClassService {

    public List<ClassFeesInfoDto> getClassFeesInfo();
    public void updateClassFees(ClassFeesInfoDto newClassFeesInfo);
    public ClassTableDto getClassInfo(String classId);
}
