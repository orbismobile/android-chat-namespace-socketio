package com.osp.projects.androidchatsocketioio.ui.fragment.adduser;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.osp.projects.androidchatsocketioio.R;
import com.osp.projects.androidchatsocketioio.persistence.MySharedPreference;

/**
 * Created by Carlos Leonardo Camilo Vargas Huamán on 11/04/17.
 *
 *
 */

public class AddUserDialogFragment extends DialogFragment implements View.OnClickListener, AddUserView{

    EditText txtAddUser;
    Button btnAddUser;

    String errorMessage;
    String screenName;

    private AddUserPresenter addUserPresenter;
    private MySharedPreference mySharedPreference;

    public static AddUserDialogFragment newInstance(String bodyMessage, String screenName) {
        AddUserDialogFragment frag = new AddUserDialogFragment();
        Bundle args = new Bundle();
        args.putString("bodyMessage", bodyMessage);
        args.putString("screenName", screenName);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        errorMessage = getArguments().getString("bodyMessage");
        screenName = getArguments().getString("screenName");
        addUserPresenter = new AddUserPresenterImpl(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dialog_adduser, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtAddUser = (EditText) view.findViewById(R.id.txtAddUser);
        btnAddUser = (Button) view.findViewById(R.id.btnAddUser);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        mySharedPreference = new MySharedPreference(getActivity());
        txtAddUser.setText(errorMessage);
        btnAddUser.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAddUser:
                addUserPresenter.validateAddUser(mySharedPreference.getUser().getUserId(), 5);
                Toast.makeText(getActivity(), "carlos", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
