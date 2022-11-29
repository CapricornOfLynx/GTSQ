package app.gtsq;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private Toolbar _toolbar;
    private DrawerLayout _drawer;

    private ScrollView main_scroll;
    private ImageView pic_1;
    private LinearLayout _drawer_drawer_bg;
    private LinearLayout _drawer_drawer_spacer_1;
    private Button _drawer_vpl_button;
    private LinearLayout _drawer_drawer_spacer_2;
    private Button _drawer_ter_button;
    private LinearLayout _drawer_drawer_spacer_3;
    private Button _drawer_bfp_button;
    private LinearLayout _drawer_drawer_spacer_4;
    private Button _drawer_now_button;
    private LinearLayout _drawer_drawer_spacer_5;
    private Button _drawer_call_button;
    private LinearLayout _drawer_drawer_spacer_6;
    private Button _drawer_ds_button;
    private LinearLayout _drawer_drawer_spacer_7;
    private LinearLayout _drawer_drawer_spacer_8;
    private LinearLayout _drawer_drawer_spacer_9;

    private Intent i = new Intent();
    private AlertDialog.Builder d;
    private TextToSpeech tts;
    private String vpmobile_store = "https://play.google.com/store/apps/details?id=com.embarcadero.VpMobil24";
    private String vpmobile_packetname = "com.embarcadero.VpMobil24";
    @Override
    protected void onCreate(Bundle _savedInstanceState) {
        super.onCreate(_savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize(_savedInstanceState);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CALL_PHONE}, 1000);
        }
        else {
            initializeLogic();
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1000) {
            initializeLogic();
        }
    }

    private void initialize(Bundle _savedInstanceState) {

        _toolbar = (Toolbar) findViewById(R.id._toolbar);
        setSupportActionBar(_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        _toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _v) {
                onBackPressed();
            }
        });
        _drawer = (DrawerLayout) findViewById(R.id._drawer);
        ActionBarDrawerToggle _toggle = new ActionBarDrawerToggle(MainActivity.this, _drawer, _toolbar, R.string.app_name, R.string.app_name);
        _drawer.addDrawerListener(_toggle);
        _toggle.syncState();

        LinearLayout _nav_view = (LinearLayout) findViewById(R.id._nav_view);

        main_scroll = (ScrollView) findViewById(R.id.main_scroll);
        pic_1 = (ImageView) findViewById(R.id.pic_1);
        _drawer_drawer_bg = (LinearLayout) _nav_view.findViewById(R.id.drawer_bg);
        _drawer_drawer_spacer_1 = (LinearLayout) _nav_view.findViewById(R.id.drawer_spacer_1);
        _drawer_vpl_button = (Button) _nav_view.findViewById(R.id.vpl_button);
        _drawer_drawer_spacer_2 = (LinearLayout) _nav_view.findViewById(R.id.drawer_spacer_2);
        _drawer_ter_button = (Button) _nav_view.findViewById(R.id.ter_button);
        _drawer_drawer_spacer_3 = (LinearLayout) _nav_view.findViewById(R.id.drawer_spacer_3);
        _drawer_bfp_button = (Button) _nav_view.findViewById(R.id.bfp_button);
        _drawer_drawer_spacer_4 = (LinearLayout) _nav_view.findViewById(R.id.drawer_spacer_4);
        _drawer_now_button = (Button) _nav_view.findViewById(R.id.now_button);
        _drawer_drawer_spacer_5 = (LinearLayout) _nav_view.findViewById(R.id.drawer_spacer_5);
        _drawer_call_button = (Button) _nav_view.findViewById(R.id.call_button);
        _drawer_drawer_spacer_6 = (LinearLayout) _nav_view.findViewById(R.id.drawer_spacer_6);
        _drawer_ds_button = (Button) _nav_view.findViewById(R.id.ds_button);
        _drawer_drawer_spacer_7 = (LinearLayout) _nav_view.findViewById(R.id.drawer_spacer_7);
        _drawer_drawer_spacer_8 = (LinearLayout) _nav_view.findViewById(R.id.drawer_spacer_8);
        _drawer_drawer_spacer_9 = (LinearLayout) _nav_view.findViewById(R.id.drawer_spacer_9);
        d = new AlertDialog.Builder(this);
        tts = new TextToSpeech(getApplicationContext(), null);

        _drawer_vpl_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _view) {
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.stundenplan24.de/20081762/vplan/"));
                startActivity(i);
            }
        });

        _drawer_ter_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _view) {
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://teamup.com/ks3i8oghh5fomj6inj"));
                startActivity(i);
            }
        });
        _drawer_bfp_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _view) {
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://gtsq.de/app/bus.html"));
                startActivity(i);
            }
        });

        _drawer_now_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _view) {
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://gtsq.de/app/aktuell.html"));
                startActivity(i);
            }
        });

        _drawer_call_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _view) {
                d.setTitle(getString(R.string.txt_dialog_title));
                d.setMessage(getString(R.string.txt_call_dialog_text));
                d.setPositiveButton(getString(R.string.txt_call_dialog_yes), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface _dialog, int _which) {
                        i.setAction(Intent.ACTION_DIAL);
                        i.setData(Uri.parse("tel:03477128698"));
                        startActivity(i);
                    }
                });
                d.setNegativeButton(getString(R.string.txt_calL_dialog_no), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface _dialog, int _which) {

                    }
                });
                d.create().show();
            }
        });

        _drawer_ds_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _view) {
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://gtsq.de/dsgvo.pdf"));
                startActivity(i);
            }
        });
    }
    private void initializeLogic() {
    }

    @Override
    protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
        super.onActivityResult(_requestCode, _resultCode, _data);

        switch (_requestCode) {

            default:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (_drawer.isDrawerOpen(GravityCompat.START)) {
            _drawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }
    @Deprecated
    public void showMessage(String _s) {
        Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
    }

    @Deprecated
    public int getLocationX(View _v) {
        int _location[] = new int[2];
        _v.getLocationInWindow(_location);
        return _location[0];
    }

    @Deprecated
    public int getLocationY(View _v) {
        int _location[] = new int[2];
        _v.getLocationInWindow(_location);
        return _location[1];
    }

    @Deprecated
    public int getRandom(int _min, int _max) {
        Random random = new Random();
        return random.nextInt(_max - _min + 1) + _min;
    }

    @Deprecated
    public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
        ArrayList<Double> _result = new ArrayList<Double>();
        SparseBooleanArray _arr = _list.getCheckedItemPositions();
        for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
            if (_arr.valueAt(_iIdx))
                _result.add((double)_arr.keyAt(_iIdx));
        }
        return _result;
    }

    @Deprecated
    public float getDip(int _input){
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
    }

    @Deprecated
    public int getDisplayWidthPixels(){
        return getResources().getDisplayMetrics().widthPixels;
    }

    @Deprecated
    public int getDisplayHeightPixels(){
        return getResources().getDisplayMetrics().heightPixels;
    }

}
