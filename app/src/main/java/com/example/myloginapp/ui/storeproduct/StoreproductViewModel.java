package com.example.myloginapp.ui.storeproduct;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class StoreproductViewModel extends ViewModel {

  private final MutableLiveData<String> mText;

  public StoreproductViewModel() {
    mText = new MutableLiveData<>();
    mText.setValue("This is home fragment");
  }

  public LiveData<String> getText() {
    return mText;
  }
}
