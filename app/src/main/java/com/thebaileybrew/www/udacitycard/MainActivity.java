package com.thebaileybrew.www.udacitycard;

import android.annotation.SuppressLint;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.internal.TextScale;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.transition.Transition;
import android.support.transition.TransitionValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.transition.TransitionSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private ListView mListView;

    //boolean values state if sheet is expanded (true) or collapsed (false)
    boolean showSheetOne = false;
    boolean showSheetTwo = false;
    boolean showSheetThree = false;
    boolean showSheetFour = false;
    View bottomSheet;
    View bottomSheet2;
    View bottomSheet3;
    View bottomSheet4;
    TextView headerText;
    TextView headerText2;
    TextView headerText3;
    TextView headerText4;
    ImageView mainLogo;
    Animation fadein;
    Animation fadeout;
    TextView courseDetails;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        courseDetails = findViewById(R.id.course_details_display);
        mainLogo = findViewById(R.id.main_udacity_logo);
        bottomSheet = findViewById(R.id.design_bottom_sheet);
        bottomSheet2 = findViewById(R.id.design_bottom_sheet_two);
        bottomSheet3 = findViewById(R.id.design_bottom_sheet_three);
        bottomSheet4 = findViewById(R.id.design_bottom_sheet_four);
        headerText = findViewById(R.id.sheet_one_header);
        headerText2 = findViewById(R.id.sheet_two_header);
        headerText3 = findViewById(R.id.sheet_three_header);
        headerText4 = findViewById(R.id.sheet_four_header);
        fadein = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        fadeout = AnimationUtils.loadAnimation(this,R.anim.fade_out);
        final BottomSheetBehavior behavior = BottomSheetBehavior.from(bottomSheet);
        final BottomSheetBehavior behavior2 = BottomSheetBehavior.from(bottomSheet2);
        final BottomSheetBehavior behavior3 = BottomSheetBehavior.from(bottomSheet3);
        final BottomSheetBehavior behavior4 = BottomSheetBehavior.from(bottomSheet4);

        //Programming to define BottomSheet Movement (Sheet ONE)
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
                        headerText.setTextAppearance(R.style.HiddenSheet_Headers_Expanded);
                        Log.i("BottomSheetCallback","BottomSheetBehavior.STATE_EXPANDED");
                        break;
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        //Add LOGIC here
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
                if (showSheetOne) {
                    mainLogo.setAnimation(fadeout);
                    fadeout.start();
                    mainLogo.setBackground(getResources().getDrawable(R.drawable.udacity_logo_side_crop));
                    mainLogo.setAnimation(fadein);
                    fadein.start();
                    showSheetOne = false;
                } else {
                    showSheetOne = true;
                }
                Log.i("BottomSheetCallback", "slideOffset: " + slideOffset);
            }
        });

        //Programming to define BottomSheet Movement (Sheet TWO)
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
                if (showSheetTwo) {
                    mainLogo.setAnimation(fadeout);
                    fadeout.start();
                    mainLogo.setBackground(getResources().getDrawable(R.drawable.udacity_logo_side_crop));
                    mainLogo.setAnimation(fadein);
                    fadein.start();
                    showSheetTwo = false;
                } else {
                    showSheetTwo = true;
                }
                Log.i("BottomSheetCallback", "slideOffset: " + slideOffset);
            }
        });


        //Programming to define BottomSheet Movement (Sheet THREE)
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
                if (showSheetThree) {
                    mainLogo.setAnimation(fadeout);
                    fadeout.start();
                    mainLogo.setBackground(getResources().getDrawable(R.drawable.udacity_logo_side_crop));
                    mainLogo.setAnimation(fadein);
                    fadein.start();
                    showSheetThree = false;
                } else {
                    showSheetThree = true;
                }
                Log.i("BottomSheetCallback", "slideOffset: " + slideOffset);
            }
        });


        //Programming to define BottomSheet Movement (Sheet FOUR)

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
                        headerText4.setAnimation(fadeout);
                        fadeout.start();
                        headerText4.setTextAppearance(R.style.HiddenSheet_Headers_Expanded);
                        headerText4.setText("LEARNING OPPORTUNITIES");
                        headerText4.setAnimation(fadein);
                        fadein.start();
                        break;
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        //Add LOGIC here
                        headerText4.setAnimation(fadeout);
                        fadeout.start();
                        headerText4.setTextAppearance(R.style.HiddenSheet_Headers);
                        headerText4.setText("WHAT CAN I LEARN?");
                        headerText4.setAnimation(fadein);
                        fadein.start();
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
                if (showSheetFour) {
                    headerText4.setText(" ");
                    mainLogo.setAnimation(fadeout);
                    fadeout.start();
                    mainLogo.setBackground(getResources().getDrawable(R.drawable.udacity_logo_side_crop));
                    mainLogo.setAnimation(fadein);
                    fadein.start();
                    showSheetFour = false;
                } else {
                    headerText4.setText(" ");
                    mainLogo.setAnimation(fadeout);
                    fadeout.start();
                    mainLogo.setBackground(getResources().getDrawable(R.drawable.udacity_logo_crop));
                    mainLogo.setAnimation(fadein);
                    fadein.start();
                    showSheetFour = true;
                }
                Log.i("BottomSheetCallback", "slideOffset: " + slideOffset);
            }
        });

    }

    public void onClickOpenSheetOne(View view) {
        final BottomSheetBehavior behavior = BottomSheetBehavior.from(bottomSheet);
        final BottomSheetBehavior behavior2 = BottomSheetBehavior.from(bottomSheet2);
        final BottomSheetBehavior behavior3 = BottomSheetBehavior.from(bottomSheet3);
        final BottomSheetBehavior behavior4 = BottomSheetBehavior.from(bottomSheet4);
        if (!showSheetOne) {
            behavior4.setState(BottomSheetBehavior.STATE_EXPANDED);
            behavior3.setState(BottomSheetBehavior.STATE_EXPANDED);
            behavior2.setState(BottomSheetBehavior.STATE_EXPANDED);
            behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            showSheetOne = true;
        } else {
            behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            showSheetOne = false;
        }
    }

    public void onClickOpenSheetTwo(View view) {
        final BottomSheetBehavior behavior = BottomSheetBehavior.from(bottomSheet);
        final BottomSheetBehavior behavior2 = BottomSheetBehavior.from(bottomSheet2);
        final BottomSheetBehavior behavior3 = BottomSheetBehavior.from(bottomSheet3);
        final BottomSheetBehavior behavior4 = BottomSheetBehavior.from(bottomSheet4);
        if (!showSheetTwo) {
            behavior4.setState(BottomSheetBehavior.STATE_EXPANDED);
            behavior3.setState(BottomSheetBehavior.STATE_EXPANDED);
            behavior2.setState(BottomSheetBehavior.STATE_EXPANDED);
            showSheetTwo = true;
        } else {
            behavior2.setState(BottomSheetBehavior.STATE_COLLAPSED);
            behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            showSheetTwo = false;
        }
    }

    public void onClickOpenSheetThree(View view) {
        final BottomSheetBehavior behavior = BottomSheetBehavior.from(bottomSheet);
        final BottomSheetBehavior behavior2 = BottomSheetBehavior.from(bottomSheet2);
        final BottomSheetBehavior behavior3 = BottomSheetBehavior.from(bottomSheet3);
        final BottomSheetBehavior behavior4 = BottomSheetBehavior.from(bottomSheet4);
        if (!showSheetThree) {
            behavior4.setState(BottomSheetBehavior.STATE_EXPANDED);
            behavior3.setState(BottomSheetBehavior.STATE_EXPANDED);
            showSheetThree = true;
        } else {
            behavior3.setState(BottomSheetBehavior.STATE_COLLAPSED);
            behavior2.setState(BottomSheetBehavior.STATE_COLLAPSED);
            behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            showSheetThree = false;
        }
    }

    public void onClickOpenSheetFour(View view) {
        final BottomSheetBehavior behavior = BottomSheetBehavior.from(bottomSheet);
        final BottomSheetBehavior behavior2 = BottomSheetBehavior.from(bottomSheet2);
        final BottomSheetBehavior behavior3 = BottomSheetBehavior.from(bottomSheet3);
        final BottomSheetBehavior behavior4 = BottomSheetBehavior.from(bottomSheet4);
        if (!showSheetFour) {
            behavior4.setState(BottomSheetBehavior.STATE_EXPANDED);
            showSheetFour = true;
        } else {
            behavior4.setState(BottomSheetBehavior.STATE_COLLAPSED);
            behavior3.setState(BottomSheetBehavior.STATE_COLLAPSED);
            behavior2.setState(BottomSheetBehavior.STATE_COLLAPSED);
            behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            showSheetFour = false;
        }

    }

    public void onClickOptionOne(View view) {
        courseDetails.setText(getResources().getString(R.string.artificial_intel));
    }
    public void onClickOptionTwo(View view) {
        courseDetails.setText(getResources().getString(R.string.business_analytics));
    }
    public void onClickOptionThree(View view) {
        courseDetails.setText(getResources().getString(R.string.data_science));
    }
    public void onClickOptionFour(View view) {
        courseDetails.setText(getResources().getString(R.string.machine_learning));
    }
    public void onClickOptionFive(View view) {
        courseDetails.setText(getResources().getString(R.string.dev_mobile));
    }
    public void onClickOptionSix(View view) {
        courseDetails.setText(getResources().getString(R.string.robotics));
    }
    public void onClickOptionSeven(View view) {
        courseDetails.setText(getResources().getString(R.string.programming_basics));
    }
    public void onClickOptionEight(View view) {
        courseDetails.setText(getResources().getString(R.string.self_driving));
    }
    public void onClickOptionNine(View view) {
        courseDetails.setText(getResources().getString(R.string.vr_ar));
    }
    public void onClickOptionTen(View view) {
        courseDetails.setText(getResources().getString(R.string.websites));
    }
}
