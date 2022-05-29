package com.example.myloginapp.ui.storeaccount;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class StoreaccountViewModel extends ViewModel {
  private final MutableLiveData<String> mText;

  public StoreaccountViewModel() {
    mText = new MutableLiveData<>();
    mText.setValue("This is home fragment");
  }

  public LiveData<String> getText() {
    return mText;
  }

}
