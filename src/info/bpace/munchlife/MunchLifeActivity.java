package info.bpace.munchlife;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;
import android.view.View.OnClickListener;

public class MunchLifeActivity extends Activity
{
	private static final String CURRENT_LEVEL = "savedLevel";
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
		
		// pull old level from savedInstanceState, or default it to 1
		level = savedInstanceState != null ? savedInstanceState.getInt(CURRENT_LEVEL)
		                                   : 1;
	}
	
	@Override
	public void onSaveInstanceState(Bundle outState)
	{
		super.onSaveInstanceState(outState);
		outState.putInt(CURRENT_LEVEL, level);
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
