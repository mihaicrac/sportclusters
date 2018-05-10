import { Component, Injectable, OnInit, ViewChild, AfterViewInit, AfterViewChecked } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { EventTypeService, EventType, EventService, Event, TokenService } from '../rest-service';
import { MapComponent } from '../shared/map/map.component';
import { EventPostReq, LocationAddReq, Coord } from '../rest-service/services/event/model';

@Component({
  moduleId: module.id,
  templateUrl: 'create-event.component.html',
  styleUrls: ['create-event.component.css'],
  providers: []
})

@Injectable()
export class CreateEventComponent implements OnInit, AfterViewInit {
  addEventForm: FormGroup;
  currDate: Date;
  eventTypes: EventType[] = [];
  location: google.maps.LatLng;
  event: Event;
  
  @ViewChild(MapComponent)
  private mapComponent: MapComponent;

  constructor(private fb: FormBuilder, private eventTypeService: EventTypeService, 
              private eventService: EventService, private tokenService:TokenService) {
    this.currDate = new Date();
  }

  ngOnInit() {
    this.addEventForm = this.fb.group({
        eventDate:[{value:this.currDate, disabled: false}, Validators.required],
        eventHours:[this.currDate.getHours(), Validators.required],
        eventMinutes:[this.currDate.getMinutes(), Validators.required],

        eventDurH:[''],
        eventDurMin:[''],

        eventType:[''],
        maxPlayers:['', Validators.required],
        guestsNumber:[''], 
        location:[{value:'', disabled:false}, Validators.required]
    });

    this.eventTypeService.getAll().subscribe((res) => {
      this.eventTypes = res;
    });
   
  }

  ngAfterViewInit() {
    this.mapComponent.onChosen.subscribe((res) => {
        this.addEventForm.get('location').setValue(res);
      }
    )
  }

  onSubmit() {
    console.log(this.addEventForm);
    let req = new EventPostReq();
    
    req.eventType = this.addEventForm.get('eventType').value;
    
    let dateTime = <Date>this.addEventForm.get('eventDate').value;
    dateTime.setSeconds(0);
    dateTime.setHours(this.addEventForm.get('eventHours').value);
    dateTime.setMinutes(this.addEventForm.get('eventMinutes').value);
    req.date = Math.round(dateTime.getTime() / 1000);

    req.duration = this.addEventForm.get('eventDurH').value * 3600 + 
                    this.addEventForm.get('eventDurMin').value * 60;               

    req.maxPlayers = this.addEventForm.get('maxPlayers').value;
    req.ownerGuests = this.addEventForm.get('guestsNumber').value;

    let loc = new LocationAddReq();
    let c = new Coord();
    loc.addLocation = c;
    c.latitude = this.addEventForm.get('location').value.lat();
    c.longitude = this.addEventForm.get('location').value.lng();
    req.location = loc;
    req.owner = this.tokenService.getToken().id;

    this.eventService.post(req).subscribe(res => {
      this.event = res;
    });
  }

  
}
