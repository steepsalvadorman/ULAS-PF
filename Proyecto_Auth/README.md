# Auth_firebase_firestore
//los componentes claves del proyecto seguir la siguente ruta en firebase
Nombre_Proyecto > Configuración de proyecto > Tus apps > npm
const firebaseConfig = {
  apiKey: "",
  authDomain: "",
  projectId: "",
  storageBucket: "",
  messagingSenderId: "",
  appId: "",
  measurementId: ""
};


Modelo de Autorizacion y autentificacion con servicios de nube
rules_version = '2';

//Firebase Cloud (reglas implementadas de usuario y admin)
service cloud.firestore {
  match /databases/{database}/documents {
    match /users/{userId}{
    	allow create: if request.auth.uid != null;
      allow read: if request.auth.uid == userId;
    }
    match /guides/{guideId}{
    	allow read: if request.auth.uid != null;
      allow write: if request.auth.token.admin == true;
    }
  }
}

//intalacion de Firebase Hosting
Instala Firebase CLI:  npm install -g firebase-tools

//Inicializa el proyecto
Acceder a Google: firebase login
Inicia el proyecto: firebase init

//Implementa en Firebase Hosting
firebase deploy

//Funcion de uso
//firebase Auth
addAdminRole
