package com.smf.phase2.Pages;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;

import com.smf.phase2.Base.BaseClass;

public class Homepage extends BaseClass {

	public Homepage() throws IOException {
		PageFactory.initElements(driver, this);
	}

}
