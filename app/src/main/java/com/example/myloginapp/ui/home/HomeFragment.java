package com.example.myloginapp.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myloginapp.ManagerMemberinfoActivity;
import com.example.myloginapp.MemberItem;
import com.example.myloginapp.MemberItemAdapter;
import com.example.myloginapp.R;
import com.example.myloginapp.StoreProductActivity;
import com.example.myloginapp.StoreProductEdit;
import com.example.myloginapp.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

  ArrayList<MemberItem> arrayList = new ArrayList<>();
  MemberItemAdapter memberItemAdapter;
  int index;
  private FragmentHomeBinding binding;
  Context context;

  public View onCreateView(@NonNull LayoutInflater inflater,
                           ViewGroup container, Bundle savedInstanceState) {
    HomeViewModel homeViewModel =
            new ViewModelProvider(this).get(HomeViewModel.class);
    context = container.getContext();
    binding = FragmentHomeBinding.inflate(inflater, container, false);
    View root = binding.getRoot();
    ListView lv = root.findViewById(R.id.maneger_manege_member_lv);

    arrayList.add(new MemberItem(R.drawable.icon_headimg, "Wendy Tsai", "X323232"));
    arrayList.add(new MemberItem(R.drawable.icon_headimg, "Sandy Wang", "X829311"));
    arrayList.add(new MemberItem(R.drawable.icon_headimg, "Cindy Chen", "X432154"));
    arrayList.add(new MemberItem(R.drawable.icon_headimg, "Aden Ko", "X987654"));

    memberItemAdapter = new MemberItemAdapter(context, R.layout.manager_manage_member_layout, arrayList);
    lv.setAdapter(memberItemAdapter);
    lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        index = i;
        Intent intent = new Intent();
        intent.setClass(context, ManagerMemberinfoActivity.class);
        intent.putExtra("IMG", arrayList.get(i).getImg());
        intent.putExtra("NAME", arrayList.get(i).getName());
        intent.putExtra("ID", arrayList.get(i).getId());
        startActivityForResult(intent,i);

      }
    });


    //final TextView textView = binding.textHome;
    //homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
    return root;
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    binding = null;
  }

  @Override
  public void onStop() {
    super.onStop();
    arrayList.clear();
  }//未測試
}