package solar.power.calculator.android;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity{

	String  classes[] = {"RegionInformation", "PanelInfomation", "Calculate"};
	String  names[] = {"Region Information", "Panel Information", "Calculate"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, names));
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		
		super.onListItemClick(l, v, position, id);
		String localStr = classes[position];
		try{
			Class intentClass = Class.forName("solar.power.calculator.android."+localStr);
			Intent intent = new Intent(Menu.this, intentClass);
			startActivity(intent);
		}catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
}
