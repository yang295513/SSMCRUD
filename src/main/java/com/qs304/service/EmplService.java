package com.qs304.service;

import com.qs304.dao.EmploveeMapper;
import com.qs304.entity.Emplovee;
import com.qs304.entity.EmploveeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmplService implements ImplService{
    @Autowired
    EmploveeMapper emplMapper = null;

    public List<Emplovee> getEmploveeList(EmploveeExample empl){

        List<Emplovee> list=emplMapper.selectByExampleWithDept(empl);

        return list;
    }
}
