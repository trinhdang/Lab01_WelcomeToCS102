import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ////////////////////////////////////////////////////////////////////////////
    //Declare the relativeLayout variable
    private RelativeLayout layout;

    ////////////////////////////////////////////////////////////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find reference and do casting
        layout = (RelativeLayout) findViewById(R.id.mainLayout);

        //Set Click listener for the layout
        layout.setOnClickListener(this);
    }

    ////////////////////////////////////////////////////////////////////////////
    @Override
    public void onClick(View myView) {
        //Capture whether there is a "click" event occurred
        switch (myView.getId()) {
            case R.id.mainLayout:
                //User has clicked on Layout, pop up a Toast message "You've just clicked on Layout"
                Toast.makeText(this, "You've just clicked on Layout", Toast.LENGTH_SHORT).show();
                break;
            default:
                //Errors or Exceptions - Do nothing
                break;
        }
    }

    //Inflate your menu resource here
    public boolean onCreateOptionsMenu(Menu menu) {
        //Create an inflater object
        MenuInflater inflater = getMenuInflater();
        //Call method inflate() to populate all items into the menu
        inflater.inflate(R.menu.my_options_menu, menu);
        //return value
        return true;
    }

    ///////////////////////////////////////////////////////////////////////
    //Detect and respond to user interaction
    public boolean onOptionsItemSelected(MenuItem item) {
        //respond to the menu item selected
        switch (item.getItemId()) {
            case R.id.about:
                //"About" item has been clicked
                Toast.makeText(this, "About item has been clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.help:
                //"Help item has been clicked
                Toast.makeText(this, "Help item has been clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.exit:
                //"Exit" item has been clicked
                //Create an AlertDialog to ask User for confirmation before closing app
                //Create an AlertDialog object by using Builder() method
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                //Set the options for Dialog: "Yes" (PositiveButton) & "No" (NegativeButton)
                builder.setMessage("Exit App")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Click "Yes" option
                                finish();//Finish your app
                                //Kill the app process
                                android.os.Process.killProcess(android.os.Process.myPid());
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Click "No" option
                                //User cancelled the dialog
                                //do nothing
                            }
                        });
                //Create the Dialog object
                AlertDialog dialog = builder.create();
                //Set the title for dialog
                dialog.setTitle("Are you sure to exit?");
                //Display dialog on screen
                dialog.show();

                //Return value
                return true;

            default:
                //Other cases and ERROR
                //Do nothing
                return super.onOptionsItemSelected(item);
        }
    }
}
