package com.viaviapp.hdvideo;

import android.content.Context;

import com.example.util.AdsConstant;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;


public class PopUpAds {


    public static void ShowInterstitialAds(Context context)
    {
        AdsConstant.AD_COUNT+=1;
        if(AdsConstant.AD_COUNT==3)
        {
            final InterstitialAd mInterstitial = new InterstitialAd(context);
            mInterstitial.setAdUnitId(context.getResources().getString(R.string.admob_intertestial_id));
            mInterstitial.loadAd(new AdRequest.Builder().build());
            mInterstitial.show();
            AdsConstant.AD_COUNT=0;
            if (!mInterstitial.isLoaded()) {
                AdRequest adRequest1 = new AdRequest.Builder()
                        .build();
                // Begin loading your interstitial.
                mInterstitial.loadAd(adRequest1);
            }
            mInterstitial.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {
                    super.onAdLoaded();
                    mInterstitial.show();
                }
            });
        }
    }
}
