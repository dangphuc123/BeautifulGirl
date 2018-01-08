package com.dpdev.beautifulgirl.controllers;

import android.app.Activity;
import android.content.Intent;

import com.dpdev.beautifulgirl.activities.favorite.FavoriteActivity;
import com.dpdev.beautifulgirl.activities.home.HomeActivity;
import com.dpdev.beautifulgirl.activities.profile.ProfileActivity;
import com.dpdev.beautifulgirl.activities.settings.SettingsActivity;
import com.dpdev.beautifulgirl.views.BeautyBaseView;


/**
 * Created by nhdangit on 1/8/17.
 */
public class DpdevController {

    private BeautyBaseView beautyBaseView;
    private Activity activity;

    public static class ExtraName {
        public static final String TabTop = "BASE_TAB_TOP";
        public static final String NoAnimation = "BASE_NO_ANIMATION";
        public static final String SelectedTab = "BASE_SELECTED_TAB";
        public static final String IMMEDIATELY_FINISH = "BASE_IMMEDIATELY_FINISH";
        private static final String SRC_ACTIVITY = "SRC_ACTIVITY";
        private static final String RESTART_ACTIVITY = "RESTART_ACTIVITY";
        public static final String INITIAL_BOOT = "INITIAL_BOOT";
        public static final String STARTUP = "STARTUP";
    }

    public DpdevController(final Activity activity){
        this.activity = activity;
    }
    private final BeautyBaseView.OnDpdevBaseViewFooterClickListener defaultListener = new BeautyBaseView.OnDpdevBaseViewFooterClickListener() {
        @Override
        public boolean onBeautyBaseViewFooterClick(BeautyBaseView view, int menuId, int currentMenuId) {
            Intent intent;
            int intentFlags = 0;
            switch (menuId) {
                case BeautyBaseView.MENU_ID_HOME:
                    intent = new Intent(activity, HomeActivity.class);
                    break;

                case BeautyBaseView.MENU_ID_FAVORITE:
                    intent = new Intent(activity, FavoriteActivity.class);
                    break;

                case BeautyBaseView.MENU_ID_PROFILE:
                    intent = new Intent(activity, ProfileActivity.class);
                    break;

                case BeautyBaseView.MENU_ID_SETTINGS:
                    intent = new Intent(activity, SettingsActivity.class);
                    break;

                default:
                    return false;
            }


            if (menuId == currentMenuId) {
                intentFlags |= Intent.FLAG_ACTIVITY_CLEAR_TOP;
            } else {
                intentFlags |= Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED;
            }
            intent.setFlags(intentFlags);
            startActivityNoAnimation(intent);
            return true;
        }
    };

    public BeautyBaseView setBeautyContentView(final int layoutResID) {
        beautyBaseView = BeautyBaseView.setBeautyContentView(activity, layoutResID);
        beautyBaseView.setOnViwafooBaseViewFooterClickListener(defaultListener);
        setBullBaseViewMenuId();
        return beautyBaseView;
    }
    private void setBullBaseViewMenuId() {
        final Intent intent = activity.getIntent();
        final int menuId = intent.getIntExtra(ExtraName.SelectedTab, -1);
        if (BeautyBaseView.isValidMenuId(menuId)) {
            beautyBaseView.setCurrentMenuId(menuId);
        }
    }

    public void startActivityNoAnimation(final Intent intent) {
        intent.setFlags(getNoAnimationNextTime(intent, intent.getFlags()));
        activity.startActivity(intent);
    }

    private int getNoAnimationNextTime(final Intent intent, final int flags) {
        intent.putExtra(ExtraName.NoAnimation, true);
        return (flags | Intent.FLAG_ACTIVITY_NO_ANIMATION);
    }
}
