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

* ``cd`` to that folder, and type ``ng serve``. This will compile the project and launch a server port to access it. Your project should be available at ``http://localhost:4200``, and you should see the angular logo along with some sample content.

### Part 2.0 - Creating Angular Components

* Open your project in Visual Studio Code

* In the ``src/app`` folder, create a new folder called ``components``.

### Part 2.1 - Creating the New Post Component

* In the ``components`` folder, create a folder called ``new-post``. 

* In the ``new-post`` folder, create two files, ``new-post.component.ts`` and ``new-post.component.html``

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
<textarea rows="4" cols="50" placeholder="How is your day?">
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

### Part 4.0 - Creating our Feed Component

* Our ``FeedComponent`` will be how we list of post from our friends.

* In the ``app/src/components`` folder, create a ``feed`` folder.

* In the ``feed`` folder, add a ``feed.component.ts`` file and a ``feed.component.html`` file.

### Part 4.1 - Creating the Post class

* In the ``feed.component.ts`` file, create a ``NewPostComponent`` decorated with the ``@Component`` decorator, passing in the appropriate metadata object.
```javascript
@Component({
    selector: 'app-feed',
    templateUrl: './feed.component.html',
})
export class FeedComponent {
    
}
```
### Part 4.2 - Creating the Post html file

* Our feed component will use our Post Component to display a list of posts.
* Add the following html to the ``feed.component.html`` file. For now, we'll just add one post (which, as you remember, is populated with sample data).
```html
<app-post></app-post>
```

### Part 4.3 - Add our component to the AppModule

* Navigate to the ``app.module.ts`` file, import your new component and add it to the declarations array.

### Part 4.4 - Add our New Post Component to the root component html

* Below the ``app-new-post`` selector, remove the ``app-post`` selector and add the ``app-feed`` selector for our feed component.
```html
<app-new-post></app-new-post>
<app-feed></app-feed>
```
* Navigate back to ``localhost:4200``. You should see your post under your new post textbox.

### Part 5.0 - Creating our Posts Service

* In the ``src/app/root`` create a ``services`` folder.

* In the ``services`` folder, create a ``post.service.ts`` file.

### Part 5.1 - Creating our PostService class.

* Create and export a PostService class.

```javascript
export class PostService {
    
}
```
* To mark this class as a service, we need the ``@Injectable`` decorator. Import the decorator from angular core at the top of the file and add the decorator to the top of the class
    * The Injectable decorator takes an optional metadata object. We'll leave it out for now.

```javascript
import { Injectable } from '@angular/core';

@Injectable()
export class PostService {
    
}
```

### Part 5.2 Adding the PostService to our Providers

* In order to use our PostService, we need to add it to the module where we want to use it.
* Navigate to the ``app.module.ts`` file. Import the ``PostService`` class and add it to the providers array.

```javascript
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { NewPostComponent } from './components/new-post/new-post.component';
import { PostComponent } from './components/post/post.component';

import { PostService } from './services/posts.service';

@NgModule({
  declarations: [
    AppComponent,
    NewPostComponent,
    PostComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [PostService],
  bootstrap: [AppComponent]
})
export class AppModule { }
```

### Part 5.3 Adding Http Client for Http Requests

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

import { PostService } from './services/posts.service';

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
  providers: [PostService],
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
export class PostService {
  private http: HttpClient;

  constructor(http: HttpClient) {
    this.http = http;
  }
}
```

### Part 5.4 Using Http Client for Http Requests

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
    username: string;
}
```
* In the ``post.ts`` file, create an interface for Post.
    * Our user property will be of type ``User``. In order to use this type, we need to import it from the ``User.ts`` file we just created.
```javascript
import { User } from './User.ts';

export interface Post {
    content: string;
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

## Part 7.0 Populating our Feed Component with Data

* Navigate to the ``feed.component.ts`` file. Now that we've created a service that our component depends on for data, we need to add our service as a dependency.

* Import ``PostServices`` from the services folder.

* Create a private field of type ``PostsService``.

* Create a constructor with a parameter of type ``PostService`` as a dependency and assign the value to the ``postService`` field.

```javascript
import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { PostService } from '../../services/post.service';

@Component({
  selector: 'app-feed',
  templateUrl: './feed.component.html'
})
export class FeedComponent {
    private postService: PostService;
    
    constructor(postService: PostService) {
        this.postService = postService;
    }
}
```

* By convention, we reserve our constructor for resolving dependencies and perform all other work in a special method called ``ngOnInit``
    * ``ngOnInit`` is a lifecycle hook that is called after Angular first displays the data-bound properties.
    * To use ``ngOnInit``, import ``OnInit`` from ``@angular/core``. ``OnInit`` is an interface. By designating that our ``FeedComponent`` implements ``OnInit``, Angular will know that the ``ngOnInit`` method is available to call. 
    * <a href="https://angular.io/guide/lifecycle-hooks">More info on LifeCycle Hooks</a>
* Add a public field of type ``Array<Post>`` called posts.
* Place your ``ngOnInit`` method below your constructor.   
```javascript
import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { PostService } from '../../services/post.service';

