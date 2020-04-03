package com.hackaton.covid19.welcome_message.adapters.presentation.presenters;

import com.hackaton.covid19.welcome_message.adapters.presentation.presenters.viewmodels.WelcomeMessageViewModel;
import com.hackaton.covid19.welcome_message.application.outbound_ports.presenters.WelcomeMessagePresenter;
import com.hackaton.covid19.welcome_message.domain.values.WelcomeMessage;
import org.springframework.http.ResponseEntity;

public class RestWelcomeMessagePresenter extends RestPresenter<WelcomeMessageViewModel> implements WelcomeMessagePresenter {


    @Override
    public void present(WelcomeMessage welcomeMessage) {
        WelcomeMessageViewModel viewModel = new WelcomeMessageViewModel();
        viewModel.setWelcomeMessage(welcomeMessage.toString());
        this.response = ResponseEntity.ok(viewModel);
    }

}
