# Simple Web App - Application Spring Boot

## 📋 Description

Simple Web App est une application web REST API développée avec Spring Boot pour la gestion de produits. Cette application démontre les concepts fondamentaux de Spring Boot, incluant les contrôleurs REST, les services, et la gestion des données en mémoire.

## 🛠️ Technologies Utilisées

- **Java 21** - Langage de programmation
- **Spring Boot 3.5.6** - Framework principal
- **Spring Web** - Pour créer des API REST
- **Lombok 1.18.30** - Pour réduire le code boilerplate
- **Maven** - Gestionnaire de dépendances et build
- **Spring DevTools** - Pour le rechargement automatique pendant le développement

## 📁 Structure du Projet

```
simpleWebApp/
├── src/
│   ├── main/
│   │   ├── java/com/kibagami/simpleWebApp/
│   │   │   ├── SimpleWebAppApplication.java    # Point d'entrée de l'application
│   │   │   ├── controller/                      # Contrôleurs REST
│   │   │   │   ├── HomeController.java         # Endpoints de base (/, /about)
│   │   │   │   ├── LoginController.java        # Endpoint de login
│   │   │   │   └── ProductController.java      # API REST pour les produits
│   │   │   ├── model/                          # Modèles de données
│   │   │   │   └── Product.java               # Modèle Product
│   │   │   └── service/                        # Logique métier
│   │   │       └── ProductService.java        # Service de gestion des produits
│   │   └── resources/
│   │       ├── application.properties          # Configuration de l'application
│   │       ├── static/                         # Fichiers statiques (CSS, JS, images)
│   │       └── templates/                      # Templates HTML
│   │           └── products.html
│   └── test/                                   # Tests unitaires
├── pom.xml                                      # Configuration Maven
└── README.md                                    # Ce fichier
```

## 🚀 Installation et Démarrage

### Prérequis

- Java JDK 21 ou supérieur
- Maven 3.6+ (ou utiliser le wrapper Maven inclus `./mvnw`)

### Étapes d'installation

1. **Cloner le projet** (si applicable)
   ```bash
   git clone <url-du-repository>
   cd simpleWebApp
   ```

2. **Compiler le projet**
   ```bash
   ./mvnw clean install
   ```
   ou sur Windows :
   ```cmd
   mvnw.cmd clean install
   ```

3. **Démarrer l'application**
   ```bash
   ./mvnw spring-boot:run
   ```
   ou sur Windows :
   ```cmd
   mvnw.cmd spring-boot:run
   ```

4. **L'application sera accessible sur** : `http://localhost:8080`

## 📡 API Endpoints

### Endpoints de Base

| Méthode | Endpoint | Description |
|---------|----------|-------------|
| GET | `/` | Page d'accueil avec message de bienvenue |
| GET | `/about` | Page "À propos" de l'application |
| GET | `/login` | Page de connexion |

### API Produits

| Méthode | Endpoint | Description | Body |
|---------|----------|-------------|------|
| GET | `/products` | Récupère la liste de tous les produits | - |
| GET | `/products/{id}` | Récupère un produit par son ID | - |
| POST | `/products` | Ajoute un nouveau produit | JSON Product |

### Exemples d'utilisation

#### 1. Récupérer tous les produits
```bash
GET http://localhost:8080/products
```

**Réponse** :
```json
[
  {
    "id": 101,
    "name": "Laptop",
    "price": 999.99
  },
  {
    "id": 102,
    "name": "Smartphone",
    "price": 499.99
  },
  {
    "id": 103,
    "name": "Tablet",
    "price": 299.99
  }
]
```

#### 2. Récupérer un produit par ID
```bash
GET http://localhost:8080/products/101
```

**Réponse** :
```json
{
  "id": 101,
  "name": "Laptop",
  "price": 999.99
}
```

#### 3. Ajouter un nouveau produit
```bash
POST http://localhost:8080/products
Content-Type: application/json

{
  "id": 104,
  "name": "Smartwatch",
  "price": 199.99
}
```

