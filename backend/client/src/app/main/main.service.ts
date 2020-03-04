import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';

export interface Asset {
  id: Int32Array;
  num: Int16Array;
  description: string;
  lifeYears: Int16Array;
  rangeMin: Int16Array;
  rangeMax: Int16Array;
  depreciationCode: string;
  olv: DoubleRange;
  flv: DoubleRange;
}

@Injectable({
  providedIn: 'root'
})
export class MainService {

  constructor(private http: HttpClient) {

  }

  getAssets() {
    return this.http.get(`http://localhost:8080/api/v1/assets`,
      {  }).pipe(map((res) => {
        return res;
      }));
  }

  getConditions() {
    return this.http.get(`http://localhost:8080/api/v1/conditions`,
      {  }).pipe(map((res) => {
        return res;
      }));
  }

  getDepreciations() {
    return this.http.get(`http://localhost:8080/api/v1/depreciation`,
      {  }).pipe(map((res) => {
        return res;
      }));
  }
}
