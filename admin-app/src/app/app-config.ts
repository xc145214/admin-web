import {Injectable} from '@angular/core';

@Injectable()
export class AppConfig{

    public version:string = "1.0.0";

    public apiPort:string = "9400";
    public apiProtocol:string ;
    public apiHostName:string;
    public baseApiPath:string;

    constructor(){
        if (this.apiProtocol===undefined){
            this.apiProtocol = window.location.protocol;
        }
        if (this.apiHostName===undefined){
            this.apiHostName = window.location.hostname;
        }
        if (this.apiPort===undefined){
            this.apiPort = window.location.port;
        }

        this.baseApiPath = this.apiProtocol + "//" + this.apiHostName + ":" + this.apiPort +"/";
    }
}