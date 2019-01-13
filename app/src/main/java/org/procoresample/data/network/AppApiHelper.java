package org.procoresample.data.network;

import org.procoresample.data.model.PullRequestsModel;
import org.procoresample.data.model.SinglePullRequestModel;
import java.util.List;
import rx.Observable;

public class AppApiHelper implements ApiHelper {

    @Override
    public Observable<List<PullRequestsModel>> getPullRequestsData() {
        return APIClient.getData().getPullRequestsData();
    }

    @Override
    public Observable<List<SinglePullRequestModel>>  getSinglePullRequestFiles(String number) {
        return APIClient.getData().getSinglePullRequestFiles(number);
    }
}
