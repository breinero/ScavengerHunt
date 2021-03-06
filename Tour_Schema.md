#Schema

##Tour Waypoint

###Namespace
tour.waypoints

###JSON
```
{	_id: ObjectId(),
	tour: UUDI
	user: UUID,
    name: "Doug's Dogs",
    desc: "The best hot-dog",
    clues: [
        "Hungry for a Coney Island?",
        "Ask for Dr. Frankenfurter",
        "Look for the hot dog stand"
    ]
    "geometry": {
        "type": "Point",
        "coordinates": [125.6, 10.1]
    }
}
```
###Operations
#####Find all waypoints for a given tour
{ tour: 1234 }
#####Find tours for a given user
{ user: 1234 }, { tour: 1, _id: 0}
#####Find tours near a given location
{ geometry: { $near: { $geometry: { coordinates: [lat, lon], type: 'Point' } } } }

##User
###Namespace
tour.users
###JSON
```
{
    _id: UUID,
    name: <string>,
    email: <string>,
    pass: <hash>,
    description: <string>
}
```

###Operations
#####login 
{user: 'bryan', pass: hash }


##Checkin
###Namespace 
tour.checkins
###JSON
```
{
	_id: ObjectId(),
	user: UUID,
	tour: tourId,
	timestamp: ISODate(),
	type: ['inprog'|'aquire']
	geometry: {
		type: "Point",
		coordinates: [ long, lat ]
	}
}
```
###NOTE!
The checkin entity can be of type 'inprog' which indicates this checkin occured while the use was enroute to completing a goal. Or a checkin can be of type 'aquire' which records the event when the user achieved a waypoint goal. The type field is a descriminator.
###Operations
#####Find path of given user 
{ user: UUID }

