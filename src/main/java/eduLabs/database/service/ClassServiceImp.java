package eduLabs.database.service;

import eduLabs.database.model.ClassTableModel;
import eduLabs.database.model.DTOs.ClassFeesInfoDto;
import eduLabs.database.model.DTOs.ClassTableDto;
import eduLabs.database.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassServiceImp implements ClassService{

    @Autowired
    private ClassRepository classRepository;

    @Override
    public List<ClassFeesInfoDto> getClassFeesInfo() {
        List<ClassFeesInfoDto> classFeesInfo = new ArrayList<>();
        List< ClassTableModel> classTable = this.classRepository.findAll();
        for(int count = 0; count<classTable.size(); count++){
            ClassFeesInfoDto temp = new ClassFeesInfoDto();
            temp.setClassID(classTable.get(count).getClassID());
            temp.setClassName(classTable.get(count).getClassName());
            temp.setGrade(classTable.get(count).getGrade());
            temp.setMonthlyFee(classTable.get(count).getMonthlyFee());
            temp.setTeacherID(classTable.get(count).getTeacherTableModel().getTeacherID());
            classFeesInfo.add(temp);
        }
        return classFeesInfo;
    }

    @Override
    public void updateClassFees(ClassFeesInfoDto newClassFeesInfo) {
        ClassTableModel classInfo = this.classRepository.findById(newClassFeesInfo.getClassID()).orElseThrow();
        classInfo.setMonthlyFee(newClassFeesInfo.getMonthlyFee());
        this.classRepository.save(classInfo);
    }

    @Override
    public ClassTableDto getClassInfo(String classId) {
        ClassTableModel classTableModel = this.classRepository.findById(classId).orElseThrow();

        ClassTableDto classInfo = new ClassTableDto();

        classInfo.setClassID(classTableModel.getClassID());
        classInfo.setTeacherId(classTableModel.getTeacherTableModel().getTeacherID());
        classInfo.setClassName(classTableModel.getClassName());
        classInfo.setGrade(classTableModel.getGrade());
        classInfo.setDayOfWeek(classTableModel.getDayOfWeek());
        classInfo.setTime(classTableModel.getTime());
        classInfo.setDuration(classTableModel.getDuration());
        classInfo.setMonthlyFee(classTableModel.getMonthlyFee());
        classInfo.setTeacherShare(classTableModel.getTeacherShare());

        return classInfo;
    }


}
