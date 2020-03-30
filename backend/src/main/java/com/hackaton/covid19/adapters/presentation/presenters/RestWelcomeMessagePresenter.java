package com.hackaton.covid19.adapters.presentation.presenters;

import com.hackaton.covid19.adapters.presentation.presenters.viewmodels.WelcomeMessageViewModel;
import com.hackaton.covid19.application.outbound_ports.presenters.WelcomeMessagePresenter;
import com.hackaton.covid19.domain.values.WelcomeMessage;
import org.springframework.http.ResponseEntity;

public class RestWelcomeMessagePresenter extends RestPresenter<WelcomeMessageViewModel> implements WelcomeMessagePresenter {


    @Override
    public void present(WelcomeMessage welcomeMessage) {
        WelcomeMessageViewModel viewModel = new WelcomeMessageViewModel();
        viewModel.setWelcomeMessage(welcomeMessage.toString());
        this.response = ResponseEntity.ok(viewModel);
    }

}
