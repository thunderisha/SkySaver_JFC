import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.prod';

@Injectable({
  providedIn: 'root'
})
export class ServicesService {
  apiUrl=environment.apiUrl;
  private userDTO ='../assets/mock-files/userDTO.json' ;
  constructor(private httpClient: HttpClient) { }

  //http://localhost:8080/gamification/user/profile?userId=2


  public getById(userId: number): Observable<any> {
    const params = new HttpParams().set('userId', userId)
    return this.httpClient.get<any>(this.apiUrl +`/gamification/user`, { params: params });
  }

  public getBDyId(userId: number): Observable<any> {
    const params = new HttpParams().set('userId', userId)
    return this.httpClient.get<any>(this.apiUrl +`/user/birthday`, { params: params });
  }


  fetchContent(): Observable<any> {

    return this.httpClient.get(this.userDTO);
  }
  public updateBook(request: any): Observable<any> {
    return this.httpClient.put<any>(this.apiUrl + `/booking`, request)
  }
}
