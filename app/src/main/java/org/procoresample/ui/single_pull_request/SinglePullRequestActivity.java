package org.procoresample.ui.single_pull_request;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import org.procoresample.R;
import org.procoresample.data.model.SinglePullRequestModel;

import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

import static org.procoresample.utils.Constants.NUMBER_PARAMETER;

public class SinglePullRequestActivity extends AppCompatActivity implements SinglePullRequestView{

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
   // @BindView(R.id.progress_bar)
  //  ProgressBar progressBar;

    private SinglePullRequestPresenterImpl singlePullRequestPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_pull_request);
        ButterKnife.bind(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        Bundle b = getIntent().getExtras();
        assert b != null;
        String number = b.getString(NUMBER_PARAMETER);
        //  String number = "2965";

        singlePullRequestPresenter = new SinglePullRequestPresenterImpl(this);
        singlePullRequestPresenter.getSinglePullRequestFiles(number);

    }

    @Override
    public void showProgressDialog() {
     //   progressBar.setVisibility(View.VISIBLE);
        mRecyclerView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void disableProgressDialog() {
       // progressBar.setVisibility(View.GONE);
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void displayPullRequestData(List<SinglePullRequestModel> singlePullRequestModels) {
        SinglePullRequestsAdapter singlePullRequestsAdapter = new SinglePullRequestsAdapter(singlePullRequestModels);
        mRecyclerView.setAdapter(singlePullRequestsAdapter);
        singlePullRequestsAdapter.notifyDataSetChanged();
    }
}
