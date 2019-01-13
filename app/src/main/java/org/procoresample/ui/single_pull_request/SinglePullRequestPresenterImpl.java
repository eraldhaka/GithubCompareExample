package org.procoresample.ui.single_pull_request;

import org.procoresample.data.model.SinglePullRequestModel;
import org.procoresample.data.network.ApiHelper;
import org.procoresample.data.network.AppApiHelper;
import java.util.List;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SinglePullRequestPresenterImpl implements SinglePullRequestPresenter {

    private SinglePullRequestActivity singlePullRequestActivity;
    private ApiHelper apiHelper;

    SinglePullRequestPresenterImpl(SinglePullRequestActivity singlePullRequestActivity) {
        this.singlePullRequestActivity = singlePullRequestActivity;
        apiHelper = new AppApiHelper();
    }


    @Override
    public void getSinglePullRequestFiles(String number) {

        singlePullRequestActivity.showProgressDialog();
        apiHelper.getSinglePullRequestFiles(number)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<SinglePullRequestModel>>() {
                    @Override
                    public void onCompleted() {
                        //
                    }

                    @Override
                    public void onError(Throwable e) {
                        singlePullRequestActivity.disableProgressDialog();
                    }

                    @Override
                    public void onNext(List<SinglePullRequestModel> singlePullRequestModels) {
                        singlePullRequestActivity.disableProgressDialog();
                        singlePullRequestActivity.displayPullRequestData(singlePullRequestModels);
                    }
                });

    }
}
