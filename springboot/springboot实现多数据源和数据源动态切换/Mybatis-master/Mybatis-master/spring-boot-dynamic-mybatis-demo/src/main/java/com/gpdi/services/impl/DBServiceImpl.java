package com.gpdi.services.impl;

import com.gpdi.mapper.DBInfoMapper;
import com.gpdi.domain.DBInfo;
import com.gpdi.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by YHYR on 2017-12-25
 */

@Service
public class DBServiceImpl implements DBService {
    @Autowired
    DBInfoMapper dbInfoMapper;

    @Override
    public DBInfo getDBInfoByprimayrId(int primayrId) {
        return dbInfoMapper.getDBInfoById(primayrId);
    }
}
