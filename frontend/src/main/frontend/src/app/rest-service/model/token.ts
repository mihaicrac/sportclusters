export class Token {
    private _sub: string;
    private _audience: string;
    private _created: number;
    private _id: string;
    private _exp: number;

	public get audience(): string {
		return this._audience;
	}

	public set audience(value: string) {
		this._audience = value;
	}

	public get exp(): number {
		return this._exp;
	}

	public set exp(value: number) {
		this._exp = value;
	}

	public get sub(): string {
		return this._sub;
	}

	public set sub(value: string) {
		this._sub = value;
	}

	public get created(): number {
		return this._created;
	}

	public set created(value: number) {
		this._created = value;
	}

	public get id(): string {
		return this._id;
	}

	public set id(value: string) {
		this._id = value;
	}
    
    
}