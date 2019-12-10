package com.gpdi.services.impl;

import com.gpdi.domain.StudentInfo;
import com.gpdi.mapper.StudentInfoMapper;
import com.gpdi.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by YHYR on 2017-12-25
 */

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentInfoMapper studentInfoMapper;

    @Override
    public List<StudentInfo> getStudentInfo() {
        return studentInfoMapper.getStudentInfo();
    }
}
