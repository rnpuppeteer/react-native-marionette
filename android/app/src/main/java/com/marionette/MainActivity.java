package com.marionette;

import com.facebook.react.ReactActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends ReactActivity {
  private static final String TAG = "com.marionette";

  /**
   * Returns the name of the main component registered from JavaScript. This is
   * used to schedule rendering of the component.
   */
  @Override
  protected String getMainComponentName() {
    return "marionette";
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Log.d(TAG, "[LOG] MainActivity onCreate()\n");
  }
}
