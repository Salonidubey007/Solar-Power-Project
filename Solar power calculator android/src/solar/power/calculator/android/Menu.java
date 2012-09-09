package solar.power.calculator.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;


public class Menu extends Activity{
	
	/*
	 * Array of Strings representing Class Names.
	 * This will allow easy upates of the menu.
	 */
	String  classes[] = {"RegionInformation", "PanelInfomation", "Calculate"};
	/*
	 * Array of strings to represent text in the menu
	 */
	String  names[] = {"Region Information", "Panel Information", "Calculate"};
	
	/*
	 * A Datastore
	 */
	Datastore data;
	Button areaInfo, pnlInfo;
	
	public Menu(){
	}
	
	/*
	 * (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 * Set the List Menu
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		/*
		areaInfo = (Button)findViewById(R.id.button1);
		pnlInfo = (Button)findViewById(R.id.button2);
		
		
		//setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, names));
		//Intent intent = getIntent();
		Bundle b = this.getIntent().getExtras();
		if(b!=null)
			data = (Datastore) b.getSerializable(Datastore.EXTRA_MESSAGE);
		else
			data = new Datastore();
		
		setup();*/
	}
	
		/*
	 * (non-Javadoc)
	 * @see android.app.ListActivity#onListItemClick(android.widget.ListView, android.view.View, int, long)
	 * When a list item is selected, the starts a new activity with the corrisponding class.
	 
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		
		super.onListItemClick(l, v, position, id);
		//Get the name of class
		String localStr = classes[position];
		try{
			//Create a class using the string representation of the class name.
			Class intentClass = Class.forName("solar.power.calculator.android."+localStr);
			//Create an intent of the class
			Intent intent = new Intent(Menu.this, intentClass);
			Bundle b = new Bundle();
			b.putSerializable(Datastore.EXTRA_MESSAGE, data);
			intent.putExtras(b);
			//Start the new activity
			startActivity(intent);
		}catch (ClassNotFoundException e)
		{
			//If you have come to here, you'v fucked up somewhere.
			e.printStackTrace();
		}
	}*/
	private void setup(){
		double dsone[] = data.getDataSetOne();
		
		double dstwo[] = data.getDataSetTwo();
		
		CheckBox pnl, region;
		pnl = (CheckBox)findViewById(R.id.pnlDone);
		region = (CheckBox) findViewById( R.id.regionDone);
		
		if(dsone[0] != 0 && dsone[1]!= 0 && dsone[2] != 0){
			region.setChecked(true);
		}else{
			region.setChecked(false);
		}
		
		if(dstwo[0] != 0 && dstwo[1]!= 0 && dstwo[2] != 0){
			pnl.setChecked(true);
		}else{
			pnl.setChecked(false);
		}
	}
	
	
	
	public void pnlInfo(View v){
		Intent intent = new Intent(this, PanelInfo.class);
		Bundle b = new Bundle();
		b.putSerializable(Datastore.EXTRA_MESSAGE, this.data);
		intent.putExtras(b);
		startActivity(intent);
	}
	
	public void areaInfo(View v){
		Intent intent = new Intent(this, RegionInformation.class);
		Bundle b = new Bundle();
		b.putSerializable(Datastore.EXTRA_MESSAGE, this.data);
		intent.putExtras(b);
		startActivity(intent);
	}
	
	@Override
    public void onResume(){
		super.onResume();
		Bundle b = this.getIntent().getExtras();
		if(b!=null)
			data = (Datastore) b.getSerializable(Datastore.EXTRA_MESSAGE);
		else
			data = new Datastore();
		
		setup();
    	
    }
	
	
	/*
	 * (non-Javadoc)
	 * @see android.app.Activity#onPause()
	 * Override the onPause method to release the resources used by the Splash Activity
	 * This prevents the Splash Screen from being accessible by pressing back after reaching the
	 * next activity.
	 */
	@Override
	protected void onStop() {
		super.onStop();
		finish();
	}
	
}
