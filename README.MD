[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/1HQg4bZb)
# 🏦 TP Java — ATM & Programmation Concurrente (Threads)

## 🎯 Objectifs du TP

À la fin de ce TP, vous serez capable de :

- Comprendre le principe des **threads** en Java
- Créer et exécuter des threads (`Thread`, `Runnable`)
- Identifier une **race condition**
- Protéger une ressource partagée avec `synchronized`
- Simuler des accès concurrents à un système réel (ATM)

---

## 📘 Contexte

Vous devez développer une **application Java simulant un distributeur bancaire (ATM)**.

Plusieurs clients peuvent utiliser **le même compte bancaire en même temps** pour effectuer :
- 💳 un retrait
- 💰 un dépôt
- 👁️ une consultation de solde

Chaque action sera exécutée **dans un thread distinct**.

---

## 🧱 Partie 1 — Modélisation (sans threads)

### 1️⃣ Classe `BankAccount`

Créer une classe `BankAccount` avec :

- Attributs :
  - `accountNumber` (int)
  - `balance` (double)
- Méthodes :
  - `deposit(double amount)`
  - `withdraw(double amount)`
  - `getBalance()`

📌 **Aucune synchronisation à ce stade**

---

### 2️⃣ Test simple

Dans une classe `Main` :

- Créer un compte avec **1000 €**
- Effectuer :
  - un dépôt de 200 €
  - un retrait de 150 €
- Afficher le solde final

---

## 🧵 Partie 2 — Introduction aux Threads

### 3️⃣ Classe `ATMTask`

Créer une classe `ATMTask` qui implémente `Runnable`.

Elle doit contenir :
- Un `BankAccount`
- Une action (`DEPOSIT`, `WITHDRAW`, `BALANCE`)
- Un montant (si nécessaire)

La méthode `run()` doit exécuter l’action correspondante.

---

## ⚠️ Partie 3 — Mise en évidence d’une Race Condition

### 4️⃣ Accès concurrent au même compte

Dans le `main` :

- Créer **un seul compte bancaire**
- Lancer **deux threads** qui tentent chacun de retirer **700 €**

```text
Solde initial : 1000 €
Retrait 1 : 700 €
Retrait 2 : 700 €
```

#### ❓ Questions
- Quel solde attend-on théoriquement ?
- Quel solde observez-vous parfois ?
- Pourquoi les deux retraits peuvent-ils réussir ?
- Comment appelle-t-on ce type de problème ?

## 🔐 Partie 4 —Synchronisation avec synchronized
5️⃣ Sécurisation du retrait
- Modifier la méthode `withdraw()` pour la rendre thread-safe à l’aide du mot-clé synchronized.
- Rejouer le scénario précédent
- Observer la différence de comportement

#### ❓ Questions
- Pourquoi synchronized empêche-t-il la race condition ?
- Que se passe-t-il si plusieurs threads veulent entrer dans la méthode ?

## 🧪 Partie 5 — Simulation multi-clients
6️⃣ Simulation réaliste
- Créer 10 threads clients
- Chaque client effectue 5 opérations aléatoires :
  - dépôt
  - retrait
  - consultation
💡 Ajouter un Thread.sleep() pour simuler le temps d’attente à l’ATM.


