package org.procoresample.ui.pull_requests;

import org.procoresample.data.model.PullRequestsModel;

import java.util.List;

public interface PullRequestsView {
    
    void showProgressDialog();

    void disableProgressDialog();

    void displayPullRequestsData(List<PullRequestsModel> pullRequestsModels);
}
