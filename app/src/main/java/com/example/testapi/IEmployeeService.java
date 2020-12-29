package com.example.testapi;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public interface IEmployeeService {
    public List<Employees> parseXMLByPull(InputStream xml)throws Exception;
    public void saveXMLByPull(List<Employees> empList, OutputStream out) throws Exception;
}
