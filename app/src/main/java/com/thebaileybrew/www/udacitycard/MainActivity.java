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
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;


public class MainActivity extends AppCompatActivity {
    //boolean values state if sheet is expanded (true) or collapsed (false)
    boolean showSheetOne = false;
    boolean showSheetTwo = false;
    boolean showSheetThree = false;
    boolean showSheetFour = false;
    //Declares the views that are being called through the BottomSheetBehavior
    View bottomSheet;
    View bottomSheet2;
    View bottomSheet3;
    View bottomSheet4;
    //Declares the text displayed in the peek attribute of BottomSheetBehavior
    TextView headerText;
    TextView headerText2;
    TextView headerText3;
    TextView headerText4;
    //Declares the generic elements used through the activity
    ImageView mainLogo;
    Animation fadein;
    Animation fadeout;
    Animation fadeinshort;
    Animation fadeoutshort;

    //Declares unique elements for Sheet One
    //Declares unique elements for Sheet Two
    //Declares unique elements for Sheet Three
    HorizontalScrollView horizontalScrollSheetThree;
    TextView courseDetails;
    TextView sheetThreeOverview;
    //Declares unique elements for Sheet Four
    TextView sheetFourSubheaderOne;
    TextView sheetFourSubOneDetails;
    TextView sheetFourSubheaderTwo;
    TextView sheetFourSubTwoDetails;
    TextView sheetFourSubheaderThree;
    TextView sheetFourSubThreeDetails;


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //GENERIC DECLARATIONS FOR ENTIRE ACTIVITY
        mainLogo = findViewById(R.id.main_udacity_logo);
        fadein = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        fadeout = AnimationUtils.loadAnimation(this,R.anim.fade_out);
        fadeinshort = AnimationUtils.loadAnimation(this, R.anim.fade_in_short);
        fadeoutshort = AnimationUtils.loadAnimation(this,R.anim.fade_out_short);

        //SPECIFIC TO SHEET ONE
        bottomSheet = findViewById(R.id.design_bottom_sheet);
        headerText = findViewById(R.id.sheet_one_header);
        final BottomSheetBehavior behavior = BottomSheetBehavior.from(bottomSheet);

        //SPECIFIC TO SHEET TWO
        bottomSheet2 = findViewById(R.id.design_bottom_sheet_two);
        headerText2 = findViewById(R.id.sheet_two_header);
        final BottomSheetBehavior behavior2 = BottomSheetBehavior.from(bottomSheet2);

        //SPECIFIC TO SHEET THREE
        bottomSheet3 = findViewById(R.id.design_bottom_sheet_three);
        headerText3 = findViewById(R.id.sheet_three_header);
        horizontalScrollSheetThree = findViewById(R.id.learn_udacity_list);
        courseDetails = findViewById(R.id.course_details_display);
        sheetThreeOverview = findViewById(R.id.sheet_three_overview);
        final BottomSheetBehavior behavior3 = BottomSheetBehavior.from(bottomSheet3);

        //SPECIFIC TO SHEET FOUR
        bottomSheet4 = findViewById(R.id.design_bottom_sheet_four);
        headerText4 = findViewById(R.id.sheet_four_header);
        sheetFourSubheaderOne = findViewById(R.id.master_skills_header);
        sheetFourSubOneDetails = findViewById(R.id.master_skills_details);
        sheetFourSubheaderTwo = findViewById(R.id.get_hired_header);
        sheetFourSubTwoDetails = findViewById(R.id.get_hired_details);
        sheetFourSubheaderThree = findViewById(R.id.maximize_impact_header);
        sheetFourSubThreeDetails = findViewById(R.id.maximize_impact_details);
        final BottomSheetBehavior behavior4 = BottomSheetBehavior.from(bottomSheet4);

