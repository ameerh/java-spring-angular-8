import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { MainService, Asset } from './main.service';
import { Observable, of } from 'rxjs';
import { delay } from 'rxjs/operators';
import { Validators, FormControl, FormGroup } from '@angular/forms';
import { _ } from 'underscore';
@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  assets: any;
  assets$: Observable<Asset[]>;
  conditions: any;
  depreciations: any;
  selectedAssetId: any;
  currentYear: number;
  assetValuationForm: FormGroup;


  selectedAsset: any;
  remainingLife: number;
  fmv: number;
  olv: number;
  fv: number;
  valuations: any;


  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private mainService: MainService) {   }

  ngOnInit() {
    this.valuations = JSON.parse(localStorage.getItem('valuations') || '[]');
    this.currentYear = new Date().getFullYear();
    this.mainService.getAssets().subscribe((result) => {
      this.assets = result;
      this.assets$ = this.getAssets();
    }, () => {
      alert('error');
    });
    this.mainService.getConditions().subscribe((result) => {
      this.conditions = result;
    }, () => {
      alert('error');
    });
    this.mainService.getDepreciations().subscribe((result) => {
      this.depreciations = result;
    }, () => {
      alert('error');
    });

    this.assetValuationForm = new FormGroup({
      asset: new FormControl(),
      new_price: new FormControl(),
      year: new FormControl(),
      condition: new FormControl()
    });

    this.assetValuationForm.valueChanges.subscribe(form => {
      // tslint:disable-next-line: max-line-length
      if ((form.asset !== undefined && form.asset !== null) && (form.new_price !== undefined && form.new_price !== null) && (form.year !== undefined && form.year !== null) && (form.condition !== undefined && form.condition !== null)) {
        const age = this.currentYear - form.year;
        // tslint:disable-next-line: only-arrow-functions
        console.log(form.asset);
        this.selectedAsset = _.find(this.assets, function(o) { return o.id === form.asset; });
        console.log(this.selectedAsset, this.selectedAsset.depreciationCode);
        this.remainingLife = this.selectedAsset.lifeYears - age;
        const depreciationCode = this.selectedAsset.depreciationCode;
        // tslint:disable-next-line: max-line-length
        const deprecationValue = _.find(this.depreciations, function(o) { return (o.depreciationCode === depreciationCode && o.age === age); });
        if (deprecationValue) {
          this.fmv = (form.new_price * deprecationValue.depreciation);
          this.olv = (this.fmv * this.selectedAsset.olv);
          this.fv = (this.fmv * this.selectedAsset.flv);
        } else {
          this.fmv = this.olv = this.fv = null;
        }
      }
    });

  }

  getAssets(term: string = null): Observable<Asset[]> {
    let items = this.assets;
    if (term) {
        items = items.filter((x: { name: string; }) => x.name.toLocaleLowerCase().indexOf(term.toLocaleLowerCase()) > -1);
    }
    return of(items).pipe(delay(500));
  }

  saveValuation() {
    const obj = {
      asset: this.selectedAsset.description,
      fmv: this.fmv,
      olv: this.olv,
      fv: this.fv,
      remainingLife: this.remainingLife
    };
    this.valuations.push(obj);
    localStorage.setItem('valuations', JSON.stringify(this.valuations));
  }
  deleteValuation(index) {
    this.valuations.splice(index, 1);
    localStorage.setItem('valuations', JSON.stringify(this.valuations));
  }
}
