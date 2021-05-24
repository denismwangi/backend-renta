## end points 


authentication EndPoints

- POST http://127.0.0.1:8080/api/auth/signin
- POST http://127.0.0.1:8080/api/auth/signup

- GET  http://127.0.0.1:8080/api/test/user
- GET  http://127.0.0.1:8080/api/test/admin
- GET  http://127.0.0.1:8080/api/test/mod

user operations
- POST  http://127.0.0.1:8080/api/v1/users
- GET  http://127.0.0.1:8080/api/v1/users
- GET  http://127.0.0.1:8080/api/v1/users/{1d}
- PUT  http://127.0.0.1:8080/api/v1/users/{id}
- DELETE http://127.0.0.1:8080/api/v1/users{1d}

houses endpoints
- POST  http://127.0.0.1:8080/api/v1/houses/create
- GET  http://127.0.0.1:8080/api/v1/houses
- GET  http://127.0.0.1:8080/api/v1/houses/{id}

file uploads separate

| Method | Endpoint URL | Header |
|-|-|-|
|POST|/api/v1/auth/signin||
|POST|/api/v1/auth/signup||

|GET|/api/v1/test/user|Token|
|GET|/api/v1/test/admin|Token|
|GET|/api/v1/test/land|Token|

|POST|/api/v1/users/create||
|GET|/api/v1/users||
|GET|/api/v1/users/{1d}||
|PUT|/api/v1/users/{id}||
|DELETE|/api/v1/users{1d}||
