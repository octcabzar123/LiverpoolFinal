package com.liverpool.examenfinal.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { 
		"src/test/resources/features/carrito/carrito.feature",
		"src/test/resources/features/preguntas/preguntas.feature" }, 
		strict = false, 
		plugin = { "pretty",
				"json:target/cucumber_json_reports/likeSongs.json", "html:target/likeSongs-html" }, 
		glue = {
				"com.liverpool.examenfinal.sites", 
				"com.liverpool.examenfinal.pages",
				"com.liverpool.examenfinal.steps", 
				"com.liverpool.examenfinal.utils",
				"com.liverpool.examenfinal.hooks" })
public class Runner {

}
