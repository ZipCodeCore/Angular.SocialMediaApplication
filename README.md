* **Objective** - to mock a simple social media app using Angular

* **Purpose** - to demonstrate
    * Angular Modules
    * Angular Services
    * Angular Components
    * Angular Directives
    * Angular Data Binding/Forms
    * Angular Http Client
	
### Part 1.0 - Create An Angular Project
	
* Using the command line, navigate to the folder you'd like to to store your project

* Using the Angular CLI, type ``ng new social-media-client``. This will generate a new Angular Project within a folder called social-media-client.

* ``cd`` to that folder, and type ``ng serve``. This will compile the project and launch a server port to access it. Your project should be available at ``localhost:4200``, and you should see the angular logo along with some sample content.

### Part 2.0 - Creating Angular Components

* Open your project in Visual Studio Code

* In the ``src/app`` folder, create a new folder called ``components``.

### Part 2.1 - Creating the New Post Component

* In the ``components`` folder, create a folder called ``new-post``. 

* In the ``new-post`` folder, create two files, ``new-post.component.ts`` and ``new-post.component.ts``

### Part 2.2 - Creating the New Post class

* In the ``new-post.component.ts`` file, create a ``NewPostComponent``.
```javascript
class NewPostComponent {

}
```
* In order to make this class accessible within our application, we need to export it.
    * Using ``export`` in Javascript is similar to marking a class ``public`` in Java.
```javascript
export class NewPostComponent {

}
```  
* Declare to Angular that this class is a component using using the ``@Component`` decorator.
    * In order to use the ``@Component`` decorator, we need to import it from angular. 
    Type ``import { Component } from '@angular/core';`` at the top of the file to gain access to the decorator.
    * Invoke the decorator above the ``NewPostComponent`` class to declare it as a component
    * Angular decorators are similar to Spring stereotype annotations like ``@Controller``
```javascript
@Component()
export class NewPostComponent {

}
```
* Set the Component meta data by passing a metadata object into the ``@Component`` decorator as a parameter.
    * Some possible properties for the metadata object include ``selector``, ``template``, ``templateUrl``, ``styleUrls`` and ``providers``. For now, we are going to use ``templateUrl`` and ``selector``.
    * ``selector`` - The selector property is mandatory. It designates the name of the html element of the component. By convention, we include ``app`` in front of the component name, with dashes separating words.
    * ``templateUrl`` - The templateUrl property designates the path of the corresponding html file for the component.
```javascript
@Component({
    selector: 'app-new-post',
    templateUrl: './new-post.component.html',
})
export class NewPostComponent {
    
}
```

### Part 2.3 - Creating the New Post html file

* Our new post component will include a textbox where we can type our post and submit it. In the ``new-post.component.html`` file, include the following html code.
```html
<!-- This creates a textbox and a submit button for our new post component -->
<textarea rows="4" cols="50">
    How is your day?
</textarea>
<button type="submit">
    Submit
</button>
```

### Part 2.4 - Add our component to the AppModule.

* In order to use our component, we need to declare it in the module where we want to use it. We currently have one master module, the ``AppModule``
* Navigate to the ``app.module.ts`` file, which should look like this.
```javascript
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
```
* The ``@NgModule`` decorator declares this class as a module. The metadata object passed into the decorator contains the
``declarations``, ``imports``, ``providers``, and ``bootstrap`` properties.
    * ``declarations`` - an array of components that are available for use within this module. All components the module wishes to use must be declared here.
    * ``imports`` - an array of modules our module depends on. In this case, we are importing the ``BrowserModule`` a module provided by angular that includes useful angular ``directives``.
    * ``providers`` - an array of the services which this module depends on.
    * ``bootstrap`` - the root component that Angular creates and inserts into the index.html host web page
* In order to use our new ``NewPostComponent`` within our root module, we need to import the component and add it to the ``declarations`` array
```javascript
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { NewPostComponent } from './components/new-post/new-post.component';

@NgModule({
  declarations: [
    AppComponent,
    NewPostComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
```

### Part 2.5 - Add our New Post Component to the root component html.

* Navigate to the ``index.html`` file, it should look something like this.
    * The ``index.html`` page is the most common name used for the default page shown on a website if no other page is specified when a visitor requests the site. In other words, index.html is the name used for the homepage of the website.
    * Our ``index.html`` file contains our root component, the ``<app-root></app-root>``, within the ``<body></body>`` of the html.
