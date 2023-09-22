package com.example.fragmente_demo_app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class Fragment_one extends Fragment {

    private static EditText editTextFirstFragment;
    FirstFragmentListener objCallbackListener;

    public interface FirstFragmentListener{
        public void onButtonClicked(String text);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View fragmentOneView = inflater.inflate(R.layout.fragment_one,container, false); //inflate this fragment

        editTextFirstFragment = (EditText) fragmentOneView.findViewById(R.id.editTextText);
        final Button button = (Button) fragmentOneView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                firstFragmentButtonClicked(v);
            }
        }
        );
        return fragmentOneView;
    }
    public void firstFragmentButtonClicked(View view){
objCallbackListener.onButtonClicked(editTextFirstFragment.getText().toString());
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try{
            objCallbackListener = (FirstFragmentListener) context;

        }catch(ClassCastException e){
            throw new ClassCastException(context.toString());
        }
    }
}
