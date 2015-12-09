package com.example.java8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("nashorn");

		File f=new File("scripts/readurl.js");
		Reader reader=new FileReader(f);
		
		String result;
		try {
			result = (String)engine.eval(reader);
			System.out.println(result);
		} catch (ScriptException e) {
			System.out.println("There was a JavaScript error");
			e.printStackTrace();
		}

	}

}