```javascript
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>SocialMediaClient</title>
  <base href="/">

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="icon" type="image/x-icon" href="favicon.ico">
</head>
<body>
  <app-root></app-root>
</body>
</html>
```
* Navigate to the ``app.component.ts`` file. It should look something like this:
    * Notice the selector is ``app-root``. That means this file is responsible for the root component we saw in the ``index.html`` file.
```javascript
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'social-media-client';
}
```
* Navigate to the ``app.component.html file``. It should look something like this:
    * Notice that we have a bunch of sample html in this file. This is the html that shows when we navigate to ``localhost:4200``.
```html
<!--The content below is only a placeholder and can be replaced.-->
<div style="text-align:center">
  <h1>
    Welcome to {{ title }}!
  </h1>
  <img width="300" alt="Angular Logo" src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHZpZXdCb3g9IjAgMCAyNTAgMjUwIj4KICAgIDxwYXRoIGZpbGw9IiNERDAwMzEiIGQ9Ik0xMjUgMzBMMzEuOSA2My4ybDE0LjIgMTIzLjFMMTI1IDIzMGw3OC45LTQzLjcgMTQuMi0xMjMuMXoiIC8+CiAgICA8cGF0aCBmaWxsPSIjQzMwMDJGIiBkPSJNMTI1IDMwdjIyLjItLjFWMjMwbDc4LjktNDMuNyAxNC4yLTEyMy4xTDEyNSAzMHoiIC8+CiAgICA8cGF0aCAgZmlsbD0iI0ZGRkZGRiIgZD0iTTEyNSA1Mi4xTDY2LjggMTgyLjZoMjEuN2wxMS43LTI5LjJoNDkuNGwxMS43IDI5LjJIMTgzTDEyNSA1Mi4xem0xNyA4My4zaC0zNGwxNy00MC45IDE3IDQwLjl6IiAvPgogIDwvc3ZnPg==">
</div>
<h2>Here are some links to help you start: </h2>
<ul>
  <li>
    <h2><a target="_blank" rel="noopener" href="https://angular.io/tutorial">Tour of Heroes</a></h2>
  </li>
  <li>
    <h2><a target="_blank" rel="noopener" href="https://github.com/angular/angular-cli/wiki">CLI Documentation</a></h2>
  </li>
  <li>
    <h2><a target="_blank" rel="noopener" href="https://blog.angular.io/">Angular blog</a></h2>
  </li>
</ul>
```
* Delete the sample html, and include the selector of the ``NewPostComponent`` we created.
```html
<app-new-post></app-new-post>
```
* Navigate back to ``localhost:4200``. You should see your textbox and submit button.

### Part 3.0 - Creating the Post Components

* Our ``PostComponent`` will be how we display posts from us and our friends in a feed.

* In the ``app/src/components`` folder, create a ``post`` folder.

* In the ``post`` folder, add a ``post.component.ts`` file and a ``post.component.html`` file.

### Part 3.1 - Creating the Post class

* In the ``post.component.ts`` file, create a ``NewPostComponent`` decorated with the ``@Component`` decorator, passing in the appropriate metadata object.
```javascript
@Component({
    selector: 'app-post',
    templateUrl: './post.component.html',
})
export class PostComponent {
    
}
```
### Part 3.2 - Creating the Post html file

* Our post component will include the content of the post as well as the username of the person who posted it.
* Add the following html to the ``post.component.html`` file. For now, we'll add some sample content.
```html
<div class="post">
    <div class="post-username">SampleUsername</div>
    <div class="post-content">Lorem ipsum bacon cupcakes solit deo pizza</div>
</div>
```

### Part 3.3 - Add our component to the AppModule

* Navigate to the ``app.module.ts`` file, import your new component and add it to the declarations array.

### Part 3.4 - Add our New Post Component to the root component html

* Below the ``app-new-post`` selector, add the selector for our post component.
```html
<app-new-post></app-new-post>
<app-post></app-post>
```
* Navigate back to ``localhost:4200``. You should see your post under your new post textbox.

### Part 4.0 - Creating our Posts Service

* In the ``src/app/root`` create a ``services`` folder.

* In the ``services`` folder, create a ``posts.service.ts`` file.

### Part 4.1 - Creating our PostsService class.

* Create and export a PostsService class.

```javascript
export class PostsService {
    
}
```
* To mark this class as a service, we need the ``@Injectable`` decorator. Import the decorator from angular core at the top of the file and add the decorator to the top of the class
    * The Injectable decorator takes an optional metadata object. We'll leave it out for now.

