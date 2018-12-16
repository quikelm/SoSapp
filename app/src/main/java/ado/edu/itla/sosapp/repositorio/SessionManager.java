package ado.edu.itla.sosapp.repositorio;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SessionManager {

    private SharedPreferences prefs;

    public SessionManager(Context context) {
        prefs = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void set(String key,String value) {
        prefs.edit().putString(key, value).commit();
    }

    public String get(String key) {
        String value = prefs.getString(key,"");
        return value;
    }
}

