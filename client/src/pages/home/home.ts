import { Component } from '@angular/core';
import { NavController, AlertController } from 'ionic-angular';
import {HomeService} from './homeService';
import {Http} from '@angular/http';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html',
  providers:[HomeService]
})
export class HomePage {

  quotes: any;
   
  constructor(public navCtrl: NavController, public homeService:HomeService, public alertCtrl:AlertController) {
    this.getQuotes();
  }

  getQuotes(){
    this.homeService.getAllQuotes().subscribe(data =>{
      this.quotes = data;
    })
  }
  postQuote(){
    this.homeService.postQuote(this.quote)
    .map(res => res.json())
            .subscribe(data => {
            console.log(data);
            this.getQuotes();
     });
  }

  deleteQuote(quote : any){
    this.homeService.deleteQuote(quote)
    .map(res => res.toString())
    .subscribe(data => {
      console.log(data)
      this.getQuotes();
    });
  }

  updateQuote(oldQuote : any, newQuote : any){
    this.homeService.updateQuote(oldQuote, newQuote)
    .map(res => res.toString())
    .subscribe(data => {
      console.log(data)
      this.getQuotes();
    });
  }

  updateAlert(oldQuote){
    let alert = this.alertCtrl.create({
      title: "Edit your quote here",
      inputs:[
        {
          name: "message",
          placeholder: "Edit the selected Quote"
        },
      ],
      buttons: [
        {
          text: "Cancel",
          handler: data => {
            console.log("Edit canceled")
          }
        },
        {
          text: "Save",
          handler: data => {
            let newQuote = data;
            newQuote.id = oldQuote.id
            console.log(newQuote)
            this.updateQuote(oldQuote, newQuote)
          }
        }
      ]
    })
    alert.present();
  }

  quote = {
    message: ""
  }

}
