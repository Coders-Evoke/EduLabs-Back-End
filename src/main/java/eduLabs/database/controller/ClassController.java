package eduLabs.database.controller;

import eduLabs.database.model.DTOs.ClassFeesInfoDto;
import eduLabs.database.model.DTOs.ClassTableDto;
import eduLabs.database.service.ClassServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ClassController {

    @Autowired
    private ClassServiceImp classService;

    @GetMapping("/getClassFeesInfo")
    public ResponseEntity<List<ClassFeesInfoDto>> getClassFeesInfo(){
        return new ResponseEntity<>(this.classService.getClassFeesInfo(), HttpStatus.OK);
    }

    @PutMapping("/updateClassFees")
    public ResponseEntity<ClassFeesInfoDto> updateClassFees(@RequestBody ClassFeesInfoDto newClassFeesInfo){
        this.classService.updateClassFees(newClassFeesInfo);
        return new ResponseEntity<>(newClassFeesInfo, HttpStatus.OK);
    }

    @GetMapping("/getClassInfo/{classId}")
    public ResponseEntity<ClassTableDto> getClassInfo(@PathVariable String classId){
        return new ResponseEntity<>(this.classService.getClassInfo(classId), HttpStatus.OK);
    }
}
