# Sistema de Gestión de Créditos - Fya Social Capital

Sistema web completo para el registro y consulta de créditos desarrollado como parte de la evaluación técnica para Fya Social Capital SAS.

## 📋 Descripción

Aplicación web full-stack que permite registrar créditos financieros y consultar la información almacenada, con notificaciones automáticas por correo electrónico para cada registro nuevo.

## 🚀 Funcionalidades

### ✅ Formulario de Registro de Créditos
- **Campos obligatorios**:
  - Nombre del cliente
  - Cédula o ID
  - Valor del crédito
  - Tasa de interés
  - Plazo en meses
  - Comercial que registra el crédito

### ✅ Notificación Automática por Correo (RPA)
- Envío automático de correo a `fyasocialcapital@gmail.com`
- **Información incluida**:
  - Nombre del cliente
  - Valor del crédito
  - Nombre del comercial
  - Fecha de registro
- Procesamiento asíncrono en segundo plano

### ✅ Módulo de Consulta de Créditos
- Visualización de todos los créditos en tabla
- **Filtros disponibles**:
  - Por nombre del cliente
  - Por ID/cédula
  - Por comercial
- **Ordenamiento**:
  - Por fecha de registro
  - Por valor del crédito

## 🛠️ Tecnologías Utilizadas

### Backend
- **Java 21** - Lenguaje de programación
- **Spring Boot** - Framework principal
- **Spring Data JPA** - Persistencia de datos
- **Spring Web** - API REST
- **Spring Mail** - Envío de correos electrónicos

### Frontend
- **React** - Biblioteca de JavaScript
- **Tailwind CSS** - Framework de estilos
- **Axios** - Cliente HTTP para API calls

### Base de Datos
- **PostgreSQL** - Base de datos relacional
- **Docker** - Contenedorización de la base de datos

### Herramientas de Desarrollo
- **Maven** - Gestión de dependencias
- **Docker Compose** - Orquestación de contenedores
- **Git** - Control de versiones


## 🚀 Instalación y Configuración

### Prerrequisitos
- Java 21
- Node.js 18+
- Docker y Docker Compose
- Git

### 1. Clonar el Repositorio
git clone https://github.com/Mauripolo17/Fya_credit_pruebaTecnica.git
cd Fya_credit_pruebaTecnica

### 2. Configurar Base de Datos
Iniciar PostgreSQL con Docker
docker-compose up -d postgres


### 3. Configurar Backend

Instalar dependencias y compilar
mvn clean install

Ejecutar aplicación
mvn spring-boot:run

### 4. Configurar Frontend

cd frontend

Instalar dependencias
npm install

Ejecutar en modo desarrollo

npm run dev
