package org.procoresample.data.network;

import org.procoresample.data.model.PullRequestsModel;
import org.procoresample.data.model.SinglePullRequestModel;
import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;


public interface API {

    @GET("pulls")
    Observable<List<PullRequestsModel>> getPullRequestsData();

    @GET("pulls/{number}/files")
    Observable<List<SinglePullRequestModel>> getSinglePullRequestFiles(@Path("number") String number);
}
