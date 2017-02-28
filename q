[33mtag V1.0[m
Tagger: wilder <marionfontaine904@gmail.com>
Date:   Tue Feb 28 11:48:04 2017 +0100

QUETE_MULTI_ACTIVITIES

[33mcommit 2f656f2a3fc6723bec65963383125cd657fdd554[m
Author: wilder <marionfontaine904@gmail.com>
Date:   Tue Feb 28 11:39:16 2017 +0100

    The extra defective activity has been deleted

[1mdiff --git a/app/src/main/java/com/example/wilder/blabla_wild/ViewSearchItineraryResultListActivity.java b/app/src/main/java/com/example/wilder/blabla_wild/ViewSearchItineraryResultListActivity.java[m
[1mdeleted file mode 100644[m
[1mindex 0ee2583..0000000[m
[1m--- a/app/src/main/java/com/example/wilder/blabla_wild/ViewSearchItineraryResultListActivity.java[m
[1m+++ /dev/null[m
[36m@@ -1,31 +0,0 @@[m
[31m-package com.example.wilder.blabla_wild;[m
[31m-[m
[31m-import android.content.Intent;[m
[31m-import android.os.Bundle;[m
[31m-import android.support.v7.app.AppCompatActivity;[m
[31m-import android.view.ViewGroup;[m
[31m-import android.widget.TextView;[m
[31m-[m
[31m-[m
[31m-[m
[31m-[m
[31m-/**[m
[31m- * Created by wilder on 27/02/17.[m
[31m- */[m
[31m-[m
[31m-public class ViewSearchItineraryResultListActivity extends AppCompatActivity {[m
[31m-    protected void onCreate(Bundle savedInstanceState) {[m
[31m-        super.onCreate(savedInstanceState);[m
[31m-        setContentView(R.layout.activity_view_search_itinerary_result_list);[m
[31m-[m
[31m-            Intent intent = getIntent();[m
[31m-            String message = intent.getStringExtra(SearchItineraryActivity.message);[m
[31m-            TextView textView = new TextView(this);[m
[31m-            textView.setTextSize(40);[m
[31m-            textView.setText(message);[m
[31m-[m
[31m-            ViewGroup layout = (ViewGroup) findViewById(R.id.activity_view_search_itinerary_result_list);[m
[31m-            layout.addView(textView);[m
[31m-[m
[31m-        }[m
[31m-}[m
[1mdiff --git a/app/src/main/res/layout/activity_view_search_itinerary_result_list.xml b/app/src/main/res/layout/activity_view_search_itinerary_result_list.xml[m
[1mdeleted file mode 100644[m
[1mindex 7f2a713..0000000[m
[1m--- a/app/src/main/res/layout/activity_view_search_itinerary_result_list.xml[m
[1m+++ /dev/null[m
[36m@@ -1,13 +0,0 @@[m
[31m-<?xml version="1.0" encoding="utf-8"?>[m
[31m-<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"[m
[31m-    xmlns:tools="http://schemas.android.com/tools"[m
[31m-    android:id="@+id/activity_view_search_itinerary_result_list"[m
[31m-    android:layout_width="match_parent"[m
[31m-    android:layout_height="match_parent"[m
[31m-    android:paddingBottom="@dimen/activity_vertical_margin"[m
[31m-    android:paddingLeft="@dimen/activity_horizontal_margin"[m
[31m-    android:paddingRight="@dimen/activity_horizontal_margin"[m
[31m-    android:paddingTop="@dimen/activity_vertical_margin"[m
[31m-    tools:context="com.example.wilder.blabla_wild.SearchItineraryActivity">[m
[31m-[m
[31m-</RelativeLayout>[m
