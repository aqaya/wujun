package com.primeton.wujun.test.testjar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class HttpTest {

	public static void main(String[] args) throws IOException {
		//String url = "https://docs.docker.com/userguide/usingdocker/";
		//String toFile = "usingdocker.html";
		String url = "https://sublime.wbond.net/channel.json";
		String toFile = "sublimeInstall.json";
		String param = "";
		BufferedReader in = null;
		String result = "";
		String urlNameString = url + "?" + param;
        URL realUrl = new URL(urlNameString);
        // �򿪺�URL֮�������
        URLConnection connection = realUrl.openConnection();
        // ����ͨ�õ���������
        connection.setRequestProperty("accept", "*/*");
        connection.setRequestProperty("connection", "Keep-Alive");
        connection.setRequestProperty("user-agent",
                "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
        // ����ʵ�ʵ�����
        connection.connect();
        // ��ȡ������Ӧͷ�ֶ�
        Map<String, List<String>> map = connection.getHeaderFields();
        // �������е���Ӧͷ�ֶ�
        for (String key : map.keySet()) {
            System.out.println(key + "--->" + map.get(key));
        }
        // ���� BufferedReader����������ȡURL����Ӧ
        in = new BufferedReader(new InputStreamReader(
                connection.getInputStream()));
        String line;
        File file = new File("d:/",toFile);
        if(!file.exists()){
        	file.createNewFile();
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        while ((line = in.readLine()) != null) {
            result += line+"\n";
            bw.write(line);
        }
        bw.close();
        
        System.out.println(result);
	}

}
