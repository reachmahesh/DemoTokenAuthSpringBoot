This projects demonstrate how you can use your own token to authenticate a user in spring boot applications.

This token can be used for REST-Endpoints.

Created a DEMO Project with below REST-Enpoints

http://localhost:8080/login {"username":"admin", "password":"admin"} OR {"username":"user", "password":"user"}

http://localhost:8080/hello/admin Header : x-auth-token

http://localhost:8080/hello/ Header : x-auth-token (Use User Token)

http://localhost:8080/logout
