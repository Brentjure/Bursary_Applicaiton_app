import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-application-form',
  imports: [FormsModule, HttpClientModule],
  templateUrl: './application-form.component.html',
  styleUrl: './application-form.component.css'
})
export class ApplicationFormComponent {
  applicationObj: any = {
    "id": 1,
    "first_name": "George",
    "last_name": "Otieno",
    "email": "george.otieno@example.com",
    "phone_number": "+254718303158",
    "gender": "M",
    "kcse_grade": "A",
    "school": "University of Nairobi",
    "programe_fees": "2000000"
}

http = inject(HttpClient);

  onSubmitEmployee(){
    console.log(JSON.stringify(this.applicationObj))

    const headers = { 'Content-Type': 'application/json' };    debugger;
    try{
      this.http.post('http://localhost:8080/api/v1/post-application',
        JSON.stringify(this.applicationObj),
        { headers }
      ).subscribe((res:any)=>{
        debugger;
        alert(res.message)
      })

    } catch(error){
      console.log(error);
      alert(error)

    }
  }

}
