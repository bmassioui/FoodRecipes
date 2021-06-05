package com.bob.foodrecipes;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.res.ResourcesCompat;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;

import java.io.File;

import adapters.DatabaseAdapter;
import adapters.ViewPagerAdapter;
import models.Recipe;
import utils.ResultCodes;

public class ViewRecipeActivity extends ToolbarActivity {

    private ViewPagerAdapter mAdapter;
    private Recipe currentRecipe;
    private DatabaseAdapter databaseAdapter;

    private ImageView mRecipeImage;
    private TextView mRecipeDescription;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_recipe);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        currentRecipe = getIntent().getParcelableExtra("recipe");
        databaseAdapter = DatabaseAdapter.getInstance(this);
        findViewsById();

        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle(currentRecipe.getName());
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mRecipeImage.setImageURI(Uri.fromFile(new File(currentRecipe.getImagePath())));
        mRecipeDescription.setText(currentRecipe.getDescription());

        mTabLayout.bringToFront();
        mAdapter = new ViewPagerAdapter(getSupportFragmentManager(), currentRecipe);

        Typeface robotMeduimFont = ResourcesCompat.getFont(this, R.font.robot_meduim);
        mCollapsingToolbarLayout.setCollapsedTitleTypeface(robotMeduimFont);
        mCollapsingToolbarLayout.setExpandedTitleTypeface(robotMeduimFont);

        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.setTabsFromPagerAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.view_recipe_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.edit_recipe:
                Intent intent = new Intent();
                intent.putExtra("recipe", currentRecipe);
                setResult(ResultCodes.RECIPE_SHOULD_BE_EDITED, intent);
                finish();
                break;
            case R.id.delete_recipe:
                Intent data = new Intent();
                data.putExtra("recipeId", currentRecipe.getId());
                setResult(ResultCodes.RECIPE_SHOULD_BE_DELETED, data);
                finish();
                break;
            case android.R.id.home:
                onBackPressed();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void findViewsById() {
        mRecipeImage = findViewById(R.id.recipe_image);
        mRecipeDescription = findViewById(R.id.recipe_description);
        mToolbar = findViewById(R.id.toolbar);
        mViewPager = findViewById(R.id.viewpager);
        mTabLayout = findViewById(R.id.tablayout);
        mCollapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
    }
}
