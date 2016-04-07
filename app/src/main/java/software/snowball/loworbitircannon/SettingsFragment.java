package software.snowball.loworbitircannon;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by Alec on 4/5/2016.
 */
public class SettingsFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.pref_general);
    }

}
