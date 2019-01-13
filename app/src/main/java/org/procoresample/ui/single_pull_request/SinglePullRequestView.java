package org.procoresample.ui.single_pull_request;

import org.procoresample.data.model.SinglePullRequestModel;

import java.util.List;

public interface SinglePullRequestView {
    void showProgressDialog();

    void disableProgressDialog();

    void displayPullRequestData(List<SinglePullRequestModel> singlePullRequestModels);
}
