# Backend-Dev-Tech-Assignment

## Prerequisites

-  A REST API with a single GET endpoint which returns a paginated list of jukeboxes that suppport a given setting id.

*  Jukebox API : Get   all  jukes.
*  Settings API :  Get   all  Settings.

## Main technical frameworks 

```xml
<!-- spring boot -->		
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.1.1.RELEASE</version>
<!-- lombok -->
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
<!--swagger2 -->
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger2</artifactId>
			<version>2.8.0</version>

```

```

```
## Apis
TEST IN SWAGGER 
http://localhost:8080/swagger-ui.html#/
```json
{
	"swagger": "2.0",
	"info": {
		"description": "Jukeboxs APIs Swagger DOC",
		"version": "1.0",
		"title": "Jukeboxs APIs"
	},
	"host": "localhost:8080",
	"basePath": "/",
	"tags": [
		{
			"name": "jukes-controller",
			"description": "Jukes Controller"
		},
		{
			"name": "jukes-info-controller",
			"description": "Jukes Info Controller"
		}
	],
	"paths": {
		"/api/jukes": {			
		},
		"/api/tech-assignment/jukes": {			
		},
		"/api/tech-assignment/settings": {
		}
	},
	"definitions": {
		"Jukebox": {
		},
		"JukeboxComponent": {			
		},
		"JukeboxSetting": {
		},
		"Result«List«JukeboxSetting»»": {
		},
		"Result«List«Jukebox»»": {	
		}
	}
}
```



## Test design
**Simple and clear test data.**

| Test  datas design |             |                        |           |      |         |
| ------------------ | ----------- | ---------------------- | --------- | ---- | ------- |
| **settings**       | **ID**      | **requires**           |           |      |         |
|                    | S1          | req1                   | req2      |      |         |
|                    | S2          | req5                   |           |      |         |
|                    | S3          |                        | req2      |      |         |
|                    | S4          |                        |           | req3 |         |
|                    | S0          |                        |           |      |         |
|                    |             |                        |           |      |         |
|                    | **ID**      | **components**         | **model** |      |         |
| **jukeboxs**       | J1          | req1                   | req2      | req3 | model-A |
|                    | J2          | req1                   | req2      |      | model-B |
|                    | J3          |                        | req2      |      | model-B |
|                    | J4          |                        |           | req4 | model-A |
|                    |             |                        |           |      |         |
|                    |             |                        |           |      |         |
|                    | **Mapting** | **setting--> jukboxs** |           |      |         |
| **settingMap**     | settingID   | jukBoxes               |           |      |         |
|                    | S1          | J1                     | J2        |      |         |
|                    | S2          | unavailable            |           |      |         |
|                    | S3          | J1                     | J2        | J3   |         |
|                    | S4          | J1                     |           |      |         |
|                    | S0          | J1                     | J2        | J3   | J4      |



## Further additions may be needed

Additional features needed for use in the actual production environment:

* Uniform authorization and access management.
* Log unified management.
* Monitor system operation.

## Contact

samwang.mt@gmail.com


