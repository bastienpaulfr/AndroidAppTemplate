# Architecture

## But

- Code testable
- Code maintenable

## Elements

**Framework**

- `interactor`

C'est l'élément qui permet de manipuler un périphérique ou une bibliothèque externe.
C'est une couche d'abstraction qui permet de regrouper plusieurs périphériques d'un même type. Par exemple, nous pouvons avoir
une interface pour intéragir avec un lecteur d'empreinte digitale et une implémentation par contructeur.

**Data**

- `data source`

Source de donnée locale ou distante. Cela peut être une base de donnée ou une API Rest.

- `entity`

Modèle de donnée spécifique à une source.

**Domain**

- `repository`

Couche d'abstraction des `data source`. A niveau, on peut implémenter une logique de manipulation de donnée comme par exemple un cache
qui va chercher la donnée depuis une source locale ou alors depuis une source distante si la source locale n'est pas disponible.

- `usecase`

Ce niveau contient les logiques métier de l'application.

- `model`

Modèle de donnée utilisé dans l'application.

**Presentation**

- `view`

Vue brute affichée à l'écran sans aucune logique.

- `presenter`

Elément du pattern MVP.

- `view model`

Elément du pattern MVVM.

## Ressources

 - [Article Medium](https://budioktaviyans.medium.com/the-android-clean-architecture-pov-d9d5ec888534)
 - [Clean Architecture Tutorial for Android: Getting Started](https://www.raywenderlich.com/3595916-clean-architecture-tutorial-for-android-getting-started)