**Note importante** : Le champ `prodId` est masqué dans les réponses JSON grâce à l'annotation `@JsonIgnore` pour éviter la duplication avec le champ `id`.

## 🔧 Configuration

### application.properties

Le fichier de configuration se trouve dans `src/main/resources/application.properties` :

```properties
spring.application.name=simpleWebApp
```

Vous pouvez ajouter des configurations supplémentaires comme :
- Le port du serveur : `server.port=8080`
- La configuration de la base de données
- Les paramètres de logging

## 🏗️ Architecture

### Modèle (Model)

**Product.java** - Représente un produit avec :
- `id` : Identifiant unique du produit
- `name` : Nom du produit
- `price` : Prix du produit
- `getProdId()` : Méthode masquée dans le JSON (avec `@JsonIgnore`)

### Service

**ProductService.java** - Contient la logique métier :
- Stockage en mémoire d'une liste de produits (ArrayList)
- Opérations CRUD sur les produits
- Recherche de produit par ID avec gestion du cas "non trouvé"

### Contrôleurs (Controllers)

**ProductController.java** - API REST pour la gestion des produits :
- `@RestController` : Indique que c'est un contrôleur REST
- `@Autowired` : Injection de dépendance du service
- Mapping des endpoints HTTP vers les méthodes Java

**HomeController.java** - Endpoints de base de l'application

**LoginController.java** - Endpoint de connexion

## 🧪 Tests

Pour exécuter les tests unitaires :

```bash
./mvnw test
```

## 📝 Points Importants et Solutions aux Problèmes Courants

### Pourquoi la page /products n'affiche pas les données ?

Si vous accédez à `/products` dans un navigateur et ne voyez pas les données :
1. ✅ Vérifiez que l'application est bien démarrée
2. ✅ Utilisez un client REST comme Postman, cURL, ou un navigateur avec extension JSON
3. ✅ L'endpoint retourne du JSON brut, pas du HTML

### Pourquoi le champ prodId n'apparaît pas dans Postman ?

Le champ `prodId` est intentionnellement masqué grâce à l'annotation `@JsonIgnore` dans la classe `Product.java`. Cela évite de dupliquer l'information avec le champ `id` lors de la sérialisation JSON.

```java
@JsonIgnore
public int getProdId() {
    return id;
}
```

Cette méthode est utilisée en interne par le service pour filtrer les produits, mais n'est pas exposée dans l'API REST.

## 🔍 Utilisation avec Postman

1. **Importer la collection** (si disponible) ou créer manuellement les requêtes
2. **Endpoints à tester** :
   - GET `http://localhost:8080/products`
   - GET `http://localhost:8080/products/101`
   - POST `http://localhost:8080/products` avec body JSON

## 📦 Dépendances Maven Principales

```xml
<!-- Spring Boot Web pour les API REST -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<!-- Lombok pour réduire le code boilerplate -->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.30</version>
</dependency>

<!-- DevTools pour le rechargement automatique -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <scope>runtime</scope>
    <optional>true</optional>
</dependency>
```

## 🚧 Améliorations Futures

- [ ] Ajouter une base de données persistante (H2, PostgreSQL, MySQL)
- [ ] Implémenter les opérations UPDATE et DELETE
- [ ] Ajouter la validation des données (Bean Validation)
- [ ] Implémenter la sécurité (Spring Security)
- [ ] Ajouter la gestion des exceptions personnalisées
- [ ] Créer des tests unitaires et d'intégration complets
- [ ] Ajouter de la documentation Swagger/OpenAPI
- [ ] Implémenter la pagination pour la liste des produits

## 📄 Licence

Ce projet est un projet de démonstration pour l'apprentissage de Spring Boot.

## 👤 Auteur

Développé par Kibagami

---

**Note** : Cette application utilise un stockage en mémoire. Les données seront perdues au redémarrage de l'application. Pour une persistance réelle, il faudrait intégrer une base de données avec Spring Data JPA.

