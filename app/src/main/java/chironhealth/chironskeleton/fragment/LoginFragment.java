package chironhealth.chironskeleton.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import chironhealth.chironskeleton.R;
import chironhealth.chironskeleton.activity.NavDrawerActivity;

/**
 * Created by SamMyxer on 10/14/15.
 */
public class LoginFragment extends Fragment {

    ImageView chironLogoIV;
    EditText emailET;
    Button continueBT;


    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);

        chironLogoIV = (ImageView) rootView.findViewById(R.id.fragment_login_logo_iv);
        emailET = (EditText) rootView.findViewById(R.id.fragment_login_email_et);
        continueBT = (Button) rootView.findViewById(R.id.fragment_login_continue_bt);

        continueBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(emailET.getText().toString())) {
                    launchCenteredToast(getString(R.string.enter_email));
                } else {
                    intentToNavDrawer();
                }
            }
        });

        return rootView;
    }


    public void intentToNavDrawer() {
        Intent navIntent = new Intent(getActivity(), NavDrawerActivity.class);
        startActivity(navIntent);
    }

    public void launchCenteredToast(String message) {
        Toast toast = Toast.makeText(getActivity(), message, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}
