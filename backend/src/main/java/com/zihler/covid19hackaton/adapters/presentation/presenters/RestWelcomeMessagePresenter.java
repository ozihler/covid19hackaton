package com.zihler.covid19hackaton.adapters.presentation.presenters;

import com.zihler.covid19hackaton.adapters.presentation.presenters.viewmodels.WelcomeMessageViewModel;
import com.zihler.covid19hackaton.application.outbound_ports.presenters.WelcomeMessagePresenter;
import com.zihler.covid19hackaton.domain.values.WelcomeMessage;
import org.springframework.http.ResponseEntity;

public class RestWelcomeMessagePresenter extends RestPresenter<WelcomeMessageViewModel> implements WelcomeMessagePresenter {


    @Override
    public void present(WelcomeMessage welcomeMessage) {
        WelcomeMessageViewModel viewModel = new WelcomeMessageViewModel();
        viewModel.setWelcomeMessage(welcomeMessage.toString());
        this.response = ResponseEntity.ok(viewModel);
    }

}
