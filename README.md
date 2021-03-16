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
- POST  http://127.0.0.1:8080/api/v1/house/create
- GET  http://127.0.0.1:8080/api/v1/house/allhouses
- GET  http://127.0.0.1:8080/api/v1/house/house/{id}
- PUT  http://127.0.0.1:8080/api/v1/house/house/{id}
- DELETE http://127.0.0.1:8080/api/v1/house/house{id}

