import {Component, OnInit} from '@angular/core';
import {WelcomeMessageService} from "./welcome-message.service";
import {environment} from "../../environments/environment";

@Component({
  selector: 'app-index',
  template: `Welcome to the {{welcomeMessage}}!`
})
export class IndexComponent implements OnInit {
  welcomeMessage: string;

  constructor(private welcomeMessageService: WelcomeMessageService) {
  }

  ngOnInit() {
    this.welcomeMessageService.fetchWelcomeMessageFor(environment.eventName)
      .subscribe(response => {
        this.welcomeMessage = response.welcomeMessage;
      })
  }

}
