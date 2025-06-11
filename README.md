


# 📝 Blogging Platform API

A simple RESTful API built with Spring Boot and MySQL that allows users to perform CRUD operations on blog posts. This project demonstrates best practices for building REST APIs, including request validation, HTTP methods, and error handling.

---

## Poject Url : https://github.com/Mahesh1vallepu/Blogging-Platform-API

---
## 🔧 Tech Stack

- Java 17+
- Spring Boot
- Spring Data JPA
- MySQL
- Lombok
- Maven

---

🧪 Tools for Testing
    - Postman

## 📌 Features

- Create a blog post
- View a single blog post
- View all blog posts
- Update a blog post
- Delete a blog post
- Search blog posts by title, content, or category

---

## 🧠 API Endpoints

### Create Blog Post
**POST** `/Blog/posts`

```json
{
  "title": "My First Blog Post",
  "content": "This is the content.",
  "category": "Technology",
  "tags": ["Java", "Spring"]
}

📝 Get a Single Blog Post
GET/Blog/posts/{id}
{
  "id": 1,
  "title": "My First Blog Post",
  "content": "This is the content of my first blog post.",
  "category": "Technology",
  "tags": ["Tech", "Programming"],
  "createdAt": "2025-06-10T10:00:00",
  "updatedAt": "2025-06-10T10:00:00"
}

📚 Get All Blog Posts
   GET /Blog/posts
[
  {
    "id": 1,
    "title": "My First Blog Post",
    "content": "This is the content of my first blog post.",
    "category": "Technology",
    "tags": ["Tech", "Programming"],
    "createdAt": "2025-06-10T10:00:00",
    "updatedAt": "2025-06-10T10:00:00"
  },
  {
    "id": 2,
    "title": "Second Blog",
    "content": "Another content",
    "category": "Health",
    "tags": ["Life", "Fitness"],
    "createdAt": "2025-06-10T10:10:00",
    "updatedAt": "2025-06-10T10:10:00"
  }
]

🔍 Search Blog Posts
GET /Blog/posts?term=tech

Returns blog posts where term appears in title, content, or category.

🛠️ Update Blog Post
PUT /Blog/posts/{id}

{
  "title": "Updated Blog Post",
  "content": "This is updated content.",
  "category": "Tech",
  "tags": ["Java", "Spring"]
}
{
  "id": 1,
  "title": "Updated Blog Post",
  "content": "This is updated content.",
  "category": "Tech",
  "tags": ["Java", "Spring"],
  "createdAt": "2025-06-10T10:00:00",
  "updatedAt": "2025-06-10T10:15:00"
}

❌ Delete Blog Post
DELETE /Blog/posts/{id}

Response
204 No Content on success

404 Not Found if ID doesn’t exist
