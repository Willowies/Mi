package com.mi.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

public abstract class BaseController {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		format.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
		binder.registerCustomEditor(int.class, new IntegerEditor());
		binder.registerCustomEditor(long.class, new LongEditor());
		binder.registerCustomEditor(double.class, new DoubleEditor());
		binder.registerCustomEditor(float.class, new FloatEditor());

	}
}
