package com.example.materialdesignapp.activities;

import android.os.Bundle;

public interface ActionListenerInterface {

   String keyForActionValue = "first key";
   int ACTION_KEY = 1;

   String getKeyForStringValue = "cursing word";

   void onCallbackListener(Bundle bundle);
}
