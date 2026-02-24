# API REST Testing - Valorant API

## Base URL
```
http://localhost:8080
```

---

## PERSONATGES

### GET - Listar todos
- **URL:** `http://localhost:8080/api/personatges`
- **Method:** GET

### GET - Obtener por ID
- **URL:** `http://localhost:8080/api/personatges/1`
- **Method:** GET

### POST - Crear personatge
- **URL:** `http://localhost:8080/api/personatges`
- **Method:** POST
- **Body:**
```json
{
    "nom": "Neon",
    "rol": "Duelista",
    "descripcio": "Agent filipina amb velocitat electrica",
    "imatge": "/img/neon.jpg"
}
```

### PUT - Actualizar personatge
- **URL:** `http://localhost:8080/api/personatges/1`
- **Method:** PUT
- **Body:**
```json
{
    "nom": "Jett Modificada",
    "rol": "Duelista",
    "descripcio": "Agent coreana actualitzada",
    "imatge": "/img/jett_v2.jpg"
}
```

### DELETE - Eliminar personatge
- **URL:** `http://localhost:8080/api/personatges/1`
- **Method:** DELETE

---

## ARMES

### GET - Listar todas
- **URL:** `http://localhost:8080/api/armes`
- **Method:** GET

### GET - Obtener por ID
- **URL:** `http://localhost:8080/api/armes/1`
- **Method:** GET

### POST - Crear arma
- **URL:** `http://localhost:8080/api/armes`
- **Method:** POST
- **Body:**
```json
{
    "nom": "Outlaw",
    "categoria": "Sniper",
    "preu": 2400,
    "descripcio": "Nou franctirador de dos trets",
    "imatge": "/img/outlaw.jpg"
}
```

### PUT - Actualizar arma
- **URL:** `http://localhost:8080/api/armes/1`
- **Method:** PUT
- **Body:**
```json
{
    "nom": "Classic Pro",
    "categoria": "Pistola",
    "preu": 0,
    "descripcio": "Pistola inicial millorada",
    "imatge": "/img/classic_pro.jpg"
}
```

### DELETE - Eliminar arma
- **URL:** `http://localhost:8080/api/armes/1`
- **Method:** DELETE

---

## MAPES

### GET - Listar todos
- **URL:** `http://localhost:8080/api/mapes`
- **Method:** GET

### GET - Obtener por ID
- **URL:** `http://localhost:8080/api/mapes/1`
- **Method:** GET

### POST - Crear mapa
- **URL:** `http://localhost:8080/api/mapes`
- **Method:** POST
- **Body:**
```json
{
    "nom": "Abyss",
    "descripcio": "Nou mapa sense barreres",
    "imatge": "/img/abyss.jpg"
}
```

### PUT - Actualizar mapa
- **URL:** `http://localhost:8080/api/mapes/1`
- **Method:** PUT
- **Body:**
```json
{
    "nom": "Ascent Reformat",
    "descripcio": "Mapa italia amb canvis",
    "imatge": "/img/ascent_v2.jpg"
}
```

### DELETE - Eliminar mapa
- **URL:** `http://localhost:8080/api/mapes/1`
- **Method:** DELETE

---

## HABILITATS

### GET - Listar todas
- **URL:** `http://localhost:8080/api/habilitats`
- **Method:** GET

### GET - Obtener por ID
- **URL:** `http://localhost:8080/api/habilitats/1`
- **Method:** GET

### POST - Crear habilitat
- **URL:** `http://localhost:8080/api/habilitats`
- **Method:** POST
- **Body:**
```json
{
    "nom": "Nova Habilitat",
    "descripcio": "Habilitat de prova",
    "tecla": "E",
    "imatge": "/img/habilitat.jpg"
}
```

### PUT - Actualizar habilitat
- **URL:** `http://localhost:8080/api/habilitats/1`
- **Method:** PUT
- **Body:**
```json
{
    "nom": "Cloudburst Millorat",
    "descripcio": "Fum mes gran i dura mes",
    "tecla": "C",
    "imatge": "/img/cloudburst_v2.jpg"
}
```

### DELETE - Eliminar habilitat
- **URL:** `http://localhost:8080/api/habilitats/1`
- **Method:** DELETE

---

## MODOS DE JUEGO

### GET - Listar todos
- **URL:** `http://localhost:8080/api/modosjuego`
- **Method:** GET

