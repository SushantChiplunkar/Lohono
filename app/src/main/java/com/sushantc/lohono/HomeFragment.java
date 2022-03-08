package com.sushantc.lohono;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.sushantc.lohono.databinding.HomeLayoutBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private HomeLayoutBinding binding;
    private MyListAdapter adapter;
    private List<CustomData> sampleData;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new MyListAdapter();
        uploadData();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.home_layout,container,false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.homeList.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        binding.homeList.setAdapter(adapter);
        adapter.submitList(sampleData);
        if (adapter !=null) {
            adapter.submitList(sampleData);
        }

    }

    private void uploadData(){
        sampleData = new ArrayList<>();
        sampleData.add(new CustomData(getString(R.string.hf_t1), getString(R.string.hf_desc_1)));
        sampleData.add(new CustomData(getString(R.string.hf_t2),getString(R.string.hf_desc_2)));
        sampleData.add(new CustomData(getString(R.string.hf_t3),getString(R.string.hf_desc_3)));


    }
}
