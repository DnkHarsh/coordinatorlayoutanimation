package com.app.coordinatorlayoutanimation

import android.app.Activity
import android.graphics.Insets
import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.WindowInsets
import androidx.appcompat.app.AppCompatActivity
import com.app.coordinatorlayoutanimation.databinding.ActivityMainBinding
import com.app.coordinatorlayoutanimation.databinding.CheckBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior


class MainActivity : AppCompatActivity() {

    private lateinit var binding: CheckBinding
    val tag = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CheckBinding.inflate(layoutInflater)
        setContentView(binding.root)


        /*val mBottomSheetBehavior: BottomSheetBehavior<*> =
            BottomSheetBehavior.from(binding.runningActivityLayout)


        val height = getScreenHeight(this, true)
//            int pickupHeight = (height - ((height * 45) / 100));
        //            int pickupHeight = (height - ((height * 45) / 100));
        Log.e(tag, "onCreate: height:- $h\eight")
        Log.e(tag, "onCreate: width:- ${getScreenHeight(this, false)}")
        val pickupHeight = height/5
        Log.e(tag, "onCreate: pickupHeight:- $pickupHeight")
//        int pickupHeight = height;
//        mBottomSheetBehavior.setPeekHeight(Utility.getLayoutHeight(binding.loutScroll));
        //        int pickupHeight = height;
//        mBottomSheetBehavior.setPeekHeight(Utility.getLayoutHeight(binding.loutScroll));
        mBottomSheetBehavior.peekHeight = pickupHeight
        mBottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED*/

        /*mBottomSheetBehavior.addBottomSheetCallback(object : BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
//                    mBottomSheetBehavior.setPeekHeight(Utility.getLayoutHeight(binding.topLayout));
                    mBottomSheetBehavior.peekHeight = pickupHeight
                    //                    binding.bottomLayoutLayout.setVisibility(View.GONE);
                }
                //                } else binding.bottomLayoutLayout.setVisibility(View.VISIBLE);
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {

            }
        })*/


    }

    private fun getScreenHeight(activity: Activity, height: Boolean): Int {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val windowMetrics = activity.windowManager.currentWindowMetrics
            val insets: Insets =
                windowMetrics.windowInsets.getInsetsIgnoringVisibility(WindowInsets.Type.systemBars())
            if (height) {
                windowMetrics.bounds.height() - insets.top - insets.bottom
            } else {
                windowMetrics.bounds.width() - insets.left - insets.right
            }
        } else {
            val displayMetrics = DisplayMetrics()
            activity.windowManager.defaultDisplay.getMetrics(displayMetrics)
            if (height) {
                displayMetrics.heightPixels
            } else {
                displayMetrics.widthPixels
            }
        }
    }
}