package com.example.testapi;

import android.util.Log;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

//import org.json.JSONArray;
//import org.json.JSONObject;

import java.util.HashMap;

public class MyJSONObject {
    private static String TAG = "MyJSONObject";
    JSONObject jsonObject = new JSONObject();
    JSONArray jsonArray = new JSONArray();
    HashMap<String,Object> hashMap = new HashMap<>();

    String myString = "[{name1:{name2:{name3:'value1',name4:'value2'}}},{}]";

    public void MyJSONObject1() {

        JSONArray getJsonArray = JSONArray.parseArray(myString);
        JSONObject getJsonObj = getJsonArray.getJSONObject(0);
        String result=getJsonObj.getJSONObject("name1").getJSONObject("name2").getString("name4");
        Log.d(TAG,"hejiangzhou result = " + result);
    }



}
