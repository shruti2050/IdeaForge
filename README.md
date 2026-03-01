# 🚀 AI Project Idea Generator

An AI-powered web application that generates innovative, domain-specific project ideas based on user preferences like tech stack, difficulty level, and area of interest.

Built with a modern full-stack architecture using Spring Boot + Next.js and powered by OpenRouter AI.

---

## 🌟 Features

- 🤖 AI-powered project idea generation
- 🎯 Domain-specific suggestions (AI, Web, Blockchain, etc.)
- 📊 Difficulty-based filtering (Beginner / Intermediate / Advanced)
- 🎨 Professional Hackathon-Ready UI (Next.js + Tailwind)
- 📱 Fully Responsive (Mobile Compatible)
- ⚡ Fast API Integration using OpenRouter
- 📋 Copy All feature
- 🌀 Animated Loader
- 🧩 Project Ideas displayed in structured cards

---

## 🏗️ Tech Stack

### Frontend
- HTML
- CSS
- JavaScript

### Backend
- Spring Boot
- REST APIs
- RestTemplate
- Jackson Databind

### AI Provider
- OpenRouter API
- Model: `openai/gpt-3.5-turbo`

---

## 🧠 Architecture

```
User
  ↓
HTML,CSS,JS(FrontEnd)
  ↓
Spring Boot Backend
  ↓
OpenRouter AI API
```

- Frontend collects user inputs.
- Backend processes prompt and securely calls OpenRouter.
- AI response is formatted and displayed as styled project cards.

---

## 📂 Project Structure

```
ai-project-generator/
│
├── projectgenerator/
│   ├── controller/
│   ├── service/
│   └── application.properties
│
├── frontend/
│   ├── index.html
│   
│   
│
└── README.md
```

---

## ⚙️ Setup Instructions

### 🔹 1. Clone Repository

```bash
git clone https://github.com/your-username/ai-project-generator.git
cd ai-project-generator
```

---

### 🔹 2. Backend Setup (Spring Boot)

```bash
cd projectgenerator
```

Update `application.properties`:

```properties
openrouter.api.key=YOUR_OPENROUTER_API_KEY
```

Run backend:

```bash
mvn spring-boot:run
```

Backend runs on:
```
http://localhost:8080
```

---


## 🌍 API Endpoint

```
POST /api/generate
```

Request Body:
```json
{
  "techStack": "Java + React",
  "domain": "AI",
  "level": "Advanced",
  "interest": "Healthcare"
}
```

Response:
AI-generated structured project ideas.

---

## 🚀 Deployment

### projectgenerator
- Deploy on Render 
- Add environment variable:
  ```
  openrouter.api.key=YOUR_KEY
  ```





## 📸 Screenshots

(Add screenshots here after deployment)

---

## 🔐 Security

- API key stored securely in backend
- Not exposed to frontend
- CORS enabled for production

---

## 👩‍💻 Author

Shruti  
Third Year Engineering Student  
Full Stack Developer | AI Enthusiast  

---

## ⭐ Future Improvements

- User authentication
- Save favorite ideas
- Idea voting system
- PDF export
- AI-powered roadmap generation

---

## 📄 License

This project is open-source and available under the MIT License.
