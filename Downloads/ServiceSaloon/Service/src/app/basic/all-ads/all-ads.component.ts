import { Component } from '@angular/core';
import { NzNotificationService } from 'ng-zorro-antd/notification';
import { CompanyService } from '../../company/services/company.service';

@Component({
  selector: 'app-all-ads',
  standalone: true,
  imports: [],
  templateUrl: './all-ads.component.html',
  styleUrl: './all-ads.component.scss'
})
export class AllAdsComponent {

  ads:any;

  constructor(private companyService: CompanyService, private notification: NzNotificationService){}

  ngOnInit(){
    this.getAllAdsByUserId();
  }

  getAllAdsByUserId(){
    this.companyService.getAllAdsByUserId().subscribe(res => {
        this.ads = res;
    })
  }

  updateImg(img){
    return 'data:image/jpeg;base64,'+ img;
  }

  deleteImg(adId: any){
    this.companyService.deleteAd(adId).subscribe(res =>{
       this.notification.success(`SUCESS`, `Ad Delete Sucessfully`, {nzDuration: 5000});
        this.getAllAdsByUserId();
    })
  }

}
