package com.popularmovies.vpaliy.popularmoviesapp.ui.navigator;


import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;

import com.popularmovies.vpaliy.popularmoviesapp.ui.actor.ActorActivity;
import com.popularmovies.vpaliy.popularmoviesapp.ui.base.bus.events.ExposeEvent;
import com.popularmovies.vpaliy.popularmoviesapp.ui.details.MediaDetailsActivity;
import com.popularmovies.vpaliy.popularmoviesapp.ui.details.MediaDetailsFragment;
import com.popularmovies.vpaliy.popularmoviesapp.ui.more.MoreMediaActivity;
import com.popularmovies.vpaliy.popularmoviesapp.ui.base.bus.events.ExposeDetailsEvent;
import com.popularmovies.vpaliy.popularmoviesapp.ui.base.bus.events.ViewAllEvent;
import com.popularmovies.vpaliy.popularmoviesapp.ui.utils.Permission;
import com.popularmovies.vpaliy.popularmoviesapp.ui.utils.wrapper.TransitionWrapper;
import android.support.annotation.NonNull;

public class Navigator {

    public void navigate(@NonNull Activity activity, @NonNull ExposeEvent event){
        Class<?> clazz=event.code!=ExposeEvent.CODE_ACTOR_DETAILS
                ?MediaDetailsActivity.class: ActorActivity.class;
        Intent intent=new Intent(activity,clazz);
        intent.putExtras(event.data);
        if(Permission.checkForVersion(Build.VERSION_CODES.LOLLIPOP)){
            ActivityOptionsCompat optionsCompat=ActivityOptionsCompat
                    .makeSceneTransitionAnimation(activity,event.pack);
            activity.startActivity(intent,optionsCompat.toBundle());
            return;
        }
        activity.startActivity(intent);
    }

    public void viewAll(@NonNull Activity activity, @NonNull ViewAllEvent event){
        Intent intent=new Intent(activity, MoreMediaActivity.class);
        intent.putExtras(event.getExtras());
        activity.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(activity).toBundle());
    }
}
