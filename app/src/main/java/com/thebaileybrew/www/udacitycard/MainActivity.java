package com.thebaileybrew.www.udacitycard;

import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.florent37.expansionpanel.ExpansionHeader;
import com.github.florent37.expansionpanel.ExpansionLayout;
import com.github.florent37.expansionpanel.viewgroup.ExpansionLayoutCollection;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;


public class MainActivity extends AppCompatActivity {
    //Declares the generic elements used through the activity
    ImageView mainLogo;
    Animation rotateClockwise;
    Animation rotateCounterClockwise;
    Animation fadein;
    Animation fadeout;
    Animation fadeinshort;
    Animation fadeoutshort;
    ExpansionLayout ex1;
    ExpansionLayout ex2;
    ExpansionLayout ex3;
    ExpansionLayout ex4;
    //Declares the text displayed in the Expansion Panel Header
    TextView headerText;
    TextView headerText2;
    TextView headerText3;
    TextView headerText4;

    ExpansionHeader headerSheetOne;
    ExpansionHeader headerSheetTwo;
    ExpansionHeader headerSheetThree;
    ExpansionHeader headerSheetFour;

    //Declares unique elements for Sheet One
    //Declares unique elements for Sheet Two
    //Declares unique elements for Sheet Three
    LinearLayout sheetThreeLinear;
    TextView courseDetails;
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
        courseDetails = findViewById(R.id.course_details_display);
        ex1 = findViewById(R.id.expansionLayoutOne);
        ex2 = findViewById(R.id.expansionLayoutTwo);
        ex3 = findViewById(R.id.expansionLayoutThree);
        ex4 = findViewById(R.id.expansionLayoutFour);
        headerSheetOne = findViewById(R.id.header_indicator_one);
        headerSheetTwo = findViewById(R.id.header_indicator_two);
        headerSheetThree = findViewById(R.id.header_indicator_three);
        headerSheetFour = findViewById(R.id.header_indicator_four);
        mainLogo = findViewById(R.id.main_udacity_logo);
        rotateClockwise = AnimationUtils.loadAnimation(this, R.anim.rotate_clockwise);
        rotateCounterClockwise = AnimationUtils.loadAnimation(this, R.anim.rotate_counter_clockwise);
        fadein = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        fadeout = AnimationUtils.loadAnimation(this,R.anim.fade_out);
        fadeinshort = AnimationUtils.loadAnimation(this, R.anim.fade_in_short);
        fadeoutshort = AnimationUtils.loadAnimation(this,R.anim.fade_out_short);
        headerText = findViewById(R.id.sheet_one_header);
        headerText2 = findViewById(R.id.sheet_two_header);
        headerText3 = findViewById(R.id.sheet_three_header);
        headerText4 = findViewById(R.id.sheet_four_header);


        //Specific to SHEET THREE
        sheetThreeLinear = findViewById(R.id.design_bottom_sheet_three);
        //Specific to SHEET FOUR
        sheetFourSubheaderOne = findViewById(R.id.master_skills_header);
        sheetFourSubOneDetails = findViewById(R.id.master_skills_details);
        sheetFourSubheaderTwo = findViewById(R.id.get_hired_header);
        sheetFourSubTwoDetails = findViewById(R.id.get_hired_details);
        sheetFourSubheaderThree = findViewById(R.id.maximize_impact_header);
        sheetFourSubThreeDetails = findViewById(R.id.maximize_impact_details);

        final ExpansionLayoutCollection expansionLayoutCollection = new ExpansionLayoutCollection();
        expansionLayoutCollection.add(ex1);
        expansionLayoutCollection.add(ex2);
        expansionLayoutCollection.add(ex3);
        expansionLayoutCollection.add(ex4);
        expansionLayoutCollection.openOnlyOne(true);

        //Sheet One
        /*
        Programming --- WHAT ARE YOU WAITING FOR?
        TO-DO: Add call to action (possibly a submit email form?)
        */
        ex1.addListener(new ExpansionLayout.Listener() {
            @Override
            public void onExpansionChanged(ExpansionLayout expansionLayout, boolean expanded) {
                if (expanded) {
                    fadeToCrop();
                } else {
                    fadeToFull();
                }
            }
        });

        //Sheet Two
        /*
        Programming --- WHERE CAN I FIND UDACITY?
        TO-DO: Add Google Maps Integration, Social Media Links, Phone
        */
        ex2.addListener(new ExpansionLayout.Listener() {
            @Override
            public void onExpansionChanged(ExpansionLayout expansionLayout, boolean expanded) {
                if (expanded) {
                    fadeToCrop();
                } else {
                    fadeToFull();
                }
            }
        });

        //Sheet Three
        /*
        Programming --- HOW MUCH CAN I LEARN?
        TO-DO: Update and cleanup the scrollview, string details for classes
        */
        ex3.addListener(new ExpansionLayout.Listener() {
            @Override
            public void onExpansionChanged(ExpansionLayout expansionLayout, boolean expanded) {
                if (expanded) {
                    fadeToCrop();
                    sheetThreeLinear.setAnimation(fadein);
                    fadein.start();
                    sheetThreeLinear.setVisibility(VISIBLE);
                } else {
                    fadeToFull();
                }
            }
        });

        //Sheet Four
        /*
        Programming --- WHAT IS UDACITY?
        TO-DO: Add functionality for crossfade of main header text (THE UDACITY ADVANTAGE)
        */
        ex4.addListener(new ExpansionLayout.Listener() {
            @Override
            public void onExpansionChanged(ExpansionLayout expansionLayout, boolean expanded) {
                if (expanded) {
                    fadeToCrop();
                    headerText4.setVisibility(INVISIBLE);
                    headerText4.setText("THE UDACITY ADVANTAGE");
                    sheetFourSubheaderOne.setAnimation(fadeinshort); sheetFourSubheaderTwo.setAnimation(fadeinshort); sheetFourSubheaderThree.setAnimation(fadeinshort);
                    sheetFourSubOneDetails.setAnimation(fadein); sheetFourSubTwoDetails.setAnimation(fadein); sheetFourSubThreeDetails.setAnimation(fadein);
                    fadeinshort.start();
                    fadein.start();
                    headerText4.setVisibility(VISIBLE);
                    sheetFourSubheaderOne.setVisibility(VISIBLE); sheetFourSubheaderTwo.setVisibility(VISIBLE); sheetFourSubheaderThree.setVisibility(VISIBLE);
                    sheetFourSubOneDetails.setVisibility(VISIBLE); sheetFourSubTwoDetails.setVisibility(VISIBLE); sheetFourSubThreeDetails.setVisibility(VISIBLE);
                } else {
                    fadeToFull();
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
                }
            }
        });


    }

    private void fadeToCrop() {
        mainLogo.setAnimation(fadeout);
        fadeout.start();
        mainLogo.setBackgroundResource(R.drawable.udacity_logo_side_crop);
        mainLogo.setAnimation(fadeinshort);
        fadeinshort.start();
    }

    private void fadeToFull() {
        mainLogo.setAnimation(fadeout);
        fadeout.start();
        mainLogo.setBackgroundResource(R.drawable.udacity_logo_crop);
        mainLogo.setAnimation(fadeinshort);
        fadeinshort.start();
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
