# 📝 Text Service

REST API сервис для хранения и обработки текстовых документов.

---

## 🌐 **Публичный URL**

🔗 [https://textservice-production.up.railway.app](https://textservice-production.up.railway.app)

---

## ⚙️ **Стек технологий**

| Компонент | Технология |
|-----------|------------|
| Язык | Java 17 |
| Фреймворк | Spring Boot 3 |
| Сборка | Maven |
| БД | PostgreSQL |
| Контейнеризация | Docker |
| CI/CD | GitHub Actions + Railway |
| Линтер | Checkstyle (Google Style) |
| Тесты | JUnit 5 |

---

## 📌 **Эндпоинты**

### 📝 Notes

| Метод | Эндпоинт | Описание |
|-------|----------|----------|
| 🟢 POST | `/notes/create` | Создать документ |
| 🔵 GET | `/notes` | Все документы |
| 🔵 GET | `/notes/{id}` | документ по ID |
| 🟡 PUT | `/notes/{id}` | Обновить документ |
| 🔴 DELETE | `/notes/{id}` | Удалить документ |
| 🔵 GET | `/notes/search?query={text}` | Поиск по тексту |
| 🔵 GET | `/notes/stats` | Статистика |

---

**📥 Пример запроса (POST /notes/create)**

```json
{
  "title": "Мой первый документ",
  "content": "Здесь хранится текстовое содержимое заметки. Можно писать длинные тексты."
}
