package info.bpace.munchlife;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;
import android.view.View.OnClickListener;

public class MunchLifeActivity extends Activity
{
	private int level = 1;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button up_button = (Button)findViewById(R.id.up_button);
		up_button.setOnClickListener(mUpClickListener);
		
		Button down_button = (Button)findViewById(R.id.down_button);
		down_button.setOnClickListener(mDownClickListener);
	}

	private OnClickListener mUpClickListener = new OnClickListener()
	{
		@Override
		public void onClick(View v)
		{
			TextView current_level = (TextView)findViewById(R.id.current_level);
			if(level < 10)
			{
				level = level + 1;
				current_level.setText("Level " + level);
			}
		}
	};
	
	private OnClickListener mDownClickListener = new OnClickListener()
	{
		@Override
		public void onClick(View v)
		{
			TextView current_level = (TextView)findViewById(R.id.current_level);
			if(level > 1)
			{
				level = level - 1;
				current_level.setText("Level " + level);
			}
		}
	};
}
