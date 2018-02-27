package com.thebaileybrew.www.udacitycard;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    boolean showSheetOne = true;
    boolean showSheetTwo = true;
    boolean showSheetThree = true;
    boolean showSheetFour = true;
    View bottomSheet;
    View bottomSheet2;
    View bottomSheet3;
    View bottomSheet4;
    TextView headerText;
    TextView headerText2;
    TextView headerText3;
    TextView headerText4;
    ImageView mainLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainLogo = findViewById(R.id.main_udacity_logo);
        bottomSheet = findViewById(R.id.design_bottom_sheet);
        bottomSheet2 = findViewById(R.id.design_bottom_sheet_two);
        bottomSheet3 = findViewById(R.id.design_bottom_sheet_three);
        bottomSheet4 = findViewById(R.id.design_bottom_sheet_four);
        headerText = findViewById(R.id.sheet_one_header);
        headerText2 = findViewById(R.id.sheet_two_header);
        headerText3 = findViewById(R.id.sheet_three_header);
        headerText4 = findViewById(R.id.sheet_four_header);

        //Programming to define BottomSheet Movement (Bottom Sheet)
        final BottomSheetBehavior behavior = BottomSheetBehavior.from(bottomSheet);
        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_DRAGGING:
                        //Add LOGIC here
                        Log.i("BottomSheetCallback","BottomSheetBehavior.STATE_DRAGGING");
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        //Add LOGIC here
                        Log.i("BottomSheetCallback","BottomSheetBehavior.STATE_SETTLING");
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED:
                        //Add LOGIC here
                        mainLogo.setBackground(getResources().getDrawable(R.drawable.udacity_logo_side_crop));
                        headerText.setTextAppearance(R.style.HiddenSheet_Headers_Expanded);
                        Log.i("BottomSheetCallback","BottomSheetBehavior.STATE_EXPANDED");
                        break;
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        //Add LOGIC here
                        mainLogo.setBackground(getResources().getDrawable(R.drawable.udacity_logo_crop));
                        headerText.setTextAppearance(R.style.HiddenSheet_Headers);
                        Log.i("BottomSheetCallback","BottomSheetBehavior.STATE_COLLAPSED");
                        break;
                    case BottomSheetBehavior.STATE_HIDDEN:
                        //Add LOGIC here
                        Log.i("BottomSheetCallback","BottomSheetBehavior.STATE_HIDDEN");
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                //Add LOGIC here
                Log.i("BottomSheetCallback", "slideOffset: " + slideOffset);
            }
        });

        //Programming to define BottomSheet Movement (Third Sheet)
        final BottomSheetBehavior behavior2 = BottomSheetBehavior.from(bottomSheet2);
        behavior2.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onStateChanged(@NonNull View bottomSheet2, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_DRAGGING:
                        //Add LOGIC here
                        Log.i("BottomSheetCallback","BottomSheetBehavior.STATE_DRAGGING");
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        //Add LOGIC here
                        Log.i("BottomSheetCallback","BottomSheetBehavior.STATE_SETTLING");
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED:
                        //Add LOGIC here
                        headerText2.setTextAppearance(R.style.HiddenSheet_Headers_Expanded);
                        Log.i("BottomSheetCallback","BottomSheetBehavior.STATE_EXPANDED");
                        break;
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        //Add LOGIC here
                        headerText2.setTextAppearance(R.style.HiddenSheet_Headers);
                        Log.i("BottomSheetCallback","BottomSheetBehavior.STATE_COLLAPSED");
                        break;
                    case BottomSheetBehavior.STATE_HIDDEN:
                        //Add LOGIC here
                        Log.i("BottomSheetCallback","BottomSheetBehavior.STATE_HIDDEN");
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet2, float slideOffset) {
                //Add LOGIC here
                Log.i("BottomSheetCallback", "slideOffset: " + slideOffset);
            }
        });


        //Programming to define BottomSheet Movement (2nd Sheet)
        final BottomSheetBehavior behavior3 = BottomSheetBehavior.from(bottomSheet3);
        behavior3.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onStateChanged(@NonNull View bottomSheet3, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_DRAGGING:
                        //Add LOGIC here
                        Log.i("BottomSheetCallback","BottomSheetBehavior.STATE_DRAGGING");
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        //Add LOGIC here
                        Log.i("BottomSheetCallback","BottomSheetBehavior.STATE_SETTLING");
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED:
                        //Add LOGIC here
                        headerText3.setTextAppearance(R.style.HiddenSheet_Headers_Expanded);
                        Log.i("BottomSheetCallback","BottomSheetBehavior.STATE_EXPANDED");
                        break;
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        //Add LOGIC here
                        headerText3.setTextAppearance(R.style.HiddenSheet_Headers);
                        Log.i("BottomSheetCallback","BottomSheetBehavior.STATE_COLLAPSED");
                        break;
                    case BottomSheetBehavior.STATE_HIDDEN:
                        //Add LOGIC here
                        Log.i("BottomSheetCallback","BottomSheetBehavior.STATE_HIDDEN");
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet3, float slideOffset) {
                //Add LOGIC here
                Log.i("BottomSheetCallback", "slideOffset: " + slideOffset);
            }
        });


        //Programming to define BottomSheet Movement (Top Sheet)
        final BottomSheetBehavior behavior4 = BottomSheetBehavior.from(bottomSheet4);
        behavior4.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onStateChanged(@NonNull View bottomSheet4, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_DRAGGING:
                        //Add LOGIC here
                        Log.i("BottomSheetCallback","BottomSheetBehavior.STATE_DRAGGING");
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        //Add LOGIC here
                        Log.i("BottomSheetCallback","BottomSheetBehavior.STATE_SETTLING");
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED:
                        //Add LOGIC here
                        headerText4.setTextAppearance(R.style.HiddenSheet_Headers_Expanded);
                        Log.i("BottomSheetCallback","BottomSheetBehavior.STATE_EXPANDED");
                        break;
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        //Add LOGIC here
                        headerText4.setTextAppearance(R.style.HiddenSheet_Headers);
                        Log.i("BottomSheetCallback","BottomSheetBehavior.STATE_COLLAPSED");
                        break;
                    case BottomSheetBehavior.STATE_HIDDEN:
                        //Add LOGIC here
                        Log.i("BottomSheetCallback","BottomSheetBehavior.STATE_HIDDEN");
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet4, float slideOffset) {
                //Add LOGIC here
                Log.i("BottomSheetCallback", "slideOffset: " + slideOffset);
            }
        });

    }

    public void onClickOpenSheetOne(View view) {
        final BottomSheetBehavior behavior = BottomSheetBehavior.from(bottomSheet);
        final BottomSheetBehavior behavior2 = BottomSheetBehavior.from(bottomSheet2);
        final BottomSheetBehavior behavior3 = BottomSheetBehavior.from(bottomSheet3);
        final BottomSheetBehavior behavior4 = BottomSheetBehavior.from(bottomSheet4);
        if (showSheetOne) {
            behavior4.setState(BottomSheetBehavior.STATE_EXPANDED);
            behavior3.setState(BottomSheetBehavior.STATE_EXPANDED);
            behavior2.setState(BottomSheetBehavior.STATE_EXPANDED);
            behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            showSheetOne = false;
        } else {
            behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            showSheetOne = true;
        }
    }

    public void onClickOpenSheetTwo(View view) {
        final BottomSheetBehavior behavior = BottomSheetBehavior.from(bottomSheet);
        final BottomSheetBehavior behavior2 = BottomSheetBehavior.from(bottomSheet2);
        final BottomSheetBehavior behavior3 = BottomSheetBehavior.from(bottomSheet3);
        final BottomSheetBehavior behavior4 = BottomSheetBehavior.from(bottomSheet4);
        if (showSheetTwo) {
            behavior4.setState(BottomSheetBehavior.STATE_EXPANDED);
            behavior3.setState(BottomSheetBehavior.STATE_EXPANDED);
            behavior2.setState(BottomSheetBehavior.STATE_EXPANDED);
            showSheetTwo = false;
        } else {
            behavior2.setState(BottomSheetBehavior.STATE_COLLAPSED);
            behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            showSheetTwo = true;
        }
    }

    public void onClickOpenSheetThree(View view) {
        final BottomSheetBehavior behavior = BottomSheetBehavior.from(bottomSheet);
        final BottomSheetBehavior behavior2 = BottomSheetBehavior.from(bottomSheet2);
        final BottomSheetBehavior behavior3 = BottomSheetBehavior.from(bottomSheet3);
        final BottomSheetBehavior behavior4 = BottomSheetBehavior.from(bottomSheet4);
        if (showSheetThree) {
            behavior4.setState(BottomSheetBehavior.STATE_EXPANDED);
            behavior3.setState(BottomSheetBehavior.STATE_EXPANDED);
            showSheetThree = false;
        } else {
            behavior3.setState(BottomSheetBehavior.STATE_COLLAPSED);
            behavior2.setState(BottomSheetBehavior.STATE_COLLAPSED);
            behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            showSheetThree = true;
        }
    }

    public void onClickOpenSheetFour(View view) {
        final BottomSheetBehavior behavior = BottomSheetBehavior.from(bottomSheet);
        final BottomSheetBehavior behavior2 = BottomSheetBehavior.from(bottomSheet2);
        final BottomSheetBehavior behavior3 = BottomSheetBehavior.from(bottomSheet3);
        final BottomSheetBehavior behavior4 = BottomSheetBehavior.from(bottomSheet4);
        if (showSheetFour) {
            behavior4.setState(BottomSheetBehavior.STATE_EXPANDED);
            showSheetFour = false;
        } else {
            behavior4.setState(BottomSheetBehavior.STATE_COLLAPSED);
            behavior3.setState(BottomSheetBehavior.STATE_COLLAPSED);
            behavior2.setState(BottomSheetBehavior.STATE_COLLAPSED);
            behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            showSheetFour = true;
        }

    }

}
