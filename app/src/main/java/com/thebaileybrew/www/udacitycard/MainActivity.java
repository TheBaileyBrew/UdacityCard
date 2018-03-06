package com.thebaileybrew.www.udacitycard;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import com.gigamole.navigationtabstrip.NavigationTabStrip;
import com.github.florent37.expansionpanel.ExpansionHeader;
import com.github.florent37.expansionpanel.ExpansionLayout;
import com.github.florent37.expansionpanel.viewgroup.ExpansionLayoutCollection;
import com.google.android.gms.maps.MapFragment;

import java.security.MessageDigest;
import java.security.Signature;
import java.util.List;
import java.util.Vector;

import cdflynn.android.library.crossview.CrossView;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;


public class MainActivity extends AppCompatActivity {
    MapFragment mMapFragment;
    private PagerAdapter mPagerAdapter;
    ViewPager pager;
    String userNameString;
    String userPhoneString;

    //Declares the toggle icons in the Headers
    CrossView sheetOne;
    CrossView sheetTwo;
    CrossView sheetThree;
    CrossView sheetFour;

    //Declares the mini navigation buttons in Sheet Two
    ImageView buttonFacebook;
    ImageView buttonLinkedin;
    ImageView buttonNavigation;
    ImageView buttonYoutube;
    ImageView buttonTwitter;

    //Generic declarations
    ImageView mainLogo;

    //Defines the animations for multiple views
    Animation fadein;
    Animation fadeout;
    Animation fadeinshort;
    Animation fadeoutshort;

    //Declares the Expansion Panel Layouts
    ExpansionLayout ex1;
    ExpansionLayout ex2;
    ExpansionLayout ex3;
    ExpansionLayout ex4;

    //Declares the text displayed in the Expansion Panel Header
    TextView headerText;
    TextView headerText2;
    TextView headerText3;
    TextView headerText4;

    //Dclares the complete hearder view in the Expansion Panel
    ExpansionHeader headerSheetOne;
    ExpansionHeader headerSheetTwo;
    ExpansionHeader headerSheetThree;
    ExpansionHeader headerSheetFour;

    //Declares unique elements for Sheet One
    EditText userName;
    EditText userPhone;
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

    NavigationTabStrip navigationTab;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        computePackageHash();

        this.initializePaging();

        mMapFragment = MapFragment.newInstance();
        navigationTab = findViewById(R.id.navigation_strip_sheet_two);
        navigationTab.setTabIndex(2);

        userName = findViewById(R.id.name_input_edit_text);
        userPhone = findViewById(R.id.phone_input_edit_text);
        courseDetails = findViewById(R.id.course_details_display);
        ex1 = findViewById(R.id.expansionLayoutOne);
        ex2 = findViewById(R.id.expansionLayoutTwo);
        ex3 = findViewById(R.id.expansionLayoutThree);
        ex4 = findViewById(R.id.expansionLayoutFour);
        sheetOne = findViewById(R.id.sheet_one_toggle);
        sheetTwo = findViewById(R.id.sheet_two_toggle);
        sheetThree = findViewById(R.id.sheet_three_toggle);
        sheetFour = findViewById(R.id.sheet_four_toggle);
        headerSheetOne = findViewById(R.id.header_indicator_one);
        headerSheetTwo = findViewById(R.id.header_indicator_two);
        headerSheetThree = findViewById(R.id.header_indicator_three);
        headerSheetFour = findViewById(R.id.header_indicator_four);
        mainLogo = findViewById(R.id.main_udacity_logo);
        fadein = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        fadeout = AnimationUtils.loadAnimation(this,R.anim.fade_out);
        fadeinshort = AnimationUtils.loadAnimation(this, R.anim.fade_in_short);
        fadeoutshort = AnimationUtils.loadAnimation(this,R.anim.fade_out_short);
        headerText = findViewById(R.id.sheet_one_header);
        headerText2 = findViewById(R.id.sheet_two_header);
        headerText3 = findViewById(R.id.sheet_three_header);
        headerText4 = findViewById(R.id.sheet_four_header);

