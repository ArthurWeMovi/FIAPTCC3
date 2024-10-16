import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { NzNotificationService } from 'ng-zorro-antd/notification';
import { CompanyService } from '../../company/services/company.service';

@Component({
  selector: 'app-update-ad',
  standalone: true,
  imports: [],
  templateUrl: './update-ad.component.html',
  styleUrl: './update-ad.component.scss'
})
export class UpdateAdComponent {

  adId:any

    selectedFile: File|null;
  imagePreview: string | ArrayBuffer | null;
  validateForm: FormGroup;
  existingImage: string| null = null;

  imgChanged: boolean = false;

  constructor(private fb: FormBuilder,
    private notification: NzNotificationService,
    private router: Router,
    private companyService: CompanyService,
    private activatedroute: ActivatedRoute
  ){}

  ngOnInit(){
    this.validateForm = this.fb.group({
      serviceName: [null, [Validators.required]],
      description: [null, [Validators.required]],
      price: [null, [Validators.required]],
    })
    this.adId = this.activatedroute.snapshot.params['id']; 
      this.getAdById();
  }

  onFileSelected(event:any){
    this.selectedFile= event.target.files[0];
    this.previewImage();
    this.existingImage = null;
    this.imgChanged = true;

  }

  previewImage(){
    const reader = new FileReader();
    reader.onload = () =>{
      this.imagePreview = reader.result;
    }
    reader.readAsDataURL(this.selectedFile);
  }

  updateAd(){
    const formData: FormData = new FormData();
    if(this.imgChanged && this.selectedFile){
      formData.append('img', this.selectedFile);
    }
    
    formData.append('serviceName', this.validateForm.get('serviceName').value);
    formData.append('description', this.validateForm.get('description').value);
    formData.append('price', this.validateForm.get('price').value);

    this.companyService.updatedAd(this.adId, formData).subscribe(res => {
      this.notification.success('SUCESS',`Ad updated Sucessfully`, {nzDuration: 5000});
      this.router.navigateByUrl('/company/ads');
    }, error => {

    })
  }

    getAdById(){
      this.companyService.getAdById(this.adId).subscribe(res => {
        console.log(res);
        this.validateForm.patchValue(res);
        this.existingImage = 'data:image/jpeg;base64,' + res.returnImg
      })
    }



}
