package software.snowball.loworbitircannon;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Alec on 4/14/2016.
 */
public class ListCommands extends AppCompatActivity {

    String[] projectorList = {"Power On", "Power Off", "Input", "Volume +", "Volume -", "Zoom +", "Zoom -", "Focus +",
            "Focus -", "Brightness +", "Brightness -", "Stress Test", "Image Stabilize", "Page Up", "Page Down", "Page Left", "Page Right"};

    Toolbar toolbar;
    ListView listView;

    private int delayTime;
    private boolean delay;

    IRUtil irUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stealth);

        toolbar = (Toolbar) findViewById(R.id.stealth_toolbar);
        setSupportActionBar(toolbar);

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.list_textview, projectorList);

        listView = (ListView) findViewById(R.id.command_list);
        listView.setAdapter(adapter);

        irUtil = new IRUtil(getApplicationContext());

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemClicked = parent.getItemAtPosition(position).toString();

                if(delay) {
                    runDelay();
                }

                switch(itemClicked) {
                    case "Power On":
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                if (delay) {
                                    runDelay();
                                }
                                irUtil.powerOn();
                            }
                        }).start();
                    case "Power Off":
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                if (delay) {
                                    runDelay();
                                }
                                irUtil.powerOff();
                            }
                        }).start();
                    case "Input":
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                if (delay) {
                                    runDelay();
                                }
                                irUtil.input();
                            }
                        }).start();
                    case "Volume +":
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                if (delay) {
                                    runDelay();
                                }
                                irUtil.volUp();
                            }
                        }).start();
                    case "Volume -":
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                if (delay) {
                                    runDelay();
                                }
                                irUtil.volDown();
                            }
                        }).start();
                    case "Zoom +":
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                if (delay) {
                                    runDelay();
                                }
                                irUtil.zoomP();
                            }
                        }).start();
                    case "Zoom -":
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                if (delay) {
                                    runDelay();
                                }
                                irUtil.zoomM();
                            }
                        }).start();
                    case "Focus +":
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                if (delay) {
                                    runDelay();
                                }
                                irUtil.focusP();
                            }
                        }).start();
                    case "Focus -":
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                if (delay) {
                                    runDelay();
                                }
                                irUtil.focusM();
                            }
                        }).start();
                    case "Brightness +":
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                if (delay) {
                                    runDelay();
                                }
                                irUtil.brightnessP();
                            }
                        }).start();
                    case "Brightness -":
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                if (delay) {
                                    runDelay();
                                }
                                irUtil.brightnessM();
                            }
                        }).start();
                    case "Stress Test":
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                if (delay) {
                                    runDelay();
                                }
                                irUtil.rapidMode();
                            }
                        }).start();
                    case "Image Stabilize":
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                if (delay) {
                                    runDelay();
                                }
                                irUtil.springMode();
                            }
                        }).start();
                    case "Page Up":
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                if (delay) {
                                    runDelay();
                                }
                                irUtil.up();
                            }
                        }).start();
                    case "Page Down":
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                if (delay) {
                                    runDelay();
                                }
                                irUtil.down();
                            }
                        }).start();
                    case "Page Left":
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                if (delay) {
                                    runDelay();
                                }
                                irUtil.left();
                            }
                        }).start();
                    case "Page Right":
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                if (delay) {
                                    runDelay();
                                }
                                irUtil.right();
                            }
                        }).start();
                    default:
                        break;
                }
            }
        });
    }

    private void runDelay() {
        try {
            Thread.sleep(delayTime * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_about:
                Intent about = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(about);
                return true;
            case R.id.action_settings:
                Intent settings = new Intent(getApplicationContext(), SettingsActivity.class);
                startActivity(settings);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //about and settings options on toolbar
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        //set if there is a delay or not
        boolean defaultEnableDelay = getResources().getBoolean(R.bool.toggle_delay_switch);
        boolean enableDelay = preferences.getBoolean("toggle_delay_switch", defaultEnableDelay);
        this.delay = enableDelay;

        //set time of delay based on preferences
        String defaultDelayTime = getResources().getString(R.string.delay_time);
        String strDelayTime = preferences.getString("delay_time", defaultDelayTime);
        this.delayTime = Integer.valueOf(strDelayTime);

        //set brand of device
        String defaultBrandName = getResources().getString(R.string.pref_general_brand);
        String brandName = preferences.getString("brand", defaultBrandName);
        irUtil.setCurBrand(brandName);

        //set type of device
        String defaultDeviceType = getResources().getString(R.string.pref_general_device);
        String deviceType = preferences.getString("device", defaultDeviceType);
        irUtil.setDeviceType(deviceType);

        //set app theme
        String defaultTheme = getResources().getString(R.string.pref_general_theme);
        String theme = preferences.getString("theme", defaultTheme);

        if(theme.equals("REMOTE")) {
            finish();
            Intent main = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(main);
        }
    }
}