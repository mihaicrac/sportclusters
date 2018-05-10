export class Event {
    private _id: number;
    private _name: string;
    private _owner: string;
    private _location: google.maps.LatLng;
    private _dateTime: number;

    public get id(): number {
		return this._id;
	}

	public set id(value: number) {
		this._id = value;
	}

    public get name(): string {
		return this._name;
	}

	public set name(value: string) {
		this._name = value;
	}

}    