@Component({
  selector: 'app-feed',
  templateUrl: './feed.component.html'
})
export class FeedComponent implements OnInit {
    private postService: PostService;
    public posts: Array<Post>;
    
    constructor(postService: PostService) {
        this.postService = postService;
    }
    
    ngOnInit(): void {
        
    }
}
```

* In our ``ngOnInit`` method, call the ``getPosts`` method on the ``PostService``. 
    * Remember that the method returns an ``Observable``. Observables have a special method called ``subscribe`` which will allow us to receive messages when the value of the observable is changed.
    * Our ``subscribe`` method takes a ``callback`` as a parameter.
```javascript
ngOnInit(): void {
    postService.getPosts()
        .subscribe(posts => {
            this.posts = posts;
        })    
}
```

### Part 8.0 Populating Our Feed with Posts

* Navigate to the ``feed.component.html``. Remember that we populated it with the ``<app-post>`` component, which currently contains sample data.
* To create a list of posts, we are going to use the ``*ngFor`` directive. We'll first create some sample html to test.
```html
<app-post></app-post>
<div *ngFor="let post of posts">
    {{ post.user.username }}
    {{ post.content }}
</div>
```
* Rather than creating a div for each post, we want to create an ``app-post`` component for each post. Let's add *ngFor to our ``app-post`` element instead.
    * Now we have an ``app-post`` component, still full of sample data, for each post in our posts array.
```html
<app-post *ngFor="let post of posts"></app-post>
```

### Part 8.1 Updating our PostComponent

*Resources*: <a href="https://angular.io/guide/component-interaction">Component Interaction</a>

* Child components can receive data to display from parent components. In the next steps, we'll update our ``PostComponent`` to receive a post to display from the ``FeedComponent`` 
* Navigate to the ``post.component.ts`` file.
* Add a public field of ``post`` of type ``post`` to the ``PostComponent`` class.
```javascript
import { Component } from '@angular/core';
import { Post } from '../../types/Post';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
})
export class PostComponent {
  public post: Post;
}
```
* This field will be populated by input from the parent component. To designate that a field will be inputted from the parent, use the ``@Input`` decorator.
```javascript
import { Component, Input } from '@angular/core';
import { Post } from '../../types/Post';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
})
export class PostComponent {
  @Input() public post: Post;
}
```
* Navigate to the ``post.component.html`` file.
* Replace the sample data with the following data interpolations. 
```javascript
<div class="post">
  <div class="post-username">{{post.user.username}}</div>
  <div class="post-content">{{post.content}}</div>
</div>
```

### Part 8.2 Updating the FeedComponent

* Navigate to the ``feed.component.html`` file
* The ``app-post`` component now has a property called post. We can bind the value of that field to a value we provide using one way data-binding.
```javascript
<app-post *ngFor="let post of posts" [post]="post"></app-post>
```

### Part 9.0 Posting new Posts

*Resources*: <a href="https://angular.io/guide/forms">Angular Forms</a>, <a href="https://blog.thoughtram.io/angular/2016/10/13/two-way-data-binding-in-angular-2.html">Two Way Data-Binding Using ngModel</a>

* Navigate to the ``app.module.ts``.  In order to work with our new post form, we'll need to import Angular's ``FormsModule``, which will allow us to do two-way data-binding.
```javascript
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { NewPostComponent } from './components/new-post/new-post.component';
import { PostComponent } from './components/post/post.component';
import { FeedComponent } from './components/feed/feed.component';

import { PostsService } from './services/posts.service';

