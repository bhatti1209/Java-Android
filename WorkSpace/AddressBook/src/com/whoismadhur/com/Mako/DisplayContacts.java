package com.whoismadhur.com.Mako;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.Intent;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.provider.Contacts.Intents.Insert;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class DisplayContacts extends Activity {
	
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.contactlistdisplay);

	        com.whoismadhur.com.Mako.DBAdapter dba = new com.whoismadhur.com.Mako.DBAdapter(this);
	        dba.open();
	         Cursor mCursor = dba.getAllTitles();
	         
	         ListView lv = (ListView) findViewById(R.id.ListView01);
	         SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.contactlistdisplay, mCursor, new String[] {"Name"}, new int[] {R.layout.row});
	         
	         lv.setAdapter(adapter);

	 }
}
