
# CBSE - Projeto Exemplo (Java) - **Projeto Acadêmico**
**por Lori Machado Filho**

Projeto **acadêmico** utilizado nas aulas para **demonstração da construção de software baseada em componentes (CBSE)** em Java.  
O foco é evidenciar **interfaces explícitas**, **componentes auto‑contidos** e **montagem por composição/substituição**.

---

## Objetivos de aprendizagem
- Aplicar **interfaces** como contratos estáveis entre partes do sistema.
- Construir **componentes** com baixo acoplamento e fácil substituição.
- Montar a aplicação **dependendo apenas das interfaces** (injeção por construtor).

---

## Estrutura (Java/Maven)
```
cbse-exemplo-java/
├─ pom.xml
├─ README.md (este arquivo)
├─ src/
│  ├─ main/java/br/edu/unijui/reuso/saude/api/            # Interfaces (contratos)
│  │  ├─ CadastroPaciente.java
│  │  ├─ AgendamentoConsulta.java
│  │  ├─ EmissaoLaudo.java
│  │  └─ Notificador.java
│  ├─ main/java/br/edu/unijui/reuso/saude/api/dto/        # DTOs
│  │  ├─ Paciente.java
│  │  ├─ Consulta.java
│  │  └─ Laudo.java
│  ├─ main/java/br/edu/unijui/reuso/saude/componentes/    # Implementações de componentes
│  │  ├─ memoria/
│  │  │  ├─ CadastroPacienteEmMemoria.java
│  │  │  ├─ AgendamentoConsultaEmMemoria.java
│  │  │  └─ AgendamentoConsultaComConflito.java
│  │  ├─ laudo/EmissaoLaudoSimples.java
│  │  └─ notificacao/ConsoleNotificador.java
│  └─ main/java/br/edu/unijui/reuso/saude/app/            # Montagem (SistemaSaude + App)
│     ├─ SistemaSaude.java
│     └─ App.java
└─ uml/exemplo.puml                              # Diagrama de Componentes (PlantUML)
```

---

## Pré‑requisitos
- **Java 17+**
- **Maven 3.8+**
- **PlantUML**  para renderizar `uml/exemplo.puml`

---

## Executar a aplicação
```bash
cd cbse
mvn -q -DskipTests exec:java
```

## Rodar testes
```bash
mvn -q test
```

---

## Demonstrando CBSE (troca de implementação)
Edite `src/main/java/br/com/exemplo/saude/app/App.java` e troque a implementação de agendamento **sem alterar a aplicação**:

```java
// Padrão (sem conflitos)
new AgendamentoConsultaEmMemoria()

// Variante (com detecção de conflitos)
new AgendamentoConsultaComConflito()
```

> A **App** depende apenas de `AgendamentoConsulta` (interface). A substituição mostra **baixo acoplamento** e **reúso**.

---

## Diagrama de Componentes (PlantUML)
- Arquivo: `uml/exemplo.puml`
- Renderização (exemplo):
```bash
plantuml uml/exemplo.puml
```

O diagrama destaca:
- App -> **usa** interfaces (`CadastroPaciente`, `AgendamentoConsulta`, `EmissaoLaudo`, `Notificador`)
- Componentes **provêem** essas interfaces:  
  `CadastroPacienteEmMemoria`, `AgendamentoConsultaEmMemoria`, `AgendamentoConsultaComConflito`, `EmissaoLaudoSimples`, `ConsoleNotificador`.

---

## Boas práticas do projeto
- **Interfaces explícitas** como contratos públicos.
- **Injeção por construtor** para orquestração.
- Componentes **auto‑contidos** (sem estado global compartilhado).
- **Testes de contrato** garantindo substituibilidade das implementações.

---

## Uso acadêmico
Projeto destinado a **aulas/demonstrações** de **Construção de Software Baseada em Componentes**.  
Livre para uso didático, sem garantias.

---

## Autor
**por Lori Machado Filho**
