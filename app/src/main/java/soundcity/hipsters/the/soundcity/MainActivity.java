package soundcity.hipsters.the.soundcity;

import android.content.Context;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public class Sound {
        public ImageView img;
        public String name;
        public String location;

        public Sound(ImageView img, String name, String location) {
            this.img = img;
            this.name = name;
            this.location = location;

        }
    }

    public class UsersAdapter extends ArrayAdapter<Sound> {
        public UsersAdapter(Context context, ArrayList<Sound> users) {
            super(context, 0, users);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Get the data item for this position
            Sound user = getItem(position);
            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.element_newsfeed, parent, false);
            }
            // Lookup view for data population
            TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
            TextView tvLocation = (TextView) convertView.findViewById(R.id.tvLocation);
            // Populate the data into the template view using the data object
            tvName.setText(user.name);
            tvLocation.setText(user.location);
            // Return the completed view to render on screen
            return convertView;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Sound> arrayOfUsers = new ArrayList<Sound>();
// Create the adapter to convert the array to views
        UsersAdapter adapter = new UsersAdapter(this, arrayOfUsers);
// Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

//    public class Sound {
//        // Constructor to convert JSON object into a Java class instance
//        public Sound(JSONObject object){
//            try {
//                this.name = object.getString("name");
//                this.hometown = object.getString("hometown");
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//        }
//
//        // Factory method to convert an array of JSON objects into a list of objects
//        // User.fromJson(jsonArray);
//        public static ArrayList<User> fromJson(JSONArray jsonObjects) {
//            ArrayList<User> users = new ArrayList<User>();
//            for (int i = 0; i < jsonObjects.length(); i++) {
//                try {
//                    users.add(new User(jsonObjects.getJSONObject(i)));
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//            return users;
//        }
//    }

        // Add item to adapter
        ImageView image = (ImageView) findViewById(R.id.tvImg);
        //image.setImageResource(R.drawable.ic_launcher_web);
        Sound newUser = new Sound(image, "Nathan", "San Diego");
        Sound newUser2 = new Sound(image, "Brian", "Los Angeles");
        adapter.add(newUser);
        adapter.add(newUser2);
        // Or even append an entire new collection
// Fetching some data, data has now returned
// If data was JSON, convert to ArrayList of User objects.
//        JSONArray jsonArray = ...;
//        ArrayList<Sound> newUsers = Sound.fromJson(jsonArray)
//        adapter.addAll(newUsers);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
