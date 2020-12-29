package com.example.testapi;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.xpath.XPathFactory;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

import android.util.Xml;
import com.example.testapi.Employees;
import com.example.testapi.IEmployeeService;

public class EmployeeServiceIml implements IEmployeeService {

    /*
     * (non-Javadoc)
     * @see com.example.interfaces.IEmployeeService#parseXMLByPull(java.io.InputStream)
     * 使用Pull解析XML
     */
    @Override
    public List<Employees> parseXMLByPull(InputStream xml) throws Exception {
        List<Employees> empList=null;
        Employees emp=null;
        //首先得到Pull解析器
        //XmlPullParser pull=(XmlPullParser) XPathFactory.newInstance();
        XmlPullParser pull=Xml.newPullParser();
        pull.setInput(xml, "UTF-8");//设置要解析XML数据源
        //解析的过程中他会把xml读取到一个字符数组中，然后一个逐个字符读取当读取到结束标志">"时，会去根据XML语法判断，若匹配了某种语法就会出发预定义的事件比如说start document等,当解析到了start document之后就不会主动往后解析了
        int event=pull.getEventType();//获取事件类型
        while(event !=XmlPullParser.END_DOCUMENT){
            switch (event) {
                case XmlPullParser.START_DOCUMENT:
                    empList=new ArrayList<Employees>();
                    break;
                //当解析到了Employee节点，触发Start_tag
                case XmlPullParser.START_TAG:
                    if("employee".equals(pull.getName())){
                        String id=pull.getAttributeValue(null,"id");//因为元素节点Employee只有一个属性，所以索引为0
                        emp=new Employees();
                        emp.setId(id);
                    }
                    if("name".equals(pull.getName())){
                        String name=pull.nextText();
                        emp.setName(name);
                    }
                    if("position".equals(pull.getName())){
                        String position=pull.nextText();
                        emp.setPosition(position);
                    }
                    break;
                //解析到结束标志时触发
                case XmlPullParser.END_TAG:
                    if("employee".equals(pull.getName())){
                        empList.add(emp);
                        emp=null;
                    }
                    break;
            }
            event=pull.next();//主动去遍历下一个节点
        }
        xml.close();
        return empList;
    }

    @Override
    public void saveXMLByPull(List<Employees> empList, OutputStream out) throws Exception {
        XmlSerializer serializer = Xml.newSerializer();
        serializer.setOutput(out, "UTF-8");
        serializer.startDocument("UTF-8", true);
        // 第一个参数为命名空间,如果不使用命名空间,可以设置为null
        serializer.startTag(null, "employees");
        for (Employees emp : empList) {
            serializer.startTag(null, "employee");// 生成这个<employees>
            serializer.attribute(null, "id", emp.getId());// 设置属性id的值
            serializer.startTag(null, "name");
            serializer.text(emp.getName());
            serializer.endTag(null, "name");
            serializer.startTag(null, "position");
            serializer.text(emp.getPosition());
            serializer.endTag(null, "position");
            serializer.endTag(null, "employee");// </employees>
        }
        serializer.endTag(null, "employees");
        serializer.endDocument();
        out.flush();
        out.close();
    }
}