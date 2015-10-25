package Model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;

import butterknife.Bind;
import butterknife.ButterKnife;
import myexamples.testingrealm.com.realmrecyclerview.R;


/**
 * Created by rob2cool on 9/9/15.
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> implements View
        .OnClickListener {

    public ArrayList<PersonObj> mItemTypes;
    Context context;

    TextView nameView;



    public ListAdapter(Collection<PersonObj> mItemTypes, Context context) {
        this.mItemTypes = new ArrayList<>(mItemTypes);
        this.context = context;

    }
    public void addItem(int position,PersonObj name) {
        if (position > mItemTypes.size()) return;

        mItemTypes.add(position, name);
        notifyItemInserted(position);
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.simplelistitem,
                parent, false);

        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
     holder.nameView.setText(mItemTypes.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return mItemTypes.size();
    }

    @Override
    public void onClick(View v) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.name_view)
        TextView nameView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(itemView);


        }
    }

}
