package com.dpdev.beautifulgirl.views;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.dpdev.beautifulgirl.R;


/**
 * Created by nhdangit on 1/8/17.
 */
public class BeautyBaseView extends RelativeLayout implements View.OnClickListener {

    public static final int MENU_ID_HOME = 0;
    public static final int MENU_ID_FAVORITE = 1;
    public static final int MENU_ID_PROFILE = 2;
    public static final int MENU_ID_SETTINGS = 3;
    private static final int MENU_ID_FIRST = 0;
    private static final int MENU_ID_LAST = MENU_ID_SETTINGS;
    public static final int MENU_ID_MAX = MENU_ID_LAST + 1;


    private OnDpdevBaseViewFooterClickListener footerListener;

    public interface OnDpdevBaseViewFooterClickListener {
        boolean onBeautyBaseViewFooterClick(BeautyBaseView view, int menuId, int currentMenuId);
    }

    private View userView;
    private LinearLayout userLayout;
    private int currentMenuId = -1;
    private final ImageView[] menuList = new ImageView[MENU_ID_MAX];

    public BeautyBaseView(Context context) {
        super(context);
        init(context);
    }

    public BeautyBaseView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);

    }

    public BeautyBaseView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);

    }


    private void init(Context context) {
        inflate(context, R.layout.beauty_base_view, this);
        userLayout = (LinearLayout) findViewById(R.id.dpdev_baseview_user_layout);
        ImageView menuHome = (ImageView) findViewById(R.id.menu_img_home);
        menuHome.setOnClickListener(this);
        menuList[MENU_ID_HOME] = menuHome;

        ImageView menuFavorite = (ImageView) findViewById(R.id.menu_img_favorite);
        menuFavorite.setOnClickListener(this);
        menuList[MENU_ID_FAVORITE] = menuFavorite;

        ImageView menuProfile = (ImageView) findViewById(R.id.menu_img_profile);
        menuProfile.setOnClickListener(this);
        menuList[MENU_ID_PROFILE] = menuProfile;

        ImageView menuSettings = (ImageView) findViewById(R.id.menu_img_settings);
        menuSettings.setOnClickListener(this);
        menuList[MENU_ID_SETTINGS] = menuSettings;
    }

    @Override
    public void onClick(View view) {
        if (footerListener == null) {
            return;
        }

        switch (view.getId()) {
            case R.id.menu_img_home:
                footerListener.onBeautyBaseViewFooterClick(this, MENU_ID_HOME, currentMenuId);
                break;
            case R.id.menu_img_favorite:
                footerListener.onBeautyBaseViewFooterClick(this, MENU_ID_FAVORITE, currentMenuId);
                break;
            case R.id.menu_img_profile:
                footerListener.onBeautyBaseViewFooterClick(this, MENU_ID_PROFILE, currentMenuId);
                break;
            case R.id.menu_img_settings:
                footerListener.onBeautyBaseViewFooterClick(this, MENU_ID_SETTINGS, currentMenuId);
                break;
            default:
                break;
        }

    }

    public static BeautyBaseView setBeautyContentView(Activity activity, int layoutResID) {
        BeautyBaseView zexyBaseView = new BeautyBaseView(activity);
        activity.setContentView(zexyBaseView);
        if (layoutResID != 0) {
            LayoutInflater inflater = LayoutInflater.from(activity);
            View userView = inflater.inflate(layoutResID, null);
            zexyBaseView.addUserView(userView);
        }
        return zexyBaseView;
    }

    public void addUserView(View child) {
        userView = child;
        userLayout.addView(child, new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
    }

    public static boolean isValidMenuId(int menuId) {
        return (BeautyBaseView.MENU_ID_FIRST <= menuId && menuId <= BeautyBaseView.MENU_ID_LAST);
    }

    public void setOnViwafooBaseViewFooterClickListener(OnDpdevBaseViewFooterClickListener listener) {
        if (listener == null) {
            this.footerListener = null;
        } else {
            this.footerListener = listener;
        }
    }

    public void setCurrentMenuId(int menuId) {
        if (!isValidMenuId(menuId)) {
            return;
        }
        setFooterImages(menuId);
    }

    private void setFooterImages(int menuId) {
        if (isValidMenuId(currentMenuId)) {
            menuList[currentMenuId].setSelected(false);
        }
        menuList[menuId].setSelected(true);
        currentMenuId = menuId;
    }

}
