package org.procoresample.ui.pull_requests;

import org.procoresample.data.model.PullRequestsModel;
import org.procoresample.data.network.ApiHelper;
import org.procoresample.data.network.AppApiHelper;
import java.util.List;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class PullRequestsPresenterImpl implements PullRequestsPresenter {

    private PullRequestsActivity pullRequestsActivity;
    private ApiHelper apiHelper;

    PullRequestsPresenterImpl(PullRequestsActivity pullRequestsActivity) {

        this.pullRequestsActivity = pullRequestsActivity;
        apiHelper = new AppApiHelper();
    }
    @Override
    public void getPullRequestsData() {

        pullRequestsActivity.showProgressDialog();
        apiHelper.getPullRequestsData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<PullRequestsModel>>() {
                    @Override
                    public void onCompleted() {
                        //
                    }

                    @Override
                    public void onError(Throwable e) {
                        pullRequestsActivity.disableProgressDialog();
                    }

                    @Override
                    public void onNext(List<PullRequestsModel> pullRequestsModels) {
                        pullRequestsActivity.disableProgressDialog();

                        pullRequestsActivity.displayPullRequestsData(pullRequestsModels);
                    }
                });

    }
}
