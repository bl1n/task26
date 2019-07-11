package com.lft.task26;

import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final float dp = getResources().getDisplayMetrics().density;
        final float sp = getResources().getDisplayMetrics().scaledDensity;

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {

            FrameLayout root = new FrameLayout(this);
            root.setPadding(16 * (int)dp, 16 * (int)dp , 16 * (int)dp, 16 * (int)dp );
            FrameLayout.LayoutParams frameParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            root.setLayoutParams(frameParams);


            RelativeLayout relativeLayout = new RelativeLayout(this);
            RelativeLayout.LayoutParams relParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

            root.addView(relativeLayout,relParams );

            ImageView ivIcon = new ImageView(this);
            ivIcon.setId(11);
            ivIcon.setScaleType(ImageView.ScaleType.CENTER_CROP);
            ivIcon.setImageResource(R.mipmap.ic_launcher);
            ViewGroup.LayoutParams linParams = new ViewGroup.LayoutParams(192*(int)dp,128*(int)dp);
            relativeLayout.addView(ivIcon, linParams);


            TextView tvTitle = new TextView(this);
            tvTitle.setId(12);
            tvTitle.setText(getResources().getString(R.string.elafonisy_beach));
            tvTitle.setTextSize(28 * sp);
            tvTitle.setTypeface(null, Typeface.BOLD);
            RelativeLayout.LayoutParams tvTitleParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            tvTitleParams.setMargins(8 * (int)dp, 0, 0, 0);
            tvTitleParams.setMarginStart(8 * (int)dp);
            tvTitleParams.addRule(RelativeLayout.ALIGN_TOP, ivIcon.getId());
            tvTitleParams.addRule(RelativeLayout.END_OF, ivIcon.getId());
            tvTitleParams.addRule(RelativeLayout.RIGHT_OF, ivIcon.getId());
            relativeLayout.addView(tvTitle,tvTitleParams );



            TextView tvQuote = new TextView(this);
            tvQuote.setText(getResources().getText(R.string.description));
            tvQuote.setTypeface(null, Typeface.ITALIC);
            tvQuote.setTextSize(14 * sp);
            RelativeLayout.LayoutParams tvQuoteParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//            tvQuoteParams.addRule(RelativeLayout.ALIGN_BOTTOM, ivIcon.getId());
            tvQuoteParams.addRule(RelativeLayout.ALIGN_LEFT, tvTitle.getId());
            tvQuoteParams.addRule(RelativeLayout.ALIGN_START, tvTitle.getId());
            tvQuoteParams.addRule(RelativeLayout.BELOW, tvTitle.getId());
            tvQuoteParams.setMargins(0, 8 * (int)dp, 0, 0);
            relativeLayout.addView(tvQuote, tvQuoteParams);

            EditText etComment = new EditText(this);
            etComment.setInputType(InputType.TYPE_CLASS_TEXT);
            etComment.setId(111);
            RelativeLayout.LayoutParams etCommentParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            etCommentParams.setMargins(0, 8 * (int)dp, 0, 0);
            etComment.setHint(getResources().getString(R.string.etcomment));
            etComment.setTextSize(14 * sp);
            etCommentParams.addRule(RelativeLayout.BELOW, ivIcon.getId());
            etComment.setLayoutParams(etCommentParams);
            relativeLayout.addView(etComment);


            LinearLayout linearLayout = new LinearLayout(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.addRule(RelativeLayout.BELOW, etComment.getId());
            linearLayout.setLayoutParams(layoutParams);
            relativeLayout.addView(linearLayout);

            Button btnPrevious = new Button(this);
            LinearLayout.LayoutParams btnPreviousParams = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT,1f);
            btnPrevious.setLayoutParams(btnPreviousParams);
            btnPrevious.setText(getResources().getString(R.string.btn_previous));
            linearLayout.addView(btnPrevious);

            Button btnNext = new Button(this);
            LinearLayout.LayoutParams btnNextParams = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT,1f);
            btnNext.setLayoutParams(btnNextParams);
            btnNext.setText(getResources().getString(R.string.btn_next));
            linearLayout.addView(btnNext);

            setContentView(root);
        }


    }


}
