package com.example.analizapp.dialogFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.analizapp.R;

public class ReminderTimeDialog extends DialogFragment {

    public static String TAG = "Reminder Set Time Dialog";

    public interface ReminderTimeDialogListener {
        void plusHourClicked();
        void minusHourClicked();
        void plusMinuteClicked();
        void minusMinuteClicked();
    }

    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.dialog_fragment_reminder_time, container, false);
    }
}
