package app.butterknifedemo.app.butterknifedemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import app.butterknifedemo.R;
import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by parna on 22/1/16.
 */
public class ListviewAdapter extends BaseAdapter {

    LayoutInflater inflater;
    Context context;

    public ListviewAdapter(LayoutInflater inflater, Context context) {
        this.inflater = inflater;
        this.context = context;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        View view = inflater.inflate(R.layout.listview_item, parent, false);
        holder = new ViewHolder(view);

       // Picasso.with(inflater.getContext()).load("http://lorempixel.com/200/200/sports/" + (position+1)).into(holder.image);
        Picasso.with(context).load(R.drawable.iclauncher).into(holder.image);
        holder.text.setText("This is a text for the image number: "+position);

        return view;

    }

    static class ViewHolder{
        @InjectView(R.id.image_in_item)
        ImageView image;
        @InjectView(R.id.textview_in_item)
        TextView text;

        public ViewHolder(View view){
            ButterKnife.inject(this, view);
        }
    }

}