@NgModule({
  declarations: [
    AppComponent,
    NewPostComponent,
    PostComponent,
    FeedComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [PostsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
```
* Navigate to the ``new-post.component.ts`` file. 
* Add a new public field called ``content`` of type ``string``. 
* Add a new public method called submitPost. Submit post should not take any parameters and should return void.
```javascript
export class NewPostComponent {
  public content: string;
  
  public submitPost(): void {
    
  }
}
```
* Navigate to the ``new-post.component.html`` file. Bind the value of the textarea to the content field, using two-way databinding with ngModel.
* Bind the click event on the ``button`` selector with the ``submitPost`` method, using event binding. 
```javascript
<textarea rows="4" cols="50" placeholder="How is your day?" [(ngModel)]="content">
</textarea>
<div>
  <button type="submit" (click)="submitPost()">
    Submit
  </button>
</div>
``` 
* The submit post method should call a method in the ``PostService`` which handles sending a ``post`` request to our api. Navigate to the ``post.service.ts`` file.
* Create a new method on the ``PostService`` class called ``createNewPost``, which takes in a parameter ``post`` of type ``Post`` and returns an ``Observable`` of type ``Post``.
```javascript
public createNewPost(post: Post): Observable<Post> {
   return this.http.post<Post>('http://localhost:8080/posts', post);
}
```
* Navigate to the ``new-post.component.ts`` file.
* The ``submitPost`` method should call the createNewPost method on the submit on the ``PostService``. 
* In order to use the ``PostService``, import and inject the service as a dependency.
* In the ``submitPost`` method, create an variable called ``post`` of type ``Post`` containing a Post object. Assign the content property to ``this.content``. For now, we'll assign the user property to a predefined sample user. 
```javascript
import { Component } from '@angular/core';
import { Post } from '../../types/Post';

import { PostsService } from '../../services/posts.service';

@Component({
  selector: 'app-new-post',
  templateUrl: './new-post.component.html',
})
export class NewPostComponent {
  public content: string;
  private postsService: PostsService;

  constructor(postsService: PostsService) {
    this.postsService = postsService;
  }

  public submitPost(): void {
    const post: Post = {
      content: this.content,
      user: {
        username: 'me',
        id: 1
      }
    };
    this.postsService.createNewPost(post)
      .subscribe();
  }
}
```
### Part 10.0 Updating Our Posts

* We just posted a new post, but we don't see the update in our view. Let's refactor our code to listen for updates.

* Navigate to the ``post.service.ts`` file. 

* Recall that our our ``getPosts`` method returns an ``Observable``. Subscribing to this observable will listen for an update from the api when the data comes back from the server. However, it's hard for us to listen to updates to that data, especially when the update needs to happen in a separate component. Our ``NewPost`` component is triggering a change, but our ``Feed`` component needs to know about it.

* We can use our service to send updates to our components when there are changes, using a special type of ``Observable`` called a ``BehaviorSubject``
    * BehaviorSubjects can emit values over time. The have a notion of a "currentValue" and can receive new values to emit. All subscribers (also called Observers) will receive an update when the value is changed.
    
* Create two new fields on ``PostService``.
    * The ``postsObservable`` should be public, so our components can subscribe to it.

```javascript
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';

import { Post } from '../types/Post';

@Injectable()
export class PostsService {
  private http: HttpClient;
  private postsBehaviorSubject: BehaviorSubject<Array<Post>>;
  public postsObservable: Observable<Array<Post>>;

  constructor(http: HttpClient) {
    this.http = http;

    this.postsBehaviorSubject = new BehaviorSubject([]);
    this.postsBehaviorSubject.asObservable();
  }

  public getPosts(): Observable<Array<Post>> {
    return this.http.get<Array<Post>>('http://localhost:8080/posts');
  }

  public createNewPost(post: Post): Observable<Post> {
    return this.http.post<Post>('http://localhost:8080/posts', post);
  }
}
```

* Instead of calling our ``getPosts`` method within our component, we will call it in our service, updating the BehaviorSubject with the value that comes back from the API, which will in term update the corresponding ``Observable`` and send a message to any subscribers.
    * To give the BehaviorSubject a new value, call the ``next`` method, passing in the new value.
    * ``getPosts`` is now private. We will only be calling it from within the service, then update a publicly available observer when we receive the data back from the http call.
```javascript
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';

import { Post } from '../types/Post';

@Injectable()
export class PostsService {
  private http: HttpClient;
  private postsBehaviorSubject: BehaviorSubject<Array<Post>>;
  public postsObservable: Observable<Array<Post>>;

  constructor(http: HttpClient) {
    this.http = http;

    this.postsBehaviorSubject = new BehaviorSubject([]);
    this.postsObservable = this.postsBehaviorSubject.asObservable();
    
    this.getPosts()
        .subscribe(posts => {
            this.postsBehaviorSubject.next(posts);
        });
  }

  private getPosts(): Observable<Array<Post>> {
    return this.http.get<Array<Post>>('http://localhost:8080/posts');
  }

  public createNewPost(post: Post): Observable<Post> {
    return this.http.post<Post>('http://localhost:8080/posts', post);
  }
}
```
* Refactor our ```createNewPost``` method to return void, and instead subscribe to the ``Observable`` returned from ``http.post()``. When it receives a new value from the api, it should add the new post to the currentPosts array (i.e. the current value of the ``BehaviorSubject``), then update the ``BehaviorSubject`` with the new value.
```javascript
public createNewPost(post: Post): Observable<Post> {
   this.http.post<Post>('http://localhost:8080/posts', post)
       .subscribe(newPost => {
            let currentPosts = this.postsBehaviorSubject.getValue();
            currentPosts.add(newPost);
            this.postsBehaviorSubject.next(currentPosts);
       });
}
```
### Part 10.1 Refactoring the NewPost component

* Navigate to ``new-post.component.ts``. Remove the ``subscribe`` method from the ``this.postService.createNewPost()`` method declaration.
```javascript
public submitPost(): void {
    const post: Post = {
      content: this.content,
      user: {
        username: 'me',
        id: 1
      }
    };
    this.postsService.createNewPost(post);
}
```

### Part 10.2 Refactoring the Feed Component

* Navigate to the ``feed.component.ts`` file.

* Instead of subscribing to the ``getPosts()`` method, subscribe to the publicly available ``postsObservable`` field on the ``PostService``.

```javascript
ngOnInit(): void {
    this.postsService.postsObservable
      .subscribe(posts => {
        this.posts = posts;
      });
}
```
* Navigate back to ``localhost:8080``. Create a new post and watch it update the feed.







