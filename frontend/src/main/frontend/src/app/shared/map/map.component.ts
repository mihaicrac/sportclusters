import { AfterContentInit, Component, Output, EventEmitter } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { } from '@types/googlemaps';

declare var google;

@Component({
  selector: 'my-map',
  template: '<div style="height: 100%;width: 100%" id="map"></div>',
})
export class MapComponent implements AfterContentInit {

  marker: google.maps.Marker;
  map: google.maps.Map;

  @Output() 
  onChosen = new EventEmitter<google.maps.LatLng>(true);

  constructor() {
  }

  public ngAfterContentInit(): void {
    var center = { lat: 44.456130, lng: 26.056845 };
    this.map = new google.maps.Map(document.getElementById('map'), {
      zoom: 12,
      center: center
    });
    this.marker = new google.maps.Marker({
      position: center,
      map: this.map,
      draggable: true
    });
    this.map.addListener('click', (e) => { this.changeMarker(e) });
    this.marker.addListener('dragend', (e) => { this.changeMarker(e) });
  }

  private changeMarker(e) {
    var latlng = new google.maps.LatLng(e.latLng.lat(), e.latLng.lng());
    console.log(latlng.toString());
    this.marker.setPosition(latlng);
    this.onChosen.emit(latlng);
  }

}