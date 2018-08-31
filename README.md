# Spring Security OAuth2 with Okta

This project is a result on following the blog on [Securing Spring Microservices with OAuth](https://developer.okta.com/blog/2018/02/13/secure-spring-microservices-with-oauth)  

## Prerequisites

1. You'll need a developer account at okta, [sign up](https://developer.okta.com/signup/)
1. Probably best you have a read of the blog above as this is just the solution.

## Get it working

1. [Create a web appliction in Okta](https://developer.okta.com/blog/2018/02/13/secure-spring-microservices-with-oauth#create-a-web-application-in-okta)
1. Note down the client id/ secret from the above
1. Note down your okta domain, given when registering for the dev account above
1. Amend [beer-catalog config](./beer-catalog-service/src/main/resources/application.yml)
   - Replace `{client-id}`   
   - Replace `{client-secret}`   
   - Replace `{okta-domain}`   
1. Amend [edge-service config](./edge-service/src/main/resources/application.yml)
   - Replace `{client-id}`   
   - Replace `{client-secret}`   
   - Replace `{okta-domain}`  
1. Start up each service, discovery, beer-catalog and then edge-service
1. Open browser at `http://localhost:8081/good-beers`
1. Log in with user of developer account
1. You should see a json response of good beers
   - If empty the wait until beer-catalog has registered with discovery service
   - Request again
1. Navigate to `http://localhost:8081/home`
1. You should see your user information  