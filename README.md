# bookstore_manager_course

This project is the basic sketch of an api for db management of a bookstore. It has the POST and GET methods implemented, for adding and reading entries.

It was developed following the udemy course: “Comece a aprender Spring Boot agora de forma prática!”

To consume the api, use Postman, or similar application. It is cloud hosted by heroku, and can be consumed through linking to it. Alternatively, it may be cloned and ran locally.

POST:

Using the post method, to the address “https://bookstore-manager-course-vilha.herokuapp.com/api/v1/books” (cloud), or “{local port}/api/v1/books”.
The body of your request should consist of a raw json entry following the format of the sample bellow:


{

    "name": "Investidor Inteligente",
    
    "pages": 200,
    
    "chapters": 20,
    
    "isbn": "0-596-52068-9",
    
    "publisherName": "Harper Collins",
    
    "author": {
    
        "name": "Benjamin Graham",
        
        "age": 100
        
    }
    
}


Notice that a proper isbn-10 value will be required. I suggest using a random isbn generator, such as https://generate.plus/en/number/isbn.

GET:

Change the method to GET, and add “/{entry index}” to the post address, to check the entry of the chosen index.
