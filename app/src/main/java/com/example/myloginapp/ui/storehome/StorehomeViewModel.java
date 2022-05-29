package com.example.myloginapp.ui.storehome;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class StorehomeViewModel extends ViewModel {
  private final MutableLiveData<String> mText;

  public StorehomeViewModel() {
    mText = new MutableLiveData<>();
    mText.setValue("This is home fragment");
  }

  public LiveData<String> getText() {
    return mText;
  }
}
