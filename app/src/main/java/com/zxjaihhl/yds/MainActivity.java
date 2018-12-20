package com.zxjaihhl.yds;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zxjaihhl.yds.fragment.EquipmentFragment;
import com.zxjaihhl.yds.fragment.FindFragment;
import com.zxjaihhl.yds.fragment.MessageFragment;
import com.zxjaihhl.yds.fragment.MyFragment;
import com.zxjaihhl.yds.manager.ClientManager;
import com.zxjaihhl.yds.utils.UtilTools;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RelativeLayout rl_go;
    private TextView tv_go;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<String> mTitle;
    private List<Fragment> mFragments;
    private TabLayout.Tab one;
    private TabLayout.Tab two;
    private TabLayout.Tab three;
    private TabLayout.Tab four;
    private Fragment equipmentFragment, findFragment, messageFragment, myFragment;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏标题
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_main);
        initDate();
        initView();
    }
    private void initDate() {
        equipmentFragment = new EquipmentFragment();
        findFragment = new FindFragment();
        messageFragment = new MessageFragment();
        myFragment = new MyFragment();
        mTitle = new ArrayList<>();
        mTitle.add("Light");
        mTitle.add("Speed");
        mTitle.add("Check");
        mTitle.add("Battery");
        mFragments = new ArrayList<>();
        mFragments.add(equipmentFragment);
        mFragments.add(findFragment);
        mFragments.add(messageFragment);
        mFragments.add(myFragment);
    }
    private void initView() {
        rl_go= (RelativeLayout) findViewById(R.id.rl_go);
        rl_go.setVisibility(View.VISIBLE);
        rl_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        tv_go= (TextView) findViewById(R.id.tv_go);
        //设置字体
        UtilTools.setlFont(this,tv_go);
        mTabLayout = (TabLayout) findViewById(R.id.mTabLayout);
        mViewPager = (ViewPager) findViewById(R.id.mViewPager);
        //预加载
        mViewPager.setOffscreenPageLimit(mFragments.size());
        //ViewPager滑动监听
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    one.setIcon(getResources().getDrawable(R.mipmap.equipment));
                    two.setIcon(getResources().getDrawable(R.mipmap.find_one));
                    three.setIcon(getResources().getDrawable(R.mipmap.message_one));
                    four.setIcon(getResources().getDrawable(R.mipmap.my_one));
                    rl_go.setVisibility(View.VISIBLE);

                } else if (position == 1) {
                    one.setIcon(getResources().getDrawable(R.mipmap.equipment));
                    two.setIcon(getResources().getDrawable(R.mipmap.find_tow));
                    three.setIcon(getResources().getDrawable(R.mipmap.message_one));
                    four.setIcon(getResources().getDrawable(R.mipmap.my_one));
                    rl_go.setVisibility(View.GONE);

                } else if (position == 2) {
                    one.setIcon(getResources().getDrawable(R.mipmap.equipment));
                    two.setIcon(getResources().getDrawable(R.mipmap.find_one));
                    three.setIcon(getResources().getDrawable(R.mipmap.message_tow));
                    four.setIcon(getResources().getDrawable(R.mipmap.my_one));
                    rl_go.setVisibility(View.GONE);

                } else if (position == 3) {
                    one.setIcon(getResources().getDrawable(R.mipmap.equipment));
                    two.setIcon(getResources().getDrawable(R.mipmap.find_one));
                    three.setIcon(getResources().getDrawable(R.mipmap.message_one));
                    four.setIcon(getResources().getDrawable(R.mipmap.my_tow));
                    rl_go.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //设置适配器
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            private int[] imageResId = {
//                    R.mipmap.ic_launcher,
//                    R.mipmap.ic_launcher,
//                    R.mipmap.ic_launcher,
//                    R.mipmap.ic_launcher,
            };

            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }


            //设置标题
            @Override
            public CharSequence getPageTitle(int position) {
                //底部图片加载 文字前面
//                Drawable image = getResources().getDrawable(imageResId[position]);
//                image.setBounds(0, 0, 70, 70);
//                SpannableString sb = new SpannableString(" " + mTitle.get(position));
//                ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
//                sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//                return sb;
                return null;
            }
        });
        mTabLayout.setupWithViewPager(mViewPager);
        //底部图片加载 文字上面
        one = mTabLayout.getTabAt(0);
        two = mTabLayout.getTabAt(1);
        three = mTabLayout.getTabAt(2);
        four = mTabLayout.getTabAt(3);
        one.setIcon(getResources().getDrawable(R.mipmap.equipment));
        two.setIcon(getResources().getDrawable(R.mipmap.find_one));
        three.setIcon(getResources().getDrawable(R.mipmap.message_one));
        four.setIcon(getResources().getDrawable(R.mipmap.my_one));
    }

    @Override
    protected void onPause() {
        super.onPause();
        ClientManager.getClient().stopSearch();
    }

}



