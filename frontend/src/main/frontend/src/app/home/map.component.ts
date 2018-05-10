import { AfterViewInit, Component } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';

declare var google;


@Component({
  selector: 'dialog-result-example',
  templateUrl: 'dialog-result-example.html',
})
export class DialogResultExample {
  selectedOption: string;

  constructor(public dialog: MatDialog) {}

  openDialog() {
    let dialogRef = this.dialog.open(DialogResultExampleDialog);
    dialogRef.afterClosed().subscribe(result => {
      this.selectedOption = result;
    });
  }
}


@Component({
  
  template: `<div style="height: 600px;width: 600px" id="map"></div>
            <button md-button (click)="closeDialog()">Close dialog</button>`,
})
export class DialogResultExampleDialog implements AfterViewInit{
  
  marker:any;
  map:any;
  
  constructor(public dialogRef: MatDialogRef<DialogResultExampleDialog>) {
    console.log('asdsasadds');
  }

    public ngAfterViewInit(): void {
      var uluru = {lat: 44.456130, lng: 26.056845};
      this.map = new google.maps.Map(document.getElementById('map'), {
          zoom: 12,
          center: uluru
      });
      this.marker = new google.maps.Marker({
          position: uluru,
          map: this.map,
          draggable: true
      });

      this.map.addListener('click', this.changeMarker.bind(this));

    }


    changeMarker = function(e){
      var latlng = new google.maps.LatLng(e.latLng.lat(),e.latLng.lng());
      console.log(latlng.toString());
      this.marker.setPosition(latlng);
      this.dialogRef.close(this.marker.position);
    };


    public closeDialog():void {
      this.dialogRef.close(this.marker.position);
    }

}