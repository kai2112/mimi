package adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import fragment.PickupFragment;
import fragment.CategoryFragment;


/**
 * Created by kai on 2016/07/10.
 */
public class MoviePageAdapter extends FragmentPagerAdapter {
    //
    private Context context;

    //
    private List<String> tabList = new ArrayList<String>() {
        {
            add("ピックアップ");
            add("ネイル");
            add("ヘアチェンジ");
        }
    };

    public MoviePageAdapter(FragmentManager fragmentManager, Context context) {
        super(fragmentManager);

        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return PickupFragment.newInstance();
        } else {
            return CategoryFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return tabList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabList.get(position);
    }
}