### GET - Obtener por ID
- **URL:** `http://localhost:8080/api/modosjuego/1`
- **Method:** GET

### POST - Crear modo de juego
- **URL:** `http://localhost:8080/api/modosjuego`
- **Method:** POST
- **Body:**
```json
{
    "nom": "Team Deathmatch",
    "descripcio": "Nou mode 5v5 sense bomba"
}
```

### PUT - Actualizar modo de juego
- **URL:** `http://localhost:8080/api/modosjuego/1`
- **Method:** PUT
- **Body:**
```json
{
    "nom": "Competitiu Actualitzat",
    "descripcio": "Mode ranquit amb millores"
}
```

### DELETE - Eliminar modo de juego
- **URL:** `http://localhost:8080/api/modosjuego/1`
- **Method:** DELETE

---

## ESTADÍSTIQUES (Lògica de Negoci)

### GET - Estadístiques d'un Personatge
- **URL:** `http://localhost:8080/api/personatges/1/estadistiques`
- **Method:** GET
- **Resposta esperada:**
```json
{
    "nomPersonatge": "Jett",
    "rol": "Duelista",
    "numHabilitats": 4,
    "teclesUtilitzades": ["C", "Q", "E", "X"],
    "habilitatUltimate": "Blade Storm",
    "nomsHabilitats": ["Cloudburst", "Updraft", "Tailwind", "Blade Storm"]
}
```

### GET - Estadístiques d'un Modo de Joc
- **URL:** `http://localhost:8080/api/modosjuego/1/estadistiques`
- **Method:** GET
- **Resposta esperada:**
```json
{
    "nomModo": "Competitiu",
    "descripcio": "Mode de joc ranquit amb sistema ELO",
    "numMapes": 10,
    "nomsMapes": ["Ascent", "Bind", "Haven", "Split", "Icebox", "Breeze", "Fracture", "Pearl", "Lotus", "Sunset"]
}
```

---

## Configuración en Postman

1. Selecciona el método (GET/POST/PUT/DELETE)
2. Pega la URL
3. Para POST y PUT:
   - Ve a **Body** → **raw** → selecciona **JSON**
   - Pega el JSON correspondiente
4. Click en **Send**

---

## UPLOAD DE FITXERS

### GET - Mostrar formulari d'upload (HTML)
- **URL:** `http://localhost:8080/upload`
- **Method:** GET
- **Descripció:** Mostra la pàgina HTML amb el formulari de pujada i la llista de fitxers

### POST - Pujar un fitxer
- **URL:** `http://localhost:8080/upload`
- **Method:** POST
- **Body:** form-data
  - **Key:** `file`
  - **Tipus:** File
  - **Value:** selecciona un fitxer (png/jpg/pdf)
- **Nota:** No poses Content-Type manualment, Postman ho fa automàticament
- **Resposta:** 302 Found (redirect a /upload)

### GET - Visualitzar un fitxer pujat
- **URL:** `http://localhost:8080/uploads/{nomFitxer}`
- **Exemples:**
  - `http://localhost:8080/uploads/foto.png`
  - `http://localhost:8080/uploads/document.pdf`
- **Method:** GET
- **Resposta:** El fitxer (binari) amb Content-Type adequat
- **Errors possibles:**
  - 404 Not Found: si no existix el fitxer
  - 400 Bad Request: si el nom intenta eixir de la carpeta (../)

### POST - Eliminar un fitxer
- **URL:** `http://localhost:8080/upload/delete/{nomFitxer}`
- **Exemple:** `http://localhost:8080/upload/delete/foto.png`
- **Method:** POST
- **Resposta:** 302 Found (redirect a /upload)

### Proves en Postman - Upload

**0) Autorització (obligatòria)**
En cada request de Postman:
- Authorization → Type: Basic Auth
- Username: (un usuari existent)
- Password: la seua contrasenya

**1) Mostrar la pàgina d'upload**
```
GET http://localhost:8080/upload
```
- Resposta: 200 OK amb HTML

**2) Pujar un fitxer**
```
POST http://localhost:8080/upload
Body → form-data → Key: file (tipus File)
```
- Resposta: 302 Found

**3) Visualitzar fitxer**
```
GET http://localhost:8080/uploads/nomFitxer.ext
```
- Resposta: 200 OK amb el fitxer

**4) Eliminar fitxer**
```
POST http://localhost:8080/upload/delete/nomFitxer.ext
```
- Resposta: 302 Found

