export class EventPostReq {
    eventType:string;
    date:number;
    duration:number;
    maxPlayers:number;
    ownerGuests:number;
    location:LocationAddReq;
    owner:string;
}


export class LocationAddReq {
    location:string;
    addLocation:Coord;
}

export class Coord {
    longitude:number;
    latitude:number;
}