import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";
import {WelcomeMessage} from "./welcome-message";

@Injectable({
  providedIn: 'root'
})
export class WelcomeMessageService {

  constructor(private http: HttpClient) {
  }

  fetchWelcomeMessageFor(eventName: string): Observable<WelcomeMessage> {
    const params = new HttpParams().set("eventName", eventName);
    return this.http.get<WelcomeMessage>(environment.baseUrl + "/dummy", {params});
  }
}
