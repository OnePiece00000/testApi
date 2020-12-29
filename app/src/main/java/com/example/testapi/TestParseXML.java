package com.example.testapi;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TestParseXML{
    public void testParseXML() throws Exception{
        IEmployeeService mEmpservice=new EmployeeServiceIml();
        List<Employees> empList;
       // InputStream ins=getClass().getClassLoader().getResourceAsStream("employeess.xml");
        FileInputStream ins = new FileInputStream("/data/data_rbd/com.example.testapi/files/newemployees.xml");
        if(ins==null){
            Log.d("ParseXML", " ins nullnull");
        }else{
            Log.d("ParseXML", " ins not nullnull");
        }
        empList=mEmpservice.parseXMLByPull(ins);
        if(empList==null){
            Log.d("ParseXML", " emp nullnull");
        }
        for (Employees employees : empList) {
            Log.d("ParseXML",employees .toString());
        }
    }

    public void testSaveXMLByPull(Context context) throws Exception{
        List<Employees> empList=new ArrayList<Employees>();
        IEmployeeService mEmpservice=new EmployeeServiceIml();
        empList.add(new Employees("26","cmo","android develper"));
        empList.add(new Employees("28","cmo","java develper"));
        empList.add(new Employees("28","vclusters","shenzhen"));
        File xml=new File(context.getFilesDir(),"newemployees.xml");//保存文件到/<package>/files下
        FileOutputStream fout=new FileOutputStream(xml);
        mEmpservice.saveXMLByPull(empList, fout);
    }
}
