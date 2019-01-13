package org.procoresample.ui.pull_requests;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import org.procoresample.R;
import org.procoresample.data.model.PullRequestsModel;
import org.procoresample.ui.single_pull_request.SinglePullRequestActivity;
import org.procoresample.utils.ItemClickListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static org.procoresample.utils.Constants.NUMBER_PARAMETER;
import static org.procoresample.utils.Utils.loadImage;

public class PullRequestsAdapter extends RecyclerView.Adapter<PullRequestsAdapter.ViewHolder> {

    private List<PullRequestsModel> feedItemList;
    private Context mContext;

    PullRequestsAdapter(Context mContext, List<PullRequestsModel> feedItemList) {
        this.feedItemList = feedItemList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public PullRequestsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.adapter_pull_requests, parent, false);
        return new PullRequestsAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PullRequestsAdapter.ViewHolder holder, final int position) {
        final PullRequestsModel feedItem = feedItemList.get(position);

        holder.setClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(mContext,SinglePullRequestActivity.class);
                intent.putExtra(NUMBER_PARAMETER, feedItem.getNumber());
                mContext.startActivity(intent);
            }
        });

        holder.txtTitle.setText(feedItem.getTitle());
        holder.txtNumber.setText(feedItem.getNumber());
        loadImage(mContext,feedItem.getUser().getAvatar_url(),holder.imgAvatar);
    }


    @Override
    public int getItemCount() {
        return (null != feedItemList ? feedItemList.size() : 0);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.image_view_avatar)
        ImageView imgAvatar;
        @BindView(R.id.text_view_title)
        TextView txtTitle;
        @BindView(R.id.text_view_number)
        TextView txtNumber;

        private ItemClickListener clickListener;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setTag(itemView);
            itemView.setOnClickListener(this);
        }

        void setClickListener(ItemClickListener itemClickListener) {
            this.clickListener = itemClickListener;
        }

        @Override
        public void onClick(View view) {
            clickListener.onClick(view, getAdapterPosition());
        }
    }
}



