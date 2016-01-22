package app.butterknifedemo.app.butterknifedemo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import app.butterknifedemo.R;
import app.butterknifedemo.app.butterknifedemo.adapter.ListviewAdapter;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import butterknife.OnItemClick;


public class ButterKnifeFragment extends Fragment {

    @InjectView(R.id.text)
    TextView textview;
    @InjectView(R.id.button)
    Button button;
    @InjectView(R.id.listview)
    ListView listview;

    Context mContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_butter_knife, container, false);
        ButterKnife.inject(this, view);
        textview.setText("This Fragment use Butter Knife!");
        button.setText("Fragment button");
        listview.setAdapter(new ListviewAdapter((LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE), mContext));
       
        return view;

    }

    @OnClick(R.id.button)
    void onClick() {
        Toast.makeText(getActivity(), "Fragment Button onClick!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @OnItemClick(R.id.listview)
    void onItemClick(int position){
        Toast.makeText(getActivity(), "ListView clicked position"+position, Toast.LENGTH_SHORT).show();
    }

}