        buttonFacebook = findViewById(R.id.buttonFacebook);
        buttonLinkedin = findViewById(R.id.buttonLinkedin);
        buttonNavigation = findViewById(R.id.buttonNavigation);
        buttonYoutube = findViewById(R.id.buttonYoutube);
        buttonTwitter = findViewById(R.id.buttonTwitter);


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
                    //When the expansion panel is expanded, these actions are taken
                    fadeToCrop();
                    headerText.setVisibility(INVISIBLE);
                    headerText.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                    headerText.setText("LET'S GET CONNECTED!");
                    headerText.setVisibility(VISIBLE);
                    sheetOne.cross(500);
                    sheetOne.setColor(getResources().getColor(R.color.colorPrimaryDark));
                } else {
                    //When the expansion panel is collapsed, these actions are taken
                    fadeToFull();
                    headerText.setVisibility(INVISIBLE);
                    headerText.setTextColor(getResources().getColor(R.color.colorWhite));
                    headerText.setText("WHAT ARE YOU WAITING FOR?");
                    headerText.setVisibility(VISIBLE);
                    sheetOne.plus(500);
                    sheetOne.setColor(getResources().getColor(R.color.colorWhite));
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
                    buttonNavigation.setImageDrawable(getResources().getDrawable(R.drawable.white_location));
                    final ViewPager pager = findViewById(R.id.viewPager);
                    pager.setCurrentItem(2);
                    headerText2.setVisibility(INVISIBLE);
                    headerText2.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                    headerText2.setText("UDACITY IS WHERE YOU ARE");
                    headerText2.setVisibility(VISIBLE);
                    pager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
                        public void onPageSelected(int position) {
                            navigationTab.setTabIndex(position);
                            switch (position) {
                                case 0:
                                    //CASE ZERO - FACEBOOK WHITE
                                    buttonFacebook.setImageDrawable(getResources().getDrawable(R.drawable.white_fb));
                                    buttonLinkedin.setImageDrawable(getResources().getDrawable(R.drawable.black_linked));
                                    buttonNavigation.setImageDrawable(getResources().getDrawable(R.drawable.black_location));
                                    buttonYoutube.setImageDrawable(getResources().getDrawable(R.drawable.black_tube));
                                    buttonTwitter.setImageDrawable(getResources().getDrawable(R.drawable.black_tweet));
                                    break;
                                case 1:
                                    //CASE ZERO - LINKEDIN WHITE
                                    buttonFacebook.setImageDrawable(getResources().getDrawable(R.drawable.black_fb));
                                    buttonLinkedin.setImageDrawable(getResources().getDrawable(R.drawable.white_linked));
                                    buttonNavigation.setImageDrawable(getResources().getDrawable(R.drawable.black_location));
                                    buttonYoutube.setImageDrawable(getResources().getDrawable(R.drawable.black_tube));
                                    buttonTwitter.setImageDrawable(getResources().getDrawable(R.drawable.black_tweet));
                                    break;
                                case 2:
                                    //CASE ZERO - NAVIGATION WHITE
                                    buttonFacebook.setImageDrawable(getResources().getDrawable(R.drawable.black_fb));
                                    buttonLinkedin.setImageDrawable(getResources().getDrawable(R.drawable.black_linked));
                                    buttonNavigation.setImageDrawable(getResources().getDrawable(R.drawable.white_location));
                                    buttonYoutube.setImageDrawable(getResources().getDrawable(R.drawable.black_tube));
                                    buttonTwitter.setImageDrawable(getResources().getDrawable(R.drawable.black_tweet));
                                    break;
                                case 3:
                                    //CASE ZERO - YOUTUBE WHITE
                                    buttonFacebook.setImageDrawable(getResources().getDrawable(R.drawable.black_fb));
                                    buttonLinkedin.setImageDrawable(getResources().getDrawable(R.drawable.black_linked));
                                    buttonNavigation.setImageDrawable(getResources().getDrawable(R.drawable.black_location));
                                    buttonYoutube.setImageDrawable(getResources().getDrawable(R.drawable.white_tube));
                                    buttonTwitter.setImageDrawable(getResources().getDrawable(R.drawable.black_tweet));
                                    break;
                                case 4:
                                    //CASE ZERO - TWITTER WHITE
                                    buttonFacebook.setImageDrawable(getResources().getDrawable(R.drawable.black_fb));
                                    buttonLinkedin.setImageDrawable(getResources().getDrawable(R.drawable.black_linked));
                                    buttonNavigation.setImageDrawable(getResources().getDrawable(R.drawable.black_location));
                                    buttonYoutube.setImageDrawable(getResources().getDrawable(R.drawable.black_tube));
                                    buttonTwitter.setImageDrawable(getResources().getDrawable(R.drawable.white_tweet));
                                    break;
                            }

                        }
                    });
                    fadeToCrop();
                    sheetTwo.cross(500);
                    sheetTwo.setColor(getResources().getColor(R.color.colorPrimaryDark));
                } else {
                    fadeToFull();
                    headerText2.setVisibility(INVISIBLE);
                    headerText2.setTextColor(getResources().getColor(R.color.colorWhite));
                    headerText2.setText("WHERE CAN I FIND UDACITY?");
                    headerText2.setVisibility(VISIBLE);
                    sheetTwo.plus(500);
                    sheetTwo.setColor(getResources().getColor(R.color.colorWhite));
                }
            }
        });

        //Sheet Three
        /*
        Programming --- HOW MUCH CAN I LEARN?
        TO-DO: Update and cleanup the scrollview, string details for classes
        TO-DO: Update font formatting and layout
        */
        ex3.addListener(new ExpansionLayout.Listener() {
            @Override
            public void onExpansionChanged(ExpansionLayout expansionLayout, boolean expanded) {
                if (expanded) {
                    fadeToCrop();
                    headerText3.setVisibility(INVISIBLE);
                    headerText3.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                    headerText3.setText("ENDLESS LEARNING WITH UDACITY");
                    headerText3.setVisibility(VISIBLE);
                    sheetThree.cross(500);
                    sheetThree.setColor(getResources().getColor(R.color.colorPrimaryDark));

                } else {
                    fadeToFull();
                    headerText3.setVisibility(INVISIBLE);
                    headerText3.setTextColor(getResources().getColor(R.color.colorWhite));
                    headerText3.setText("HOW MUCH CAN I LEARN?");
                    headerText3.setVisibility(VISIBLE);
                    sheetThree.plus(500);
                    sheetThree.setColor(getResources().getColor(R.color.colorWhite));
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
                    headerText4.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                    headerText4.setText("THE UDACITY ADVANTAGE");
                    sheetFourSubheaderOne.setAnimation(fadeinshort); sheetFourSubheaderTwo.setAnimation(fadeinshort); sheetFourSubheaderThree.setAnimation(fadeinshort);
                    sheetFourSubOneDetails.setAnimation(fadein); sheetFourSubTwoDetails.setAnimation(fadein); sheetFourSubThreeDetails.setAnimation(fadein);
                    fadeinshort.start();
                    fadein.start();
                    headerText4.setVisibility(VISIBLE);
                    sheetFourSubheaderOne.setVisibility(VISIBLE); sheetFourSubheaderTwo.setVisibility(VISIBLE); sheetFourSubheaderThree.setVisibility(VISIBLE);
                    sheetFourSubOneDetails.setVisibility(VISIBLE); sheetFourSubTwoDetails.setVisibility(VISIBLE); sheetFourSubThreeDetails.setVisibility(VISIBLE);
                    sheetFour.cross(500);
                    sheetFour.setColor(getResources().getColor(R.color.colorPrimaryDark));
                } else {
                    fadeToFull();
                    headerText4.setVisibility(INVISIBLE);
                    headerText4.setTextColor(getResources().getColor(R.color.colorWhite));
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
                    sheetFour.plus(500);
                    sheetFour.setColor(getResources().getColor(R.color.colorWhite));
                }
            }
        });


    }

    public void initializePaging() {
        //Creates the record list of fragments in the quiz
        List<Fragment> fragments = new Vector<>();
        fragments.add(Fragment.instantiate(this, FacebookFragment.class.getName()));
        fragments.add(Fragment.instantiate(this, LinkedinFragment.class.getName()));
        fragments.add(Fragment.instantiate(this, MapViewFragment.class.getName()));
        fragments.add(Fragment.instantiate(this, YoutubeFragment.class.getName()));
        fragments.add(Fragment.instantiate(this, TwitterFragment.class.getName()));
        mPagerAdapter = new PagerAdapter(super.getSupportFragmentManager(), fragments);
        //
        ViewPager pager = super.findViewById(R.id.viewPager);
        pager.setAdapter(this.mPagerAdapter);
    }
    @Override
    public void onBackPressed() {
        final ViewPager pager = (ViewPager)super.findViewById(R.id.viewPager);
        if (pager.getCurrentItem() == 0) {
            //Defines what to do if the user presses the back button and is currently on the first fragment page
            //This calls finish() on the activity and returns
            super.onBackPressed();
        } else {
            //Otherwise, current fragment will rotate one back
            pager.setCurrentItem(pager.getCurrentItem() - 1);
        }
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

    public void onClickIntentCallFaceBook(View view) {
        final ViewPager pager = findViewById(R.id.viewPager);
        navigationTab.setTabIndex(0);
        pager.setCurrentItem(0, true);
    }

    public void onClickIntentCallLinkedIn(View view) {
        final ViewPager pager = findViewById(R.id.viewPager);
        navigationTab.setTabIndex(1);
        pager.setCurrentItem(1,true);
    }

    public void onClickIntentCallNavigation(View view) {
        final ViewPager pager = findViewById(R.id.viewPager);
        navigationTab.setTabIndex(2);
        pager.setCurrentItem(2,true);
    }

    public void onClickIntentCallYoutube(View view) {
        final ViewPager pager = findViewById(R.id.viewPager);
        navigationTab.setTabIndex(3);
        pager.setCurrentItem(3,true);
    }

    public void onClickIntentCallTwitter(View view) {
        final ViewPager pager = findViewById(R.id.viewPager);
        navigationTab.setTabIndex(4);
        pager.setCurrentItem(4,true);
    }

    private void computePackageHash() {
        try {
            PackageInfo info = getPackageManager().getPackageInfo("com.thebaileybrew.www.udacitycard", PackageManager.GET_SIGNATURES);
            for (android.content.pm.Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (Exception e) {
            Log.e("TAG", e.getMessage());
        }
    }

    public void onClickOpenEmailFormLetter(View view) {
        userNameString = userName.getText().toString();
        userPhoneString = userPhone.getText().toString();
        String emailBodyStringData = "Hello Udacity, \n my name is " +userNameString+ ", and I'm very interested in learning more about Udacity. \n Please feel free to email me or call me at this number: " + userPhoneString + "\n \n \n Sincerely, \n" +userNameString;

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","info@udacity.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "I'd like to learn more about Udacity!");
        emailIntent.putExtra(Intent.EXTRA_TEXT, emailBodyStringData);
        startActivity(emailIntent);
    }
}
