package org.procoresample.data.network;


import org.procoresample.data.model.PullRequestsModel;
import org.procoresample.data.model.SinglePullRequestModel;
import java.util.List;

import rx.Observable;

public interface ApiHelper {
    Observable<List<PullRequestsModel>> getPullRequestsData();

    Observable<List<SinglePullRequestModel>> getSinglePullRequestFiles(String number);
}