        /*
        Programming to define BottomSheet Movement (Sheet FOUR) **WHAT IS UDACITY?**
        TO-DO: Add functionality for crossfade of main header text (THE UDACITY ADVANTAGE)
        */
        behavior4.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onStateChanged(@NonNull View bottomSheet4, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_DRAGGING:
                        //Add LOGIC here
                        mainLogo.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        //Add LOGIC here
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED:
                        mainLogo.setAnimation(fadeout);
                        fadeout.startNow();
                        mainLogo.setBackground(getResources().getDrawable(R.drawable.udacity_logo_side_crop));
                        mainLogo.setAnimation(fadein);
                        fadein.startNow();
                        showSheetFour = false;
                        headerText4.setVisibility(INVISIBLE);
                        headerText4.setText("THE UDACITY ADVANTAGE");
                        headerText4.setAnimation(fadeinshort);
                        sheetFourSubheaderOne.setAnimation(fadeinshort); sheetFourSubheaderTwo.setAnimation(fadeinshort); sheetFourSubheaderThree.setAnimation(fadeinshort);
                        sheetFourSubOneDetails.setAnimation(fadein); sheetFourSubTwoDetails.setAnimation(fadein); sheetFourSubThreeDetails.setAnimation(fadein);
                        fadeinshort.start();
                        fadein.start();
                        headerText4.setVisibility(VISIBLE);
                        sheetFourSubheaderOne.setVisibility(VISIBLE); sheetFourSubheaderTwo.setVisibility(VISIBLE); sheetFourSubheaderThree.setVisibility(VISIBLE);
                        sheetFourSubOneDetails.setVisibility(VISIBLE); sheetFourSubTwoDetails.setVisibility(VISIBLE); sheetFourSubThreeDetails.setVisibility(VISIBLE);
                        showSheetFour = true;
                        break;
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        mainLogo.setAnimation(fadeout);
                        fadeout.start();
                        mainLogo.setBackground(getResources().getDrawable(R.drawable.udacity_logo_crop));
                        mainLogo.setAnimation(fadein);
                        fadein.start();
                        showSheetFour = true;
                        headerText4.setVisibility(INVISIBLE);
                        headerText4.setText("WHAT IS UDACITY ABOUT?");
                        headerText4.setAnimation(fadeinshort);
                        fadeinshort.start();
                        headerText4.setVisibility(VISIBLE);
                        sheetFourSubheaderOne.setVisibility(INVISIBLE);
                        sheetFourSubheaderTwo.setVisibility(INVISIBLE);
                        sheetFourSubheaderThree.setVisibility(INVISIBLE);
                        sheetFourSubOneDetails.setVisibility(INVISIBLE);
                        sheetFourSubTwoDetails.setVisibility(INVISIBLE);
                        sheetFourSubThreeDetails.setVisibility(INVISIBLE);
                        showSheetFour = false;
                        //Add LOGIC here
                        break;
                    case BottomSheetBehavior.STATE_HIDDEN:
                        //STATE_HIDDEN NOT ALLOWED
                        break;
                }
            }
            @Override
            public void onSlide(@NonNull View bottomSheet4, float slideOffset) {
                //Add LOGIC here
                if (behavior4.getState() == BottomSheetBehavior.STATE_DRAGGING) {

                }

            }
        });


        /*
        Programming to define BottomSheet Movement (Sheet THREE) **HOW MUCH CAN I LEARN?**
        TO-DO: Update and cleanup the scrollview, string details for classes
        */
        behavior3.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onStateChanged(@NonNull View bottomSheet3, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_DRAGGING:
                        //Add LOGIC here
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        //Add LOGIC here
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED:
                        //Add LOGIC here
                        break;
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        //Add LOGIC here
                        break;
                    case BottomSheetBehavior.STATE_HIDDEN:
                        //STATE_HIDDEN NOT ALLOWED
                        break;
                }
            }
            @Override
            public void onSlide(@NonNull View bottomSheet3, float slideOffset) {
                //Add LOGIC here
                if (showSheetThree) {
                } else {
                }
            }
        });


        /*
        Programming to define BottomSheet Movement (Sheet TWO) --- WHERE CAN I FIND UDACITY?
        TO-DO: Add Google Maps Integration, Social Media Links, Phone
        */
        behavior2.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onStateChanged(@NonNull View bottomSheet2, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_DRAGGING:
                        //Add LOGIC here
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        //Add LOGIC here
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED:
                        //Add LOGIC here
                        break;
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        //Add LOGIC here
                        break;
                    case BottomSheetBehavior.STATE_HIDDEN:
                        //STATE_HIDDEN NOT ALLOWED
                        break;
                }
            }
            @Override
            public void onSlide(@NonNull View bottomSheet2, float slideOffset) {
                //Add LOGIC here
                if (showSheetTwo) {
                } else {
                }
            }
        });


        /*
        Programming to define BottomSheet Movement (Sheet ONE) --- WHAT ARE YOU WAITING FOR?
        TO-DO: Add call to action (possibly a submit email form?)
        */
        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_DRAGGING:
                        //Add LOGIC here
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        //Add LOGIC here
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED:
                        //Add LOGIC here
                        break;
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        //Add LOGIC here
                        break;
                    case BottomSheetBehavior.STATE_HIDDEN:
                        //STATE_HIDDEN NOT ALLOWED
                        break;
                }
            }
            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                //Add LOGIC here
                if (showSheetOne) {
                } else {
                }
            }
        });
    }

    //Specific method for onClick SHHET ONE rather than slide to open functionality
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
    //Specific method for onClick SHEET TWO rather than slide to open functionality
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

    //Specific method for onClick SHEET THREE rather than slide to open functionality
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

    //Specific method for onClick SHEET FOUR rather than slide to open functionality
    public void onClickOpenSheetFour(View view) {
        final BottomSheetBehavior behavior = BottomSheetBehavior.from(bottomSheet);
        final BottomSheetBehavior behavior2 = BottomSheetBehavior.from(bottomSheet2);
        final BottomSheetBehavior behavior3 = BottomSheetBehavior.from(bottomSheet3);
        final BottomSheetBehavior behavior4 = BottomSheetBehavior.from(bottomSheet4);
        mainLogo.setBackgroundColor(getResources().getColor(R.color.colorWhite));
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

    //Unique onClicks for HorizontalScrollView to display detail strings for each image in scroll.
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
