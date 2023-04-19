# Food-Facts-MVVM
Implementing MVVM Architecture (Room, Dagger 2 , Livedata, databinding, Picasso, Retrofit, Okhttp)

1 - Les points developpés :

- Mise en place de l'architecture MVVM et utilisation des composant d'architecture proposé par Google

- Utilisation de Livedata pour observation des données en respectant le le cycle de vie des activités et fragments.

- Mise en place d'un Client REST basé sur Retrofit 2 et Okhttp.

- La persistance des données grace à Room

- Code review : séparation des différentes parties de code par l'utilisation des "regions"

- Utilisation de Android Databinding pour le binding des views.

- Mise en place Zxing pour la lecture du code a bar

- Intégration de leakcanary : détection des fuites mémoires

2 - Outils et librairies Utilisés : Android Studio 3, Git, Livedata, LifeCycle, Retrofit 2, Okhttp, Databinding, Dagger 2, Room

3 - Proposition des nouvelles fonctionnalités :


- Intégration de Robolectric : tests unitaires sur UI

- Migration vers Kotlin

- Utiliser "Repository" pour verifier si la data est dans la base sinon la fetcher du API
