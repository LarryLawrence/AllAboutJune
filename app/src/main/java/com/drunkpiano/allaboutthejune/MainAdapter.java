/*
 * This adapter is used for displaying the guide recyclerView.
 * @author DrunkPiano
 * @version 1.1.2
 * Modifying History:
 * Modifier: DrunkPiano, June 3rd 2016, fix it to accord with standard coding disciplines;
 */

package com.drunkpiano.allaboutthejune;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainAdapter extends RecyclerView.Adapter {
    protected Context mContext;
    private final LayoutInflater mLayoutInflater;

    public MainAdapter(Context mContext) {
        this.mContext = mContext;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new GuideViewHolder(mLayoutInflater.inflate
                    (R.layout.view_holder_basic, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        GuideViewHolder gv = (GuideViewHolder) holder;
        String title = "";
        String info = "";
        switch (position) {
            case 0:
                title = "智能数码";
                info = "百万商品 5折疯抢";
                break;
            case 1:
                title = "手机通讯";
                info = "0元抽奖 不止5折";
                break;
            case 2:
                title = "电脑办公";
                info = "满千减百 红包大派送";
                break;
            case 3:
                title = "Q: 主页右上角的「时光机」按钮是随机到某一天的吗?";
                info = "A: 是的，每次点击会随机来到2014年9月19日到今天之间的某一天。";
                break;
            case 4:
                title = "Q: 有时候点进去之后会提示登录？";
                info = "A: Android WebView的loadUrl()函数有时候会把原本正确的地址转换成urlEncode编码，这似乎是Android源码的问题，目前我还没有找到解决办法。出现这种情况时，烦请移驾右上角「使用知乎客户端打开」。";
                break;
            case 5:
                title = "Q: 如何在知乎APP中打开答案？";
                info = "A: 可以在应用内阅读的时候在右上角菜单选择用知乎打开; 也可以在设置中选择默认打开方式。";
                break;
            case 6:
                title = "Q: 怎么回到历史上具体的某一天?";
                info = "A: 点击右上角菜单中的「回到过去」。";
                break;
            case 7:
                title = "Q: 获取数据的速度好像有点慢，是不是加载了很多东西？";
                info = "A: 连接kanzhihu.com的速度确实不够快，但加载答案列表的数据量很小，是纯文字，每次大约30KB。4G网络下首次建立连接大约需要8秒，连接建立之后，再次加载的速度只需要不到1秒。";
                break;
            case 8:
                title = "Q: 答案页底部的奇怪符号是什么?";
                info = "A: 是乐谱中的「四分休止符」。点击它可以回到页面顶端。";
                break;
            case 9:
                title = "Q: 开发者是谁?";
                info = "A: 在「关于」页面可以找到，有任何问题或建议都可以给我私信/写邮件。谢谢:)";
                break;
        }
        gv.title.setText(title);
        gv.info.setText(info);
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class GuideViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView info;
        View rootView;

        public GuideViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            info = (TextView) view.findViewById(R.id.info);
            rootView = view.findViewById(R.id.card_main);
        }
    }
}
