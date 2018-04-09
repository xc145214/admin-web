import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';

@Component({
    selector: "admin-menu",
    templateUrl: './menu.component.html',
    styles: [],
    providers: [
    ]
})
export class MenuComponent implements OnInit {
    menuList = [];
    isCollapsed = false;
    url: string = "/assets/mock/menuList.json"
    constructor(private http: Http) {

    }

    ngOnInit() {
        this.http.get(this.url).subscribe(data => {
            this.menuList = JSON.parse(data["_body"])
        }, err => {
            console.log(err["statusText"])
        });
    }


}