import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LoginComponent } from './pages/login/login.component';

export const routes: Routes = [

    { path: '', redirectTo: 'login', pathMatch: 'full' },
    { path: 'login', component: LoginComponent }
];


@NgModule({
    imports: [ RouterModule.forRoot(routes, {useHash:true} )],
    exports: [ RouterModule ],
    declarations:[]
})
export class AppRoutingModule {

}