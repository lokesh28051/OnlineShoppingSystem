import { Component, OnInit } from '@angular/core';
import { Item } from '../model/item';
import { ItemService } from '../service/item.service';
import { Image } from '../model/image';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  product: Item[];
  images: Image[];

  retrieveRespnse: any;

  constructor(private itemService: ItemService) { }

  ngOnInit(): void {
    //this.menu = this.itemService.getMenu();
    
    this.itemService.getMenu().subscribe(data =>{
      console.log(data);
      this.product = data;
    });

    this.itemService.getAllImages().subscribe(data =>{
      console.log(data);
      this.images = data;
    });

  }

}
