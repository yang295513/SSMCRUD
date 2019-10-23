package com.qs304.service;

import com.qs304.entity.Emplovee;
import com.qs304.entity.EmploveeExample;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ImplService {
    public List<Emplovee> getEmploveeList(EmploveeExample empl);
}
