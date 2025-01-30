import { Component } from '@angular/core';
import { ApplicationFormComponent } from '../components/application-form/application-form.component';

@Component({
  selector: 'app-home',
  imports: [ApplicationFormComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {

}
