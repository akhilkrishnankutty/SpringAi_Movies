# 🎬 Spring AI Movie Recommender

This is a demo application showcasing the integration of **Spring AI** with **Ollama**, running locally to generate AI-powered movie recommendations.  
The application interacts with the **OMDb API** to fetch detailed information about the recommended movies.

---

## 🚀 Features

### 🔹 AI-Powered Movie Suggestion
- **Endpoint:** `GET /movies/random`
- Uses a locally running **Ollama** model to generate random movie titles.

### 🔹 Movie Details via OMDb API
- **Endpoint:** `POST /movies/bytitle`
- Accepts a movie title in the request body and returns complete movie details (plot, genre, year, etc.).

### 🔹 Genre-Based Recommendations
- **Endpoint:** `GET /movies/recommend/bygenre`
- Requires a `genre` parameter and returns a list of movies matching the genre.

---

## 🖼️ Screenshots

### 🎲 AI Movie Recommendation Output
> **Endpoint:** `/movies/random`

![AI Movie Recommendation](img.png)

The AI generates a random movie title, which is then passed to the OMDb API for further details.

---

### 🎬 OMDb Movie Details Output
> **Endpoint:** `/movies/bytitle`

![OMDb API Output](img_1.png)

---

### 🔍 Search by Movie Title
> **Endpoint:** `/movies/bytitle` (POST)  
> **Body Example:**
```json
{
  "title": "Inception"
}
```

### 🔍 Search by Movie Genre

![OMDb API Output](img_3.png)

AI will recommend an movie based on the input genre