package org.procoresample.ui.single_pull_request;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import org.procoresample.R;
import org.procoresample.data.model.SinglePullRequestModel;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

import static org.procoresample.utils.Utils.convertString;

public class SinglePullRequestsAdapter extends RecyclerView.Adapter<SinglePullRequestsAdapter.ViewHolder> {

    private List<SinglePullRequestModel> feedItemList;

    SinglePullRequestsAdapter(List<SinglePullRequestModel> feedItemList) {
        this.feedItemList = feedItemList;
    }

    @NonNull
    @Override
    public SinglePullRequestsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.adapter_single_pull_request, parent, false);
        return new SinglePullRequestsAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SinglePullRequestsAdapter.ViewHolder holder, final int position) {
        final SinglePullRequestModel feedItem = feedItemList.get(position);

        holder.txtLeftPatch.setText(convertString(feedItem.getPatch(),"\n+","\n-"), TextView.BufferType.SPANNABLE);
        holder.txtRightPatch.setText(convertString(feedItem.getPatch(),"\n-","\n+"), TextView.BufferType.SPANNABLE);

    }

    @Override
    public int getItemCount() {
        return (null != feedItemList ? feedItemList.size() : 0);
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.text_view_left_patch)
        TextView txtLeftPatch;
        @BindView(R.id.text_view_right_patch)
        TextView txtRightPatch;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setTag(itemView);
        }
    }
}


