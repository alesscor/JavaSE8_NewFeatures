package com.example.java8;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Main {

	public static void main(String[] args) {

		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("nashorn");
		String script = 
				"var welcome = 'Hello'; "
				+ "welcome += ', Alessandroski'; "
				+ "welcome";
		String result;
		try {
			result = (String)engine.eval(script);
			System.out.println(result);
		} catch (ScriptException e) {
			System.out.println("There was a JavaScript error");
			e.printStackTrace();
		}

	}

}
