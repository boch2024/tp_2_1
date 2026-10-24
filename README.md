# TP2 - Activité 2-1 : Sockets TCP (échange de chaînes de caractères)

**Matière :** Développement d'applications réparties - LSI 3
**Année :** 2026 - 2027

## Description

Cette application contient un **Client** et un **Serveur** en Java qui communiquent avec les sockets TCP.

Le client envoie une opération complète (exemple : `55 * 25`). Le serveur calcule le résultat et le renvoie au client. Le client affiche le résultat.

## Fichiers

- `Serveur.java` : reçoit l'opération, calcule et envoie le résultat.
- `Client.java` : lit l'opération au clavier, vérifie la syntaxe, envoie au serveur et affiche le résultat.

## Comment ça marche

1. Le client lit l'opération (exemple : `55 * 25`).
2. Le client vérifie la syntaxe avec `split`. Il faut 3 parties : nombre, opérateur, nombre.
3. Le client envoie 3 lignes au serveur : le premier nombre, l'opérateur et le deuxième nombre.
4. Le serveur calcule l'opération (`+`, `-`, `*`, `/`).
5. Le serveur envoie le résultat au client.
6. Le client affiche le résultat.

Si la syntaxe est fausse (exemple : `25 ** 55` ou `abc + 3`), le client affiche une erreur et n'envoie rien au serveur.

## Exécution

1. Compiler :
   ```
   javac Serveur.java Client.java
   ```
2. Lancer le serveur dans un premier terminal :
   ```
   java Serveur
   ```
3. Lancer le client dans un deuxième terminal :
   ```
   java Client
   ```
4. Écrire une opération avec des espaces (exemple : `55 * 25`). Pour quitter, écrire `quit`.

## Exemple

```
Connecté au serveur. Saisissez une opération (ex: 55 * 25) ou 'quit'.
> 55 * 25
Résultat : 1375.0
```

## Captures d'écran

**Serveur en attente :**

<img width="937" height="340" alt="Capture d&#39;écran 2026-10-25 003644" src="https://github.com/user-attachments/assets/e70b243e-4d65-4a15-8133-356a1a965435" />


**Client avec le résultat :**

<img width="972" height="367" alt="Capture d&#39;écran 2026-10-25 003721" src="https://github.com/user-attachments/assets/ad0be1d6-b392-40da-a7b9-7f9bb7a2921c" />
