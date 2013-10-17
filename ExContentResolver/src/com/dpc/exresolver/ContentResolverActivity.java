package com.dpc.exresolver;

import com.dpc.exresolver.R;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ContentResolverActivity extends Activity {
	private final String DPC_URI = "content://com.dpc.provider.books/book";
	private ContentResolver cr;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        cr = this.getContentResolver();
        Button button1 = (Button)findViewById(R.id.button1);
        Button button2 = (Button)findViewById(R.id.button2);
        
        button1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//与已经注册的uri进行匹配
				Cursor cursor = cr.query(Uri.parse(DPC_URI), null, null, null, null);
				while(cursor.moveToNext()) {
					String name = cursor.getString(1);
					TextView tv = (TextView)findViewById(R.id.textView);
					tv.setText(name);
				}
				cursor.close();
			}
		});
        
        button2.setOnClickListener(new OnClickListener() {
        	@Override
        	public void onClick(View v) {
        		ContentValues cv = new ContentValues();
        		cv.put("bookname", "自学成才第二版");
        		int result = cr.update(Uri.parse(DPC_URI), cv, null, null);
        		if(result > 0) {
        			Toast.makeText(ContentResolverActivity.this, "修改成功", 1000).show();
        		}
        	}
        });
    }
}
