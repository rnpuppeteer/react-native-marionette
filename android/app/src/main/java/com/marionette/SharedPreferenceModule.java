package com.marionette;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.uimanager.IllegalViewOperationException;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import java.util.Map;

public class SharedPreferenceModule extends ReactContextBaseJavaModule {

  public SharedPreferenceModule(ReactApplicationContext reactContext) {
    super(reactContext);
  }

  @Override
  public String getName() {
    return "SharedPreference";
  }

  @ReactMethod
  public void showAll(Callback errorCallback, Callback successCallback) {
    try {
      SharedPreferences preference = getCurrentActivity().getSharedPreferences("com.marionette_preferences",
          Context.MODE_PRIVATE);
      Map<String, ?> prefs = preference.getAll();

      String list = "";
      for (Map.Entry entry : prefs.entrySet()) {
        list += entry.getKey().toString() + ": " + entry.getValue().toString() + " \n";
      }
      Toast.makeText(getReactApplicationContext(), list, Toast.LENGTH_LONG).show();
      successCallback.invoke("SharedPreferences showAll... " + Integer.toString(prefs.size()));
    } catch (IllegalViewOperationException e) {
      errorCallback.invoke(e.getMessage());
    }
  }

  @ReactMethod
  public void set(String key, String value, Callback errorCallback, Callback successCallback) {
    try {
      SharedPreferences preference = getCurrentActivity()
          .getSharedPreferences(getCurrentActivity().getPackageName() + "_preferences", Context.MODE_PRIVATE);
      SharedPreferences.Editor editor = preference.edit();
      editor.putString(key, value).apply();
      editor.commit();

      Toast.makeText(getReactApplicationContext(), value, Toast.LENGTH_SHORT).show();

      successCallback.invoke("SharedPreferences set... key: " + key + " value:" + value);
    } catch (IllegalViewOperationException e) {
      errorCallback.invoke(e.getMessage());
    }
  }

  @ReactMethod
  public void get(String key, Callback errorCallback, Callback successCallback) {
    try {
      SharedPreferences preference = getCurrentActivity()
          .getSharedPreferences(getCurrentActivity().getPackageName() + "_preferences", Context.MODE_PRIVATE);
      String value = preference.getString(key, "NOT FOUND");

      Toast.makeText(getReactApplicationContext(), value, Toast.LENGTH_LONG).show();

      successCallback.invoke("SharedPreferences get... value: " + value);
    } catch (IllegalViewOperationException e) {
      errorCallback.invoke(e.getMessage());
    }
  }
}