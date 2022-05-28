package com.example.myloginapp.ui.home;

import android.widget.ListView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myloginapp.MemberItem;
import com.example.myloginapp.MemberItemAdapter;

import java.util.ArrayList;

public class HomeViewModel extends ViewModel {


  private final MutableLiveData<String> mText;

  public HomeViewModel() {
    mText = new MutableLiveData<>();
    mText.setValue("This is home fragment");
  }
}
