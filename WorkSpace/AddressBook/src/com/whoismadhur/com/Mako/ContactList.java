package com.whoismadhur.com.Mako;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.whoismadhur.com.Mako.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.Intent;
import android.content.OperationApplicationException;
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

public class ContactList extends Activity {
   
	/** Called when the activity is first created. */
	private ContactList mContext;
	private EditText fname;
	private EditText lname;
	private EditText phonenumber;
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	mContext = this;
        super.onCreate(savedInstanceState);
        final DBAdapter db = new DBAdapter(this);
        db.open();
       
        setContentView(R.layout.main);
        
        Button btnSave = (Button) findViewById(R.id.btnSave);
        Button btnView = (Button) findViewById(R.id.btnView);
        
        btnSave.setOnClickListener(new OnClickListener() {
			
			
		
			public void onClick(View v) {
				db.open();
				AlertDialog show;
				fname = (EditText) findViewById(R.id.txtfname);
				lname = (EditText) findViewById(R.id.txtlname);
				phonenumber = (EditText) findViewById(R.id.txtPhone);
				
				String first_name = fname.getText().toString();
				String last_name = lname.getText().toString();
				String pnumber = phonenumber.getText().toString();
				
				if(first_name.equals("")  && last_name.equals(""))
				{
										
					show = new AlertDialog.Builder(mContext).setTitle("Error")
                    .setMessage("Please Enter First Name or Last Name")
                    .setPositiveButton("OK", null).show();

				}
				else
				{
					Random r = new Random(1213131);
					int id = r.nextInt();
					

					/* ArrayList<ContentProviderOperation> ops = new ArrayList<ContentProviderOperation>();
					 ops.add(ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI)
				                .withValue(ContactsContract.RawContacts.ACCOUNT_TYPE, null)
				                .withValue(ContactsContract.RawContacts.ACCOUNT_NAME, null)
				                .build());
					 ops.add(ContentProviderOperation.newInsert(Data.CONTENT_URI)
					          .withValue(Data.RAW_CONTACT_ID, id)
					          .withValue(Data.MIMETYPE, Phone.CONTENT_ITEM_TYPE)
					          .withValue(Data.DISPLAY_NAME, first_name)
					          .withValue(Phone.NUMBER, pnumber)
					          .withValue(Phone.TYPE, Phone.TYPE_CUSTOM)
					          .build());
					 try {
						getContentResolver().applyBatch(ContactsContract.AUTHORITY, ops);
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (OperationApplicationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} */
					
					db.insertTitle(first_name + " ," + last_name,pnumber);

				
						
				
						fname.setText("");
						lname.setText("");
						phonenumber.setText("");
						db.close();
				}
					

				}
			
        });
        
        btnView.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent i = new Intent(ContactList.this, DisplayContacts.class);
				startActivity(i);
			}
		});
    
    
    }
}
				
				
			
		
    
