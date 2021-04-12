package com.example.remindme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.remindme.customComponent.SwipeDisabledViewPager;
import com.example.remindme.view.ViewFloatingButton;

public class MainActivity extends AppCompatActivity implements OnAddContentClickListener{

    private final int ID_ADD_CONTENT = 1;
    private final int ID_HOME = 2;
    private final int ID_SORT = 3;

    private SwipeDisabledViewPager viewPager;
    private ViewPageAdapter adapter;

    private int previousPage;
    private int currentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Sembuyikan header/toolbar
        getSupportActionBar().hide();

        //Inisiasi
        ViewFloatingButton viewFloatingButton = new ViewFloatingButton();

        initializationRecyclerView();
        initializationFloatingButton(viewFloatingButton);
        initializationBottomNav(viewFloatingButton);

        onSortButtonClick(viewFloatingButton);
    }

    private void initializationRecyclerView(){
        viewPager = findViewById(R.id.viewPager);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        adapter = new ViewPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentAddContent(), "AddContact");
        adapter.addFragment(new FragmentHome(), "Home");

        viewPager.setAdapter(adapter);
    }

    private void initializationFloatingButton(ViewFloatingButton viewFloatingButton){
        viewFloatingButton.setByDifficultyButton(findViewById(R.id.sortByDifficultyButton));
        viewFloatingButton.setByDateButton(findViewById(R.id.sortByDateButton));
        viewFloatingButton.setByCreatedButton(findViewById(R.id.sortByDefaultButton));
        viewFloatingButton.setFromBottom(AnimationUtils.loadAnimation(this, R.anim.from_bottom_animation));
        viewFloatingButton.setToBottom(AnimationUtils.loadAnimation(this, R.anim.to_bottom_animation));
    }

    private void initializationBottomNav(ViewFloatingButton viewFloatingButton) {
        MeowBottomNavigation bottomNavigation = findViewById(R.id.footer);
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_ADD_CONTENT, R.drawable.ic_add_content));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_HOME, R.drawable.ic_home));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_SORT, R.drawable.ic_sort));

        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener(){
            @Override
            public void onShowItem(MeowBottomNavigation.Model item){
                int selectedPage;
                previousPage = currentPage;
                switch (item.getId()){
                    case 1:{
                        selectedPage = 0;
                        currentPage = 1;
                        break;
                    }
                    case 2:{
                        selectedPage = 1;
                        currentPage = 2;
                        break;
                    }
                    case 3:{
                        selectedPage = 1;
                        currentPage = 3;
                    }
                    default:{
                        selectedPage = 1;
                    }
                }
                onFloatingButtonClick(viewFloatingButton);
                viewPager.setCurrentItem(selectedPage, true);
            }
        });

                bottomNavigation.show(ID_HOME, true);

        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
            }
        });

        bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {
            }
        });
    }

    private void onFloatingButtonClick(ViewFloatingButton viewFloatingButton){
        TextView byDifficultyLabel = findViewById(R.id.labelByDifficulty);
        TextView byDateLabel = findViewById(R.id.labelByDate);
        TextView byCreatedLabel = findViewById(R.id.labelByDefault);

        if(currentPage == ID_SORT){
            viewFloatingButton.getByDifficultyButton().setVisibility(View.VISIBLE);
            viewFloatingButton.getByCreatedButton().setVisibility(View.VISIBLE);
            viewFloatingButton.getByDateButton().setVisibility(View.VISIBLE);

            byDifficultyLabel.setVisibility(View.VISIBLE);
            byDateLabel.setVisibility(View.VISIBLE);
            byCreatedLabel.setVisibility(View.VISIBLE);

            viewFloatingButton.getByDifficultyButton().startAnimation(viewFloatingButton.getFromBottom());
            viewFloatingButton.getByCreatedButton().startAnimation(viewFloatingButton.getFromBottom());
            viewFloatingButton.getByDateButton().startAnimation(viewFloatingButton.getFromBottom());
            byDifficultyLabel.startAnimation(viewFloatingButton.getFromBottom());
            byDateLabel.startAnimation(viewFloatingButton.getFromBottom());
            byCreatedLabel.startAnimation(viewFloatingButton.getFromBottom());

        }
        else if(previousPage == ID_SORT){
            viewFloatingButton.getByDifficultyButton().setVisibility(View.INVISIBLE);
            viewFloatingButton.getByCreatedButton().setVisibility(View.INVISIBLE);
            viewFloatingButton.getByDateButton().setVisibility(View.INVISIBLE);

            byDifficultyLabel.setVisibility(View.INVISIBLE);
            byDateLabel.setVisibility(View.INVISIBLE);
            byCreatedLabel.setVisibility(View.INVISIBLE);

            viewFloatingButton.getByDifficultyButton().startAnimation(viewFloatingButton.getToBottom());
            viewFloatingButton.getByCreatedButton().startAnimation(viewFloatingButton.getToBottom());
            viewFloatingButton.getByDateButton().startAnimation(viewFloatingButton.getToBottom());

            byDifficultyLabel.startAnimation(viewFloatingButton.getToBottom());
            byDateLabel.startAnimation(viewFloatingButton.getToBottom());
            byCreatedLabel.startAnimation(viewFloatingButton.getToBottom());
        }
    }

    private void onSortButtonClick(ViewFloatingButton viewFloatingButton){
        viewFloatingButton.getByCreatedButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentHome fragment = (FragmentHome) adapter.getItem(1);
                if(fragment!=null){
                    fragment.updateContentOrder(1);
                }
            }
        });
        viewFloatingButton.getByDateButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentHome fragment = (FragmentHome) adapter.getItem(1);
                if(fragment!=null){
                    fragment.updateContentOrder(2);
                }
            }
        });
        viewFloatingButton.getByDifficultyButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentHome fragment = (FragmentHome) adapter.getItem(1);
                if(fragment!=null){
                    fragment.updateContentOrder(3);
                }
            }
        });
    }

    @Override
    public void onClickListener(Content content) {
        FragmentHome fragment = (FragmentHome) adapter.getItem(1);
        if(fragment!=null){
            fragment.insertContent(content);
        }
    }
}