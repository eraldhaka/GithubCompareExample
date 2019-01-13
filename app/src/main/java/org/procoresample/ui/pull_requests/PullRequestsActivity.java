package org.procoresample.ui.pull_requests;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import org.procoresample.R;
import org.procoresample.data.model.PullRequestsModel;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

public class PullRequestsActivity extends AppCompatActivity implements PullRequestsView{

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    private PullRequestsPresenterImpl pullRequestsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_requests);

        ButterKnife.bind(this);
        pullRequestsPresenter = new PullRequestsPresenterImpl(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        pullRequestsPresenter.getPullRequestsData();
    }

    @Override
    public void showProgressDialog() {
        progressBar.setVisibility(View.VISIBLE);
        mRecyclerView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void disableProgressDialog() {
        progressBar.setVisibility(View.GONE);
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void displayPullRequestsData(List<PullRequestsModel> pullRequestsModels) {
        PullRequestsAdapter pullRequestsAdapter = new PullRequestsAdapter(this, pullRequestsModels);
        mRecyclerView.setAdapter(pullRequestsAdapter);
        pullRequestsAdapter.notifyDataSetChanged();
    }
}
