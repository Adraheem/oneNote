# oneNote API Documentation

SpringBoot Application\
Database: PostgreSQL Database

This application allows you to create a user account and create notes that can have reminder information in them.

Sample note JSON object:
````
{
    "id": 5,
    "title": "Hey there with reminder",
    "body": "Quo animi sunt aut odio nesciunt ex omnis ",
    "dateCreated": "2023-01-03T00:35:01.397552",
    "dateUpdated": "2023-01-03T00:35:01.397561",
    "reminder": {
        "id": 4,
        "reminderDate": "2023-01-05T02:00:00",
        "completed": false
    }
}
````

### Full documentation (Postman)
[Postman Collection -> postman.com/orbital-module-opera...](https://www.postman.com/orbital-module-operator-11041625/workspace/public-workspace/collection/15097759-d00e1b0a-d3d9-4a08-9424-ffc8d0a216af?action=share&creator=15097759)

### Server by [Raheem Adebayo](https://github.com/Adraheem)
#### Semicolon Africa