package com.hfad.bitsandpizzas_materialdesign;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CaptionedImagesAdapter extends RecyclerView.Adapter<CaptionedImagesAdapter.ViewHolder>
{
    private String[] captions;
    private int[] imageIds;
    private Listener listener;

    public static interface Listener
    {
        public void onClick(int position);
    }

    //提供指向回收視圖所使用之視圖元件的參考
    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        //定義 view holder
        private CardView cardView;
        public ViewHolder(CardView v)
        {
            super(v);
            cardView=v;
        }
    }

    public CaptionedImagesAdapter(String[] captions, int[] imageIds)
    {
        this.captions = captions;
        this.imageIds = imageIds;
    }

    public void setListener(Listener listener)
    {
        this.listener = listener;
    }

    @Override
    public CaptionedImagesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        //建立新的視圖元件
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_captioned_image, parent, false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position)
    {
        //設定視圖元件的值
        CardView cardView = holder.cardView;
        ImageView imageView = (ImageView)cardView.findViewById(R.id.info_image);
        Drawable drawable = cardView.getResources().getDrawable(imageIds[position]);
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(captions[position]);
        TextView textView = (TextView)cardView.findViewById(R.id.info_text);
        textView.setText(captions[position]);
        cardView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (listener != null)
                {
                    listener.onClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount()
    {
        //回傳資料集的項目數量
        return captions.length;
    }
}
