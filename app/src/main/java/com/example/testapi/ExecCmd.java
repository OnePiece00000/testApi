package com.example.testapi;

import android.util.Log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ExecCmd {
    private final String TAG = "ExecCmd";
    public String runCommand(String command) {
        Process process = null;
        String result = "";
        DataOutputStream os = null;
        DataInputStream is = null;
        try {
            process = Runtime.getRuntime().exec("su");
            os = new DataOutputStream(process.getOutputStream());
            is = new DataInputStream(process.getInputStream());
            Log.d(TAG,"hejiangzhou command = " + command);
            os.writeBytes(command + "\n");
            os.writeBytes("exit\n");
            os.flush();
            String line = null;
            while ((line = is.readLine()) != null) {
                result += line;
            }
            process.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (process != null) {
                process.destroy();
            }
        }
        return result;
    }
}
