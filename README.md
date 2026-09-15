# 📅 API de Gestão de Eventos

API RESTful desenvolvida em Java com Spring Boot para gerenciamento de eventos, participantes e controle automático de vagas.

---

## 🛠️ Tecnologias Utilizadas

* Java 21
* Spring Boot
* Spring Data JPA
* MySQL / H2 Database
* Maven

---

## 📌 Endpoints da API

### Eventos
* `POST /api/eventos` - Cadastra um novo evento (RF01)
* `GET /api/eventos` - Lista todos os eventos (RF02)
* `GET /api/eventos/{id}` - Consulta evento e exibe vagas restantes (RF03)

### Participantes
* `POST /api/participantes` - Cadastra um novo participante (RF04)

### Inscrições
* `POST /api/inscricoes` - Inscreve participante em um evento (RF05)
* `GET /api/inscricoes/evento/{eventoId}` - Lista participantes de um evento (RF06)
* `DELETE /api/inscricoes/{id}` - Cancela uma inscrição (RF07)

---

## ⚙️ Regras de Negócio

* **RN01 — Limite de vagas:** Retorna HTTP 400 se a capacidade máxima for atingida.
* **RN02 — Inscrição duplicada:** Rejeita tentativas de inscrever o mesmo participante duas vezes no mesmo evento.
* **RN03 — E-mail único:** Garante que cada participante tenha um e-mail exclusivo.
* **RN04 — Cancelamento libera vaga:** Excluir uma inscrição disponibiliza a vaga para outro participante.

---

## 🌿 Git e Pull Requests

Desenvolvimento realizado em branches secundárias. Integrações na `main`/`master` ocorrem obrigatoriamente via Pull Request.