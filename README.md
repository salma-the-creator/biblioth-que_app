#  TP06 – Application Android : Gestion des Livres

##  Description du projet
Ce projet est une application Android développée en **Kotlin**, permettant de gérer une liste de livres.  
L’utilisateur peut :
- Ajouter un livre (titre, prix, image et disponibilité)
- Afficher les livres sous forme de liste (RecyclerView)
- Consulter les détails d’un livre (dialogue avec titre, prix, disponibilité)
- Activer ou désactiver le **mode sombre (Dark Mode)** à l’aide d’un interrupteur (SwitchCompat)
- Sauvegarder automatiquement le thème choisi (grâce à `SharedPreferences`)

---

##  Fonctionnalités principales

| Fonction | Description |
|-----------|--------------|
|  **Ajouter un livre** | L’utilisateur peut saisir le titre, le prix, le lien de l’image et cocher “Disponible”. |
|  **Affichage dynamique** | Les livres sont affichés dans une RecyclerView avec leur image, titre, prix et état. |
| **Dark Mode** | L’application prend en charge le thème sombre grâce à `AppCompatDelegate`. |
|  **Sauvegarde du thème** | L’état du mode sombre est mémorisé avec `SharedPreferences`. |
|  **Dialog de détails** | Un clic sur un livre affiche une boîte de dialogue contenant ses informations. |

---



<img width="391" height="812" alt="Screenshot 2025-10-26 143448" src="https://github.com/user-attachments/assets/262773d9-1e9b-477e-a840-d726731f1a5b" />
