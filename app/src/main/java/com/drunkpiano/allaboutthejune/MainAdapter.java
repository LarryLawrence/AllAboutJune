/*
 * This adapter is used for displaying the main recyclerView.
 * @author DrunkPiano
 * @version 1.0
 * Modifying History:
 * Modifier: DrunkPiano, June 5th 2016, fixed to accord it with the standard coding disciplines.
 */

package com.drunkpiano.allaboutthejune;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainAdapter extends RecyclerView.Adapter {
    protected Context mContext;
    private static final int REGULAR_ITEM = 0;
    private static final int ITEM_WITH_HEADER = 1;
    private final LayoutInflater mLayoutInflater;
    private ItemCellData[] mData;
    private ItemOnClickListener mItemOnClickListener;

    public MainAdapter(Context mContext) {
        generateContentData();
        this.mContext = mContext;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    public View.OnClickListener linkListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mItemOnClickListener.onMainItemClick((Integer) v.getTag());
        }
    };

    @Override
    public int getItemViewType(int position) {
        if (position == 0 || position == 3 || position == 5
                || position == 10 || position == 15 || position == 21)
            return ITEM_WITH_HEADER;
        else
            return REGULAR_ITEM;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == REGULAR_ITEM)
            return new RegularViewHolder(mLayoutInflater.inflate
                    (R.layout.view_holder_basic, parent, false));
        else
            return new RegularViewHolderWithHeader(mLayoutInflater.
                    inflate(R.layout.view_holder_with_header, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof RegularViewHolderWithHeader) {
            ((RegularViewHolderWithHeader) holder).headerText.setText(mData[position].getmHeaderText());
            ((RegularViewHolderWithHeader) holder).title.setText(mData[position].getmTitle());
            ((RegularViewHolderWithHeader) holder).info.setText(mData[position].getmInfo());
            ((RegularViewHolderWithHeader) holder).img.setImageResource(mData[position].getmImageResourceId());
            ((RegularViewHolderWithHeader) holder).rootView.setTag(position);
            ((RegularViewHolderWithHeader) holder).rootView.setOnClickListener(linkListener);
            System.out.println("position---type-a-->" + position);
        } else if (holder instanceof RegularViewHolder) {
            ((RegularViewHolder) holder).title.setText(mData[position].getmTitle());
            ((RegularViewHolder) holder).info.setText(mData[position].getmInfo());
            ((RegularViewHolder) holder).img.setImageResource(mData[position].getmImageResourceId());
            ((RegularViewHolder) holder).rootView.setTag(position);
            ((RegularViewHolder) holder).rootView.setOnClickListener(linkListener);
            System.out.println("position---type-b-->" + position);
        }
    }

    @Override
    public int getItemCount() {
        return 15;
    }

    public class RegularViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView title;
        public TextView info;
        public ImageView img;

        public RegularViewHolder(View view) {
            super(view);
            rootView = view.findViewById(R.id.card_main);
            title = (TextView) view.findViewById(R.id.title);
            info = (TextView) view.findViewById(R.id.info);
            img = (ImageView) view.findViewById(R.id.grocery_img_view);

            TextPaint tp = title.getPaint();
            tp.setFakeBoldText(true);
        }
    }

    public class RegularViewHolderWithHeader extends RegularViewHolder {
        TextView headerText;

        public RegularViewHolderWithHeader(View view) {
            super(view);
            headerText = (TextView) view.findViewById(R.id.head_text);
        }
    }

    private void generateContentData() {
        mData = new ItemCellData[15];
        for (int i = 0; i < 15; i++)
            mData[i] = new ItemCellData();

        mData[0].setmHeaderText("6.1-6.6 数码城");
        mData[0].setmTitle("智能数码");
        mData[0].setmInfo("百万商品 5折疯抢");
        mData[0].setmImageResourceId(R.drawable.card_bg_normal_beats);

        mData[1].setmTitle("手机通讯");
        mData[1].setmInfo("0元抽奖 不止5折");
        mData[1].setmImageResourceId(R.drawable.card_bg_normal_mobile);

        mData[2].setmTitle("电脑办公");
        mData[2].setmInfo("口碑好货 低至五折");
        mData[2].setmImageResourceId(R.drawable.card_bg_normal_laptop);

        mData[3].setmHeaderText("6.7-6.9 电器城");
        mData[3].setmTitle("家用电器");
        mData[3].setmInfo("满千减百 红包大派送");
        mData[3].setmImageResourceId(R.drawable.card_bg_normal_television);

        mData[4].setmTitle("小家电");
        mData[4].setmInfo("买一送三 价保6月");
        mData[4].setmImageResourceId(R.drawable.card_bg_normal_fan);

        mData[5].setmHeaderText("6.10-6.13 日用百货城");
        mData[5].setmTitle("京东超市");
        mData[5].setmInfo("6.18元囤一年");
        mData[5].setmImageResourceId(R.drawable.card_bg_normal_television);

        mData[6].setmTitle("母婴玩具");
        mData[6].setmInfo("低至满199减100");
        mData[6].setmImageResourceId(R.drawable.card_bg_normal_child);

        mData[7].setmTitle("食品综合");
        mData[7].setmInfo("零食低至99减50");
        mData[7].setmImageResourceId(R.drawable.card_bg_normal_food);

        mData[8].setmTitle("个护清洁");
        mData[8].setmInfo("跨品类199减100");
        mData[8].setmImageResourceId(R.drawable.card_bg_normal_shampoo);

        mData[9].setmTitle("美妆盛宴");
        mData[9].setmInfo("满199减100");
        mData[9].setmImageResourceId(R.drawable.card_bg_normal_lamer);

        mData[10].setmHeaderText("6.14-6.17 服饰家居城");
        mData[10].setmTitle("超值一口价");
        mData[10].setmInfo("6.18元抢好货");
        mData[10].setmImageResourceId(R.drawable.card_bg_normal_television);

        mData[11].setmTitle("万店齐发");
        mData[11].setmInfo("买3免1");
        mData[11].setmImageResourceId(R.drawable.card_bg_normal_fan);

        mData[12].setmTitle("自营好货");
        mData[12].setmInfo("满200减100起");
        mData[12].setmImageResourceId(R.drawable.card_bg_normal_fan);

        mData[13].setmTitle("京东生活家");
        mData[13].setmInfo("满199减100");
        mData[13].setmImageResourceId(R.drawable.card_bg_normal_fan);

        mData[14].setmTitle("素人大变身");
        mData[14].setmInfo("搭配技能一站get");
        mData[14].setmImageResourceId(R.drawable.card_bg_normal_fan);
    }

    public void setOuterItemOnClickListener(ItemOnClickListener listener) {
        this.mItemOnClickListener = listener;
    }
}
