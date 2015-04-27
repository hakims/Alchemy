package com.dev.foundingfourfathers.alchemy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dev.foundingfourfathers.alchemy.DrinkStrategies.MixedDrink;
import com.dev.foundingfourfathers.alchemy.DrinkStrategies.MixedDrinkListSingleton;

/**
 * Created by alihakimi on 4/27/2015.
 */
public class PossibleDrinksAdapter extends BaseAdapter {
    private final LayoutInflater dLayoutInflater;
    private final int dResourceId;

    public PossibleDrinksAdapter(LayoutInflater inflater, int resourceId) {
        dLayoutInflater = inflater;
        dResourceId = resourceId;
    }

    @Override
    public int getCount() {
        return MixedDrinkListSingleton.getMixedDrinkListSingleton().possibleDrinksToMake().size();
    }

    @Override
    public MixedDrink getItem(int position) {
        //return MixedDrink.ALL_MIXED_DRINKS[position];
        return MixedDrinkListSingleton.getMixedDrinkListSingleton().possibleDrinksToMake().get(position);
    }

    @Override
    public long getItemId(int position) {
//        return MixedDrink.ALL_MIXED_DRINKS[position].resourceId;
        return MixedDrinkListSingleton.getMixedDrinkListSingleton().possibleDrinksToMake().get(position).resourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View view;
        final ViewHolder holder;
        if (null == convertView) {
            view = dLayoutInflater.inflate(dResourceId, parent, false);
            holder = new ViewHolder();
            assert view != null;
            holder.image = (ImageView) view.findViewById(R.id.image);
            holder.title = (TextView) view.findViewById(R.id.title);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        bindView(holder, position);
        return view;
    }

    public void bindView(ViewHolder holder, int position) {
        MixedDrink mixedDrink = getItem(position);
        holder.image.setImageResource(mixedDrink.resourceId);
        holder.title.setText(mixedDrink.getName());
    }

    public static class ViewHolder {
        public ImageView image;
        public TextView title;
    }
}
