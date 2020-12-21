package com.example.eventappdsc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class EventActivity extends AppCompatActivity {

   Button JoinEventbtn;
   ImageView eventImage;
   TextView eventLocation, eventDate, eventTime, eventSpeaker, eventDesc, eventName;
    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        getWindow().setStatusBarColor(Color.GRAY);

        eventImage = findViewById(R.id.EventImage);
        eventLocation = findViewById(R.id.EventLocation);
        eventDate = findViewById(R.id.EvetnDate);
        eventTime = findViewById(R.id.EventTime);
        eventSpeaker = findViewById(R.id.EventSpeakers);
        eventDesc = findViewById(R.id.EventDesc);
        eventName = findViewById(R.id.EventName);
        JoinEventbtn = findViewById(R.id.joinevent);

        Intent intent = getIntent();
        int position = intent.getIntExtra("position",0);
       /* String desc = intent.getParcelableExtra("eventDesc");*/



        if(position == 0){

            eventImage.setImageResource(R.drawable.favicon);
            eventSpeaker.setText("Many Speakers");
            eventName.setText("DSC WOW");
            eventDate.setText("Dec 7 - 13");
            eventTime.setText("5:00 PM (IST)");
            eventLocation.setText("Youtube");
            eventDesc.setText("We cannot be more excited to invite you all to be a part of this 7 Day technological celebration, hosted by more than 120 DSC chapters across India. DSC WOW is a week-long virtual event consisting of webinars & workshops for five days and the ‘CodeOffDuty’ Hackathon for the last 48 hours.\n" +
                    "\n" +
                    "DSC WOW will bring Industry leaders as mentors and college students from all over the country and beyond to compete over 48 hours to develop creative solutions to real-world problems. There are multiple prizes and swags to be won!\n" +
                    "\n" +
                    "Join us to learn in domains like AI/ML, Blockchain, Design Thinking from Googlers, and experts from all over the world! We have Miri Rodriguez, Ada Rose Cannon, Rachel Hue, and Mrinal Jain to name a few, as speakers lined up to give you insights like never before.");

            JoinEventbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://dsc.community.dev/events/details/developer-student-clubs-vellore-institute-of-technology-bhopal-presents-dsc-wow-indias-biggest-collaboration-prizes-worth-10-lakhs/"));
                    startActivity(intent);
                    Toast.makeText(EventActivity.this, "You will connected to the meeting link", Toast.LENGTH_SHORT).show();
                }
            });

        }

        if(position == 1){

            eventImage.setImageResource(R.drawable.kotline);
            eventName.setText("Android Study Jam - Intro to Kotlin");
            eventDate.setText(" Dec 6");
            eventTime.setText(" 3:00 PM (IST)");
            eventSpeaker.setText("Surya Kumar");
            eventLocation.setText("Youtube");
            eventDesc.setText("What are Android Study Jams?\n" +
                    "\n" +
                    "Android Study Jams are community-organized study groups for people to learn how to build Android apps in the Kotlin programming language, using a curriculum provided by Google. There are two tracks available:\n" +
                    "\n" +
                    "New to Programming Track - for people who are new to programming, follow the Android Basics in Kotlin course.\n" +
                    "\n" +
                    "Prior Programming Experience Track - for people who already have programming experience, follows the Android Kotlin Fundamentals course. Also includes a pre-work section using Kotlin Koans from JetBrains for those who are new to Kotlin.");

            JoinEventbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://dsc.community.dev/events/details/developer-student-clubs-vellore-institute-of-technology-bhopal-presents-android-study-jam-intro-to-kotlin/"));
                    startActivity(intent);
                    Toast.makeText(EventActivity.this, "You will connected to the meeting link", Toast.LENGTH_SHORT).show();
                }
            });

        }

        if(position == 2){

            eventImage.setImageResource(R.drawable.tcce);
            eventName.setText("Theory and Mathematics");
            eventDate.setText(" Dec 4 - 5");
            eventTime.setText(" 5:00 PM (IST)");
            eventSpeaker.setText("Many Speakers");
            eventLocation.setText("Youtube");
            eventDesc.setText("“Dive deep enough into anything, and you’ll find mathematics.”\n" +
                    "\n" +
                    "As you know that mathematics is important in competitive programming but there may be confusion about where to start and how much to learn? Don't worry because we at The Coding Culture are here with our first webinar about Number Theory and Mathematics which will give you a better understanding of these topics and a great start towards the Competitive Programming World.\n" +
                    "\n" +
                    "The best part is we will be taking care of all your doubts too so make yourself available from 5.00 P.M. Onwards on the 4th and 5th of December\n" +
                    "\n" +
                    "This is a part of the webinar series which will cover all the topics that are required to be in this Competitive Programming world.");

            JoinEventbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://dsc.community.dev/events/details/developer-student-clubs-vellore-institute-of-technology-bhopal-presents-theory-and-mathematics/"));
                    startActivity(intent);
                    Toast.makeText(EventActivity.this, "You will connected to the meeting link", Toast.LENGTH_SHORT).show();
                }
            });
        }



       /* JoinEventbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /// Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://dsc.community.dev/events/details/developer-student-clubs-vellore-institute-of-technology-bhopal-presents-theory-and-mathematics/"));
                Toast.makeText(EventActivity.this, "You will connected to the meeting link", Toast.LENGTH_SHORT).show();
            }
        });*/
    }
}