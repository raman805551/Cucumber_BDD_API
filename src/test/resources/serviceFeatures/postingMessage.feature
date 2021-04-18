Feature: To test the social network website for posts, comments and users details
  As a user, I want to verify that posting a message on social site is successfull
  and  check for comments on the post including the users

  Scenario Outline: Validate the posts is returning a valid and invalid response
  Given I want to post a "<message>" on social network website
  When I do a POST request for "<endPoint>"
  Then I validate the response with status code <expectedStatus>

  Examples:
  |Test Case                 | message                   | expectedStatus | endPoint                                   |
  |Valid HTTPS Request       |Hello check my new post    |201             | https://jsonplaceholder.typicode.com/posts |
  |Invalid HTTPS Request     |Hello check my new post    |404             | https://jsonplaceholder.typicode.com/post  |
  |Valid HTTP Request        |Hello check my second post |201             | http://jsonplaceholder.typicode.com/posts  |
  |Invalid HTTP Request      |Hello check my new post    |404             | https://jsonplaceholder.typicode.com/post  |

  Scenario Outline: validate the comment on post is returning a valid response
    Given I want to get the comments on the post
    When I do a GET request for "<endPoint>"
    Then I validate the response with status code <expectedStatus>
    Then I validate the Email in the response body is "<Email>"

    Examples:
      |Test Case                 | endPoint                                              | expectedStatus | Email              |
      |Valid HTTPS Request       | https://jsonplaceholder.typicode.com/comments         |            200 | Eliseo@gardner.biz |
      |Invalid HTTPS Request     | https://jsonplaceholder.typicode.com/comment          |            404 | Eliseo@gardner.biz |
      |Valid HTTP Request        | https://jsonplaceholder.typicode.com/comments         |            200 | Eliseo@gardner.biz |
      |Invalid HTTP Request      | https://jsonplaceholder.typicode.com/comment          |            404 | Eliseo@gardner.biz |

  Scenario Outline: To get the list of users
    Given I want to get the list of all the users
    When I do a GET request for "<endPoint>"
    Then I validate the response with status code <expectedStatus>

    Examples:
      |Test Case                 | endPoint                                   | expectedStatus |
      |Valid HTTPS Request       | https://jsonplaceholder.typicode.com/users |            200 |
      |Invalid HTTPS Request     | https://jsonplaceholder.typicode.com/user  |            404 |
      |Valid HTTP Request        | https://jsonplaceholder.typicode.com/users |            200 |
      |Invalid HTTP Request      | https://jsonplaceholder.typicode.com/user  |            404 |