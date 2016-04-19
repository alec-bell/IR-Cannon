package software.snowball.loworbitircannon;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.hardware.ConsumerIrManager;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ConsumerIrManager ir;
    IRUtil irUtil;

    private boolean isOn;

    private int delayTime;
    private boolean delay;

    Toolbar toolbar;
    Button power;
    Button video;
    Button picmute; //mutes picture
    Button focusp; //focus in
    Button focusm; //focus out
    Button brightnessp; //raise brightness
    Button brightnessm; //lower brightness
    Button zoomp;
    Button zoomm;
    Button rapid;
    Button spring;
    Button select;
    Button up;
    Button down;
    Button left;
    Button right;
    Button volUp;
    Button volDown;

    TextView brand;
    TextView textDelay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set up toolbar
        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        irUtil = new IRUtil(getApplicationContext());

        //set up remote description
        brand = (TextView) findViewById(R.id.tvBrand);
        setRemoteDescription();

        //set up delay description
        textDelay = (TextView) findViewById(R.id.delay);
        textDelay.setTypeface(null, Typeface.ITALIC);
        setDelayDescription();

        //device is assumed to be off when remote is opened
        isOn = false;

        //delay is off on startup
        delay = false;
        delayTime = 0;

        //initializing objects
        power = (Button) findViewById(R.id.btnPower);
        video = (Button) findViewById(R.id.btnInput);
        picmute = (Button) findViewById(R.id.btnPicMute);
        focusp = (Button) findViewById(R.id.btnFocusP);
        focusm = (Button) findViewById(R.id.btnFocusM);
        brightnessp = (Button) findViewById(R.id.btnBrightnessp);
        brightnessm = (Button) findViewById(R.id.btnBrightnessm);
        zoomp = (Button) findViewById(R.id.btnZoomp);
        zoomm = (Button) findViewById(R.id.btnZoomm);
        rapid = (Button) findViewById(R.id.btnRapid);
        spring = (Button) findViewById(R.id.btnSpring);
        select = (Button) findViewById(R.id.btnOK);
        up = (Button) findViewById(R.id.btnPageUp);
        down = (Button) findViewById(R.id.btnPageDown);
        left = (Button) findViewById(R.id.btnPageLeft);
        right = (Button) findViewById(R.id.btnPageRight);
        volUp = (Button) findViewById(R.id.btnVolumeUp);
        volDown = (Button) findViewById(R.id.btnVolumeDown);

        //setting listeners to handle clicking
        power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if(isOn) {
                            if(delay) {
                                //change button to orange to signify delay
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        power.setBackgroundColor(Color.rgb(255, 140, 0));
                                    }
                                });
                                runDelayNoColorChange();
                            }
                            irUtil.powerOff();
                            isOn = false;
                            //change button to green
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    power.setBackgroundColor(Color.rgb(20, 90, 50));
                                }
                            });
                        } else {
                            if(delay) {
                                //change button to light green to signify delay
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        power.setBackgroundColor(Color.rgb(60, 179, 113));
                                    }
                                });
                                runDelayNoColorChange();
                            }
                            irUtil.powerOn();
                            isOn = true;
                            //change button to red
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    power.setBackgroundColor(Color.rgb(146, 43, 33));
                                }
                            });
                        }
                    }
                }).start();
            }
        });
        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if (delay) {
                            runDelay(video);
                        }
                        irUtil.input();
                    }
                }).start();
            }
        });
        picmute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if (delay) {
                            runDelay(picmute);
                        }
                        irUtil.pictureMute();
                    }
                }).start();
            }
        });
        focusp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if (delay) {
                            runDelay(focusp);
                        }
                        irUtil.focusP();
                    }
                }).start();
            }
        });
        focusm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if (delay) {
                            runDelay(focusm);
                        }
                        irUtil.focusM();
                    }
                }).start();
            }
        });
        brightnessp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if (delay) {
                            runDelay(brightnessp);
                        }
                        irUtil.brightnessP();
                    }
                }).start();
            }
        });
        brightnessm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if (delay) {
                            runDelay(brightnessm);
                        }
                        irUtil.brightnessM();
                    }
                }).start();
            }
        });
        zoomp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if (delay) {
                            runDelay(zoomp);
                        }
                        irUtil.zoomP();
                    }
                }).start();
            }
        });
        zoomm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if (delay) {
                            runDelay(zoomm);
                        }
                        irUtil.zoomM();
                    }
                }).start();
            }
        });
        rapid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if (delay) {
                            runDelay(rapid);
                        }
                        irUtil.rapidMode();
                    }
                }).start();
            }
        });
        spring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if (delay) {
                            runDelay(spring);
                        }
                        irUtil.springMode();
                    }
                }).start();
            }
        });
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if (delay) {
                            runDelay(select);
                        }
                        irUtil.select();
                    }
                }).start();
            }
        });
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if (delay) {
                            runDelay(up);
                        }
                        irUtil.up();
                    }
                }).start();
            }
        });
        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if (delay) {
                            runDelay(down);
                        }
                        irUtil.down();
                    }
                }).start();
            }
        });
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if (delay) {
                            runDelay(left);
                        }
                        irUtil.left();
                    }
                }).start();
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if (delay) {
                            runDelay(right);
                        }
                        irUtil.right();
                    }
                }).start();
            }
        });
        volUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if (delay) {
                            runDelay(volUp);
                        }
                        irUtil.volUp();
                    }
                }).start();
            }
        });
        volDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if (delay) {
                            runDelay(volDown);
                        }
                        irUtil.volDown();
                    }
                }).start();
            }
        });
    }

    private void setRemoteDescription() {
        brand.setText(irUtil.getCurBrand() + " " + irUtil.getDeviceType() + " REMOTE");
    }

    private void setDelayDescription() {
        if (delay) {
            textDelay.setText("DELAY FOR " + delayTime + " SECONDS");
        } else {
            textDelay.setText("NO DELAY");
        }
    }

    private void runDelay(final Button b) {
        //time in milliseconds
        try {
            //set button background to yellow
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    b.setBackgroundColor(Color.rgb(230, 184, 0));
                }
            });

            Thread.sleep(delayTime * 1000);

            //set button background back to gray
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    b.setBackgroundColor(Color.rgb(52, 73, 94));
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void runDelayNoColorChange() {
        try {
            Thread.sleep(delayTime * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //about and settings options on toolbar
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
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
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
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
        if(theme.equals("STEALTH")) {
            finish();
            Intent stealth = new Intent(getApplicationContext(), ListCommands.class);
            startActivity(stealth);
        } else {
            setDelayDescription();
            setRemoteDescription();
        }
    }
}