```javascript
import { Injectable } from '@angular/core';

@Injectable()
export class PostsService {
    
}
```

### Part 4.2 Adding the PostsService to our Providers

* In order to use our PostsService, we need to add it to the module where we want to use it.
* Navigate to the ``app.module.ts`` file. Import the ``PostsService`` class and add it to the providers array.

```javascript
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { NewPostComponent } from './components/new-post/new-post.component';
import { PostComponent } from './components/post/post.component';

import { PostsService } from './services/posts.service';

@NgModule({
  declarations: [
    AppComponent,
    NewPostComponent,
    PostComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [PostsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
```

### Part 4.3 Adding Http Client for Http Requests

* To make http requests, we are going to use Angular's HttpClient, which provides a helpful library for dealing with http requests.
    * To use ``HttpClient``, we first need import the ``HttpClientModule`` within the module where we want to use it.
* Navigate to the ``app.module.ts`` file, import the ``HttpClientModule`` from ``@angular/core`` and it to the imports array.

```javascript
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from 'angular/common/http';

import { AppComponent } from './app.component';
import { NewPostComponent } from './components/new-post/new-post.component';
import { PostComponent } from './components/post/post.component';

import { PostsService } from './services/posts.service';

@NgModule({
  declarations: [
    AppComponent,
    NewPostComponent,
    PostComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [PostsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
```

* Navigate back to the ``posts.service.ts`` file. We'll need ``HttpClient`` as a dependency for our service.
    * First, import ``HttpClient`` from ``@angular/common/http``.
    * Next, create a private field of type ``HttpClient`` named ``http``.
    * Next, create a constructor for your service with HttpClient as a dependency and assign the value of the parameter to your http field. 
        * Angular will create the HttpClient object for us, and inject it into our service through Dependency Injection.

```javascript
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class FareService {
  private http: HttpClient;

  constructor(http: HttpClient) {
    this.http = http;
  }
}
```

### Part 4.4 Using Http Client for Http Requests

* The ``HttpClient`` library includes helpful http verb methods like ``get``, ``post``, ``put``, and ``delete``. To make a get request for all posts from our RESTful Spring API, we're going to use ``http.get()``.
    * Create a getPosts method that calls the ``get`` method on the ``http`` object, passing in the url of the endpoint.
```javascript
    public getPosts() {
        this.http.get('http://localhost:8080/posts');
    }
```
* The ``get``, ``put``, ``post`` and ``delete`` methods on the ``http`` object return a type called an Observable, a generic that takes a parameterized type. You can read more about Observables <a href="https://angular.io/guide/observables">here</a>
    * In order to use the observable type, we need to import ``Observable`` from ``rxjs``.
```javascript
    public getPosts() {
        Observable<object> = this.http.get('http://localhost:8080/posts');
    }
```
* By returning this observable, we can create subscribers that receive updates when the value of the Observable is changed. 
```javascript
    public getPosts(): Observable<object> {
        return this.http.get('http://localhost:8080/posts');
    }
```
* Right now, the type of our observable is a generic object, but we really want it to return an an array of objects of type ``Post``, however, Angular knows nothing about what our Post type looks like. We'll create custom types for our application in the next steps.

### Part 5 Creating Types

* In the ``src/app`` folder, create a folder called ``types``.
* In the ``types`` folder, create a ``post.ts`` file and a ``user.ts`` file.
* In the ``user.ts`` file, create an interface for User.
    * This creates a contract saying that all Post objects must have properties of a certain name and type.
```javascript
export interface User {
    id: number;
    username: string;
}
```
* In the ``post.ts`` file, create an interface for Post.
    * Our user property will be of type ``User``. In order to use this type, we need to import it from the ``User.ts`` file we just created.
```javascript
import { User } from './User.ts';

export interface Post {
    id: number;
    content: string;
    createdTime: number;
    updatedTime: number;
    user: User;
}
```

### Part 6.0 Updating our Service with our Types
* Update the getPosts method to return an ``Observable`` of type ``Array<Post>``.
    * Notice the http verb methods, such as ``get``, also take a parameterized type. Angular will attempt to take the json and translate it into the type we want. 
```javascript
    public getPosts(): Observable<Array<Post>> {
        return this.http.get<Array<Post>>('http://localhost:8080/posts');
    }
```

## Part 7.0 





