import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.prod';

@Injectable({
  providedIn: 'root'
})
export class ServicesService {

  constructor(private httpClient: HttpClient) { }

  //http://localhost:8080/gamification/user/profile?userId=2


  public getById(userId: number): Observable<any> {
    const params = new HttpParams().set('userId', userId)
    return this.httpClient.get<any>(`${environment.apiUrl}/gamification/user/profile`, { params: params });
 }
}
