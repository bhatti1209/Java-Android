package com.google.helloworld;

import android.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import java.lang.*;

public class ButtonHandler extends Activity {
	
	long currentnum = 0;
	long num2 = 0;
	long result = 0;
	boolean OppPerformed = true;
	
	public void NumPadClickHandle(View view)
    {
    	TextView tv = (TextView) findViewById(com.google.helloworld.R.id.txtresult);
    	Button b = (Button) findViewById(view.getId());
    	
    	if(OppPerformed == false)
    	{
    		tv.append(b.getText());
    	}
    	else
    	{
    		tv.setText(b.getText());
    		OppPerformed = false;
    	}
    }
	
	public void CalculateTaskClickHandle(View view)
	{
		switch(view.getId())
		{
		case com.google.helloworld.R.id.btnadd : doadd();
												 break;
	
		case com.google.helloworld.R.id.btnsub : dosub();
		 										 break;
		}
	}
	
	private long getCurrentNumber()
	{
		TextView tv = (TextView) findViewById(com.google.helloworld.R.id.txtresult);
		
		return new Integer(tv.getText().toString());
	}
	
	private void doadd()
	{
		//result += getCurrentNumber();
		
		//OppPerformed = true;
	}
	
	private void dosub()
	{
		result -= getCurrentNumber();
	}
	
	private void dodivide()
	{
		result /= getCurrentNumber();
	}
	
	private void domulti()
	{
		result *= getCurrentNumber();
	}
}