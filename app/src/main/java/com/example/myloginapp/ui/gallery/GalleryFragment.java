package com.example.myloginapp.ui.gallery;

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

import com.example.myloginapp.DeliverItem;
import com.example.myloginapp.DeliverItemAdapter;
import com.example.myloginapp.ManagerDeliverinfoActivity;
import com.example.myloginapp.ManagerMemberinfoActivity;
import com.example.myloginapp.MemberItem;
import com.example.myloginapp.MemberItemAdapter;
import com.example.myloginapp.R;
import com.example.myloginapp.databinding.FragmentGalleryBinding;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {

  ArrayList<DeliverItem> arrayList = new ArrayList<>();
  DeliverItemAdapter deliverItemAdapter;
  int index;
  private FragmentGalleryBinding binding;
  Context context;

  public View onCreateView(@NonNull LayoutInflater inflater,
                           ViewGroup container, Bundle savedInstanceState) {
    GalleryViewModel galleryViewModel =
            new ViewModelProvider(this).get(GalleryViewModel.class);
    context = container.getContext();
    binding = FragmentGalleryBinding.inflate(inflater, container, false);
    View root = binding.getRoot();
    ListView lv = root.findViewById(R.id.maneger_manege_deliiver_lv);

    arrayList.add(new DeliverItem(R.drawable.icon_headimg, "Andy Hung", "X079800"));
    arrayList.add(new DeliverItem(R.drawable.icon_headimg, "Wendy Tsai", "X323232"));
    arrayList.add(new DeliverItem(R.drawable.icon_headimg, "Sandy Wang", "X829311"));
    arrayList.add(new DeliverItem(R.drawable.icon_headimg, "Cindy Chen", "X432154"));
    arrayList.add(new DeliverItem(R.drawable.icon_headimg, "Aden Ko", "X987654"));

    deliverItemAdapter = new DeliverItemAdapter(context, R.layout.manager_manage_member_layout, arrayList);
    lv.setAdapter(deliverItemAdapter);
    lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        index = i;
        Intent intent = new Intent();
        intent.setClass(context, ManagerDeliverinfoActivity.class);
        intent.putExtra("IMG", arrayList.get(i).getImg());
        intent.putExtra("NAME", arrayList.get(i).getName());
        intent.putExtra("ID", arrayList.get(i).getId());
        startActivityForResult(intent,i);

      }
    });
    //final TextView textView = binding.textGallery;
    //galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
    return root;
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    binding = null;
  }

}