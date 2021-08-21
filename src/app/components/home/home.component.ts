import { Component, OnInit } from '@angular/core';
import { ServiceService } from '../../service.service';
import * as moment from 'moment';
import {MessageService} from 'primeng/api';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  value1: any;
  date:Date=new Date();
  dialog:boolean=false;
  name:any;
  from:any;
  to:any;
  datetable:any=[];
  todaytable:any=[];
  occurence:any;
  selectedoccur:any;
  editdialog:boolean=false;
  editindex:any;
  editid:any;
  constructor(private service:ServiceService,private messageService: MessageService) { }

  ngOnInit(): void {
    this.occurence=[
      {'label':'Daily'},
      {'label':'Weekly'},
      {'label':'Monthly'}
    ]
    this.selectedoccur={'label':'Daily'};
    this.getdata();
  }

  setdate(){

  }

  newform(){
    this.dialog=true;
  }

  getdata(){
    this.datetable=[]
    this.todaytable=[]
    this.service.getdata().subscribe((data) =>{
      let day=moment(new Date()).format('YYYY-MM-DD')
      for(let d of data){
        let f=(moment(d['from']).format('YYYY-MM-DD'));
        let t=(moment(d['to']).format('YYYY-MM-DD'));
        if(moment(day).isSameOrAfter(moment(f), 'day') && moment(day).isSameOrBefore(moment(t), 'day')){
          console.log("yes")
          this.todaytable.push(d);
        }
        d['from']=moment(d['from']).format('YYYY-MM-DD HH:MM:SS');
        d['to']=moment(d['to']).format('YYYY-MM-DD HH:MM:SS');
        this.datetable.push(d);

      }
    });
  }
  saveform(){
    let component:any={};
    component['name']=this.name;
    this.dialog=false;
    this.editdialog=false;
    // component['fromdate']=String(moment(this.from).format('YYYY-MM-DD HH:MM:SS'));
    // component['todate']=String(moment(this.to).format('YYYY-MM-DD HH:MM:SS'));
    component['fromdate']=this.from;
    component['todate']=this.to;
    component['occur']=this.selectedoccur['label'];
    this.service.addcomponent(component).subscribe(()=>{
      this.getdata();
      this.messageService.add({severity:'success', summary:'Success', detail:'Added'});
    },(error)=>{
      this.messageService.add({severity:'error', summary:'Failed', detail:'Failed'});
    });
  }

  saveedit(){
    let component:any={};
    component['name']=this.name;
    this.dialog=false;
    this.editdialog=false;
    component['fromdate']=this.from;
    component['todate']=this.to;
    component['occur']=this.selectedoccur['label'];
    component['id']=this.editid;
    this.service.addcomponent(component).subscribe(()=>{
      this.getdata();
      this.messageService.add({severity:'success', summary:'Success', detail:'Added'});
    },(error)=>{
      this.messageService.add({severity:'error', summary:'Failed', detail:'Failed'});
    });
  }

  onedit(index:any,id:any){
    this.from=new Date(this.datetable[index]['from']);
    this.to=new Date(this.datetable[index]['to']);
    this.name=this.datetable[index]['name'];
    this.editdialog=true;
    this.editindex=index;
    this.editid=id;
  }

  delete(id:any){
    this.service.deletedata(id).subscribe(()=>{
      this.getdata();
      this.messageService.add({severity:'success', summary:'Success', detail:'Deleted'});
    },(error)=>{
      this.messageService.add({severity:'error', summary:'Failed', detail:'Failed'});
    });
  }
}
