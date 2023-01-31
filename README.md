# PokeTeam

**Número da Lista**: Não se aplica<br>
**Conteúdo da Disciplina**: Programação Dinâmica<br>

## Alunos
|Matrícula | Aluno |
| -- | -- |
| 19/0010606 | Artur de Sousa Vieira |
| 18/0145363 |  Yan Andrade de Sena  |

## Sobre 
O objetivo do PokeTeam é apresentar uma interface direta e simples de utilizar, que tem a função de mostrar a menor distância entre dois pokémons. Para isso é utilizado o algoritmo de menor distância entre dois pontos. 

## Screenshots

### Pagina inicial (Sem Seleção)

![Itens não selecionados](assets-readme/pokefind-notselected.png) 

### Pagina inicial (Area e Pokemon Selecionados)

![Pokemons selecionados](assets-readme/pokefind-selected.png) 

### Modal de caminho

![Modal Caminho Inicio](assets-readme/pokefind-modal-1.png) 
![Modal Caminho Final](assets-readme/pokefind-modal-2.png) 

## Instalação 
**Linguagem**: Java, Typescript<br>
**Framework**: Springboot, Angular<br>

Para rodar o nosso projeto localmente, deverá ter instalado Java (versão 11), Node (versão 16) e Maven(Versão 3.8). Também sugerimos a instalação de uma IDE, o Intellij, já que o mesmo facilita rodar projetos Java.

Para rodar o backend (sem IDE) basta acessar o diretório poketeam_backend e rodar o comando:

```
mvn spring-boot:run 
```

Para rodar o backend (com a IDE) instalada basta apertar o botão "▶" no método main da classe ``br.com.poketeam.PokeTeamApplication``.

Para rodar o frontend basta ir no diretório poketeam_frontend e rodar o comando:

```
npm i 
```

Para baixar as dependências e em seguida execute o comando:

```
npm run start
```

A aplicação estará disponível no endereço:

```
http://localhost:4200
```

## Uso 
Para a utilizaçao devemos selecionar dois pokémons e em seguida apertar o botão: ``"Go!"``.

## Outros 

### Download Apresentação

Segue o Link para download da [Apresentação do projeto](assets-readme/apresentacao-pokegraph.mp4).<br>
(Para download, clique no link e depois nas opções *Download* ou *View Raw*)