import {Component} from '@angular/core';
import {Routeroutlet} from '@angular/router';
import {LoginComponent} from './login/login.component';

@Component({
    selector:'app-root',
    standalone:true,
    imports:[RouterOutlet,LoginComponent],
    templateurl:'./app.component.html',
    styleurl:'./app.component.css'
})

export class AppComponent {
    title = 'my-login-app';
}