package com.primeton.wujun.test.testjar;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONWriter;

public class JettisonTest {
	
	public static void main(String[] args) throws IOException, JSONException {
		File file = new File("d:/test.txt");
		if(!file.exists()){
			file.createNewFile();
		}
		Writer w = new FileWriter(file);
		JSONWriter jw = new JSONWriter(w);
		jw.object();
		jw.key("name");
		jw.value("wujun");
		jw.key("age");
		jw.array();
		jw.value("s");
		jw.endArray();
		jw.endObject();
		w.flush();
	}

}
